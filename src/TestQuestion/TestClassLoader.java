package TestQuestion;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class TestClassLoader extends ClassLoader {
	private String basedir;
	public TestClassLoader(String basedir,ClassLoader parent){
		super(parent);
		this.basedir=basedir;
	}
	
	protected Class<?> findClass(String name) throws ClassNotFoundException{
		Class<?> cls=null;
		StringBuffer sb=new StringBuffer(basedir);
		String classname=name.replace('.', File.separatorChar)+".class";
		sb.append(File.separator+classname);
		File classF=new File(sb.toString());
		if(!classF.exists()){
			throw new ClassNotFoundException();
		}
		
		byte[] raw=new byte[(int)classF.length()];
		try{
			InputStream fin=new FileInputStream(classF);
			fin.read(raw);
			fin.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		cls=defineClass(name,raw,0,raw.length);
		return cls;
	}
}
