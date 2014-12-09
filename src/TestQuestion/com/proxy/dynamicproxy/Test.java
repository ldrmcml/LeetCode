package TestQuestion.com.proxy.dynamicproxy;
                     
public class Test {
    public static void main(String[] args) {
        DynamicProxy proxy = new DynamicProxy();
        Resource resource = proxy.create();
        resource.operationA();
    }
}
