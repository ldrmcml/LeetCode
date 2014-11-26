package LeetCode;
/**
 * use String
 * @author admin
 *
 */
public class ZigZagConversion_2 {
	public static String convert(String s, int nRows) {
		if(nRows==1)return s;
	    //StringBuffer[] sArr=null;
	    //for(int i=0;i<nRows;i++)sArr[i]=new StringBuffer("");
		String[] sArr=new String[nRows];
	    for(int i=0;i<nRows;i++)sArr[i]=new String("");
		for(int i=0;i<s.length();i++){
	    	int cycle=nRows*2-2;
	    	int num=i%cycle;
	    	if(num<nRows)sArr[num]+=s.charAt(i);
			if(num>=nRows)sArr[2*(nRows-1)-num]+=s.charAt(i);
	    }
		for(int i=1;i<nRows;i++)
			sArr[0]+=sArr[i];
	    return sArr[0];
	}
	public static void main(String[] args){
		System.out.println(convert("PAYPALISHIRING",2));
	}
}
