package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public void dfs(int num1,int num2,char[] buffer,int n,List<String> list){
		if(num1==num2&&num1==n){
			list.add(new String(buffer));
			return;
		}else if(num1>num2&&num1==n){
			buffer[num1+num2]=')';
			dfs(num1,num2+1,buffer,n,list);
		}else if(num1>num2&&num1<n){
			buffer[num1+num2]='(';
			dfs(num1+1,num2,buffer,n,list);
			buffer[num1+num2]=')';
			dfs(num1,num2+1,buffer,n,list);
		}else if(num1==num2&&num1<n){
			buffer[num1+num2]='(';
			dfs(num1+1,num2,buffer,n,list);
		}
	}
	public List<String> generateParenthesis(int n) {
		List<String> list=new ArrayList<String>();
		char[] buffer=new char[2*n];
		//for(int i=0;i<n;i++){
			dfs(0,0,buffer,n,list);
		//}
			return list;
	}
	public static void main(String[] args){
		GenerateParentheses o=new GenerateParentheses();
		List<String> list=o.generateParenthesis(3);
		System.out.println(list);
	}
}
