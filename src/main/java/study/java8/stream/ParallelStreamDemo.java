/**
 * ParallelStreamDemo.java
 */
package study.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author jack 2016年8月16日 下午5:23:51
 */
public class ParallelStreamDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int max = 1000000;
		List<String> values = new ArrayList<>(max);
		for (int i = 0; i < max; i++) {
			UUID uuid = UUID.randomUUID();
			values.add(uuid.toString());
		}
		
		long st0 = System.nanoTime();
		
		long scount = values.stream()
		                    .sorted()
		                    .count();
		System.out.println(scount);
		
		long st1 = System.nanoTime();
		
		long smillis = TimeUnit.NANOSECONDS.toMillis(st1 - st0);
		System.out.println(String.format("sequential sort took: %d ms",
		                                 smillis));
		
		long pt0 = System.nanoTime();
		
		long pcount = values.parallelStream()
		                    .sorted()
		                    .count();
		System.out.println(pcount);
		
		long pt1 = System.nanoTime();
		
		long pmillis = TimeUnit.NANOSECONDS.toMillis(pt1 - pt0);
		System.out.println(String.format("parallel sort took: %d ms",
		                                 pmillis));
		
	}
	
}
