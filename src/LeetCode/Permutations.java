package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	List<List<Integer>> ll;
	List<Integer> list;
	public List<List<Integer>> permute(int[] nums) {
		ll=new ArrayList<List<Integer>>();
		list=new ArrayList<Integer>();
		
		if(nums==null||nums.length==0){
			ll.add(list);
			return ll;
		}
		
		getPermute(0,nums);
		return ll;
	}
	public void getPermute(int level, int[] nums){
		if(level==nums.length){
			for(int i=0;i<nums.length;i++)
				list.add(nums[i]);
			ll.add(new ArrayList<Integer>(list));
			list.clear();
			return;
		}

		for(int i=level;i<nums.length;i++){
			// swap nums[level]/nums[i]
			int tmp=nums[level];
			nums[level]=nums[i];
			nums[i]=tmp;
			
			getPermute(level+1, nums);
			
			// swap nums[level]/nums[i]
			// revert to original array
			tmp=nums[level];
			nums[level]=nums[i];
			nums[i]=tmp;
		}
	}
	public static void main(String[] args){
		Permutations p=new Permutations();
		List<List<Integer>> ll=p.permute(new int[]{1,2,3});
		System.out.println(ll);
	}
}
