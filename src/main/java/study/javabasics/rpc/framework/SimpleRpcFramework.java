/**
 * 
 */
package study.javabasics.rpc.framework;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author jack
 *
 */
public class SimpleRpcFramework {

	private static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

	/**
	 * 暴露服务
	 * 
	 * @param service
	 *            服务实现
	 * @param port
	 *            服务端口
	 * @throws Exception
	 */
	public static void exporter(final Object service, int port) throws Exception {
		if (service == null)
			throw new IllegalArgumentException("service instance == null");
		if (port <= 0 || port > 65535)
			throw new IllegalArgumentException("Invalid port " + port);
		System.out.println("Export service " + service.getClass().getName() + " on port " + port);

		// 在本机起Socket服务,监听TCP端口:port
		@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(port);
		for (;;) {
			final Socket socket = server.accept();
			// 服务器端一旦收到消息，就放到线程池中,由线程进行处理: 反序列化请求对象-调用服务实现者-返回调用结果
			executor.execute(new Runnable() {
				@Override
				public void run() {
					processService(service, socket);
				}

				private void processService(final Object service, final Socket socket) {
					try {
						// 将客户端Socket发过来的调用方法的名称，参数类型等反序列化成对象
						ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
						String methodName = input.readUTF();// 获得方法的名称
						Class<?>[] parameterTypes = (Class<?>[]) input.readObject();// 从流读取对象,获得参数的类型
						Object[] arguments = (Object[]) input.readObject();// 获得参数
						Method method = service.getClass().getMethod(methodName, parameterTypes);// 通过反射机制获得方法
						// 调用服务实现者
						Object result = method.invoke(service, arguments);
						// 将调用结果对象(序列化)写到流中,通过socket发送到客户端
						ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
						output.writeObject(result);
						System.out.println("服务端调用结果:" + result);

						output.close();
						input.close();
						socket.close();
					} catch (IOException | ClassNotFoundException | NoSuchMethodException | SecurityException
							| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			});

		}
	}

	/**
	 * 引用服务
	 * 
	 * @param <S>
	 *            接口泛型
	 * @param interfaceClass
	 *            接口类型
	 * @param host
	 *            服务器主机名
	 * @param port
	 *            服务器端口
	 * @return 远程服务
	 * @throws Exception
	 */
	// 原理是通过代理，获得服务器端接口的一个“代理”的对象。对这个对象的所有操作都会调用invoke函数.
	// 在invoke函数中，实现接口的远程调用: 将被调用的函数名，参数列表和参数发送到服务器，并接收服务器处理的结果
	@SuppressWarnings("unchecked")
	public static <S> S importer(final Class<S> interfaceClass, final String host, final int port) throws Exception {
		preStep(interfaceClass, host, port);

		// 将本地接口调用转成JDK动态代理调用
		return (S) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[] { interfaceClass },
				new InvocationHandler() {
					// 在代理中实现接口的远程调用
					@Override
					public Object invoke(Object proxy, Method method, Object[] arguments) throws Throwable {
						// Creates a stream socket and connects it to the
						// specified port number on the named host.
						Socket socket = new Socket(host, port);
						Object result = null;
						try {
							// 客户端把: 当前的调用请求对象--->序列化,写入socket流,发送到服务端(远程服务调用)
							ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
							output.writeUTF(method.getName());
							output.writeObject(method.getParameterTypes());
							output.writeObject(arguments);

							// 客户端读取远程服务调用结果: 从对象输入流中反序列化出调用结果对象result
							ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
							result = input.readObject();

							afterStep(socket, result, output, input);
						} catch (Exception e) {
							e.printStackTrace();
						}
						return result;
					}

					private void afterStep(Socket socket, Object result, ObjectOutputStream output,
							ObjectInputStream input) throws Throwable, IOException {
						if (result instanceof Throwable)
							throw (Throwable) result;
						input.close();
						output.close();
						socket.close();
					}
				});
	}

	private static <S> void preStep(final Class<S> interfaceClass, final String host, final int port) {
		if (interfaceClass == null)
			throw new IllegalArgumentException("Interface class == null");
		if (!interfaceClass.isInterface())
			throw new IllegalArgumentException("The " + interfaceClass.getName() + " must be interface class!");
		if (host == null || host.length() == 0)
			throw new IllegalArgumentException("Host == null!");
		if (port <= 0 || port > 65535)
			throw new IllegalArgumentException("Invalid port " + port);

		System.out.println("GET REMOTE SERVICE " + interfaceClass.getName() + " FROM SERVER " + host + ":" + port);
	}
}
