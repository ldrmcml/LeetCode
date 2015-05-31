package TestQuestion;

public class TestException {
	public static void main(String[] args){
		int ans;
		try{
			try{
				ans=1/0;
			}catch(ArithmeticException e){
				e.printStackTrace();
				throw(e);
			}catch(RuntimeException e){
				e.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
			throw(e);
		}
	}
}
