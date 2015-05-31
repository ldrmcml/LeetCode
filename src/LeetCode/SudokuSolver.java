package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		// 回溯->递归
		// 假设存在唯一解
		solve(board);
	}
	// 递归
	public boolean solve(char[][] board){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(board[i][j]=='.'){
					for(char e='1';e<='9';e++){
						board[i][j]=e;
						if(isValid(board, i, j)&&solve(board)){
							return true;
						}
						board[i][j]='.';
					}
					return false;
				}
			}
		}
		return true;
	}
	public boolean isValid(char[][] board, int x, int y){
		Set<Character> set=new HashSet<Character>();
		//1.横行
		for(int i=x,j=0;j<9;j++){
			char e=board[i][j];
			if(e!='.'){
				if(set.contains(e)){
					return false;
				}else{
					set.add(e);
				}
			}
		}
		set.clear();

		//2.纵行
		for(int i=0,j=y;i<9;i++){
			char e=board[i][j];
			if(e!='.'){
				if(set.contains(e)){
					return false;
				}else{
					set.add(e);
				}
			}
		}
		set.clear();

		//3.九宫格 第i个九宫格的第j个元素
		x=3*(x/3)+y/3;
		for(int i=x,j=0;j<9;j++){
			char e=board[3*(i/3)+j/3][3*(i%3)+j%3];
			if(e!='.'){
				if(set.contains(e)){
					return false;
				}else{
					set.add(e);
				}
			}
		}

		return true;
	}
}
