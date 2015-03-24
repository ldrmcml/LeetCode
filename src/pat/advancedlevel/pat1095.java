package pat.advancedlevel;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeSet;

class Rec{
	String plate;
	String date;
	String sta;
	public Rec(String plate, String date, String sta) {
		super();
		this.plate = plate;
		this.date = date;
		this.sta = sta;
	}
}
class Ti implements Comparable<Ti>{
	String plate;
	int len;
	
	public Ti(String plate, int len) {
		super();
		this.plate = plate;
		this.len = len;
	}

	@Override
	public int compareTo(Ti t) {
		// TODO Auto-generated method stub
		int x=t.len-len;
		if(x==0)
			return plate.compareTo(t.plate);
		return x;
	}
}
public class pat1095 {
	public static void display(Rec[] arr){
		for(int i=0;i<arr.length ;i++){
			Rec tmp=arr[i];
			System.out.println(tmp.plate+" "+tmp.date+" "+tmp.sta);
		}
	}
	public static void del(Rec[] arr){
		for(int i=0;i<arr.length;i++){
			
		}
	}
	public static int timelen(String d1,String d2){
		String[] a1=d1.split(":");
		int h1=Integer.parseInt(a1[0]);
		int m1=Integer.parseInt(a1[1]);
		int s1=Integer.parseInt(a1[2]);
		
		String[] a2=d2.split(":");
		int h2=Integer.parseInt(a2[0]);
		int m2=Integer.parseInt(a2[1]);
		int s2=Integer.parseInt(a2[2]);
		
		return 3600*(h2-h1)+60*(m2-m1)+s2-s1;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		Rec[] arr=new Rec[n];
		for(int i=0;i<n;i++){
			Rec tmp=new Rec(sc.next(),sc.next(),sc.next());
			arr[i]=tmp;
		}
		String[] que=new String[k];
		for(int i=0;i<k;i++){
			que[i]=sc.next();
		}
		Arrays.sort(arr, new Comparator<Rec>(){

			@Override
			public int compare(Rec o1, Rec o2) {
				// TODO Auto-generated method stub
				int t=o1.plate.compareTo(o2.plate);
				if(0==t){
					return o1.date.compareTo(o2.date);
				}
				return t;
			}
			
		});
		int[] num=new int[k];
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		for(int i=0;i<k;i++){
			num[i]=0;
		}
		for(int i=0;i<arr.length-1;i++){// 双层循环效率太低，注意到K个查询均是按时间先后顺序！
			Rec r1=arr[i];
			Rec r2=arr[i+1];
			if(r1.plate.equals(r2.plate)&&(r1.sta.equals("in")&&r2.sta.equals("out"))){
				int len=timelen(r1.date, r2.date);
				if(map.containsKey(r1.plate)){
					map.put(r1.plate, map.get(r1.plate)+len);
				}else{
					map.put(r1.plate, len);
				}
				for(int j=0;j<k;j++){
					if(r1.date.compareTo(que[j])<=0&&que[j].compareTo(r2.date)<0){
						num[j]++;
					}
				}
			}
		}
//		display(arr);
		for(int i=0;i<k;i++){
			System.out.println(num[i]);
		}
//		TreeSet ts=new TreeSet();
		int cur,max=-1,total=0;
		for(Entry e:map.entrySet()){
			cur=(Integer)e.getValue();
			if(cur>max){
				max=cur;
				total=1;
			}else if(cur==max){
				total++;
			}
		}
		String[] sa=new String[total];
		int index=0;
		for(Entry e:map.entrySet()){
			cur=(Integer)e.getValue();
			if(cur==max){
				sa[index++]=(String)e.getKey();
			}
		}
		Arrays.sort(sa);
		for(int i=0;i<index;i++){
			System.out.print(sa[i]+" ");
		}
		
//		TreeSet ts=new TreeSet();
//		for(Entry e:map.entrySet()){
//			cur=(Integer)e.getValue();
//			if(cur==max){
//				ts.add(e.getKey());
//			}
//		}
//		Iterator ite=ts.iterator();
//		while(ite.hasNext()){
//			System.out.print(ite.next()+" ");
//		}
		
		
//		Iterator ite=ts.iterator();
//		while(ite.hasNext()){
//			Ti t=(Ti) ite.next();
//			System.out.println(t.plate+":"+t.len);
//		}
//		Ti cur=(Ti) ite.next(),pre;
//		int len=cur.len;
//		while(ite.hasNext()){
//			System.out.print(cur.plate+" ");
//			pre=cur;
//			cur=(Ti) ite.next();
//			if(cur.len!=pre.len)break;
//		}
		System.out.printf("%02d:%02d:%02d",max/3600,max%3600/60,max%3600%60);
//		display(arr);
		sc.close();
	}
}
