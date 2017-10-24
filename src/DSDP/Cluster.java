package DSDP;

import java.io.IOException;
import java.io.Reader;

/**
 * The general clustering algorithm.
 * 
 * @author Fan Min 2017.1.12.
 *
 */
public class Cluster {
	/**
	 * Cluster information
	 */
	public int[] blockInformation;

	/**
	 * Class Labels
	 */
	public int[] classLabels;

	/**
	 * Centers
	 */
	public double[][] centers;

	/**
	 * The size of each block
	 */
	public int[] blockSizes;

	/**
	 * The diameter of the data
	 */
	public double diameter;

	
	/**
	 *************** 
	 * Compute the distance.
	 **************** 
	 */
	public double KLDivergenceDistance(double[] paraRatesI, double[] paraCenters) {
		double tempDistance = 0;

		int tempILen = paraRatesI.length;

		if (tempILen == 0) {
			return 9999;// 返回一个大数，表示两个实例的距离很远
		} // Of if
		
		for(int i = 0; i < tempILen; i ++){
			if((paraCenters[i] != 0) && (paraRatesI[i] != 0) && ((paraRatesI[i]  / paraCenters[i]) > 0)){
				tempDistance += paraRatesI[i] * Math.log(paraRatesI[i]  / paraCenters[i]);
			}//Of if
		}//Of for i
		
		return tempDistance;
	}// Of distance
	
	/**
	 *************** 
	 * Compute the distance.
	 **************** 
	 */
	public double manhattanDistance(double[] paraOldCenters, double[] paraNewCenters) {
		double tempDistance = 0;

		int tempILen = paraOldCenters.length;
		
		for(int i = 0; i < tempILen; i ++){
			tempDistance += Math.abs(paraOldCenters[i] - paraNewCenters[i]);
		}//Of for i
		
		return tempDistance / tempILen;
	}// Of distance

	/**
	 *************** 
	 * Is the values in the bound [0, k - 1]?
	 **************** 
	 */
	public boolean isBlockInformationValid(int paraK) {
		for (int i = 0; i < blockInformation.length; i++) {
			if ((blockInformation[i] < 0) || (blockInformation[i] >= paraK)) {
				return false;
			} // Of if
		} // Of for i

		return true;
	}// Of isBlockInformationValid

}// Of class Cluster
