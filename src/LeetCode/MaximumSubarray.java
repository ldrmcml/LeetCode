package LeetCode;
/**
 * 算法思想：动态规划。求以某数结尾的最大子串和。
 * @author Administrator
 *
 */
public class MaximumSubarray {
	public static int maxSubArray(int[] A) {
		//以A[0]结尾，最大和就是他本身
		int cur=A[0];//cur存当前最大值
		int max=A[0];//max存全局最大值
		for(int i=1;i<A.length;i++){
			//求取cur
			cur=(cur<=0)?A[i]:cur+A[i];
			//求取max
			max=Math.max(cur, max);
		}
        return max;
    }
	public static void main(String[] args){
		System.out.println(maxSubArray(new int[]{1}));
	}
}
