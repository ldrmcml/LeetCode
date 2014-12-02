package LeetCode;

/**
 * 时间复杂度为遍历两遍
 * @author cml
 *
 */
public class SortColors_TwoPass {
	public static void sortColors(int[] A) {
        int num0=0,num1=0;// 分别计数0,1的个数
		for(int i=0;i<A.length;i++){
        	if(A[i]==0)
        		num0++;
        	else if(A[i]==1)
        		num1++;
        }
		for(int i=0;i<A.length;i++){
			if(i<num0)
				A[i]=0;
			else if(i<num1+num0)
				A[i]=1;
			else
				A[i]=2;
		}
    }
	public static void main(String[] args){
		int A[]={0,1,2,0,2,1,1,2,0};
		sortColors(A);
		for(int n:A)
			System.out.print(n+" ");
	}
}
