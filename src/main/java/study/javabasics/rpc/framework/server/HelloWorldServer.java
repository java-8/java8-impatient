/**
 * 
 */
package study.javabasics.rpc.framework.server;

import study.javabasics.rpc.framework.SimpleRpcFramework;
import study.javabasics.rpc.framework.api.HelloWorldService;

/**
 * @author jack
 *
 */
public class HelloWorldServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HelloWorldService service = new HelloWorldServiceImpl();
		try {
			SimpleRpcFramework.exporter(service, 1234);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
