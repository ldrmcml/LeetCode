package TestQuestion.test;

import java.util.Stack;

public class UnDuplicate {
	public static String method(String s){
		StringBuffer sb=new StringBuffer();
		Stack<Character> stack=new Stack<Character>();
		for(int i=0;i<s.length();i++){
			stack.push(s.charAt(i));
			if(s.charAt(i)==']'){
				while(stack.peek()!='['){
					stack.pop();
				}
				stack.pop();
			}
		}
		while(!stack.empty()){
			sb.append(stack.peek());
			stack.pop();
		}
		return sb.reverse().toString();
	}
	public static void main(String[] args){
		System.out.println(method("abc[abc]c[e[fa]]"));
	}
}
