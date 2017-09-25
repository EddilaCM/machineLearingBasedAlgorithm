package fundamentalAlgorithm;
//�ݹ����������
public class binaryTree_recurrent {
	 /** 
     * @author cm
     * ����������������������� 
     */  
	public static void main(String arg[]){
		binaryTree_recurrent test = new binaryTree_recurrent();
		buildNode rootNode = test.init();
		System.out.println("���������");
		test.theFirstTraversal(rootNode);
		System.out.println("\n���������");
		test.theInOrderTraversal(rootNode);
		System.out.println("\n���������");
		test.thePostOrderTraversal(rootNode);
	}
	
	public buildNode init(){
		buildNode J = new buildNode(8,null,null);
		buildNode H = new buildNode(4,null,null);
		buildNode G = new buildNode(2,null,null);
		buildNode F = new buildNode(7,null,J);
		buildNode E = new buildNode(5,H,null);
		buildNode D = new buildNode(1,null,G);
		buildNode C = new buildNode(9,null,F);
		buildNode B = new buildNode(3,D,E);
		buildNode A = new buildNode(6,B,C);
		return A;
	}
	public void printNodeData(buildNode node){
		System.out.print(node.getData());
	}
	//�������  �� -��-��
	public void theFirstTraversal(buildNode root){
		printNodeData(root);
		if(root.getLeftNode()!=null){
			theFirstTraversal(root.getLeftNode());
		}
		if(root.getRightNode()!=null){
			theFirstTraversal(root.getRightNode());
		}
	}
	
	//������� ��-��-��
	public void theInOrderTraversal(buildNode root){
		if(root.getLeftNode()!=null){
			theInOrderTraversal(root.getLeftNode());
		}
		printNodeData(root);
		if(root.getRightNode()!=null){
			theInOrderTraversal(root.getRightNode());
		}
		
	}
	
	
	//������� ��-��-��
	public void thePostOrderTraversal(buildNode root){
		if(root.getLeftNode()!=null){
			thePostOrderTraversal(root.getLeftNode());
		}
		if(root.getRightNode()!=null){
			thePostOrderTraversal(root.getRightNode());
		}
		printNodeData(root);
	}
}
