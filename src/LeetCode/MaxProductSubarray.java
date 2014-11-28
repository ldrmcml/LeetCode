package LeetCode;

public class MaxProductSubarray {
    public int maxProduct(int[] A) {
		int curMax,curMin,res;
		if(A.length<=0)return 0;
		if(A.length==1)return A[0];
		curMin=A[0];
		curMax=A[0];
		res=A[0];
		for(int i=1;i<A.length;i++){
			//以下两种情况可以合并，反正都是比较A[i]/curMax*A[i]/curMin*A[i]
			/*if(A[i]<0){
				tmp=curMax;
				curMax=Math.max(curMin*A[i], A[i]);
				curMin=Math.min(tmp*A[i], A[i]);
			}else if(A[i]>=0){
				curMax=Math.max(curMax*A[i], A[i]);
				curMin=Math.min(curMin*A[i], A[i]);
			}*/
			curMax=Math.max(A[i], Math.max(curMin*A[i], curMax*A[i]));
			curMin=Math.min(A[i], Math.min(curMin*A[i], curMax*A[i]));
			res=Math.max(res, curMax);
		}
		return res;
    }
}