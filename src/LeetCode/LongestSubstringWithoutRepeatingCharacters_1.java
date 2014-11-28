package LeetCode;
/**
 * 未使用HashMap
 * @author Administrator
 *
 */
public class LongestSubstringWithoutRepeatingCharacters_1 {
	public int lengthOfLongestSubstring(String s) {
		if(s==null||s.length()==0)return 0;
        //动态规划
		//设s0s1s2...si...sn为字符串,len[i]为以si为结尾的最长不重复子串长度
		int len[]=new int[s.length()];
		//设置max保存当前最大长度，至少为1，相当于与len[0]比较过了
		int max=1;
		//设置标志，是否与前面子串存在重复
		boolean flag=false;
		//求递推公式
		len[0]=1;
		//i从1开始，求len[i]
		for(int i=1;i<s.length();i++){
			//将当前字符与前面子串(s0...si-1)一一比较
			//有遇到重复字符
			//初始化标志位
			flag=false;
			for(int j=i-len[i-1];j<i;j++)
				if(s.charAt(j)==s.charAt(i)){
					len[i]=i-j;
					//遇到了重复字符
					flag=true;
					break;
				}
			//未遇到重复字符
			if(!flag)len[i]=len[i-1]+1;
			max=Math.max(max, len[i]);
		}
		return max;
    }
	public static void main(String[] args){
		String str="wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		System.out.println(new LongestSubstringWithoutRepeatingCharacters_1().
				lengthOfLongestSubstring(str));
	}
}
