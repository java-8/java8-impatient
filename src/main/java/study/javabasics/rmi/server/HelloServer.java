/**
 * 
 */
package study.javabasics.rmi.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import study.javabasics.rmi.stub.HelloService;

/**
 * @author jack
 *
 */
public class HelloServer {

	/**
	 * @param args
	 * @throws RemoteException
	 */
	public static void main(String[] args) throws RemoteException {
		HelloService helloService = new HelloServiceImpl();
		try {
			// Bind the remote object's stub in the registry
			LocateRegistry.createRegistry(2001);
			Naming.rebind("rmi://127.0.0.1:2001/helloService", helloService);
			System.out.println("server is ready");
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}

	}

}
