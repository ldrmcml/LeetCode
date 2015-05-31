package LeetCode;

public class JumpGame {
	public boolean canJump(int[] nums) {
		if(nums==null||nums.length==0)return true;
		int cur=nums[0];
		// 贪心法 
		for(int i=1;i<nums.length;i++){
			if(cur>0){
				cur--;
				cur=Math.max(nums[i],cur);
			}else
				return false;
		}
		return true;
	}
	public boolean canJump1(int[] nums) {
		if(nums==null||nums.length==0)return true;
		int cur=0;
		int paces;
		while(cur<nums.length&&cur!=nums.length-1&&nums[cur]!=0){
			paces=nums[cur];
			cur+=paces;
		}
		if(cur>=nums.length-1)
			return true;
		return false;
	}
	public static void main(String[] args){
		JumpGame j=new JumpGame();
		int nums[]={2,0};
		System.out.println(j.canJump(nums));
	}
}
