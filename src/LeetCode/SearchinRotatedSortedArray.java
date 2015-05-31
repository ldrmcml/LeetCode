package LeetCode;

public class SearchinRotatedSortedArray {
	public void adjust(int[] nums){
		// time O(lgn)
	}
	public int binSearch(int[] nums, int target) {
		// time O(lgn)
		return 0;
	}
	public int search1(int[] nums, int target) {
		if(nums==null||nums.length==0)return -1;
		// 调整为sorted array
		adjust(nums);
		// 折半查找
		return binSearch(nums,target);
	}
	public int search(int[] nums, int target) {
		if(nums==null||nums.length==0)return -1;
		// 1.找到起始值的index
		int begin=0,end=nums.length-1;
		int len=nums.length;
		int newStart;
		while(begin<end){
			if(nums[(begin+end)/2]<nums[len-1])
				end=(begin+end)/2-1;
			else
				begin=(begin+end)/2+1;
		}
		// 防止begin==end即跳出的情况，此时nums[(begin+end)/2]<nums[len-1]并没有比较
		newStart=nums[begin]>nums[len-1]?begin+1:begin;
		// 2.折半查找
		begin=newStart;
		end=newStart+len-1;
		while(begin<end){
			int mid=(begin+end)/2>len-1?(begin+end)/2-len:(begin+end)/2;
			if(nums[mid]>target)
				end=(begin+end)/2-1;
			else if(nums[mid]<target)
				begin=(begin+end)/2+1;
			else
				return mid;
		}
		// 防止begin==end即跳出的情况，此时nums[mid]<target并没有比较
		begin=begin>len-1?begin-len:begin;
		if(nums[begin]==target)return begin;
		return -1;
	}
	public static void main(String[] args){
		int[] nums={5,1,3};
		int tar=5;
		SearchinRotatedSortedArray s=new SearchinRotatedSortedArray();
		System.out.println(s.search(nums, tar));
	}
}
