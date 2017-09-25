package Fp_growthTree;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
public class tree<T> {
	private final int DEFAULT_SIZE = 2;
	private int size;
	private int count;
	private Object[] nodes;
	//构造函数
	public tree(){
		this.size = this.DEFAULT_SIZE;
		this.nodes = new Object[this.size];
		this.count = 0;
	}
	
	public tree(Node<T> root){
		this();
		this.count = 1;
		this.nodes[0] = root;
	}
	
	public tree(Node<T> root, int size){
		this.size = size;
		this.nodes = new Object[this.size];
		this.count = 1;
		this.nodes[0] = root; 
	}
	// 添加一个节点
	public void add(Node<T> node){
		for(int i= 0; i<this.size; i++){
			if(this.nodes[i]==null){
				nodes[i] = node;
				break;
			}
		}
		this.count++;
	}
	
	public void enlarge(){
		this.size = this.size + this.DEFAULT_SIZE;
		Object[] newNodes = new Object[this.size];
		newNodes = Arrays.copyOf(nodes, this.size);
		Arrays.fill(nodes,null);
		this.nodes = newNodes;
		System.out.println("enlarge");
	}
	
	public void check(){
		if(this.count>=this.size){
			this.enlarge();
		}
	}
	
	
	// 添加一个节点，并指明其父节点
	public void add(Node<T> node, Node<T> parent){
		this.check();
		node.setParent(this.position(parent));
		this.add(node);
	}
	//获取节点在数组中的存储位子
	public int position(Node<T> node){
		for(int i=0; i<this.size;i++){
			if(nodes[i]==node){
				return i;
			}
		}
		return -1;
	}
	
	//获取整棵树有多少个节点
	public int getSize(){
		return this.count;
	}
	
	//获取根节点
	public Node<T> getRoot(){
		return (Node<T>) this.nodes[0];
	}
	
	//获取所有的节点以list的形式返回
	public List<Node<T>> getAllNodes(){
		List<Node<T>> list = new ArrayList<Node<T>>();
		for(int i=0; i<this.size; i++){
			if(this.nodes[i] !=null){
				list.add((Node<T>)nodes[i]);
			}
		}
		return list;
	}
	//获取数的深度
	public int getDepth(){
		int max =1;
		if(this.nodes[0]==null){
			return 0;
		}
		for(int i=0; i<this.count;i++){
			int deep =1;
			int location =((Node<T>)(this.nodes[i])).getParent();
			while(location !=-1&&this.nodes[location]!=null){
				location = ((Node<T>)(this.nodes[location])).getParent();
				deep++;
			}
			if(max<deep){
				max = deep;
			}
		}
		return max;
	}
	

}
