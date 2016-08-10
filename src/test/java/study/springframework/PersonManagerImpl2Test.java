/**
 * 
 */
package study.springframework;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author jack
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class PersonManagerImpl2Test {
	@Autowired
	PersonManager personManager2;

	/**
	 * Test method for
	 * {@link study.springframework.PersonManagerImpl2#getPerson(int)}.
	 */
	@Test
	public final void testGetPerson() {
		System.out.println(personManager2.getPerson(27));

	}

}
