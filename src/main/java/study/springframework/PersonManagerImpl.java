/**
 * 
 */
package study.springframework;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jack
 *
 */
public class PersonManagerImpl implements PersonManager {

	@Override
	public List<Person> getPerson(int age) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");// 读取bean.xml中的内容
		Person p1 = ctx.getBean("person1", Person.class);// 创建bean的引用对象
		Person p2 = ctx.getBean("person2", Person.class);// 创建bean的引用对象
		List<Person> result = new ArrayList<Person>(2);
		result.add(p1);
		result.add(p2);
		return result;
	}

}
