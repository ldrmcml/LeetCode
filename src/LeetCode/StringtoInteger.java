package LeetCode;
/**
 * Runtime error.数位累加
 * @author Administrator
 *
 */
public class StringtoInteger {
	public static int atoi(String str) {
	    if(str==null)
	    {
	        return 0;
	    }
	    str = str.trim();
	    if(str.length()==0)
	        return 0;
	    boolean isNeg = false;
	    int i = 0;
	    if(str.charAt(0)=='-' || str.charAt(0)=='+')
	    {
	        i++;
	        if(str.charAt(0)=='-')
	            isNeg = true;
	    }
	    int res = 0;
	    while(i<str.length()){
	    	if(str.charAt(i)>'9'||str.charAt(i)<'0')
	            break;
	        int digit = (int)(str.charAt(i)-'0');
	        //res*10+digit>-Integer.MIN_VALUE
	        //即-(res*10+digit)<Integer.MIN_VALUE
	        if(isNeg && res>-((Integer.MIN_VALUE+digit)/10))
	            return Integer.MIN_VALUE;
	        //res*10+digit>Integer.MAX_VALUE
	        else if(!isNeg && res>(Integer.MAX_VALUE-digit)/10)
	            return Integer.MAX_VALUE;
	        res = res*10+digit;
	        i++;
	    }
	    return isNeg?-res:res;
	}
	public static void main(String[] args){
		int num=0;//初始值
		try {
			num = atoi("-1123qwe123");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(num);
	}
}
