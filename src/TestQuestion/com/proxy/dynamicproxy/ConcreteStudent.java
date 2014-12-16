package TestQuestion.com.proxy.dynamicproxy;

public class ConcreteStudent implements Student {
	@Override
    public void operationA() {
        System.out.println("Operation A.");
    }
    public void operationB() {
        System.out.println("Operation B.");
    }
    public void operationC(String s) {
        System.out.println("args:"+s);
    }
	@Override
	public void operationD() {
		// TODO Auto-generated method stub
		
	}
}
