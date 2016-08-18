/**
 * MapOfStream.java
 */
package study.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jack 2016年8月18日 下午2:38:35
 */
public class StreamFilterDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 转为大写
		List<String> wordList = Arrays.asList("a",
		                                      "b",
		                                      "c");
		wordList.stream()
		        .map(String::toUpperCase)
		        .forEach(System.out::println);
		
		// 计算平方
		List<Integer> nums = Arrays.asList(1,
		                                   2,
		                                   3,
		                                   4);
		// filter > 10 nums
		List<Integer> squareNums = nums.stream()
		                               .map(n -> n * n)
		                               .filter(n -> n > 10)
		                               .collect(Collectors.toList());
		squareNums.forEach(System.out::println);
		
	}
	
}
