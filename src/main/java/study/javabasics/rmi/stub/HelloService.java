/**
 * 
 */
package study.javabasics.rmi.stub;

import java.rmi.Remote;

/**
 * @author jack
 *
 */
public interface HelloService extends Remote {

	public String sayHey(String name);

}
