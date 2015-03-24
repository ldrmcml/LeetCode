package pat.advancedlevel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Testee{
	String regNum;
	Integer score;
	Integer place;
	Integer finalRank;
	Integer localRank;
	Integer pcount;
	public Testee(String regNum, int score, int place, int pcount) {
		super();
		this.regNum = regNum;
		this.score = score;
		this.place = place;
		this.pcount=pcount;
	}
	@Override
	public String toString() {
		return regNum + " " + finalRank + " "
				+ place+ " "+localRank;
	}
}
public class pat1025 {
	public static void rank(List<Testee> list){
		list.get(0).finalRank=1;
		for(int i=1;i<list.size();i++){
			list.get(i).finalRank=i;
			if(list.get(i).score==list.get(i-1).score)
				list.get(i).finalRank=list.get(i-1).finalRank;
		}
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		List<Testee> list=new ArrayList<Testee>();
		int n=sc.nextInt();
		Testee tmp;
		int pcount, count=0;
		for(int i=1;i<=n;i++){
			pcount=sc.nextInt();
			count+=pcount;
			for(int j=0;j<pcount;j++){
				tmp=new Testee(sc.next(), sc.nextInt(), i, pcount);
				list.add(tmp);
			}
		}
		
		Collections.sort(list, new Comparator<Testee>(){
			public int compare(Testee t0, Testee t1){
				int i=t0.place.compareTo(t1.place);
				if(0==i){
					return t1.score.compareTo(t0.score);
				}
				return i;
			}
		});
		int j=2;
		list.get(0).localRank=1;
		for(int i=1;i<list.size();i++){
			if(list.get(i).place!=list.get(i-1).place)j=1;
			if(1!=j&&list.get(i).score==list.get(i-1).score){
				list.get(i).localRank=list.get(i-1).localRank;
				j++;
			}
			else
				list.get(i).localRank=j++;
		}
//		for(Testee t:list)
//			System.out.println(t);
		
		Collections.sort(list, new Comparator<Testee>(){
			public int compare(Testee t0, Testee t1){
				int i=t1.score.compareTo(t0.score);
				if(0==i){
					return t0.regNum.compareTo(t1.regNum);
				}
				return i;
			}
		});
		list.get(0).finalRank=1;
		for(int i=1;i<list.size();i++){
			list.get(i).finalRank=i+1;
			if(list.get(i).score==list.get(i-1).score)
				list.get(i).finalRank=list.get(i-1).finalRank;
		}
		
		System.out.println(count);
		for(Testee t:list)
			System.out.println(t);
		sc.close();
	}
}
