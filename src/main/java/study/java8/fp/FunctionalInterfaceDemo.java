/**
 * FunctionalInterfaceDemo.java
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
		FunctionalInterfaceDemo fid = new FunctionalInterfaceDemo();
		Converter<String, String> converter = fid::startWith;
		
		String cc = converter.convert("Scala");
		System.out.println(cc);
		
		Runnable r1 = () -> {
			System.out.println("Hello Lambda!");
		};
		
		System.out.println((Runnable) () -> {
		}); // 正确
		
	}
	
}

@FunctionalInterface
interface Converter<F, T> {
	T convert(F from);
}
