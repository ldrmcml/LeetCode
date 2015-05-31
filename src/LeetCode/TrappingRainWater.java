package LeetCode;

public class TrappingRainWater {
	// two pointers
	// stack
	public int trap(int[] height) {
		if(height==null||height.length==0)return 0;
		// 找到最高值
		int maxid=0;
		for(int i=0;i<height.length;i++){
			if(height[i]>height[maxid]){
				maxid=i;
			}
		}
		// 已经找到最高值
		int water=0;
		int cur=height[0];
		for(int i=1;i<maxid;i++){
			if(height[i]>cur)cur=height[i];
			else water+=cur-height[i];
		}
		cur=height[height.length-1];
		for(int i=height.length-2;i>maxid;i--){
			if(height[i]>cur)cur=height[i];
			else water+=cur-height[i];
		}
		return water;
	}
}
