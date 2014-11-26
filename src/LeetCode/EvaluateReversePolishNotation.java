package LeetCode;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<String> stack=new Stack<String>();
        String str1,str2;
        int operand1,operand2;
        for(String token:tokens){
        	if(token.equals("+")||token.equals("-")||token.equals("*")||token.equals("/"))
        	{	
        		str2=stack.pop();
        		str1=stack.pop();
        		operand1=Integer.parseInt(str1);
        		operand2=Integer.parseInt(str2);
        		switch(token){
        		case "+":
        			stack.push(String.valueOf(operand1+operand2));break;
        		case "-":
        			stack.push(String.valueOf(operand1-operand2));break;
        		case "*":
        			stack.push(String.valueOf(operand1*operand2));break;
        		case "/":
        			stack.push(String.valueOf(operand1/operand2));break;
        		}
        		continue;
        	}
        	stack.push(token);
        }
        return Integer.parseInt(stack.pop());
    }
    public static void main(String[] args){
    	//String tokens[]={"4", "13", "5", "/", "+"};
    	String tokens[]={"2", "1", "+", "3", "*"};
    	System.out.println(new EvaluateReversePolishNotation().evalRPN(tokens));
    }
}
