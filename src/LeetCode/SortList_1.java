package LeetCode;

/**
 * 堆排序实现
 * 空间复杂度为O(n)，不符合常数空间复杂度的要求
 * @author Administrator
 *
 */
public class SortList_1 {
	//交换数组下标为i、child的元素值
	public void swap(int a[],int i,int child){
		int tmp=a[i];
		a[i]=a[child];
		a[child]=tmp;
	}
	//数组元素从0开始
	//此处size应为堆大小，即数组元素个数
	public void adjust(int a[],int i,int size){
		//数组下标i从0开始
		int lchild=2*i+1,rchild=2*i+2;
		//从最后一个非叶子结点开始调整，0、1、2、3、4、5、6这样的完全二叉树，此时size为7
		//0<=(1-2)/2为true!!!!!!!!!!
		if(size>=2&&i<=(size-2)/2){
			//rchild已经超出数组
			if(rchild>size-1){
				if(a[i]<a[lchild]){
					swap(a,i,lchild);
					adjust(a,lchild,size);
					//已经调整即返回
					return;
				}
				return;
			}
			//左儿子大于等于右儿子
			if(a[lchild]>=a[rchild]){
				if(a[i]<a[lchild]){
					swap(a,i,lchild);
					adjust(a,lchild,size);
					//已经调整即返回
					return;
				}
				return;
			}
			//判断一下万一最后一个非叶子结点没有右儿子
			//size为元素个数
			if(a[i]<a[rchild]){
				swap(a,i,rchild);
				adjust(a,rchild,size);
			}
		}
	}
	public void adjust1(int a[],int i,int size){
		//数组下标i从0开始
		int lchild=2*i+1,rchild=2*i+2;
		//用max记录最大数数组序号
		int max=i;
		//从最后一个非叶子结点开始调整，0、1、2、3、4、5、6这样的完全二叉树，此时size为7
		//0<=(1-2)/2为true!!!!!!!!!!
		if(2*i+1<=size-1){
			//两两比较，得到i结点和左右儿子最大数的序号
			if(a[max]<a[lchild])
				max=lchild;
			if(rchild<=size-1&&a[max]<a[rchild])
				max=rchild;
			//如果最大序号不为i，则需要交换
			if(max!=i){
				swap(a,i,max);
				adjust1(a,max,size);
			}
		}
	}
	//构造初始化堆
	public void InitHeap(int a[]){
		int size=a.length;
		for(int i=(size-2)/2;i>=0;i--){
			adjust1(a,i,size);
		}
	}
	public void HeapSort(int a[]){
		InitHeap(a);
		for(int i=0;i<a.length-1;i++){
			//交换堆顶和最末元素
			swap(a,0,a.length-1-i);
			adjust1(a,0,a.length-1-i);
		}
	}
    public ListNode sortList(ListNode head) {
    	int len=0;
    	ListNode node=head;
    	while(node!=null){
    		len++;
    		node=node.next;
    	}
        int[] arr=new int[len];
        int i=0;
        node=head;
        while(node!=null){
        	arr[i++]=node.val;
        	node=node.next;
        }
        HeapSort(arr);
        node=head;
        i=0;
        while(node!=null){
        	node.val=arr[i++];
        	node=node.next;
        }
        return head;
    }
    
    public static void main(String[] args){
    	int[] arr=new int[]{-1,2,-4,9,3,11,13,0};
    	ListNode head=new ListNode(arr[0]),node=head;;
    	for(int i=1;i<arr.length;i++){
    		node.next=new ListNode(arr[i]);
    		node=node.next;
    	}
    	new SortList_1().sortList(head);
    	node=head;
    	while(node!=null){
    		System.out.print(node.val+" ");
    		node=node.next;
    	}
    }
}