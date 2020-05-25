package TREE.AVL;

import java.util.Scanner;

public class AVL {
	
	public int getData() {
		return data;
	}


	public void setData(int data) {
		this.data = data;
	}


	public AVL getlNode() {
		return lNode;
	}


	public void setlNode(AVL lNode) {
		this.lNode = lNode;
	}


	public AVL getrNode() {
		return rNode;
	}


	public void setrNode(AVL rNode) {
		this.rNode = rNode;
	}


	private static int MIN=-1;
	private  int data;
	private AVL lNode;
	private AVL rNode;

	public int Height(AVL avl) {
		if (avl==null) {
			return -1;
		}
		return avl.height;
	}
	
	private int height;
	
	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public AVL() {
		lNode=null;
		rNode=null;
		data=MIN;
		height=0;
	}
	
	public void OrderByPre() {
		System.out.print(this.getData());
		if(null!=this.getlNode()) {
		this.getlNode().OrderByPre();
		}
		if(null!=this.getrNode()) {
		this.getrNode().OrderByPre();
		}
	}
	
	public void OrderByPost() {
		if(null!=this.getlNode()) {
		this.getlNode().OrderByPost();
		}
		if(null!=this.getrNode()) {
		this.getrNode().OrderByPost();
		}
		System.out.print(this.getData());
	}
	
	public void OrderByIn() {
		if(null!=this.getlNode()) {
		this.getlNode().OrderByIn();
		}
		System.out.print(this.getData());
		if(null!=this.getrNode()) {
		this.getrNode().OrderByIn();
		}
	}
	
	public void buildTree(int data) {
		if(this.data==MIN) {
			this.data=data;
			return;
		}
		if(data<this.data) {
			if(null==this.getlNode()) {
				this.setlNode(new AVL());
			}
			this.getlNode().buildTree(data);
			if((Height(this.getlNode())-Height(this.getrNode()))==2) {
				if(data<this.getlNode().getData()) {
					if(findNodePre(this.getData())==null) {
						AVL zAvl=this.getrNode();
						AVL k1 = new AVL();
						k1=this.getlNode();
						this.setlNode(k1.getlNode());
						k1.setlNode(k1.getrNode());
						k1.setrNode(zAvl);
						this.setrNode(k1);
						int k2data = this.data;
						this.data=k1.getData();
						k1.setData(k2data);
						k1.setHeight(Math.max(Height(k1.getrNode()), Height(k1.getlNode()))+1);
						this.setHeight(Math.max(k1.getHeight(), Height(this.getlNode()))+1);
					}
					else {
						AVL dTreePre=findNodePre(this.getData());
						if(dTreePre.getData()<this.getData()) {
							dTreePre.setrNode(SingleRotateWithLeft());
						}else {
							dTreePre.setlNode(SingleRotateWithLeft());
						}
					}
				}
				else {
					if(findNodePre(this.getData())==null) {
						this.setlNode(this.getlNode().SingleRotateWithRight());
						
						AVL zAvl=this.getrNode();
						AVL k1 = new AVL();
						k1=this.getlNode();
						this.setlNode(k1.getlNode());
						k1.setlNode(k1.getrNode());
						k1.setrNode(zAvl);
						this.setrNode(k1);
						int k2data = this.data;
						this.data=k1.getData();
						k1.setData(k2data);
						k1.setHeight(Math.max(Height(k1.getrNode()), Height(k1.getlNode()))+1);
						this.setHeight(Math.max(k1.getHeight(), Height(this.getlNode()))+1);
					}else {
					AVL dTreePre=findNodePre(this.getData());
					if(dTreePre.getData()<this.getData()) {
						dTreePre.setrNode(DoubleRotateWithLeft());
					}else {
						dTreePre.setlNode(DoubleRotateWithLeft());
					}
					}
					
				}
				
			}

		}else {
			if (null==this.getrNode()) {
				this.setrNode(new AVL());
			}
			this.getrNode().buildTree(data);
			if((Height(this.getrNode())-Height(this.getlNode()))==2) {
				if(data>=this.getrNode().getData()) {
					if(findNodePre(this.getData())==null) {
						AVL zAvl=this.getlNode();
						AVL k1 = new AVL();
						k1=this.getrNode();
						this.setrNode(k1.getrNode());
						k1.setrNode(k1.getlNode());
						k1.setlNode(zAvl);
						this.setlNode(k1);
						int k2data = this.data;
						this.data=k1.getData();
						k1.setData(k2data);
						k1.setHeight(Math.max(Height(k1.getrNode()), Height(k1.getlNode()))+1);
						this.setHeight(Math.max(k1.getHeight(), Height(this.getrNode()))+1);
					}
					else {
						AVL dTreePre=findNodePre(this.getData());
						if(dTreePre.getData()<this.getData()) {
							dTreePre.setrNode(SingleRotateWithRight());
						}else {
							dTreePre.setlNode(SingleRotateWithRight());
						}
					}
				}
				else {
					if(findNodePre(this.getData())==null) {
						this.setrNode(this.getrNode().SingleRotateWithLeft());
						
						AVL zAvl=this.getlNode();
						AVL k1 = new AVL();
						k1=this.getrNode();
						this.setrNode(k1.getrNode());
						k1.setrNode(k1.getlNode());
						k1.setlNode(zAvl);
						this.setlNode(k1);
						int k2data = this.data;
						this.data=k1.getData();
						k1.setData(k2data);
						k1.setHeight(Math.max(Height(k1.getrNode()), Height(k1.getlNode()))+1);
						this.setHeight(Math.max(k1.getHeight(), Height(this.getrNode()))+1);
					}
					else {
					AVL dTreePre=findNodePre(this.getData());
					if(dTreePre.getData()<this.getData()) {
						dTreePre.setrNode(DoubleRotateWithRight());
					}else {
						dTreePre.setlNode(DoubleRotateWithRight());
					}
					}
				}
				
			}

		}
		this.setHeight(Math.max(Height(this.getrNode()), Height(this.getlNode()))+1);
	}

