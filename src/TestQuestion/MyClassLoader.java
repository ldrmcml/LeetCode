package TestQuestion;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;

public class MyClassLoader extends ClassLoader {
	//类加载器名称
	private String name;
	//加载类的路径
	private String path="D:/";
	private final String fileType=".class";
	public MyClassLoader(String name){
		//让系统类加载器成为该类加载器的父加载器
		super();
		this.name=name;
	}
	public MyClassLoader(ClassLoader parent,String name){
		//显示指定该类加载器的父加载器
		super(parent);
		this.name=name;
	}
	public String getPath(){
		return path;
	}
	public void setPath(String path){
		this.path=path;
	}
	@Override
	public String toString(){
		return this.name;
	}
	/**
	 * 获取.class文件的字节数组
	 * @param name
	 * @return
	 */
	private byte[] loaderClassData(String name){
		InputStream is=null;
		byte[] data=null;
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		this.name=this.name.replace(".", "/");
		try{
			is=new FileInputStream(new File(path+name+fileType));
			int c=0;
			while(-1!=(c=is.read())){
				baos.write(c);
			}
			data=baos.toByteArray();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				is.close();
				baos.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return data;
	}
	/**
	 * 获取Class对象
	 */
	@Override
	public Class<?> findClass(String name){
		byte[] data=loaderClassData(name);
		// Converts an array of bytes into an instance of class Class.
		return this.defineClass(name, data, 0, data.length);
	}

	public static void main(String[] args) throws ClassNotFoundException,InstantiationException,IllegalAccessException{
		//loader1的父加载器为系统类加载器
		MyClassLoader loader1=new MyClassLoader("loader1");
		loader1.setPath("D:/lib1/");
		//loader1.setPath("D:/eclipse workspace/ThinkinginJava/bin/TestQuestion/");
		//loader2的父加载器为loader1
		MyClassLoader loader2=new MyClassLoader(loader1,"loader2");
		loader2.setPath("D:/lib2/");
		//loader2.setPath("D:/eclipse workspace/ThinkinginJava/bin/TestQuestion/");
		//loader3的父加载器为根类加载器
		MyClassLoader loader3=new MyClassLoader(null,"loader3");
		loader3.setPath("D:/lib3/");
		//loader3.setPath("D:/eclipse workspace/ThinkinginJava/bin/TestQuestion/");
		
		//Sample is loaded by loader1
		//A is loaded by loader1
		//eclipse均默认自动编译
		//实验成功前提是Eclipse默认编译的class文件必须删除掉，否则系统类加载器会在classpath中找到
		//当执行loader2.loaderClass("Sample")时，先由它上层的所有父加载器尝试加载Sample类。
		//当执行loader1.loaderClass("Sample")时，先由它上层的所有父加载器尝试加载Sample类。
		//直到引导类加载器均无法找到Sample类
		//此时调用自定义类定义的findClass方法。loader1从D:/lib1/目录下成功的加载了Sample类，因此laoder1是Sample类的定义类加载器，loader1和loader2是Sample类的初始类加载器。
		//loadClass参数必须符合Java语言规范，即binary name，如java.lang.String，即加入包名
		Class clazz=loader3.loadClass("Sample");
		Object object=clazz.newInstance();
	}
}
//ClassLoader抽象类的关键方法
/*public Class<?> loadClass(String name) throws ClassNotFoundException {
	return loadClass(name,false);
}*/
/*protected synchronized Class<?> loadClass(String name,boolean resolve){
	//first,check if the class has already been loaded
	Class c=findLoadedClass(name);
	if(c==null){
		try{
			if(parent!=null){
				c=parent.loadClass(name,false);
			}else{
				c=findBootstrapClassOrNull(name);
			}
		}catch(ClassNotFoundException e){
			//ClassNotFoundException thrown if class not found
			//from the non-null parent class loader
		}
		if(c==null){
			//if still not found,then invoke findClass in order
			//to find the class.
			c=findClass(name);
		}
	}
	if(resolve){
		resolveClass(c);
	}
	return c;
}*/