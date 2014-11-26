package LeetCode;

import java.util.HashMap;

class Point {
	int x;
	int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
}
public class MaxPointsOnALine {
	public static int maxPoints(Point[] points) {
		if(points==null||points.length==0)return 0;
        //利用HashMap存取斜率，key为斜率，value为点个数
		HashMap<Float,Integer> hashMap=new HashMap<Float,Integer>();
		float k;
		//max为与出发点同一直线的点数(不包括出发点)
		int max=0;
		int tmp=0;//一组比较过后同一条线最大点数
		int duplicate=0;
		//以一点出发，求取斜率相同点数
		for(int i=0;i<points.length;i++){
			hashMap.clear();
			//计算其他点到该点的斜率，并记录点数
			//infinite存取斜率无穷大的情况，即与y轴平行，x坐标相等
			duplicate=0;
			tmp=0;
			for(int j=0,infinite=0;j<points.length;j++){
				if(j!=i){
					if(points[j].x==points[i].x&&points[j].y==points[i].y)duplicate++;
					else if(points[j].x==points[i].x&&points[j].y!=points[i].y){
						infinite++;
						tmp=Math.max(tmp, infinite);
					}
					else{
						k=(float)(points[j].y-points[i].y)/(points[j].x-points[i].x);
						if(hashMap.containsKey(Float.valueOf(k))){
							int num=hashMap.get(Float.valueOf(k));
							hashMap.put(Float.valueOf(k), ++num);
							tmp=Math.max(tmp, num);
						}else{
							hashMap.put(Float.valueOf(k), 1);
							tmp=Math.max(tmp, 1);
						}
					}
				}
			}
			tmp+=duplicate;
			max=Math.max(max, tmp);
		}
		//max没有包括出发点
		return max+1;
    }
	public static void main(String[] args){
        //Point[] array = { new Point(0,0),new Point(0,0)};
        //Point[] array = { new Point(0,0), new Point(0,0),new Point(0,0), new Point(0,0)};
        //Point[] array = { new Point(84,250), new Point(0,0) , new Point(1,0), new Point(0,-70), new Point(0,-70), new Point(1,-1), new Point(21,10), new Point(42,90),new Point(-42,-230)};
        //Point[] array = { new Point(0,0), new Point(0,1)};
        //Point[] array = { new Point(0,0), new Point(1,0)};
        //Point[] array = { new Point(1,1), new Point(1,2), new Point(1,3)};
        //Point[] array = { new Point(0,0), new Point(0,1), new Point(0,0)};
        //Point[] array = { new Point(2,3), new Point(3,3),new Point(-5,3)};
        //array.length为132
		Point[] array = {new Point(40,-23),new Point(9,138),new Point(429,115),new Point(50,-17),new Point(-3,80),new Point(-10,33),new Point(5,-21),new Point(-3,80),new Point(-6,-65),new Point(-18,26),new Point(-6,-65),new Point(5,72),new Point(0,77),new Point(-9,86),new Point(10,-2),new Point(-8,85),new Point(21,130),new Point(18,-6),new Point(-18,26),new Point(-1,-15),new Point(10,-2),new Point(8,69),new Point(-4,63),new Point(0,3),new Point(-4,40),new Point(-7,84),new Point(-8,7),new Point(30,154),new Point(16,-5),new Point(6,90),new Point(18,-6),new Point(5,77),new Point(-4,77),new Point(7,-13),new Point(-1,-45),new Point(16,-5),new Point(-9,86),new Point(-16,11),new Point(-7,84),new Point(1,76),new Point(3,77),new Point(10,67),new Point(1,-37),new Point(-10,-81),new Point(4,-11),new Point(-20,13),new Point(-10,77),new Point(6,-17),new Point(-27,2),new Point(-10,-81),new Point(10,-1),new Point(-9,1),new Point(-8,43),new Point(2,2),new Point(2,-21),new Point(3,82),new Point(8,-1),new Point(10,-1),new Point(-9,1),new Point(-12,42),new Point(16,-5),new Point(-5,-61),new Point(20,-7),new Point(9,-35),new Point(10,6),new Point(12,106),new Point(5,-21),new Point(-5,82),new Point(6,71),new Point(-15,34),new Point(-10,87),new Point(-14,-12),new Point(12,106),new Point(-5,82),new Point(-46,-45),new Point(-4,63),new Point(16,-5),new Point(4,1),new Point(-3,-53),new Point(0,-17),new Point(9,98),new Point(-18,26),new Point(-9,86),new Point(2,77),new Point(-2,-49),new Point(1,76),new Point(-3,-38),new Point(-8,7),new Point(-17,-37),new Point(5,72),new Point(10,-37),new Point(-4,-57),new Point(-3,-53),new Point(3,74),new Point(-3,-11),new Point(-8,7),new Point(1,88),new Point(-12,42),new Point(1,-37),new Point(2,77),new Point(-6,77),new Point(5,72),new Point(-4,-57),new Point(-18,-33),new Point(-12,42),new Point(-9,86),new Point(2,77),new Point(-8,77),new Point(-3,77),new Point(9,-42),new Point(16,41),new Point(-29,-37),new Point(0,-41),new Point(-21,18),new Point(-27,-34),new Point(0,77),new Point(3,74),new Point(-7,-69),new Point(-21,18),new Point(27,146),new Point(-20,13),new Point(21,130),new Point(-6,-65),new Point(14,-4),new Point(0,3),new Point(9,-5),new Point(6,-29),new Point(-2,73),new Point(-1,-15),new Point(1,76),new Point(-4,77),new Point(6,-29)};
        //最后一个测试用例是leetCode上面最难AC的一个数据，正确答案应该是25，小伙伴们AC了吗？
        System.out.println(MaxPointsOnALine.maxPoints(array));
	}
}
