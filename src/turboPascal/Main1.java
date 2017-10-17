package turboPascal;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

/*СM������һ���Թ��У�����Թ�������һ��N*M�ľ����ʾ��
������Թ���ĳЩλ���д��ڽ�ҡ�һ��ʼСM���Թ�����ڣ���������Ͻǣ�λ��(1��1)�����Թ��ĳ���λ�ھ�������½ǣ�λ��(N,M)����
ÿһ��СM����ѡ�����»��������ߵ�һ�����ڵĸ��ӣ����ǲ��ܿ���Թ��⡣����СM���ռ����Թ��е����н�Ҳ���󵽴��Թ��ĳ��ڣ���������滮һ����̵�·����*/
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
		int first_x=1,first_y=1;//���
		int end_x=N, end_y=M;//������
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
		//�յ�
		
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
