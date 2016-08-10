/**
 * 
 */
package study.javabasics.reflection;

import java.lang.reflect.Method;

/**
 * @author jack
 *
 */
public class StudyReflection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = getParamClazzName("study.javabasics.reflection.ContactService","getPerson");
		System.out.println(str);

	}
	
	private static String getParamClazzName(String api, String method) {
		String paramClassName = null;
		try {
			Class<?> clz = Class.forName(api);
			Method[] methods = clz.getMethods();
			for (Method m : methods) {
				String name = m.getName();
				// 获取被测接口的参数对象类型,默认先支持1个对象参数(28-rules)
				if (method.equals(name)) {
					Class<?> pClass = m.getParameterTypes()[0];
					paramClassName = pClass.getName();
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return paramClassName;
	}

}
