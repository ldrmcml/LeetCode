package TestQuestion;   

import java.io.ByteArrayInputStream;   
import java.io.ByteArrayOutputStream;   
import java.io.IOException;   
import java.io.ObjectInputStream;   
import java.io.ObjectOutputStream;   
import java.util.ArrayList;   
import java.util.List;   

public class TestMain {   

	/**  
	 * @param args  
	 */  
	public static void main(String[] args) {   
		List<Userinfo> src = new ArrayList<Userinfo>(2);   
		Userinfo ui1 = new Userinfo();   
		ui1.setId(1);   
		ui1.setName("aaa");   
		src.add(ui1);   

		Userinfo ui2 = new Userinfo();   
		ui2.setId(2);   
		ui2.setName("bbb");   
		src.add(ui2);   
		
		System.out.println(src);   
		List<Userinfo> dest = new ArrayList<Userinfo>(2);   

		TestMain test = new TestMain();   
		try {
			dest = test.deepCopy(src);   
		} catch (IOException e) {   
			e.printStackTrace();   
		} catch (ClassNotFoundException e) {   
			e.printStackTrace();   
		}   
		System.out.println(src==dest);   
		Userinfo u = (Userinfo)src.get(0);   
		Userinfo uu = (Userinfo)dest.get(0);   
		uu.setName("dkkdkddk");   
		System.out.println(u.getName());   

		System.out.println(uu.getName());   

	}   

	public List deepCopy(List src) throws IOException, ClassNotFoundException{   
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();   
		ObjectOutputStream out = new ObjectOutputStream(byteOut);   
		out.writeObject(src);   

		ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());   
		ObjectInputStream in =new ObjectInputStream(byteIn);   
		List dest = (List)in.readObject();   
		return dest;   
	}   
}  