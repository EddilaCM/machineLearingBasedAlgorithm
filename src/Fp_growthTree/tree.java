package Fp_growthTree;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
public class tree<T> {
	private final int DEFAULT_SIZE = 2;
	private int size;
	private int count;
	private Object[] nodes;
	//���캯��
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
	// ���һ���ڵ�
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
	
	
	// ���һ���ڵ㣬��ָ���丸�ڵ�
	public void add(Node<T> node, Node<T> parent){
		this.check();
		node.setParent(this.position(parent));
		this.add(node);
	}
	//��ȡ�ڵ��������еĴ洢λ��
	public int position(Node<T> node){
		for(int i=0; i<this.size;i++){
			if(nodes[i]==node){
				return i;
			}
		}
		return -1;
	}
	
	//��ȡ�������ж��ٸ��ڵ�
	public int getSize(){
		return this.count;
	}
	
	//��ȡ���ڵ�
	public Node<T> getRoot(){
		return (Node<T>) this.nodes[0];
	}
	
	//��ȡ���еĽڵ���list����ʽ����
	public List<Node<T>> getAllNodes(){
		List<Node<T>> list = new ArrayList<Node<T>>();
		for(int i=0; i<this.size; i++){
			if(this.nodes[i] !=null){
				list.add((Node<T>)nodes[i]);
			}
		}
		return list;
	}
	//��ȡ�������
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
