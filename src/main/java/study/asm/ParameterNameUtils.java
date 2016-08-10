/**
 * 
 */
package study.asm;

import java.util.List;

import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;

import study.springframework.PersonManager;

/**
 * @author jack javac -g:vars
 */
public class ParameterNameUtils {

	public static void main(String[] args) {
		ParameterNameDiscoverer pnd = new DefaultParameterNameDiscoverer();
		String[] parameterNames = pnd.getParameterNames(PersonManager.class.getMethods()[0]);

		for (String p : parameterNames) {
			System.out.println(p);
		}
	}

}
