/**
 * 
 */
package study.javabasics.proxy.pattern;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import sun.misc.ProxyGenerator; 

/**
 * @author jack
 *
 */
@SuppressWarnings("restriction")
public class DynamicProxyDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RealSubject realSubject = new RealSubject();

		ClassLoader loader = Subject.class.getClassLoader();
		Class<?>[] interfaces = new Class[] { Subject.class };
		InvocationHandler h = new ProxyHandler(realSubject);

		Subject proxySubject = (Subject) Proxy.newProxyInstance(loader, interfaces, h);

		proxySubject.doSomething(10L);

		// write proxySubject class binary data to file
		createProxyClassFile();

	}

	public static void createProxyClassFile() {
		String name = "ProxySubject";
		byte[] data = ProxyGenerator.generateProxyClass(name, new Class[] { Subject.class });
		try {
			FileOutputStream out = new FileOutputStream(name + ".class");
			out.write(data);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
