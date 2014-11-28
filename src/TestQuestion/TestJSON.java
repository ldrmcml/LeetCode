package TestQuestion;

import java.util.HashMap;
import com.alibaba.fastjson.JSON;
/**
 * public static final Object parse(String text); // 把 JSON 文本 parse 为 JSONObject 或者 JSONArray 
 * public static final JSONObject parseObject(String text)；  //  把 JSON 文本 parse 成 JSONObject 
 * public static final <T> T parseObject(String text, Class<T> clazz); // 把 JSON 文本 parse 为 JavaBean 
 * public static final JSONArray parseArray(String text); // 把 JSON 文本 parse 成 JSONArray 
 * public static final <T> List<T> parseArray(String text, Class<T> clazz); //把 JSON 文本 parse 成 JavaBean 集合 
 * public static final String toJSONString(Object object); // 将 JavaBean 序列化为 JSON 文本 
 * public static final String toJSONString(Object object, boolean prettyFormat); // 将 JavaBean 序列化为带格式的 JSON 文本 
 * public static final Object toJSON(Object javaObject); 将 JavaBean 转换为 JSONObject 或者 JSONArray
 * @author Administrator
 *
 */
public class TestJSON {
	String text;
	HashMap<String,String> javaBean;
	
	public void SerializeJSONTexxt(){
		HashMap<String,String> json=new HashMap<String,String>();
		json.put("rawmaterial","raw");
		json.put("process","pro");
		json.put("trans","tra");
		json.put("sale","sale");
		
		text=JSON.toJSONString(json);
	}
	@SuppressWarnings("unchecked")
	public void ParseToJavaBean(String text){
		try {
			javaBean=(HashMap<String, String>) JSON.parseObject(text,Class.forName("java.util.HashMap"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		TestJSON testJSON=new TestJSON();
		testJSON.SerializeJSONTexxt();
		System.out.println(testJSON.text);
		testJSON.ParseToJavaBean(testJSON.text);
		System.out.println(testJSON.javaBean.get("sale"));
	}

}
