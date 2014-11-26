package LeetCode;

import java.util.HashMap;
/**
 * 首先，对于cache，如果希望有O(1)的查找复杂度，肯定要用hashmap来保存key和对象的映射。
 * 对于LRU而言，问题在于如何用O(1)解决cache entry的替换问题。
 * 利用双向链表(队列)处理
 * 双向链表分别设置一个头结点和尾结点
 * @author Administrator
 *
 */
public class LRUCache {
	class CacheEntry{
		int key;
		int value;
		CacheEntry pre,next;
		CacheEntry(int key,int value){
			this.key=key;
			this.value=value;
			this.pre=null;
			this.next=null;
		}
	}
	//容量
	private int capacity;
	//存放数据
	private HashMap<Integer,LRUCache.CacheEntry> hashMap;
	//用于存放最近最少使用的记录
	private CacheEntry head,tail;
    
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.hashMap=new HashMap<Integer,LRUCache.CacheEntry>();
        //LinkedList实现了Queue接口，我们可以把LinkedList作为Queue使用
        //队列中至少存在首尾两个结点
        //头结点
        this.head=new CacheEntry(-1,-1);
        //尾结点
        this.tail=new CacheEntry(1,1);
        head.next=tail;
        tail.pre=head;
    }
    
    public int get(int key) {
    	if(hashMap.containsKey(key)){
    		CacheEntry cEntry=hashMap.get(key);
    		MoveToHead(cEntry);
    		return cEntry.value;
    	}else
    		return -1;
    }
    
    public void set(int key, int value) {
        if(hashMap.containsKey(key)){
        	//更新缓存项
        	CacheEntry cEntry=hashMap.get(key);
        	cEntry.value=value;
        	hashMap.put(key, cEntry);
        	MoveToHead(cEntry);
        }else{
        	//判断hashMap大小是否超出容量
        	if(hashMap.size()<capacity){
        		//新建CacheEntry项
        		CacheEntry cEntry=new CacheEntry(key,value);
        		hashMap.put(key, cEntry);
        		MoveToHead(cEntry);
        	}else{
        		//获取并删除队尾tail
        		CacheEntry cEntry=tail.pre;
        		hashMap.remove(cEntry.key);
        		RemoveTail();
        		//新建CacheEntry项
        		cEntry=new CacheEntry(key,value);
        		hashMap.put(key, cEntry);
        		MoveToHead(cEntry);
        	}
        }
    }
    //将cEntry项移到双向链表的队首，即head直接后继的位置
    public void MoveToHead(CacheEntry cEntry){
    	//如果不为新建项，此时为第一种情况只是更新value值
    	if(cEntry.pre!=null&&cEntry.pre!=null){
    		//此时需要更新两个指针，画图就很清楚了
    		cEntry.pre.next=cEntry.next;
    		cEntry.next.pre=cEntry.pre;
    	}
    	//假设为新建CacheEntry项，此时pre、next均为null，未入队列
    	//此时需要更新四个指针
    	cEntry.pre=head;
    	cEntry.next=head.next;
    	head.next.pre=cEntry;
    	head.next=cEntry;
    }
    //删除队尾，即tail直接前驱的位置，即最近最少使用的CacheEntry
    public void RemoveTail(){
    	//此时需要更新两个指针，画图就很清楚了
    	tail.pre.pre.next=tail;
    	tail.pre=tail.pre.pre;
    }
}