	private AVL DoubleRotateWithRight() {
		// TODO Auto-generated method stub
		this.setrNode(this.getrNode().SingleRotateWithLeft());
		return this.SingleRotateWithRight();
	}


	private AVL SingleRotateWithRight() {
		// TODO Auto-generated method stub
		AVL k1 = new AVL();
		k1=this.getrNode();
		this.setrNode(k1.getlNode());
		k1.setlNode(this);
		this.height=Math.max(Height(this.getrNode()), Height(this.getlNode()))+1;
		k1.setHeight(Math.max(this.getHeight(), Height(k1.getrNode()))+1);
		return k1;
	}


	public AVL SingleRotateWithLeft() {
		AVL k1 = new AVL();
		k1=this.getlNode();
		this.setlNode(k1.getrNode());
		k1.setrNode(this);
		this.height=Math.max(Height(this.getrNode()), Height(this.getlNode()))+1;
		k1.setHeight(Math.max(this.getHeight(), Height(k1.getlNode()))+1);
		return k1;
	}
	
	public AVL DoubleRotateWithLeft() {
		this.setlNode(this.getlNode().SingleRotateWithRight());
		 return  this.SingleRotateWithLeft();
	}
	
	public AVL findNode(int data) {
		AVL bTree =this;
		while(bTree!=null) {
			if (bTree.getData()>data) {
				if (bTree.getlNode()==null) {
					return null;
				}
				bTree=bTree.getlNode();
			}else if (bTree.getData()<data) {
				if (bTree.getrNode()==null) {
					return null;
				}
				bTree=bTree.getrNode();
			}
			else {
			return bTree;
			}
		}
		return null;
	}
	
	public AVL findMin(AVL bTree) {
		AVL pTree=bTree;
		while(pTree.getlNode()!=null) {
			pTree=pTree.getlNode();
		}
		return pTree;
	}
		
	public AVL findNodePre(int data) {
		AVL bTree =this;
		AVL bTreePre=null;
		
		while(bTree!=null) {
			if (bTree.getData()>data&&bTree.getlNode()!=null) {
				bTreePre=bTree;
				bTree=bTree.getlNode();
			}else if (bTree.getData()<data&&bTree.getrNode()!=null) {
				bTreePre=bTree;
				bTree=bTree.getrNode();
			}
			else {
			return bTreePre;
			}
		}
		return bTreePre;
	}
	
	public void delNode(int data) {
		AVL dTree=this.findNode(data);
		AVL dTreePre=this.findNodePre(data);
		if(null==dTree) {
			System.out.println("It N0 In Tree");
			return ;
		}
		if((dTree.getlNode()==null)&&(dTree.getrNode()==null)) {
			if(dTreePre.getData()<data) {
				dTreePre.setrNode(null);
			}else {
				dTreePre.setlNode(null);
			}
		}
		else if((dTree.getlNode()!=null)&&(dTree.getrNode()==null)) {
			if(dTreePre.getData()<data) {
				dTreePre.setrNode(dTree.getlNode());
			}else {
				dTreePre.setlNode(dTree.getlNode());
			}
		}
		else if((dTree.getlNode()==null)&&(dTree.getrNode()!=null)) {
			if(dTreePre.getData()<data) {
				dTreePre.setrNode(dTree.getrNode());
			}else {
				dTreePre.setlNode(dTree.getrNode());
			}
		}
		else {
			AVL mTree=this.findMin(dTree.getrNode());
			dTree.delNode(mTree.getData());
			dTree.setData(mTree.getData());
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVL bTree=new AVL();
		Scanner sc = new Scanner(System.in);
		 int data = sc.nextInt();
		 while(data!=-1) {
			 bTree.buildTree(data);
			 data = sc.nextInt();
		 }
		 bTree.OrderByIn();
		 System.out.println("-");
		 bTree.OrderByPost();
		 System.out.println("-");
		 bTree.OrderByPre();
		 System.out.println("-");
	}

}
