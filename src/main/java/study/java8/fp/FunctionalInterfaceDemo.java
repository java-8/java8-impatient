/**
 * DoubleColons.java
 */
package study.java8.fp;

/**
 * @author jack 2016年8月16日 下午3:57:58
 */
public class FunctionalInterfaceDemo {
	String startWith(String s) {
		return s.valueOf(s.charAt(0));
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FunctionalInterfaceDemo DoubleColons = new FunctionalInterfaceDemo();
		Converter<String, String> converter = DoubleColons::startWith;
		
		String cc = converter.convert("Scala");
		System.out.println(cc);
		
	}
	
}

@FunctionalInterface
interface Converter<F, T> {
	T convert(F from);
}
