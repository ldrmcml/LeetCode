package LeetCode;

/**
 * 大堆排序
 * @author Administrator
 *
 */
public class BigHeapSort {
	public int a[];
	//用数组构造
	public BigHeapSort(int a[]){
		this.a=a;
	}
	//交换数组下标为i、child的元素值
	public void swap(int i,int child){
		int tmp=a[i];
		a[i]=a[child];
		a[child]=tmp;
	}
	//数组元素从0开始
	//此处size应为堆大小，即数组元素个数
	public void adjust(int i,int size){
		//数组下标i从0开始
		int lchild=2*i+1,rchild=2*i+2;
		//从最后一个非叶子结点开始调整，0、1、2、3、4、5、6这样的完全二叉树，此时size为7
		//0<=(1-2)/2为true!!!!!!!!!!
		if(size>=2&&i<=(size-2)/2){
			//rchild已经超出数组
			if(rchild>size-1){
				if(a[i]<a[lchild]){
					swap(i,lchild);
					adjust(lchild,size);
					//已经调整即返回
					return;
				}
				return;
			}
			//左儿子大于等于右儿子
			if(a[lchild]>=a[rchild]){
				if(a[i]<a[lchild]){
					swap(i,lchild);
					adjust(lchild,size);
					//已经调整即返回
					return;
				}
				return;
			}
			//判断一下万一最后一个非叶子结点没有右儿子
			//size为元素个数
			if(a[i]<a[rchild]){
				swap(i,rchild);
				adjust(rchild,size);
			}
		}
	}
	public void adjust1(int i,int size){
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
				swap(i,max);
				adjust1(max,size);
			}
		}
	}
	//构造初始化堆
	public void InitHeap(){
		int size=a.length;
		for(int i=(size-2)/2;i>=0;i--){
			adjust(i,size);
		}
	}
	public void HeapSort(){
		InitHeap();
		for(int i=0;i<a.length-1;i++){
			//交换堆顶和最末元素
			swap(0,a.length-1-i);
			adjust(0,a.length-1-i);
		}
	}
	public static void main(String[] args){
		int a[]={-1,5,0,7,7,8,9,3,2,-7};
		BigHeapSort bigHeapSort=new BigHeapSort(a);
		for(int e:bigHeapSort.a)
			System.out.print(e+" ");
		System.out.println();
		bigHeapSort.HeapSort();
		for(int e:bigHeapSort.a)
			System.out.print(e+" ");
	}
}
