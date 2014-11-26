package LeetCode;

public class StringtoInteger {
	public static int atoi(String str) {
		//null or ""
		if(str==null||str.equals(""))
			try {
				throw new Exception("null or blank string");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//去掉前后空白字符
		str=str.trim();
		for(int i=0;i<str.length();i++)
			if(!(str.charAt(i)>='0'&&str.charAt(i)<='9'))
				try {
					throw new Exception("contain not number");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		//"0123"
		int num=Integer.parseInt(str);
        return num;
    }
	public static void main(String[] args){
		int num=0;//初始值
		try {
			num = atoi("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(num);
	}
}
