package fundamentalAlgorithm;
import java.util.Stack;
public class binaryTree_stack {

	/**
	 * @param args
	 * ��ջ����
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        binaryTree_stack test = new binaryTree_stack();
        buildNode root = test.init();
        System.out.println("���������");
        test.theFirstOrderTraversal_stack(root);
        System.out.println("\n���������");
        test.theInOrderTraversal_stack(root);
        System.out.println("\n���������");
        test.theLastOrderTraversal_stack(root);
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
		System.out.print(node.getData() +" ");
	}
	//�������
	public void theFirstOrderTraversal_stack(buildNode root){
		Stack<buildNode> stack= new Stack<buildNode>();
		buildNode node = root;
	    while(node != null ||stack.size()>0){//�����е�������ѹջ
	    	if(node != null){//ѹջ֮ǰ�ȷ���
	    		printNodeData(node);
	    		stack.push(node);
	    		node = node.getLeftNode();
	    	}else{
	    		node = stack.pop();
	    		node = node.getRightNode();
	    	}
	    }
	}
	//�������
	public void theInOrderTraversal_stack(buildNode root){
		Stack<buildNode> stack = new Stack<buildNode>();
		buildNode node = root;
		while(node != null || stack.size()>0){
			if(node!=null){
				stack.push(node);//ֱ��ѹջ
				node = node.getLeftNode();
			}else{
				node = stack.pop();//��ջ������
				printNodeData(node);
				node = node.getRightNode();
			}
		}
	}
	//�������
	public void theLastOrderTraversal_stack(buildNode root){
		Stack<buildNode> stack = new Stack<buildNode>();
		Stack<buildNode> output = new Stack<buildNode>();//����һ���м�ջ���洢���������Ľ��  
		buildNode node = root;
		while(node != null || stack.size()>0){
			if(node != null){
				output.push(node);
				stack.push(node);
				node = node.getRightNode();
			}else{
				node = stack.pop();
				node = node.getLeftNode();
			}
		}
		System.out.println(output.size());
		while(output.size()>0){
			printNodeData(output.pop());
		}
	}

}
