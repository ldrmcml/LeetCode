package LeetCode;

import java.util.HashMap;
import java.util.Map;

class Node{
	int data;
	Node pre,next;
	public Node(int data) {
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}

}
public class LRUCache_DuLinkList {
	int capacity;
	Map map;
	Node head,tail;
	public LRUCache_DuLinkList(int capacity, Map map) {
		this.capacity = capacity;
		this.map=new HashMap();
	}
	public int get(int key){
		if(map.containsKey(key)){
			Node node=(Node)map.get(key);
			Node pre=node.pre;
			Node next=node.next;
			pre.next=next;
			next.pre=pre;

			next=head;
			node.next=next;
			next.pre=node;
			node.pre=null;
			head=node;
			return node.getData();
		}else{
			return -1;
		}
	}
	public void set(int key,int value){
		if(map.containsKey(key)){
			Node node=(Node)map.get(key);
			node.data=value;
			
			Node pre=node.pre;
			Node next=node.next;
			pre.next=next;
			next.pre=pre;

			next=head;
			node.next=next;
			next.pre=node;
			node.pre=null;
			head=node;
		}else{
			if(map.size()<capacity){
				Node node=new Node(key);

				Node next=head;
				node.next=next;
				node.pre=null;
				head=node;
				
				map.put(key, node);
			}else{
				map.remove(tail.data);
				// 删除表尾
				tail=tail.pre;
				tail.next=null;
				// 新建节点，在表头插入
				Node node=new Node(key);

				Node next=head;
				node.next=next;
				node.pre=null;
				head=node;
				
				map.put(key, node);
			}
		}
	}
}
