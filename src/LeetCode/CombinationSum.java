package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	List<List<Integer>> ll;
	List<Integer> list;
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		ll=new ArrayList<List<Integer>>();
		list=new ArrayList<Integer>();
		Arrays.sort(candidates);
		getCombination(candidates, target, 0, 0);
		return ll;
	}
	public void getCombination(int[] can, int target, int sum, int index){
		if(sum>target)return;
		if(sum==target){
			ll.add(new ArrayList<Integer>(list));
			return;
		}
		// less than target
		for(int i=index;i<can.length;i++){
			sum+=can[i];
			list.add(can[i]);
			getCombination(can, target, sum, i);
			// above getCombination return
			sum-=can[i];
			list.remove(list.size()-1);
		}
	}
	public static void main(String[] args){
		int nums[]={3,2,7,6};
		CombinationSum s=new CombinationSum();
		@SuppressWarnings("unused")
		List<List<Integer>> ll=s.combinationSum(nums, 7);
	}
}
