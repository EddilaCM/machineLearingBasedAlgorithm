package fundamentalAlgorithm;
import java.util.Scanner;
import java.util.Arrays;
public class mutilpleInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
//        while(true){
//        	String nextLine = sc.nextLine();
//        	if(nextLine == null || nextLine.trim().length()==0){
//        		System.out.println("empty , break");
//        		break;
//        	}
//        	System.out.println(nextLine);
//        }
		if(sc.hasNext()){
		   int len = sc.nextInt();
		   int[] course = new int[len];
		   int[] number = new int[len];
		   for(int i=0; i<len; i++){
			   course[i]=sc.nextInt();
			   number[i]=sc.nextInt();
		   }
		   System.out.println(Arrays.toString(course));
		   System.out.println(Arrays.toString(number));
		}
	}
	

	/**
	 * @param args
	 */

}
