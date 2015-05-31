package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		Set<Character> set=new HashSet<Character>();
		//1.横行
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				char e=board[i][j];
				//				if(!('1'<=e&&e<='9'))
				//					return false;
				if(e!='.'){
					if(set.contains(e)){
						System.out.println(i+" "+j+" "+e+" 1");
						return false;
					}else{
						set.add(e);
					}
				}
			}
			set.clear();
		}

		//2.纵行
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				char e=board[j][i];
				//				if(!('1'<=e&&e<='9'))
				//					return false;
				if(e!='.'){
					if(set.contains(e)){
						System.out.println(i+" "+j+" "+e+" 2");
						return false;
					}else{
						set.add(e);
					}
				}
			}
			set.clear();
		}

		//3.九宫格 第i个九宫格的第j个元素
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				char e=board[3*(i/3)+j/3][3*(i%3)+j%3];
				//				if(!('1'<=e&&e<='9'))
				//					return false;
				if(e!='.'){
					if(set.contains(e)){
						System.out.println(i+" "+j+" "+e+" 3");
						return false;
					}else{
						set.add(e);
					}
				}
			}
			set.clear();
		}
		
		return true;
	}
	public static void main(String[] args){
		String[] sa={"845219763","389675421","761423985","258147396","694538172","137962854","926384517","513796248","472851639"};
		char[][] board = new char[9][9];
		for(int i=0;i<sa.length;i++){
			//board[i]=new char[9];
			for(int j=0;j<9;j++){
				board[i][j]=sa[i].charAt(j);
			}
		}
		ValidSudoku s=new ValidSudoku();
		System.out.println(s.isValidSudoku(board));
	}
}
