package Fp_growthTree;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
public class FP_GrowthTree {
	private double miniSupport;
	private double miniConfidence;
	
	private void setMiniSupport(double miniSupport){
		this.miniSupport = miniSupport;
	}
	
	private void setMiniConfidence(double Confidence){
		this.miniConfidence = Confidence;
	}
	
	public void init(String[][] originalDate){
		
		//ͳ�Ʋ�����
		List<String> name = new ArrayList<String>();
		for(int i=0; i<originalDate.length;i++){
			//System.out.println(Arrays.toString(originalDate[i]));
			if(i==0){
				for(String str:originalDate[i]){
					name.add(str);
				}
			}else{
				System.out.print(name.toString());
				for(String str:originalDate[i]){
					Boolean temp1= false;
					for(String name1:name){
						if(str.equals(name1)){
							continue;
						}else{
							
						}
					}
				}
			}
		}// of for i
		
		System.out.print(name.toString());
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	String[][] testData = {
							{"ţ��","����","���","��Ƭ"},
							{"����","���׻�","��Ƭ","ơ��"},
			                {"����","���","��Ƭ"},
							{"ţ��","����","���","���׻�","��Ƭ","ơ��"},
			                {"ţ��","���","ơ��"},
			                {"����","���","ơ��"},
			                {"ţ��","���","��Ƭ"},
			                {"ţ��","����","���","����","��Ƭ"},
			                {"ţ��","����","����","��Ƭ"}
			               };
	FP_GrowthTree test = new FP_GrowthTree();
	test.setMiniSupport(0.5);
	test.setMiniConfidence(0.8);
	test.init(testData);
	}// of main()
	
}
