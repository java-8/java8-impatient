/**
 * 
 */
package study.javabasics.proxy.pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author jack
 *
 */
public class ProxyHandler implements InvocationHandler {
	private Object proxied;

	public ProxyHandler(Object proxied) {
		this.proxied = proxied;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object,
	 * java.lang.reflect.Method, java.lang.Object[])
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		return method.invoke(proxy, args);
	}

}
