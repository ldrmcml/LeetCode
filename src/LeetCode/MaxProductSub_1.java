package LeetCode;

public class MaxProductSub_1 {
	public int maxProduct(int[] A) {
		int curMax,curMin,res,tmp;
		if(A.length<=0)return 0;
		if(A.length==1)return A[0];
		curMin=A[0];
		curMax=A[0];
		res=A[0];
		for(int i=1;i<A.length;i++){
			//可以把两种情况统一起来，都是比较curMax*[i]/curMin*A[i]/A[i]
			if(A[i]<0){
				tmp=curMax;//先把curMax保存起来，后面curMin的计算需要用到
				curMax=Math.max(curMin*A[i], A[i]);
				curMin=Math.min(tmp*A[i], A[i]);
			}else if(A[i]>=0){
				curMax=Math.max(curMax*A[i], A[i]);
				curMin=Math.min(curMin*A[i], A[i]);
			}
			res=Math.max(res, curMax);
		}
		return res;
    }
	public static void main(String[] args){
		int[] A={2,-1,3,-4,0,9,-3};
		System.out.println(new MaxProductSub_1().maxProduct(A));
	}
}
