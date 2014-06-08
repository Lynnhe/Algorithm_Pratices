package a1033;

/**
 * 找出下面给出图形的规律，给出n，画一个n行的对应图形。
　　1 2 3 4
　　12 13 14 5
　　11 16 15 6
　　10 9 8 7
 * 
 * 
 * 这题花了好多冤枉时间。
 * 因为用了很多全局变量，debug时看不到全局变量的值，所以只好用最原始的方法print出来，才发现问题所在：全局变量没有正确使用。
 * 使用全局变量时，不能把全局变量当做参数传给函数，比如field，因为基本类型值作为参数传递时是值传递，函数内值的变化不会影响到参数本身。
 * 
 * 
 * 本题的思路是把矩阵想象成一个棋盘，有一个虫子在棋盘上顺时针转，条件是不能走出棋盘，且不能走已经走过的格子。
 * 走过的格子要做上标记。
 * 
 * */


import java.util.Scanner;

public class Main {
	private static final int UP = 1;
	private static final int RIGHT = 2;
	private static final int DOWN =3;
	private static final int LEFT = 4;
	
	private static int[][]field;
	private static int count = 1;
	private static int num;
	private static int direction = RIGHT;
	private static int y=0;
	private static int x=0;

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		field = prepareFiled(num);      //初始化棋盘
		startCrawl();                  //开始爬
		printField();                  //打印结果
	}
	
	public static void printField(){
		for(int i = 0;i<num;i++){
			for(int j=0;j<num;j++){
				System.out.print(field[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static int[][] prepareFiled(int n){
		field = new int[n][n];
		return field;		
	}
	
	public static void startCrawl(){
		while(count<=num*num){      //控制循环的逻辑
			field[y][x]=count;      //赋值，作为已经走过的判断标准。
			count +=1;
			crawl();          //虫子爬一格
		}		
	}
	
	public static void crawl(){
		switch(direction){
			case RIGHT:{                               //注意坐标的方向和二维数组的维度 ***
				if(x<num-1 && field[y][x+1]==0){      //控制虫子在未走过的格子里爬
					x+=1;
				}else{
					direction = DOWN;                  //不能再往右爬了，改向下爬
					y +=1;                             //注意
				}
				break;
			}case DOWN:{
				if(y<num-1 && field[y+1][x]==0){
					y+=1;
				}else{
					direction = LEFT;
					x -= 1;
				}		
				break;
			}case LEFT:{
				if(x>0 && field[y][x-1]==0){
					x-=1;
				}else{
					direction = UP;
					y -= 1; 
				}		
				break;
			}case UP:{
				if(y>0 && field[y-1][x]==0){
					y-=1;
				}else{
					direction = RIGHT;
					x+=1;
				}			
			}			
			break;
		}
	}
}
