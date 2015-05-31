package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumII {
	List<List<Integer>> ll;
	List<Integer> list;
//	List<Integer> tmp;
//	Set<List<Integer>> set;
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		ll=new ArrayList<List<Integer>>();
		list=new ArrayList<Integer>();
//		set=new HashSet<List<Integer>>();
		Arrays.sort(candidates);
		getCombination(candidates,target,0,0);
		return ll;
	}
	public void getCombination(int[] can, int target, int sum, int index){
		if(sum>target)return;
		if(sum==target){
			// avoid duplicate
//			if(list.equals(tmp))return;
//			tmp=new ArrayList<Integer>(list);
			// when ends with e,avoid duplicate
//			if(index>1){
//				if(can[index-1]==can[index-2])
//					return;
//			}
			// returns true if and only if this set contains an element e such that (o==null ? e==null : o.equals(e)).
//			if(set.contains(list)){
//				return;
//			}else{
//				set.add(list);
//			}
			ll.add(new ArrayList<Integer>(list));
			return;
		}
		for(int i=index;i<can.length;i++){
			// when list is empty,avoid duplicate
//			if(list.isEmpty()){
//				if(i>0){
//					if(can[i]==can[i-1])
//						continue;
//				}
//			}
			// 加上can[i]之后与之前加上can[i-1]重复
			if (i != index && can[i] == can[i - 1])
            {
                continue;
            }
			sum+=can[i];
			list.add(can[i]);
			getCombination(can, target, sum, i+1);
			// above getCombination return
			sum-=can[i];
			list.remove(list.size()-1);
		}
	}
	public static void main(String[] args){
		//int nums[]={10,1,2,7,6,1,5};//target=8
		int nums[]={2,2,2};
		CombinationSumII s=new CombinationSumII();
		@SuppressWarnings("unused")
		// [[1, 1, 6], [1, 2, 5], [1, 7], [1, 2, 5], [1, 7], [2, 6]]
		List<List<Integer>> ll=s.combinationSum2(nums, 4);
		
		List<Integer> ori=new ArrayList<Integer>();
		ori.add(1);ori.add(2);ori.add(3);
		List<Integer> dup=new ArrayList<Integer>(ori);
		// ori.equals(dup) compare every element!!!
		System.out.println(ori.equals(dup));
	}
}
