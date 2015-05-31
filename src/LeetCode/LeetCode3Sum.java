package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode3Sum {
	public static List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> ll=new ArrayList<List<Integer>>();
		if(null==num||num.length==0)return ll;
		Arrays.sort(num);
		for(int i=0;i<num.length;i++){
			// 考虑{-4,-1,-1,0,1,2}，必须保证输出唯一数组
			if(i>0&&num[i]==num[i-1])continue;
			for(int j=i+1,k=num.length-1;j<k;){
				// 考虑{0,0,0}，j>i+1，因为i+1是最开始的第一组
				if(j>i+1&&num[j]==num[j-1]){j++;continue;}
				if(num[j]+num[k]==-num[i]){
					List<Integer> list=new ArrayList<Integer>();
					list.clear();
					list.add(num[i]);
					list.add(num[j]);
					list.add(num[k]);
					ll.add(list);
					j++;
				}else if(num[j]+num[k]<-num[i]){
					j++;
				}else{
					k--;
				}
			}
		}
		return ll;
	}
	public static void main(String[] args){
//		int[] num={-1,0,1,2,-1,-4};
		int[] num={0,0,0,0};
		List<List<Integer>> ll=threeSum(num);
		for(List<Integer> list:ll){
			for(Integer e:list){
				System.out.print(e+" ");
			}
			System.out.println();
		}
	}
}
