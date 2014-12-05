package TestQuestion.test;

import java.util.Stack;

public class UnDuplicate_Array {
	public static String method(String s){
		Stack<Integer> stack=new Stack<Integer>();
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='[')
				stack.push(i);
			if(s.charAt(i)==']')
				s.replaceFirst(s.substring(stack.pop(), i+1), "");
		}
		return s;
	}
	public static void main(String[] args){
		System.out.println(method("abc[abc]c[e[fa]]"));
	}
}
