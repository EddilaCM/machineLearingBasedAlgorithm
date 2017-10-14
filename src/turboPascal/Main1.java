package turboPascal;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

/*小M来到了一个迷宫中，这个迷宫可以用一个N*M的矩阵表示。
在这个迷宫的某些位置中存在金币。一开始小M在迷宫的入口：矩阵的左上角，位置(1，1)处；迷宫的出口位于矩阵的右下角，位置(N,M)处。
每一次小M可以选择向下或者向右走到一个相邻的格子，但是不能跨出迷宫外。现在小M想收集完迷宫中的所有金币并最后到达迷宫的出口，请你帮她规划一条最短的路径。*/
public class Main1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main1 testMain= new Main1();
		if (sc.hasNext()) {
			int N=sc.nextInt();
			int M=sc.nextInt();
			int K=sc.nextInt();
			int[][] goldCon = new int[K][2];
			
			for (int i = 0; i < K; i++) {
				 for (int j = 0; j < 2; j++) {
					goldCon[i][j]=sc.nextInt();					
				}
				
			}// of for i
			testMain.root(goldCon, N, M);
		}// of if
		

	}
	
	public void root(int[][] goldCon, int N, int M) {
		int first_x=1,first_y=1;//起点
		int end_x=N, end_y=M;//结束点
		for(int i=0; i<goldCon.length;i++){
			int temp_x=goldCon[i][0];
			int temp_y=goldCon[i][1];
			if (first_x==temp_x&&first_y<temp_y) {
				for (int j = 0; j <(temp_y-first_y) ; j++) {
					System.out.println("R");					
				}
				first_x=temp_x;
				first_y=temp_y;
			}else if(first_x<temp_x&&temp_y==first_y){
				for (int j = 0; j <(temp_x-first_x) ; j++) {
					System.out.println("D");					
				}
				first_x=temp_x;
				first_y=temp_y;
			}else if (first_x<temp_x&&first_y<temp_y) {
				for (int j = 0; j <(temp_y-first_y) ; j++) {
					System.out.println("R");					
				}
				for (int j = 0; j <(temp_x-first_x) ; j++) {
					System.out.println("D");					
				}
				first_x=temp_x;
				first_y=temp_y;
			}
			
			
		}
		//终点
		
		if (first_x<N&&first_y<M) {
			for (int j = 0; j <(M-first_y) ; j++) {
				System.out.println("R");					
			}
			for (int j = 0; j <(N-first_x) ; j++) {
				System.out.println("D");					
			}
			first_x=N;
			first_y=M;
		}
	}
	

}
