package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode4Sum {
	public static List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> ll=new ArrayList<List<Integer>>();
		if(num==null||num.length==0)return ll;
		Arrays.sort(num);
		for(int i=0;i<num.length;i++){
			// 直接跳过重复数字
			if(i>0&&num[i]==num[i-1])continue;
			for(int j=i+1;j<num.length;j++){
				if(j>i+1&&num[j]==num[j-1])continue;
				for(int m=j+1,n=num.length-1;m<n;){
					if(m>j+1&&num[m]==num[m-1]){
						m++;
						continue;
					}
					if(num[i]+num[j]+num[m]+num[n]==target){
						List<Integer> tm=new ArrayList<Integer>();
						tm.add(num[i]);
						tm.add(num[j]);
						tm.add(num[m]);
						tm.add(num[n]);
						ll.add(tm);
						m++;
					}else if(num[i]+num[j]+num[m]+num[n]<target){
						m++;
					}else{
						n--;
					}
				}
			}
		}
		return ll;
	}
	public static void main(String[] args){
		int[] num={1,0,-1,0,-2,2};
		int target=0;
		List<List<Integer>> ll=fourSum(num, target);
		System.out.println(ll);
	}
}
