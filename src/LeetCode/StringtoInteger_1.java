package LeetCode;
/**
 * Runtime error.使用了java类库Integer.parseInt(String)
 * @author Administrator
 *
 */
public class StringtoInteger_1 {
	public static int atoi(String str) {
		//null or ""
		if(str==null||str.equals(""))
			return 0;
		//去掉前后空白字符
		str=str.trim();
		//取得符号
		boolean minus=false;
		//原字符串取出符号
		if(str.charAt(0)=='-'){
			minus=true;
			str=str.substring(1);
		}else if(str.charAt(0)=='+'){
			str=str.substring(1);
		}
		if(!(str.charAt(0)>='0'&&str.charAt(0)<='9'))return 0;
		for(int i=1;i<str.length();i++)
			if(!(str.charAt(i)>='0'&&str.charAt(i)<='9'))
				str=str.substring(0,i);
		//上溢出
		if(!minus){
			if(str.length()>10)return Integer.MAX_VALUE;
			else if(str.length()==10&&str.compareTo("2147483647")>0)
				return Integer.MAX_VALUE;
		}else{//下溢出
			if(str.length()>10)return Integer.MIN_VALUE;
			else if(str.length()==10&&str.compareTo("2147483648")>0)
				return Integer.MIN_VALUE;
		}
		
		//负数
		//"0123"
		int num=Integer.parseInt(str);
		if(minus)num=-num;
        return num;
    }
	public static void main(String[] args){
		int num=0;//初始值
		try {
			num = atoi("-1123qwe123");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(num);
	}
}
