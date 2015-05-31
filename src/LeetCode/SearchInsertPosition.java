package LeetCode;

public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		int be=0,end=nums.length-1;
		while(be<end){
			int mid=(be+end)/2;
			if(nums[mid]<target){
				be=mid+1;
			}else if(nums[mid]>target){
				end=mid-1;
			}else
				return mid;
		}
		if(nums[be]==target)return be;
		else if(nums[be]<target)return be+1;
		else return be;
	}
	public static void main(String[] args){
		int[] nums={1,3,5,6};
		int tar=0;
		SearchInsertPosition s=new SearchInsertPosition();
		System.out.println(s.searchInsert(nums, tar));
	}
}
