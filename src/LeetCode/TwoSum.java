package LeetCode;

import java.util.HashMap;

/**
 * 利用HashMap降低时间复杂度，Time:O(n)
 * @author Administrator
 *
 */
public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		HashMap<Integer,Integer> hashMap=new HashMap<Integer,Integer>();
		for(int i=0;i<numbers.length;i++)
			hashMap.put(numbers[i], i);
		for(int i=0;i<numbers.length;i++){
			int another=target-numbers[i];
			if(hashMap.containsKey(another)&&hashMap.get(another)!=i)
				return new int[]{i+1,hashMap.get(another)+1};
		}
        return null;
    }
	public static void main(String[] args){
		int[] numbers={2,11,7,15};
		int[] res=new TwoSum().twoSum(numbers, 9);
		for(int a:res)
			System.out.print(a+" ");
	}
}
