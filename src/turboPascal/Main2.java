package turboPascal;
import java.util.Scanner;
/*СM��Ҫ����n�����ˣ���Ϊ����׼����n����ͬ��ζ���������ֱ�ʢװ��n���������С�������������֪��ÿλ����ϲ��ʲô��ζ��������ϣ��ÿλ���˶���Ʒ������n�ֲ�ͬ��ζ����������������ÿ�����������ֳ���nƬ�������������Щ�ֿ�������������n������n�ֲ�ͬ��ζ��������Ϊ����ȡ����һ���յ�С���ӣ�С����ֻ������һƬ������СM���Խ������²�����
1. ��ĳ���������ϵ�һƬ�������õ���һ�������ӵĿ���λ�ã�ע������ʱ��ÿ��������������ֻ����nƬ������
2. ��ĳ���������ϵ�һƬ�������õ�С�����У������ʱС�����ǿյĻ���
3. ��С�����ϵ��������õ�ĳ�������ӵĿ���λ�á�
�����æ����СM����Ҫ���ж��ٴβ������������Ŀ�ꡣ*/

public class Main2 {
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner sc = new Scanner(System.in);
		Main2 testMain= new Main2();
		if (sc.hasNext()) {
			int n=sc.nextInt();
			int[][] anxls=new int[n][4];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 4; j++) {
					anxls[i][j]=sc.nextInt();					
				}
				
			}
			
		}// of if
		
	}
	
	
	public void judgeA(int[][] arr) {
		//3���߶ηֱ��ʾ3�����Ժ���----���Բ�ֵ�������
		int y1,y2,y3;
		int x = 0;
		for (int i = 0; i < arr.length; i=i+3) {
			y1=(arr[i][1])*(x-arr[i][2])/(arr[i][0]-arr[i][3]);
			y1=(arr[i+1][1])*(x-arr[i+1][2])/(arr[i+1][0]-arr[i+1][3]);
			y1=(arr[i+2][1])*(x-arr[i+2][2])/(arr[i+2][0]-arr[i+3][3]);
			
		}
	}
	
	
}

