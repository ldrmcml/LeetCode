package LeetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    public String reverseWords(String s) {
    	String[] sArr=s.trim().split(" ");
    	StringBuffer sb=new StringBuffer();
    	Stack<String> ss=new Stack<String>();
    	for(String str:sArr)
    		if(!(str.equals(" ")||str.equals("")))
            ss.push(str);
    	while(!ss.empty())
    	{
    		sb.append(ss.pop()).append(" ");
    	}
    	return sb.toString().trim();
        
    }
    public static void main(String[] args){
        Solution sol=new Solution();
        
        String s=null;

        InputStreamReader isr = new InputStreamReader(System.in);//封装低级别的输入

        BufferedReader br = new BufferedReader(isr);//封装比自己低的

        try

        {

            s=br.readLine();
            /*
            while(!s.equals(""))

            {

                System.out.println("Read:"+s);

                s= br.readLine();

            }*/

            br.close();

        }

        catch(IOException e)

        {

            e.printStackTrace();

        }
        System.out.println(sol.reverseWords(s));
        //for(String str:sol.reverseWords(s))
        //System.out.println(str);
    }
}
