/**
 * CollectionSort.java
 */
package study.java8.fp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author jack 2016年8月13日 下午1:08:18
 */
public class CollectionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> names1 = new ArrayList<>();
		names1.add("Java");
		names1.add("Scala");
		names1.add("Clojure");
		names1.add("Groovy");
		// Java 5,6,7
		Collections.sort(names1, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println(names1);

		List<String> names2 = new ArrayList<>();
		names2.add("Java");
		names2.add("Scala");
		names2.add("Clojure");
		names2.add("Groovy");
		// In Java 8
		Collections.sort(names2, (o1, o2) -> o2.compareTo(o1));
		System.out.println(names2);
	}

}
