package tree;

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


	private static final int  MIN=-1;
	private  int data;
	private AVL lNode;
	private AVL rNode;

	public int height(AVL avl) {
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
	
	public void orderByPre() {
		System.out.print(this.getData());
		if(null!=this.getlNode()) {
		this.getlNode().orderByPre();
		}
		if(null!=this.getrNode()) {
		this.getrNode().orderByPre();
		}
	}
	
	public void orderByPost() {
		if(null!=this.getlNode()) {
		this.getlNode().orderByPost();
		}
		if(null!=this.getrNode()) {
		this.getrNode().orderByPost();
		}
		System.out.print(this.getData());
	}
	
	public void orderByIn() {
		if(null!=this.getlNode()) {
		this.getlNode().orderByIn();
		}
		System.out.print(this.getData());
		if(null!=this.getrNode()) {
		this.getrNode().orderByIn();
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
			if((height(this.getlNode())- height(this.getrNode()))==2) {
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
						k1.setHeight(Math.max(height(k1.getrNode()), height(k1.getlNode()))+1);
						this.setHeight(Math.max(k1.getHeight(), height(this.getlNode()))+1);
					}
					else {
						AVL dTreePre=findNodePre(this.getData());
						if(dTreePre.getData()<this.getData()) {
							dTreePre.setrNode(singleRotateWithLeft());
						}else {
							dTreePre.setlNode(singleRotateWithLeft());
						}
					}
				}
				else {
					if(findNodePre(this.getData())==null) {
						this.setlNode(this.getlNode().singleRotateWithRight());
						
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
						k1.setHeight(Math.max(height(k1.getrNode()), height(k1.getlNode()))+1);
						this.setHeight(Math.max(k1.getHeight(), height(this.getlNode()))+1);
					}else {
					AVL dTreePre=findNodePre(this.getData());
					if(dTreePre.getData()<this.getData()) {
						dTreePre.setrNode(doubleRotateWithLeft());
					}else {
						dTreePre.setlNode(doubleRotateWithLeft());
					}
					}
					
				}
				
			}

		}else {
			if (null==this.getrNode()) {
				this.setrNode(new AVL());
			}
			this.getrNode().buildTree(data);
			if((height(this.getrNode())- height(this.getlNode()))==2) {
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
						k1.setHeight(Math.max(height(k1.getrNode()), height(k1.getlNode()))+1);
						this.setHeight(Math.max(k1.getHeight(), height(this.getrNode()))+1);
					}
					else {
						AVL dTreePre=findNodePre(this.getData());
						if(dTreePre.getData()<this.getData()) {
							dTreePre.setrNode(singleRotateWithRight());
						}else {
							dTreePre.setlNode(singleRotateWithRight());
						}
					}
				}
				else {
					if(findNodePre(this.getData())==null) {
						this.setrNode(this.getrNode().singleRotateWithLeft());
						
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
						k1.setHeight(Math.max(height(k1.getrNode()), height(k1.getlNode()))+1);
						this.setHeight(Math.max(k1.getHeight(), height(this.getrNode()))+1);
					}
					else {
					AVL dTreePre=findNodePre(this.getData());
					if(dTreePre.getData()<this.getData()) {
						dTreePre.setrNode(doubleRotateWithRight());
					}else {
						dTreePre.setlNode(doubleRotateWithRight());
					}
					}
				}
				
			}

		}
		this.setHeight(Math.max(height(this.getrNode()), height(this.getlNode()))+1);
	}

	private AVL doubleRotateWithRight() {
		// TODO Auto-generated method stub
		this.setrNode(this.getrNode().singleRotateWithLeft());
		return this.singleRotateWithRight();
	}


	private AVL singleRotateWithRight() {
		// TODO Auto-generated method stub
		AVL k1 = new AVL();
		k1=this.getrNode();
		this.setrNode(k1.getlNode());
		k1.setlNode(this);
		this.height=Math.max(height(this.getrNode()), height(this.getlNode()))+1;
		k1.setHeight(Math.max(this.getHeight(), height(k1.getrNode()))+1);
		return k1;
	}


	public AVL singleRotateWithLeft() {
		AVL k1 = new AVL();
		k1=this.getlNode();
		this.setlNode(k1.getrNode());
		k1.setrNode(this);
		this.height=Math.max(height(this.getrNode()), height(this.getlNode()))+1;
		k1.setHeight(Math.max(this.getHeight(), height(k1.getlNode()))+1);
		return k1;
	}
	
	public AVL doubleRotateWithLeft() {
		this.setlNode(this.getlNode().singleRotateWithRight());
		 return  this.singleRotateWithLeft();
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
		try{
			int data = sc.nextInt();
			while(data!=-1) {
				bTree.buildTree(data);
				data = sc.nextInt();
			}
			bTree.orderByIn();
			System.out.println("-");
			bTree.orderByPost();
			System.out.println("-");
			bTree.orderByPre();
			System.out.println("-");
		}finally {
			sc.close();
		}
	}

}
