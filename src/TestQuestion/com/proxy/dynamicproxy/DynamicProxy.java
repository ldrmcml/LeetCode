package TestQuestion.com.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import TestQuestion.com.proxy.dynamicproxy.ConcreteResource;
import TestQuestion.com.proxy.dynamicproxy.Resource;
                                          
public class DynamicProxy implements InvocationHandler {
    private Resource resource;

    public DynamicProxy() {
        resource = new ConcreteResource();
    }

    public Resource create() {
        Resource returnResource = null;
        //关键！！！！！！生成一个代理实例，并将proxy与Resource接口进行绑定
        returnResource = (Resource) Proxy.newProxyInstance(Resource.class.getClassLoader(), new Class[]{ Student.class,Resource.class }, this);
        return returnResource;
    }

    public Object invoke(Object proxy, Method method, Object[] args) {
        Object o = null;
        try {
            if (method.getName().equals("operationAb")) {
                System.out.println("OperationA in Proxy");
            } else {
                o = method.invoke(resource, args);
                //System.out.println(args);
                //System.out.println(new String[]{"world"});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }
}
