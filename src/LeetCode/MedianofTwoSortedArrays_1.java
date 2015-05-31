package LeetCode;

public class MedianofTwoSortedArrays_1 {
	// A从a开始
	public int findkth(int A[],int B[],int k,int a,int b){
		int m=A.length,n=B.length;
		if(k>m-a+n-b)return 0;
		if(m<=a)return B[b+k];
		if(n<=b)return A[a+k];
		
		if(a+k/2>=m){
			if(A[m-1]<B[b+k+a-m])return findkth(A,B,k+a-m,m,b);
			if(A[m-1]>=B[b+k+a-m])return findkth(A,B,m-a,a,b+k+a-m);
		}
		if(b+k/2>=n){
			if(A[a+k+b-n]<B[n-1])return findkth(A,B,m-b,a+k+b-n,b);
			if(A[a+k+b-n]>=B[n-1])return findkth(A,B,k+b-n,a,n);
		}
		if(A[a+k/2]==B[b+k/2])return A[a+k/2];
		else if(A[a+k/2]<B[b+k/2]){
			return findkth(A,B,k/2,a+k/2+1,b);
		}else if(A[a+k/2]>B[b+k/2]){
			return findkth(A,B,k/2,a,b+k/2+1);
		}
		return n;
	}
	public double findMedianSortedArrays(int A[], int B[]) {
		int m=A.length,n=B.length;
		int total=m+n,k=total/2;
		double median=0;
		if(total%2==1){
			median=findkth(A,B,k,0,0);
		}else{
			median=(findkth(A,B,k,0,0)+findkth(A,B,k-1,0,0))*0.5;
		}
		return  median;
	}
}
