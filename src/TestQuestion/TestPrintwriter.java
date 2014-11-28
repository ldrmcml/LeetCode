package TestQuestion;
 
import java.io.*;
import java.util.Scanner;

public class TestPrintwriter {

 /**
  * @param args
  */
 public static void main(String[] args) {
  // TODO Auto-generated method stub
	 
	//File filename=new File("printWriter.txt");
	 
	  FileWriter filename=null;
	  java.io.PrintWriter writer=null;
	  try{
	   filename=new FileWriter("printWriter.txt",true);
	      writer=new java.io.PrintWriter(filename);
	      
  /*File filename=new File("printWriter.txt");
  java.io.PrintWriter writer=null;
  try{
      writer=new java.io.PrintWriter(filename);*/
  }catch(FileNotFoundException e1){
   e1.printStackTrace();
   System.out.println("PrintWriter error while openning the file"+filename);
   System.exit(0);
  }catch(IOException e2){
	  e2.printStackTrace();
  }
  System.out.println("Enter four lines of text:");
  Scanner keyboard=new Scanner(System.in);
  for(int count=1;count<5;count++){
   String line=keyboard.nextLine();
   //write和println方法都可以写入文件，但是println可以根据系统输出换行
   writer.write(count+" "+line);
   //writer.println(count+" "+line);
  }
  writer.println("你好！");
  System.out.println("File is Successful write!");
  writer.close();
 }

}