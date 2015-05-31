package LeetCode;

import java.util.Arrays;

public class FirstMissingPositive {
	public int firstMissingPositive1(int[] nums) {
		// 1.Arrays.fill(boolA,false); 2.int[] A=new int[5]{};A.sort();
		if(nums==null||nums.length==0)return 1;
		Arrays.sort(nums);
		
		// 跳过负数
		int i=0;
		while(i<nums.length&&nums[i]<=0)i++;
		if(i>=nums.length||nums[i]!=1)return 1;
		
		// 找出不连续的整数
		while(i+1<nums.length&&(nums[i]==nums[i+1]||nums[i]+1==nums[i+1]))i++;
		return nums[i]+1;
	}
	public int firstMissingPositive(int[] nums) {
		int i=0;
		while(i<nums.length){
			// 跳过位置正确或者连续重复元素[2,3,4,2]
			if(nums[i]<=0||nums[i]==i+1||nums[i]>nums.length||nums[i]==nums[nums[i]-1])i++;
			else{
				int tmp=nums[i];
				nums[i]=nums[tmp-1];
				nums[tmp-1]=tmp;
			}
		}
		for(i=0;i<nums.length;i++){
			if(nums[i]!=i+1)break;
		}
		return i+1;
	}
	public static void main(String[] args){
		//int[] A=new int[5];//默认用0填充
		//Arrays.fill(A, 0);

		int nums[]={1,0};
//		FirstMissingPositive s=new FirstMissingPositive();
//		System.out.println(s.firstMissingPositive(nums));
	}
}
