/**
 * 
 */
package study.javabasics.rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import study.javabasics.rmi.stub.HelloService;

/**
 * @author jack
 *
 */
public class HelloClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			HelloService helloService = (HelloService) Naming.lookup("rmi://127.0.0.1:2001/helloService");
			System.out.println(helloService.sayHey("RMI!"));
		} catch (RemoteException | NotBoundException | MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
