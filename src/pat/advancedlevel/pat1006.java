package pat.advancedlevel;

import java.util.Scanner;
public class pat1006 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		// lines
		int m = scanner.nextInt();
		String first,last;
		first=last=scanner.next();
		String date1=scanner.next();
		String date2=scanner.next();
		String tmp,dtmp1,dtmp2;
		for(int i=0;i<m-1;i++){
			tmp=scanner.next();
			dtmp1=scanner.next();
			dtmp2=scanner.next();
			if(dtmp1.compareTo(date1)<0){first=tmp;date1=dtmp1;}
			if(dtmp2.compareTo(date2)>0){last=tmp;date2=dtmp2;}
		}
		System.out.println(first+" "+last);
		scanner.close();
	}
}
