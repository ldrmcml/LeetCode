package TestQuestion.com.proxy.dynamicproxy;
                     
public class Test {
    public static void main(String[] args) {
        DynamicProxy proxy = new DynamicProxy();
        Student resource = proxy.create();
        resource.operationA();
    }
}
