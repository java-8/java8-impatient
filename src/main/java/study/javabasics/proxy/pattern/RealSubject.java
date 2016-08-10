/**
 * 
 */
package study.javabasics.proxy.pattern;

/**
 * @author jack
 *
 */
public class RealSubject implements Subject {
	public String doSomething(Long id) {
		return "Really Do Something --- " + id;
	}

}
