package LeetCode;

import java.util.Arrays;

public class LeetCode3SumClosest {
	public static int threeSumClosest(int[] num, int target) {
		if(null==num||num.length==0)return 0;
		Arrays.sort(num);
		int diff1=0,diff=Integer.MAX_VALUE,sum=0;
		for(int i=0;i<num.length;i++){
			for(int j=i+1,k=num.length-1;j<k;){
				if(num[j]+num[k]==target-num[i]){
					return target;
				}else if(num[j]+num[k]<target-num[i]){
					diff1=Math.abs(num[i]+num[j]+num[k]-target);
					if(diff1<diff){
						diff=diff1;
						sum=num[i]+num[j]+num[k];
					}
					j++;
				}else{
					diff1=Math.abs(num[i]+num[j]+num[k]-target);
					if(diff1<diff){
						diff=diff1;
						sum=num[i]+num[j]+num[k];
					}
					k--;
				}
			}
		}
		return sum;
	}
	public static void main(String[] args){
		int[] num={-1,2,1,-4};
		System.out.println(threeSumClosest(num, 1));
	}
}
