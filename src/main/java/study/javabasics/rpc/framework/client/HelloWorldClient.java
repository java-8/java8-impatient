/**
 * 
 */
package study.javabasics.rpc.framework.client;

import study.javabasics.rpc.framework.SimpleRpcFramework;
import study.javabasics.rpc.framework.api.HelloWorldService;

/**
 * @author jack
 *
 */
public class HelloWorldClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HelloWorldService service;
		try {
			service = SimpleRpcFramework.importer(HelloWorldService.class, "127.0.0.1", 1234);
			for (int i = 0; i < Integer.MAX_VALUE; i++) {
				String hello = service.sayHello("World, " + i);
				System.out.println(hello);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
