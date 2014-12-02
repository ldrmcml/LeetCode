package LeetCode;

/**
 * 时间复杂度为遍历一遍
 * @author cml
 *
 */
public class SortColors_OnePass {
	public static void swap(int[] A,int sour,int des){
		int tmp=A[sour];
		A[sour]=A[des];
		A[des]=tmp;
	}
	public static void sortColors(int[] A) {
		int head=0,tail=A.length-1;// tail为最大下标
//		for(int i=0;i<A.length;i++){// 遍历一遍
		for(int i=0;i<=tail;i++){// 无需遍历一遍
			while(A[i]==2&&i<tail)swap(A,i,tail--);
			while(A[i]==0&&i>head)swap(A,i,head++);
			System.out.print(" tail:"+tail+" ");
		}
	}
	public static void main(String[] args){
		int A[]={0,1,2,0,2,1,1,2,0};
		sortColors(A);
		for(int n:A)
			System.out.print(n+" ");
	}
}
