package TestQuestion;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateExcel {
	public static void main(String[] args){
		 FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("c:\\Result.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Random random=new Random(System.currentTimeMillis());
		   for (int i = 0; i < 100000; i++) {
		    try {
				fileWriter.write("姓名"+String.valueOf(i)+" "+String.valueOf(i)+" "+random.nextInt(100)+"\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     }
		   try {
			fileWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   try {
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
