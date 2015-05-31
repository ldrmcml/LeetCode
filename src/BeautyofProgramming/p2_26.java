package BeautyofProgramming;

public class p2_26 {
	public static int maxSubArray(int num[]){
		int len=num.length;
		int sum[]=new int[len];
		sum[0]=num[0];
		int max=sum[0];
		for(int i=1;i<len;i++){
			if(sum[i-1]<=0){
				sum[i]=num[i];
			}else{
				sum[i]=sum[i-1]+num[i];
			}
			if(sum[i]>max)max=sum[i];
		}
		return max;
	}
	public static void main(String[] args){
		int[] num={0,-2,3,5,-1,2};
		System.out.println(maxSubArray(num));
	}
}
