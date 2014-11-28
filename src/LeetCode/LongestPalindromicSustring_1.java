package LeetCode;

public class LongestPalindromicSustring_1 {
	public String longestPalindrome(String s) {
		if(s==null||s.equals(""))return null;
		if(s.length()==1)return s;
		
		//boolean judge[][]=new boolean[1005][1005];
		//用以保存当前最长回文子串长度和左右端点
		int max=0,start=0,end=0,i,j,k;
		//中心元素坐标i从0到末尾
		for(i=0;i<s.length()-1;i++){
			//向两端扩展
			if(i==0){
				if(s.charAt(0)==s.charAt(1)){
					max=1;
					start=0;
					end=1;
				}
			}else{
				k=i-1;
				j=i+1;
				while(k>=0&&j<s.length()&&s.charAt(k)==s.charAt(j)){
					k--;j++;
				}
				k++;j--;
				if(j-k+1>max){
					max=j-k+1;
					start=k;
					end=j;
				}
				
				if(s.charAt(i)==s.charAt(i+1)){
					k=i-1;j=i+2;
					while(k>=0&&j<s.length()&&s.charAt(k)==s.charAt(j)){
						k--;j++;
					}
				}
				k++;j--;
				if(j-k+1>max){
					max=j-k+1;
					start=k;
					end=j;
				}
			}
		}
		return s.substring(start, end+1);
	}
	public static void main(String[] args){
		String str="abb";
		System.out.println(new LongestPalindromicSustring_1().longestPalindrome(str));
	}
}
