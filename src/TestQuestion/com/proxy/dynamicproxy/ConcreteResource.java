package TestQuestion.com.proxy.dynamicproxy;

public class ConcreteResource implements Resource,Student {
    public void operationA() {
        System.out.println("Operation A.");
    }
    public void operationB() {
        System.out.println("Operation B.");
    }
    public void operationC(String s) {
        System.out.println("args:"+s);
    }
}
