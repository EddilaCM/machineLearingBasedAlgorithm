package turboPascal;
import java.util.Scanner;
/*СM��Ҫ����n�����ˣ���Ϊ����׼����n����ͬ��ζ���������ֱ�ʢװ��n���������С�������������֪��ÿλ����ϲ��ʲô��ζ��������ϣ��ÿλ���˶���Ʒ������n�ֲ�ͬ��ζ����������������ÿ�����������ֳ���nƬ�������������Щ�ֿ�������������n������n�ֲ�ͬ��ζ��������Ϊ����ȡ����һ���յ�С���ӣ�С����ֻ������һƬ������СM���Խ������²�����
1. ��ĳ���������ϵ�һƬ�������õ���һ�������ӵĿ���λ�ã�ע������ʱ��ÿ��������������ֻ����nƬ������
2. ��ĳ���������ϵ�һƬ�������õ�С�����У������ʱС�����ǿյĻ���
3. ��С�����ϵ��������õ�ĳ�������ӵĿ���λ�á�
�����æ����СM����Ҫ���ж��ٴβ������������Ŀ�ꡣ*/

public class Main {
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner sc = new Scanner(System.in);
		Main testMain= new Main();
		if (sc.hasNext()) {
			int n=sc.nextInt();
			testMain.countOperate(n);
			}
	}
	public void countOperate(int n){
		int big_pan = n;
		//����֪��ÿ�����Ӷ�Ҫ��������������ÿ����������Ҫ�õ����β�����
		int change_number = computeN_leijia(big_pan);
		System.out.println("change_number:"+change_number);
		int operator_number=3*change_number;
		System.out.println("the operator times is :"+operator_number);
	}
	public int computeN_leijia(int n){
		int N_LJ=0;
		for (int i = 1; i < n; i++) {
			N_LJ += i;
		}
		
		return N_LJ;
	}
	
}

