package algorithms;

import algorithms.stdlib.In;
import algorithms.stdlib.StdOut;
import algorithms.stdlib.StdRandom;

public class Example {
	private static int N=5;

	public static void sort(Comparable[] a){
	}
	
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j){
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	private static void show(Comparable[] a){
		for (int i = 0; i < a.length; i++)
			StdOut.print(a[i] + " ");
		StdOut.println();
	}
	
	private static boolean isSorted(Comparable[] a){
		for (int i=1;i<a.length;i++)
			if(less(a[i],a[i-1]))return false;
		return true;
	}
	
	public static void main(String[] args){
		String[] a=In.readStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}
}