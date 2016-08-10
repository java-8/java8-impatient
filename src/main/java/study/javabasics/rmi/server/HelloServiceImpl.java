/**
 * 
 */
package study.javabasics.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import study.javabasics.rmi.stub.HelloService;

/**
 * @author jack
 *
 */
public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {
	private static final long serialVersionUID = 779348761118572338L;

	protected HelloServiceImpl() throws RemoteException {
	}

	@Override
	public String sayHey(String name) {
		return "Hey, RMI: " + name;
	}

}
