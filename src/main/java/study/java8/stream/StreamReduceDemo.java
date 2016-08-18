/**
 * ReduceDemo.java
 */
package study.java8.stream;

import java.util.stream.Stream;

/**
 * @author jack 2016年8月18日 下午2:49:27
 */
public class StreamReduceDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 字符串连接，concat = "ABCD"
		String concat = Stream.of("A",
		                          "B",
		                          "C",
		                          "D")
		                      .reduce("",
		                              String::concat);
		System.out.println(concat);
		// 求最小值，minValue = -3.0
		double minValue = Stream.of(-1.5,
		                            1.0,
		                            -3.0,
		                            -2.0)
		                        .reduce(Double.MAX_VALUE,
		                                Double::min);
		System.out.println(minValue);
		// 求和，sumValue = 10, 有起始值
		int sumValue = Stream.of(1,
		                         2,
		                         3,
		                         4)
		                     .reduce(0,
		                             Integer::sum);
		System.out.println(sumValue);
		
		// 求和，sumValue = 10, 无起始值
		sumValue = Stream.of(1,
		                     2,
		                     3,
		                     4)
		                 .reduce(Integer::sum)
		                 .get();
		
		System.out.println(sumValue);
		// 过滤，字符串连接，concat = "ace"
		concat = Stream.of("a",
		                   "B",
		                   "c",
		                   "D",
		                   "e",
		                   "F")
		               .filter(x -> x.compareTo("Z") > 0)
		               .reduce("",
		                       String::concat);
		
		System.out.println(concat);
	}
	
}
