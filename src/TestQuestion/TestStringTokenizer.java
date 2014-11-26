package TestQuestion;

import java.util.StringTokenizer;

public class TestStringTokenizer {
	public static void main(String[] args){
		String s="The Java platform is the ideal platform for network computing";
		StringTokenizer st=new StringTokenizer(s);
		System.out.println("Token Total:"+st.countTokens());
		while(st.hasMoreElements()){
			System.out.println(st.nextToken());
		}
		
		s=new String("The=Java=platform=is=the=ideal=platform=for=network=computing");
		st=new StringTokenizer(s,"=",true);
		System.out.println("Token Total:"+st.countTokens());
		while ( st.hasMoreElements() ){
			System.out.println(st.nextToken());
		}
	}
}
