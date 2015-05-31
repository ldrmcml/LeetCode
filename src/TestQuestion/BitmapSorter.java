package TestQuestion;
public class BitmapSorter {
	public static void main(String[] args) {
		double d=-27.2345;
		System.out.println(Math.ceil(d));
		System.out.println(Math.round(d));
		System.out.println(Math.floor(d));
		System.out.println(Math.abs(d));
		
		int [] arr = { 1 , 7 , - 3 , 0 , 0 , 6 , 6 , 9 , - 11 } ;
		bitmapSort(arr);
		for ( int i:arr) {
			System.out.print(i + " , " );
		}
	}
	/**
	 * 使用位图法进行排序
	 * @param arr
	 */
	public static void bitmapSort( int [] arr) {
		// 找出数组中最值
		int max = arr[ 0 ];
		int min = max;
		for ( int i:arr) {
			if (max < i) {
				max = i;
			}
			if (min > i) {
				min = i;
			}
		}
		// 得到位图数组，局部数组初值为0
		int [] newArr = new int [max -min + 1 ];
		for ( int i:arr) {
			int index = i - min;
			newArr[index] ++ ;
		}
		// 重整arr中的元素
		int index = 0 ;
		for ( int i = 0 ;i <newArr.length;i ++ ) {
			while (newArr[i] > 0 ) {
				arr[index] = i + min;
				index ++ ;
				newArr[i] -- ;
			}
		}
	}
}