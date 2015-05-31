package TestQuestion;

import java.util.Date;//and StringBuffer mutable class

final class BetterPerson {
	private String firstName;
	private String lastName;
	private Date dob;
	public BetterPerson(String firstName,String lastName,
			Date dob){
		this.firstName=firstName;
		this.lastName=lastName;
		this.dob=new Date(dob.getTime());// 深度clone
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Date getDob() {
		return new Date(dob.getTime());
	}
}
public final class BrokenPerson {
	private String firstName;
	private String lastName;
	private Date dob;
	public BrokenPerson(String firstName,String lastName,
			Date dob){
		this.firstName=firstName;
		this.lastName=lastName;
		this.dob=dob;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Date getDob() {
		return dob;
	}
	public static void main(String[] args){
		BrokenPerson brokenPerson=new BrokenPerson("Jackie", "Chen", new Date(System.currentTimeMillis()));
		System.out.println(brokenPerson.getDob());
		final StringBuffer a=new StringBuffer("a");
		a.append("b");
		//The final local variable a cannot be assigned. It must be blank and not using a compound 
		// assignment
		//a=new StringBuffer();
		//a=null;//同上
		System.out.println(a);
	}
}
