/**
 * 
 */
package study.javabasics.rpc.framework.server;

import study.javabasics.rpc.framework.api.HelloWorldService;

/**
 * @author jack
 *
 */
public class HelloWorldServiceImpl implements HelloWorldService {
	@Override
	public String sayHello(String name) {
		return "Hello, World! " + name;
	}

}
