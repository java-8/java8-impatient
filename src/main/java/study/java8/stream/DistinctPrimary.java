/**
 * DistinctPrimary.java
 */
package study.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jack 2016年8月18日 下午1:50:56
 */
public class DistinctPrimary {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		distinctPrimary(2,
		                2,
		                2,
		                5,
		                5,
		                5,
		                10,
		                8,
		                9,
		                11,
		                11,
		                13,
		                13,
		                13,
		                19,
		                23,
		                45,
		                97);
	}
	
	// 给出一个Integer类型的数组，找出其中所有不重复的素数
	public static void distinctPrimary(Integer... numbers) {
		List<Integer> l = Arrays.asList(numbers);
		List<Integer> r = l.stream()
		                   .map(e -> new Integer(e))
		                   .distinct()
		                   .filter(e -> Primes.isPrime(e))
		                   .collect(Collectors.toList());
		System.out.println("distinctPrimary result is: " + r);
	}
	
}

class Primes {
	public static boolean isPrime(int a) {
		boolean flag = true;
		if (a < 2) {// 素数不小于2
			return false;
		} else {
			for (int i = 2; i <= Math.sqrt(a); i++) {
				if (a % i == 0) {// 若能被整除，则说明不是素数，返回false
					flag = false;
					break;// 跳出循环
				}
			}
		}
		return flag;
	}
}
