package DSDP;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/**
 * The item-based DSDP clustering algorithm.
 * 在kMeans基础上进行修改：（1）统计用户在不同评级上的评分频率，向量间距离的复杂度从O(m)->O(1),m为电影数量；
 * （2）迭代终止条件为最近两次获得的中心距离都低于阈值
 * 
 * @author Henry 2017.9.11.
 *
 */
public class ItemDSDP extends Cluster {
	public static String itemGroupPath = new String("data/ml-100k/itemGroupML943u.txt");

	/**
	 * Number of centers
	 */
	int k;

	/**
	 * Is the cluster information changed?
	 */
	// boolean clusterChanged;

	/**
	 * 
	 */
	double[][] oldcenters;

	/**
	 *************** 
	 * @param paraReader
	 * @throws IOException
	 * @throws Exception
	 *************** 
	 */
	public ItemDSDP() throws IOException, Exception {
		super();
		blockInformation = new int[ClusterDataInfo.itemNum];
		for (int i = 0; i < blockInformation.length; i++) {
			blockInformation[i] = -1;
		} // Of for i
	}// Of the first constructor

	/**
	 *************** 
	 * Swap the elements of an array randomly.
	 **************** 
	 */
	public int[] randomSwapIndices(int paraLength) {
		int[] tempIndices = new int[paraLength];
		for (int i = 0; i < tempIndices.length; i++) {
			tempIndices[i] = i;
		} // Of for i

		Random tempRandom = new Random();
		int tempIndex1, tempIndex2, tempValue;

		for (int i = 0; i < 100; i++) {
			tempIndex1 = tempRandom.nextInt(paraLength);
			tempIndex2 = tempRandom.nextInt(paraLength);

			tempValue = tempIndices[tempIndex1];
			tempIndices[tempIndex1] = tempIndices[tempIndex2];
			tempIndices[tempIndex2] = tempValue;
		} // Of for i

		return tempIndices;
	}// Of randomSwap

	/**
	 *************** 
	 * Cluster.
	 **************** 
	 */
	public void randomSelectCenters() {
		int[] tempIndices = randomSwapIndices(ClusterDataInfo.itemNum);

		for (int i = 0; i < k; i++) {
			for (int j = 0; j < ClusterDataInfo.CHAN_LEN; j++) {
				centers[i][j] = ClusterDataInfo.iChannels[tempIndices[i]][j];
			} // Of for j
		} // Of for i
	}// Of randomSelectCenters

	/**
	 *************** 
	 * clusterUsingCenters.
	 **************** 
	 */
	public void clusterUsingCenters() {
		for (int i = 0; i < ClusterDataInfo.itemNum; i++) {
			int tempIndex = 0;
			double tempDistance = Double.MAX_VALUE;
			// 每一个实例都和所有中心进行计算距离，将该实例分类到距离最小的中心
			for (int j = 0; j < centers.length; j++) {
				double tempUserDist = KLDivergenceDistance(ClusterDataInfo.iChannels[i], centers[j]);
//				System.out.println("tempUserDist: " + tempUserDist);
				if (tempUserDist < tempDistance) {
					tempDistance = tempUserDist;
					tempIndex = j;
				} // Of if
			} // Of for j

			if (blockInformation[i] != tempIndex) {
				blockInformation[i] = tempIndex;
			} // Of if
		} // Of for i
	}// Of clusterUsingCenters

	/**
	 *************** 
	 * Compute new centers using the mean value of each block.
	 **************** 
	 */
	public void meanAsCenters() {
		// Initialize
		oldcenters = new double[k][ClusterDataInfo.CHAN_LEN];
		blockSizes = new int[k];
		for (int i = 0; i < centers.length; i++) {
			blockSizes[i] = 0;
			for (int j = 0; j < centers[i].length; j++) {
				oldcenters[i][j] = centers[i][j];
				centers[i][j] = 0;
			} // Of for j
		} // Of for i

		// Scan all instances and sum
		for (int i = 0; i < ClusterDataInfo.itemNum; i++) {
			blockSizes[blockInformation[i]]++;
			for (int j = 0; j < ClusterDataInfo.CHAN_LEN; j++) {
				centers[blockInformation[i]][j] += ClusterDataInfo.iChannels[i][j];
			} // Of for j
		} // Of for i

		// Divide
		for (int i = 0; i < centers.length; i++) {
			for (int j = 0; j < centers[i].length; j++) {
				centers[i][j] /= blockSizes[i];
			} // Of for j
		} // Of for i
	}// Of meanAsCenters

	/**
	 *************** 
	 * Compute the distance between the old and new centers.
	 **************** 
	 */
	public double diffOfOldAndNewCenters() {
		// Compute the distance between the old and new centers
		double tempMax = 0;
		for (int i = 0; i < centers.length; i++) {
			double tempDistance = manhattanDistance(oldcenters[i], centers[i]);
			if (tempDistance > tempMax) {
				tempMax = tempDistance;
			} // Of if
		} // Of for i

		System.out.println("tempDistance: " + tempMax);
		return tempMax;
	}//of diffOfOldAndNewCenters

	/**
	 *************** 
	 * Cluster.
	 **************** 
	 */
	public void cluster(int paraK, double paraThr) {
		// Initialize
		k = paraK;
		centers = new double[k][ClusterDataInfo.CHAN_LEN];

		// Select centers
		randomSelectCenters();
		SimpleTool.printMatrix(centers);
		// Cluster and mean
		while (true) {
			
			// Cluster
			clusterUsingCenters();

			// Mean
			meanAsCenters();
			
			double tempDistance = diffOfOldAndNewCenters();

			if(tempDistance < paraThr){
				break;
			}//Of if
			//System.out.println(Arrays.toString(blockInformation));
		}// Of while
	}// Of cluster

	/**
	 *************** 
	 * Test the program
	 **************** 
	 */
	public static void test() throws Exception {
		ClusterDataInfo tempSoc = new ClusterDataInfo();
		tempSoc.buildDataModel();
		ItemDSDP tempKMeans = new ItemDSDP();

		System.out.println(tempKMeans);

		int tempGroupNum = 3;
		tempKMeans.cluster(tempGroupNum, 0.1);
		System.out.println(Arrays.toString(tempKMeans.blockInformation));
		System.out.println(Arrays.toString(tempKMeans.blockSizes));
		OutputGroupFile.outToGrpFile(itemGroupPath, tempGroupNum, tempKMeans.blockInformation);

		// ClusterMeasure tempMeasure = new
		// ClusterMeasure(tempKMeans.blockInformation, tempKMeans.classLabels);
		//
		// System.out.println("The JC is: " + tempMeasure.getJc());
		// System.out.println("The FMI is: " + tempMeasure.getFmi());
		// System.out.println("The RI is: " + tempMeasure.getRi());
		//
		// System.out.println("The purity is: " + tempMeasure.computPurity());
	}// Of test

	/**
	 * The main function.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			test();
		} catch (Exception ee) {
			ee.printStackTrace();
		} // Of try
	}// Of main

}// Of class KMeans
