package LeetCode;

public class SearchforaRange {
	public int[] searchRange(int[] nums, int target) {
		if(nums==null||nums.length==0)return new int[]{-1,-1};
		int be=0,end=nums.length-1,mid=0;
		while(be<end){
			mid=(be+end)/2;
			if(nums[mid]<target)
				be=mid+1;
			else if(nums[mid]>target)
				end=mid-1;
			else
				break;
		}
		int index=mid;
		// break
		if(nums[mid]==target)index=mid;
		// be==end
		else if(nums[be]==target)index=be;
		else return new int[]{-1,-1};
		
		be=index-1;
		while(be>=0&&nums[be]==target)be--;
		be++;
		
		end=index+1;
		while(end<nums.length&&nums[end]==target)end++;
		end--;
		
		return new int[]{be,end};
	}
	public static void main(String[] args){
		int[] nums={5, 7, 7, 8, 8, 10};
		int tar=8;
		SearchforaRange s=new SearchforaRange();
		for(int n:s.searchRange(nums, tar))
			System.out.println(n);
	}
}
