/**
 * AppleFilter.java
 */
package study.java8.fp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author jack 2016年8月10日 下午5:30:53
 */
public class AppleFilter {

	public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));

		List<Apple> greenApples = filterApples(inventory, AppleFilter::isGreenApple);
		System.out.println(greenApples);

		List<Apple> heavyApples = filterApples(inventory, AppleFilter::isHeavyApple);
		System.out.println(heavyApples);

		List<Apple> greenApples2 = filterApples(inventory, (Apple a) -> isGreenApple(a));
		System.out.println(greenApples2);

		List<Apple> heavyApples2 = filterApples(inventory, (Apple a) -> isHeavyApple(a));
		System.out.println(heavyApples2);

		List<Apple> weirdApples = filterApples(inventory,
				(Apple a) -> a.getWeight() < 80 || "brown".equals(a.getColor()));
		System.out.println(weirdApples);
	}

	public static List<Apple> filterGreenApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (isGreenApple(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterHeavyApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (isHeavyApple(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

	/////////////////////////////////////////////////

	public static boolean isGreenApple(Apple apple) {
		return "green".equals(apple.getColor());
	}

	public static boolean isHeavyApple(Apple apple) {
		return apple.getWeight() > 150;
	}

	public static class Apple {
		private int weight = 0;
		private String color = "";

		public Apple(int weight, String color) {
			this.weight = weight;
			this.color = color;
		}

		public Integer getWeight() {
			return weight;
		}

		public void setWeight(Integer weight) {
			this.weight = weight;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String toString() {
			return "Apple{" + "color='" + color + '\'' + ", weight=" + weight + '}';
		}
	}

}
