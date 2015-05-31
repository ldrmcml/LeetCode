package program.chapter2.greedy;

import java.util.Arrays;

public class QujianDiaodu {
	public final class Pair implements Comparable<Pair> {
		int first;
		int second;
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			if(first==o.first)return second-o.second;
			return first-o.first;
		}
	}
	int n=5,s[]={1,2,4,6,8},t[]={3,5,7,9,10};// t为结束时间，s为开始时间
	Pair itv[]=new Pair[n];
	// 贪心原则：在可选的工作中，每次都选取结束时间最早的工作
	public void solve(){
		// 对pair进行排序
		// 未来让结束时间早的工作排在前面，把t存入first，把s存入second
		for(int i=0;i<n;i++){
			itv[i]=new Pair();
			itv[i].first=t[i];
			itv[i].second=s[i];
		}
		Arrays.sort(itv);
		
		// t是最后所选工作的结束时间
		int ans=0,t=0;
		for(int i=0;i<n;i++){
			if(t<itv[i].second){
				ans++;
				t=itv[i].first;
			}
		}
		System.out.println(ans);
	}
	public static void main(String[] args){
		new QujianDiaodu().solve();
	}
}
