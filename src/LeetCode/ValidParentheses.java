package LeetCode;

import java.util.Stack;

public class ValidParentheses {
	public static boolean isValid(String s) {
		boolean b=true;
		Stack<Character> stack=new Stack<Character>();
		for(int i=0;i<s.length();i++){
			char tmp=s.charAt(i);
			if(tmp=='('||tmp=='['||tmp=='{'){
				stack.push(tmp);
			}else if(stack.isEmpty()){
				return false;
			}else if(tmp==')'&&!stack.pop().equals('(')){
				return false;
			}else if(tmp==']'&&!stack.pop().equals('[')){
				return false;
			}else if(tmp=='}'&&!stack.pop().equals('{')){
				return false;
			}
		}
		if(!stack.empty())return false;
		return b;
	}
	public static boolean isValid1(String s) {
		boolean b=true;
		Stack<Character> stack=new Stack<Character>();
		for(int i=0;i<s.length();i++){
			char tmp=s.charAt(i);
			if(tmp=='('||tmp=='['||tmp=='{'){
				stack.push(tmp);
			}else if(tmp==')'){
				if(!stack.empty()&&stack.pop().equals('('))
					continue;
				else
					return false;
			}else if(tmp==']'){
				if(!stack.empty()&&stack.pop().equals('['))
					continue;
				else
					return false;
			}else if(tmp=='}'){
				if(!stack.empty()&&stack.pop().equals('{'))
					continue;
				else
					return false;
			}
		}
		if(!stack.empty())return false;
		return b;
	}
	public static void main(String[] args){
		Integer x=new Integer(1),a=new Integer(1);
		if(x==a);
		System.out.println(x==a);
	}
}
