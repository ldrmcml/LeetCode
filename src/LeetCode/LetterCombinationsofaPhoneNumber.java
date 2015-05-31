package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
	public void dfs(List<String> list,String[] str,String digits,int index){
		
	}
	public void dfsTree(String digits,int index,char[] middleStr,String[] map,List<String> result){
		if(index==digits.length()){
			result.add(new String(middleStr));
			return ;
		}
		char strChar=digits.charAt(index);
		for(int i=0;i<map[strChar-'0'].length();i++){
			middleStr[index]=map[strChar-'0'].charAt(i);
			dfsTree(digits,index+1,middleStr,map,result);
		}
	}
	public List<String> letterCombinations(String digits) {
		List<String> list=new ArrayList<String>();
		if(null==digits||digits.length()==0)return list;
		String[] str={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		char[] middleTemp=new char[digits.length()];
		dfsTree(digits,0,middleTemp,str,list);
		return list;
	}
	public static void main(String[] args){
		System.out.println(new LetterCombinationsofaPhoneNumber().letterCombinations("4836"));
	}
}
