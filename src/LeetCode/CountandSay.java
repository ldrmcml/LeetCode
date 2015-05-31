package LeetCode;

public class CountandSay {
	public String countAndSay(int n) {
		String[] sa=new String[n];
		sa[0]="1";
		for(int i=1;i<n;i++){
			StringBuffer sb=new StringBuffer();
			String tmp=sa[i-1];
			int count=1;
			for(int j=0;j<tmp.length()-1;j++){
				char c1=tmp.charAt(j);
				char c2=tmp.charAt(j+1);
				if(c1==c2){
					count++;
				}else{
					sb.append(count).append(c1);
					count=1;
				}
			}
			sb.append(count).append(tmp.charAt(tmp.length()-1));
			sa[i]=sb.toString();
		}
		return sa[n-1];
	}
	public static void main(String[] args){
		CountandSay s=new CountandSay();
		System.out.println(s.countAndSay(5));
	}
}
