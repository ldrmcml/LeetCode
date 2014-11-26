package LeetCode;
/**
 * Time:O(n^2)
 * @author Administrator
 *
 */
public class TwoSum_1 {
	public int[] twoSum(int[] numbers, int target) {
		for(int i=0;i<numbers.length;i++)
			for(int j=i+1;j<numbers.length;j++)
				if(numbers[i]+numbers[j]==target)
					return new int[]{i+1,j+1};
        return null;
    }
	public static void main(String[] args){
		int[] numbers={2,7,11,15};
		int[] res=new TwoSum_1().twoSum(numbers, 9);
		for(int a:res)
			System.out.print(a+" ");
	}
}
