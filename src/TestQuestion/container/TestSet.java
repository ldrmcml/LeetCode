package TestQuestion.container;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class TestSet {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
//		String sm=sc.next();
//		String sn=sc.next();
		String sm="babdacb";
		String sn="bc";
		
		Set<Character> set=new HashSet<Character>();
		for(int i=0;i<sn.length();i++)
			set.add(sn.charAt(i));
		/*第一种方案------------------------------*/
		/*StringBuffer sb=new StringBuffer();
		for(int i=0;i<sm.length();i++)
			if(!set.contains(sm.charAt(i)))
				sb.append(sm.charAt(i));
		System.out.println(sb);*/
		/*end------------------------------*/
		
		/*第二种方案------------------------------*/
		/*Iterator<Character> ite=set.iterator();
		while(ite.hasNext()){
			char c=ite.next();
			sm=sm.replaceAll(c+"", "");
		}
		System.out.println(sm);*/
		/*end------------------------------*/
		
		/*第三种方案，有问题sb删除之后i索引不对了！！！！------------------------------*/
		/*StringBuffer sb=new StringBuffer(sm);
		for(int i=0;i<sb.length();i++)
			if(set.contains(sb.charAt(i)))
				sb.deleteCharAt(i);
		System.out.println(sb);*/
		/*end------------------------------*/
		
		/*测试replace------------------------------*/
		/*String x="[k||kk//kkk\\kkkkk]";
//		String re=x.replaceAll("\\|", "h");
		String re=x.replace("\\", "h");
		//String re=x.replace('\\', 'h');
		System.out.println(re);*/
		/*end------------------------------*/
		
		sc.close();
	}
}
