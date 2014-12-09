package TestQuestion.com.proxy.filter;

import java.lang.reflect.Proxy;

public class Main {
	
	public static void main(String[] args) {
		FilterHandler handler1 = new FilterHandler("com.proxy.filter.FirstAction");
		Action first = (Action) Proxy.newProxyInstance(Action.class.getClassLoader(), new Class[] {Action.class}, handler1);
		
		FilterHandler handler2 = new FilterHandler("com.proxy.filter.second");
		Action second = (Action) Proxy.newProxyInstance(Action.class.getClassLoader(), new Class[] {Action.class}, handler2);
		
		FilterHandler handler3 = new FilterHandler("com.proxy.filter.ThirdAction");
		Action third = (Action) Proxy.newProxyInstance(Action.class.getClassLoader(), new Class[] {Action.class}, handler3);
		
		first.excute();
		second.excute();
		third.excute();
	}
}