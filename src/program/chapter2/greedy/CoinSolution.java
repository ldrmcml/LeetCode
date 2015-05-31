package program.chapter2.greedy;
/**
 * 硬币问题
 * @author ldrmcml
 *
 */
public class CoinSolution {
	// 硬币的面值
	// 贪心原则：优先使用面值大的硬币
	public static final int V[]={1,5,10,50,100,500};
	public void solve(int A, int C[]){
		int ans=0,a=A;
		for(int i=C.length-1;i>=0;i--){
			int t=Math.min(a/V[i], C[i]);
			a-=t*V[i];
			ans+=t;
		}
		System.out.println(ans);
	}
	public static void main(String[] args){
		// 各种币值个数
		int C[]={3,2,1,3,0,2},A=620;
		new CoinSolution().solve(A, C);
	}
}
