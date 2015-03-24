package LeetCode;

public class ContainerWithMostWater {
	public static int maxArea(int[] height) {
		int max=0;
		for(int i=0,j=height.length-1;i<j;){
			max=Math.max(Math.min(height[i], height[j])*(j-i),max);
			if(height[i]<height[j]){
				i++;
			}else{
				j--;
			}
		}
		return max;
	}
	public static void main(String[] args){
		int test[]={1,2,4,3};
		System.out.println(maxArea(test));
	}
}
