package LeetCode;

public class MaxProductSub {
	public int maxProduct(int[] A) {
		if(A.length<=0) return 0;
		if(A.length==1) return A[0];
		int curMax = A[0];
		int curMin = A[0];
		int ans = A[0];
		for(int i=1;i<A.length;i++){
			int temp = curMin *A[i];//先保存起来，后面cuaMax的计算需要用到
			curMin = Math.min(A[i], Math.min(temp, curMax*A[i]));
			curMax = Math.max(A[i], Math.max(temp, curMax*A[i]));
			ans = Math.max(ans, curMax);
		}
		return ans;
    }
	public static void main(String[] args){
		int[] A={2,-1,3,-4,0,9,-3};
		System.out.println(new MaxProductSub().maxProduct(A));
	}
}
