package LeetCode;

public class LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
		if(null==strs||strs.length==0)return "";
//		int lenmin=0x7FFFFFFF;
		int lenmin=Integer.MAX_VALUE;
		int count=0;
		int sum;
		boolean flag=true;
		for(int i=0;i<strs.length;i++){
			if(strs[i].length()<lenmin)
				lenmin=strs[i].length();
		}
		for(int i=0;i<lenmin;i++){
			sum=strs[0].charAt(i);
			for(int j=1;j<strs.length;j++){
				if(sum!=strs[j].charAt(i)){
					flag=false;
					break;
				}
			}
			if(flag)count++;
		}
		String s=strs[0].substring(0, count);
		return s;
	}
	public static void main(String[] args){
		String[] strs=new String[]{"str","str1","str2"};
		System.out.println(longestCommonPrefix(strs));
	}
}
