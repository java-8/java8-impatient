/**
 * LambdaDemo.java
 */
package study.java8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author jack 2016年8月18日 下午2:16:53
 */
public class LambdaDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(1,
		                                   23,
		                                   4,
		                                   56,
		                                   7,
		                                   8,
		                                   10);
		// 用stream api
		nums.stream()
		    .sorted()
		    .forEach(System.out::println);
		// lambda表达式本质上也是Collections.sort方法
		nums.sort((e1, e2) -> e1.compareTo(e2));
		nums.forEach(System.out::println);
		
		// 内部类,Collections.sort方法
		nums.sort(new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		
		List<String> languages = Arrays.asList("Java",
		                                       "Scala",
		                                       "C++",
		                                       "Haskell",
		                                       "Lisp");
		
		System.out.println("Languages which starts with J :");
		filter(languages,
		       (str) -> str.startsWith("J"));
		
		System.out.println("Languages which ends with a ");
		filter(languages,
		       (str) -> str.endsWith("a"));
		
		System.out.println("Print all languages :");
		filter(languages,
		       (str) -> true);
		
		System.out.println("Print no language : ");
		filter(languages,
		       (str) -> false);
		
		System.out.println("Print language whose length greater than 4:");
		filter(languages,
		       (str) -> str.length() > 4);
		
	}
	
	public static void filter(List<String> names, Predicate<String> condition) {
		for (String name : names) {
			if (condition.test(name)) {
				System.out.println(name + " ");
			}
		}
	}
	
}
