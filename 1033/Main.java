package a1033;

/**
 * �ҳ��������ͼ�εĹ��ɣ�����n����һ��n�еĶ�Ӧͼ�Ρ�
����1 2 3 4
����12 13 14 5
����11 16 15 6
����10 9 8 7
 * 
 * 
 * ���⻨�˺ö�ԩ��ʱ�䡣
 * ��Ϊ���˺ܶ�ȫ�ֱ�����debugʱ������ȫ�ֱ�����ֵ������ֻ������ԭʼ�ķ���print�������ŷ����������ڣ�ȫ�ֱ���û����ȷʹ�á�
 * ʹ��ȫ�ֱ���ʱ�����ܰ�ȫ�ֱ�������������������������field����Ϊ��������ֵ��Ϊ��������ʱ��ֵ���ݣ�������ֵ�ı仯����Ӱ�쵽��������
 * 
 * 
 * �����˼·�ǰѾ��������һ�����̣���һ��������������˳ʱ��ת�������ǲ����߳����̣��Ҳ������Ѿ��߹��ĸ��ӡ�
 * �߹��ĸ���Ҫ���ϱ�ǡ�
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
		field = prepareFiled(num);      //��ʼ������
		startCrawl();                  //��ʼ��
		printField();                  //��ӡ���
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
		while(count<=num*num){      //����ѭ�����߼�
			field[y][x]=count;      //��ֵ����Ϊ�Ѿ��߹����жϱ�׼��
			count +=1;
			crawl();          //������һ��
		}		
	}
	
	public static void crawl(){
		switch(direction){
			case RIGHT:{                               //ע������ķ���Ͷ�ά�����ά�� ***
				if(x<num-1 && field[y][x+1]==0){      //���Ƴ�����δ�߹��ĸ�������
					x+=1;
				}else{
					direction = DOWN;                  //�������������ˣ���������
					y +=1;                             //ע��
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
