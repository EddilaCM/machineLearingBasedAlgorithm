package Fp_growthTree;
import java.util.List;
import java.util.ArrayList;
public class treeNode {//节点信息：节点名称，计数，父节点，孩子节点
	private String name;
	private treeNode parent;
	private int count;
	private List<treeNode> children;
	
	public String toString(){
		return name;
	}
	
	public treeNode(){
		
	}
	
	public treeNode(String name){
		this.name = name;//一开始只知道名字   所以只初始化名字
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getCount(){
		return this.count;
	}
	
	public void setCount(int count){
		this.count = count;
	}
	
	public treeNode getParent(){
		return this.parent;
	}
	
	public void setParent(treeNode parent){
		this.parent = parent;
	}
	
	public List<treeNode> getChildren(){
		return this.children;
	}
	
	public void setChildren(List<treeNode> children){
		this.children = children;
	}
	
	public void addChild(treeNode child){
		if(this.getChildren() == null){
			List<treeNode> list = new ArrayList<treeNode>();
			list.add(child);
			setChildren(list);
		}else{
			this.getChildren().add(child);
		}
	}
	
	
	public treeNode findChild(String name){
		List<treeNode> children = this.getChildren();
		if(children != null){
			for(treeNode child:children){
				if(child.getName().equals(name)){
					return child;
				}
			}
		}
		return null;
	}
	
	public void printChildName(){
		List<treeNode> children = this.getChildren();
		if(children != null){
			for(treeNode child:children){
				System.out.print(child.getName()+"  ");
			}
		}else{
			System.out.print("null");
		}
	}
	
	
	

}
