package LeetCode;

public class LongestPalindromicSustring {
	public String longestPalindrome(String s) {
		if(s==null||s.equals(""))return null;
		if(s.length()==1)return s;
		boolean judge[][]=new boolean[1005][1005];
		//用以保存当前最长回文子串长度和左右端点
		int max=0,str1=0,str2=1,i,j,k;
		//中心元素坐标i从0到末尾
		for(i=0;i<s.length()-1;i++){
			//向两端扩展
			judge[i][i]=true;
			max=Math.max(max, 1);
			j=i;
			//直到找到不重复为止
			while(j<=s.length()-2&&s.charAt(i)==s.charAt(j+1)){
				j++;
				judge[i][j]=true;
			}
			if(max<j-i+1){
				str1=i;
				str2=j;
				max=j-i+1;
			}
			k=i;
			for(;k>0&&j<s.length()-1;k--,j++){
				if(judge[k][j]&&s.charAt(k-1)==s.charAt(j+1)){
					judge[k-1][j+1]=true;
					if(max<j-k+3){
						str1=k-1;
						str2=j+1;
						max=j-k+3;
					}
				}
			}
		}
		return s.substring(str1, str2+1);
	}
	public static void main(String[] args){
		String str="tattarrattat";
		System.out.println(new LongestPalindromicSustring().longestPalindrome(str));
	}
}
