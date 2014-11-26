package LeetCode;

import java.util.Random;

/**
 * use StringBuilder.StringBuilder不是线程安全的，但是在单线程中性能要比StringBuffer好
 * @author admin
 *
 */
public class ZigZagConversion {
	public static String convert(String s, int nRows) {
		if(nRows==1)return s;
	    StringBuilder[] sArr=new StringBuilder[nRows];
	    for(int i=0;i<nRows;i++)sArr[i]=new StringBuilder("");
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
		//new StringBuffer()无参构造器默认创建空白字符串“”，且初始容量为16字符
		//System.out.println(new StringBuffer().append("Hello"));
		System.out.println(convert("PAYPALISHIRING",2));
		Random random=new Random(System.currentTimeMillis());
		int num=random.nextInt();
		System.out.println("random number:"+num);
		try{
			throw new Exception("devide 0");
		}catch(Exception e){
			System.err.println("Exception:"+e);
			e.printStackTrace();
			System.exit(1);
		}
	}
}
