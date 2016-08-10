/**
 * 
 */
package study.springframework;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author jack
 *
 */
public class PersonManagerImpl2 implements PersonManager {
	@Autowired
	@Qualifier("person1")
	Person person1;
	@Autowired
	@Qualifier("person2")
	Person person2;

	@Override
	public List<Person> getPerson(int age) {

		List<Person> result = new ArrayList<Person>(2);
		result.add(person1);
		result.add(person2);
		return result;
	}

}
