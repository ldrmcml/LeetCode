package TestQuestion;

import java.util.Scanner;

public class microsoft_test {
	static long arr[];
	static long b[];
	static int count;
	int tmp;
	void merge(int low,int mid,int high){
		int i,j,k;
		for(i=low;i<=high;i++)
			b[i]=arr[i];
		tmp=0;
		for(i=low,j=mid+1,k=low;i<=mid&&j<=high;){
			if(b[i]<=b[j]){
				arr[k++]=b[i++];
				count+=tmp;
			}else{
				arr[k++]=b[j++];
				tmp++;
			}
		}
		while(i<=mid){
			arr[k++]=b[i++];
			count+=tmp;
		}
		while(j<=high){
			arr[k++]=b[j++];
		}
	}
	void merge_sort(int low,int high){
		if(low<high){
			int mid=(low+high)/2;
			merge_sort(low,mid);
			merge_sort(mid+1,high);
			merge(low,mid,high);
		}
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		arr=new long[n];
		b=new long[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextLong();
		new microsoft_test().
		merge_sort(0,n-1);
		System.out.println(count);
		sc.close();
	}

}
