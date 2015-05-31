package LeetCode;

// 采用贪心算法，每次计算出能到达的最大位置即可。
public class JumpGameII {
	public int jump(int[] nums) {
		int ret=0;//jump数
		int curMax=0;//从0~i这i+1个nums元素中能达到的最大范围
		int curRch=0;//从nums[0]进行ret次jump后达到的最大范围
		for(int i=0;i<nums.length;i++){
			if(curRch<i){
				ret++;
				curRch=curMax;
			}
			curMax=Math.max(curMax, nums[i]+i);
		}
		return ret;
	}
}
