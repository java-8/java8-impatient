/**
 * StreamApiDemo.java
 */
package study.java8.stream;

import java.util.List;
import java.util.stream.Stream;
import java.util.ArrayList;

/**
 * @author jack 2016年8月16日 下午4:48:22
 */
public class StreamApiDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<String> fpList = new ArrayList<>();
		fpList.add("Scala");
		fpList.add("Haskell");
		fpList.add("Clojure");
		fpList.add("Lisp");
		
		System.out.println("=====原来的list=========");
		
		fpList.forEach(System.out::println);
		
		System.out.println("======排序输出========");
		
		fpList.stream()
		      .sorted()
		      .forEach(System.out::println);
		
		System.out.println("=====Stream的排序不影响原来list=========");
		
		fpList.forEach(System.out::println);
		
		Stream<String> stream = fpList.stream()
		                              .sorted();
		
		System.out.println("==============");
		
		fpList.stream()
		      .sorted()
		      .filter((s) -> s.contains("S") || s.contains("s"))
		      .forEach(System.out::println);
		
	}
	
}
