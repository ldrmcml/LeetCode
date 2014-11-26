package LeetCode;

public class MedianofTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
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
		if(C.length%2==1)return C[C.length/2];
		else return 1.0*(C[C.length/2]+C[C.length/2-1])/2;
    }
	public static void main(String[] args){
		int A[]={1,1,2},B[]={1,3,4};
		double median=new MedianofTwoSortedArrays().findMedianSortedArrays(A, B);
		System.out.println(median);
	}
}
