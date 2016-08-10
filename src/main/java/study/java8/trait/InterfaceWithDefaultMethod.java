/**
 * InterfaceWithDefaultMethod.java
 */
package study.java8.trait;

/**
 * 
 * @author jack 2016年8月10日 下午3:51:19
 */
public interface InterfaceWithDefaultMethod {

	abstract public void abstractMethod();

	public static void staticMethod() {
		System.out.println("staticMethod  print");
	}

	public default void defaultMethod() {
		System.out.println("defaultMethod  print");
	}

	public static void main(String[] args) {// 接口可以有main函数
		staticMethod();

		// InterfaceWithDefaultMethod iMethod = new
		// InterfaceWithDefaultMethod(); 接口不能new实例化
		// defaultMethod();
	}

}
