package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;;
/**
 * 利用队列处理
 * Time Limit Exceed超时
 * @author Administrator
 *
 */
public class LRUCache_Queue {
	//容量
	private int capacity;
	//存放数据
	private HashMap<Integer,Integer> hashMap;
	//用于存放最近最少使用的记录
	private Queue<Integer> queue;
    
    public LRUCache_Queue(int capacity) {
        this.capacity=capacity;
        this.hashMap=new HashMap<Integer,Integer>();
        //LinkedList实现了Queue接口，我们可以把LinkedList作为Queue使用
        this.queue=new LinkedList<Integer>();
    }
    
    public int get(int key) {
    	if(hashMap.containsKey(key)){
    		//poll顺序询问，轮询
    		if(queue.contains(key)){
    			//这儿的处理将不是O(1)时间复杂度，下同
    			queue.remove(key);
    		}
    		queue.offer(key);
    		return hashMap.get(key);
    	}else
    		return -1;
    }
    
    public void set(int key, int value) {
        if(hashMap.containsKey(key)){
        	hashMap.put(key, value);
        }
        else{
        	//判断hashMap大小是否超出容量
        	if(hashMap.size()<capacity){
        		hashMap.put(key, value);
        	}else{
        		//获取并删除队列front
        		hashMap.remove(queue.poll());
        		hashMap.put(key, value);
        	}
        }
        if(queue.contains(key)){
			queue.remove(key);
		}
		queue.offer(key);
    }
}