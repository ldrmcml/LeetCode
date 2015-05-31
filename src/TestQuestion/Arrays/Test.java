package TestQuestion.Arrays;

import java.util.Arrays;

public class Test {
	// 考虑性能：可变参数方法的每次调用都会导致进行一次数组分配和初始化
	// 假设确定对某个方法95%的调用会有3个或者更少的参数，就声明该方法的5个重载，
	// 每个重载方法带有0至3个普通参数，当参数的数目超过3个时，就使用一个可变参数方法
	public void foo(){}
	public void foo(int a1){}
	public void foo(int a1,int a2){}
	public void foo(int a1,int a2,int a3){}
	public void foo(int a1,int a2,int a3,int...rest){}
	public static void main(String[] args){
		// Obsolete idiom to print an array!
		int[] digits = {3,1,4};
		Integer[] integerArr = {3,1,4};
		System.out.println(Arrays.asList(integerArr));
		// The right way to print an array
		System.out.println(Arrays.toString(digits));
		System.out.println(Arrays.toString(integerArr));
	}
}
