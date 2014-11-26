package LeetCode;
/**
 * use StringBuffer
 * @author admin
 *
 */
public class ZigZagConversion_3 {
	public static String convert(String s, int nRows) {
		if(nRows==1)return s;
	    StringBuffer[] sArr=new StringBuffer[nRows];
	    for(int i=0;i<nRows;i++)sArr[i]=new StringBuffer("");
		for(int i=0;i<s.length();i++){
	    	int cycle=nRows*2-2;
	    	int num=i%cycle;
	    	if(num<nRows)sArr[num].append(s.charAt(i));
			if(num>=nRows)sArr[2*(nRows-1)-num].append(s.charAt(i));
	    }
		for(int i=1;i<nRows;i++)
			sArr[0].append(sArr[i]);
	    return sArr[0].toString();
	}
	public static void main(String[] args){
		System.out.println(convert("PAYPALISHIRING",2));
	}
}
