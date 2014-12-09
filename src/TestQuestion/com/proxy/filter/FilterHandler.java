package TestQuestion.com.proxy.filter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class FilterHandler implements InvocationHandler {
	private String className;
	
	public FilterHandler(String className) {
		this.className = className;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if (className.endsWith("Action")) {
			System.out.println(className + "." + method.getName());
			return method.invoke(Class.forName(className).newInstance(), args);
		} else {
			System.out.println(className + " doesn't end with 'Action'");
			return null;
		}
	}

}