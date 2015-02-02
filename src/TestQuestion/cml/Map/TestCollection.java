package TestQuestion.cml.Map;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
class Person {
	private String name;
	private Integer id_card;
	public Person(String name, Integer id_card){
		this.name=name;
		this.id_card=id_card;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId_card() {
		return id_card;
	}
	public void setId_card(Integer id_card) {
		this.id_card = id_card;
	}
}

public class TestCollection {
	public static void main(String[] args) {
		System.out.println("开始：");
		Person person1 = new Person("马先生", 220181);
		Person person2 = new Person("李先生", 220193);
		Person person3 = new Person("王小姐", 220186);
		Map<Number, Person> map = new HashMap<Number, Person>();
		map.put(person1.getId_card(), person1);
		map.put(person2.getId_card(), person2);
		map.put(person3.getId_card(), person3);
		System.out.println("由HashMap类实现的Map集合，无序：");
		for (Iterator<Number> it = map.keySet().iterator(); it.hasNext();) {// 遍例集合
			Person person = map.get(it.next());
			System.out.println(person.getId_card() + " " + person.getName());
		}
		System.out.println("由TreeMap类实现的Map集合，键对象升序：");
		TreeMap<Number, Person> treeMap = new TreeMap<Number, Person>();
		treeMap.putAll(map);
		treeMap.put(220186, new Person("test", 220186));
		for (Iterator<Number> it = treeMap.keySet().iterator(); it.hasNext();) {// 遍例集合
			Person person = treeMap.get(it.next());
			System.out.println(person.getId_card() + " " + person.getName());
		}
		System.out.println("由TreeMap类实现的Map集合，键对象降序：");
		TreeMap<Number, Person> treeMap2 = new TreeMap<Number, Person>(
				Collections.reverseOrder());// 初始化为反转排序
		treeMap2.putAll(map);
		for (Iterator<Number> it = treeMap2.keySet().iterator(); it.hasNext();) {// 遍例集合
			Person person = (Person) treeMap2.get(it.next());
			System.out.println(person.getId_card() + " " + person.getName());
		}
		System.out.println("结束！");
	}
}

