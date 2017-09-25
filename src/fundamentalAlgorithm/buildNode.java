package fundamentalAlgorithm;

public class buildNode {
 private int data;
 private buildNode leftNode;
 private buildNode rightNode;
 public buildNode(int data,buildNode leftNode, buildNode rightNode){
	 this.data=data;
	 this.leftNode=leftNode;
	 this.rightNode=rightNode;
 }
 public int getData(){
	 return data;
 }
 public void setData(int data){
	 this.data = data;
 }
 public buildNode getLeftNode(){
	 return leftNode;
 }
 public void setLeftNode(buildNode leftNode){
	 this.leftNode=leftNode;	 
 }
 public buildNode getRightNode(){
	 return rightNode;
 }
 public void setRightNode(buildNode rightNode){
	 this.rightNode=rightNode;
 }
 
 
}
