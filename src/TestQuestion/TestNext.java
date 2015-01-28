package TestQuestion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class TestNext {
	private static Scanner scan;
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println(br.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Stack<String> stack = new Stack<String>();
//		scan = new Scanner(System.in);
////		System.out.println(scan.nextLine());
//		// 输入Ctrl+z可终止
//		while(scan.hasNext()){
//			stack.push(scan.next());
//		}
////		scan.nextLine();
//		System.out.print(stack.pop());
//		while(!stack.isEmpty()){
//			System.out.print(" "+stack.pop());
//		}
	}
}
