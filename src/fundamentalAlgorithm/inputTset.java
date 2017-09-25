package fundamentalAlgorithm;
import java.util.Scanner;
import java.util.Arrays;

public class inputTset {

	/**
	 * @param args
	 */
	/**  
	   * Scanner类中的方法  
	   * 优点一: 可以获取键盘输入的字符串  
	   * 优点二: 有现成的获取int,float等类型数据，非常强大，也非常方便；  
	   */  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Scanner sc = new Scanner(System.in);
     System.out.println("Please input the size of the array_test and the array number:");
     while(sc.hasNext()){
    	 int size = sc.nextInt();
//    	 System.out.println("the size is"+size);
    	 int[] test = new int[size];
    	 for(int i=0;i<size;i++){
    		 test[i] = sc.nextInt();
    	 }
//    	 Arrays.sort(test);
    	 System.out.println(Arrays.toString(test));
    	 
     }
     
     int a = 1234;
     String test = String.valueOf(a);
     int le = test.length();
     System.out.println("length is "+le);
     int jinzhi = 1;
     for(int i=0; i<le;i++){
    	 jinzhi *=10;
     }
     System.out.println("jinzhi is "+jinzhi);
	}

}
