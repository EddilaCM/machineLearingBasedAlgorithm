package fundamentalAlgorithm;
import java.util.Stack;
public class binaryTree_stack {

	/**
	 * @param args
	 * 堆栈遍历
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        binaryTree_stack test = new binaryTree_stack();
        buildNode root = test.init();
        System.out.println("先序遍历：");
        test.theFirstOrderTraversal_stack(root);
        System.out.println("\n先序遍历：");
        test.theInOrderTraversal_stack(root);
        System.out.println("\n先序遍历：");
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
	//先序遍历
	public void theFirstOrderTraversal_stack(buildNode root){
		Stack<buildNode> stack= new Stack<buildNode>();
		buildNode node = root;
	    while(node != null ||stack.size()>0){//将所有的做孩子压栈
	    	if(node != null){//压栈之前先访问
	    		printNodeData(node);
	    		stack.push(node);
	    		node = node.getLeftNode();
	    	}else{
	    		node = stack.pop();
	    		node = node.getRightNode();
	    	}
	    }
	}
	//中序遍历
	public void theInOrderTraversal_stack(buildNode root){
		Stack<buildNode> stack = new Stack<buildNode>();
		buildNode node = root;
		while(node != null || stack.size()>0){
			if(node!=null){
				stack.push(node);//直接压栈
				node = node.getLeftNode();
			}else{
				node = stack.pop();//出栈并访问
				printNodeData(node);
				node = node.getRightNode();
			}
		}
	}
	//后序遍历
	public void theLastOrderTraversal_stack(buildNode root){
		Stack<buildNode> stack = new Stack<buildNode>();
		Stack<buildNode> output = new Stack<buildNode>();//构造一个中间栈来存储逆后序遍历的结果  
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
