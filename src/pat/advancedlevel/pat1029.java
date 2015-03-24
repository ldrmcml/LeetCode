package pat.advancedlevel;

import java.util.Scanner;

public class pat1029 {
    public static int findMedianSortedArrays(int A[], int B[]) {
		int i=0,j=0,k=0;
		int C[]=new int[A.length+B.length];
		while(i<A.length&&j<B.length){
			if(A[i]<B[j]){
				C[k++]=A[i];
				i++;
			}else{
				C[k++]=B[j];
				j++;
			}
		}
		if(i>=A.length)
			while(j<B.length)C[k++]=B[j++];
		if(j>=B.length)
			while(i<A.length)C[k++]=A[i++];
		return C[(C.length+1)/2-1];
    }
    public static void main(String[] args){
    	Scanner sc=new Scanner(System.in);
    	int n1=sc.nextInt();
    	int a1[]=new int[n1];
    	for(int i=0;i<n1;i++)
    		a1[i]=sc.nextInt();
    	int n2=sc.nextInt();
    	int a2[]=new int[n2];
    	for(int i=0;i<n2;i++)
    		a2[i]=sc.nextInt();
    	System.out.println(findMedianSortedArrays(a1, a2));
    	sc.close();
    }
}