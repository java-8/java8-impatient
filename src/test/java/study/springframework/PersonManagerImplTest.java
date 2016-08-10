/**
 * 
 */
package study.springframework;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.TestExecutionListeners;

import study.junitframework.SwordSpringJUnit4ClassRunner;
import study.junitframework.SwordTestData;
import study.junitframework.SwordTestExecutionListener;
import study.junitframework.SwordTestLogger;

/**
 * @author jack
 *
 */
@RunWith(SwordSpringJUnit4ClassRunner.class)
@TestExecutionListeners({ SwordTestExecutionListener.class })
public class PersonManagerImplTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link study.springframework.PersonManagerImpl#getPerson(int)}.
	 */
	@Test
	@SwordTestLogger(log = "GET PERSON TEST!")
	@SwordTestData(tedaCaseId = 1L)
	public void testGetPerson() {
		PersonManagerImpl personManagerImpl = new PersonManagerImpl();
		List<Person> result = personManagerImpl.getPerson(27);
		System.out.println(result);
	}

}
