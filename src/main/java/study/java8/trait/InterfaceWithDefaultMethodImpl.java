/**
 * InterfaceWithDefaultMethodImpl.java
 */
package study.java8.trait;

/**
 * @author jack 2016年8月10日 下午3:57:06
 */
public class InterfaceWithDefaultMethodImpl implements InterfaceWithDefaultMethod {

	public static void main(String[] args) {
		InterfaceWithDefaultMethodImpl impl = new InterfaceWithDefaultMethodImpl();
		impl.defaultMethod();
		impl.abstractMethod();
		// impl.staticMethod(); // 调不到接口里面的静态方法, The method staticMethod() is
		// undefined for the type InterfaceWithDefaultMethodImpl
		InterfaceWithDefaultMethod.staticMethod();// 类似scala里面的object的意思
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see study.java8.trait.InterfaceWithDefaultMethod#abstractMethod()
	 */
	@Override
	public void abstractMethod() {
		// Do Something ...
		System.out.println("Do Something ...");

	}

}
