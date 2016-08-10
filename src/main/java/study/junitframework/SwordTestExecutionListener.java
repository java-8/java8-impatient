/**
 * 
 */
package study.junitframework;

import java.lang.reflect.Method;

import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

/**
 * @author jack
 *
 */
public class SwordTestExecutionListener implements TestExecutionListener {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.test.context.TestExecutionListener#beforeTestClass(
	 * org.springframework.test.context.TestContext)
	 */
	@Override
	public void beforeTestClass(TestContext testContext) throws Exception {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.test.context.TestExecutionListener#
	 * prepareTestInstance(org.springframework.test.context.TestContext)
	 */
	@Override
	public void prepareTestInstance(TestContext testContext) throws Exception {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.test.context.TestExecutionListener#beforeTestMethod(
	 * org.springframework.test.context.TestContext)
	 */
	@Override
	public void beforeTestMethod(TestContext testContext) throws Exception {
		SwordTestData swordTestData = testContext.getTestMethod().getAnnotation(SwordTestData.class);
		System.out.println("SwordTestData=" + swordTestData);
		if (swordTestData == null)
			return;

		long tedaCaseId = swordTestData.tedaCaseId();
		beforeTestMethodProcess(testContext, tedaCaseId);

	}

	// 实现对注解方法测试数据的赋值处理
	private void beforeTestMethodProcess(TestContext testContext, long tedaCaseId) {
		Method m = testContext.getTestMethod();
		String result = "beforeTestMethod: " + m.getName() + " " + tedaCaseId;
		System.out.println(result);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.test.context.TestExecutionListener#afterTestMethod(
	 * org.springframework.test.context.TestContext)
	 */
	@Override
	public void afterTestMethod(TestContext testContext) throws Exception {
		SwordTestData swordTestData = testContext.getTestMethod().getAnnotation(SwordTestData.class);
		System.out.println("SwordTestData=" + swordTestData);
		if (swordTestData == null)
			return;

		long tedaCaseId = swordTestData.tedaCaseId();
		afterTestMethodProcess(testContext, tedaCaseId);

	}

	private void afterTestMethodProcess(TestContext testContext, long tedaCaseId) {
		Method m = testContext.getTestMethod();
		String result = "afterTestMethod: " + m.getName() + " " + tedaCaseId;
		System.out.println(result);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.test.context.TestExecutionListener#afterTestClass(org
	 * .springframework.test.context.TestContext)
	 */
	@Override
	public void afterTestClass(TestContext testContext) throws Exception {
		// TODO Auto-generated method stub

	}

}
