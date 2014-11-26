package LeetCode;

public class PalindromeNumber {
	public static boolean isPalindrome(int x) {
		//负数不算回文数
		//if(x<0)x=-x;
		String str=String.valueOf(x);
		int i=0,j=str.length()-1;
		while(i<j){
			if(str.charAt(i)!=str.charAt(j))
				return false;
			i++;
			j--;
		}
        return true;
    }
	public static void main(String[] args){
		System.out.println(isPalindrome(-1));
	}
}
