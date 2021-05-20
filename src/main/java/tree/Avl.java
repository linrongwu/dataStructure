package tree;

/**
 * @author String
 */
public class Avl extends BinarySortTree{
	private static final int HEIGHT_DIFFERENCE = 2;
	private static final int  MIN=-1;
	private  int data;
	private Avl lNode;
	private Avl rNode;
	
	@Override
	public int getData() {
		return data;
	}


	@Override
	public void setData(int data) {
		this.data = data;
	}


	@Override
	public Avl getlNode() {
		return lNode;
	}


	public void setlNode(Avl lNode) {
		this.lNode = lNode;
	}


	@Override
	public Avl getrNode() {
		return rNode;
	}


	public void setrNode(Avl rNode) {
		this.rNode = rNode;
	}

	public int height(Avl avl) {
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


	public Avl() {
		lNode=null;
		rNode=null;
		data=MIN;
		height=0;
	}
	
	@Override
	public void orderByPre() {
		System.out.print(this.getData());
		if(null!=this.getlNode()) {
		this.getlNode().orderByPre();
		}
		if(null!=this.getrNode()) {
		this.getrNode().orderByPre();
		}
	}
	
	@Override
	public void orderByPost() {
		if(null!=this.getlNode()) {
		this.getlNode().orderByPost();
		}
		if(null!=this.getrNode()) {
		this.getrNode().orderByPost();
		}
		System.out.print(this.getData());
	}
	
	@Override
	public void orderByIn() {
		if(null!=this.getlNode()) {
		this.getlNode().orderByIn();
		}
		System.out.print(this.getData());
		if(null!=this.getrNode()) {
		this.getrNode().orderByIn();
		}
	}
	
	@Override
	public void buildTree(int data) {
		if(this.data==MIN) {
			this.data=data;
			return;
		}
		if(data<this.data) {
			if(null==this.getlNode()) {
				this.setlNode(new Avl());
			}
			this.getlNode().buildTree(data);
			if((height(this.getlNode())- height(this.getrNode()))==HEIGHT_DIFFERENCE) {
				if(data<this.getlNode().getData()) {
					if(findNodePre(this.getData())==null) {
						dealWithAvlLeft();
					}
					else {
						Avl dTreePre=findNodePre(this.getData());
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
						dealWithAvlLeft();
					}else {
					Avl dTreePre=findNodePre(this.getData());
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
				this.setrNode(new Avl());
			}
			this.getrNode().buildTree(data);
			if((height(this.getrNode())- height(this.getlNode()))==HEIGHT_DIFFERENCE) {
				if(data>=this.getrNode().getData()) {
					if(findNodePre(this.getData())==null) {
						dealWithAvlRight();
					}
					else {
						Avl dTreePre=findNodePre(this.getData());
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
						dealWithAvlRight();
					}
					else {
					Avl dTreePre=findNodePre(this.getData());
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

	private void dealWithAvlRight() {
		Avl zAvl=this.getlNode();
		Avl k1 = this.getrNode();
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

	private void dealWithAvlLeft() {
		Avl zAvl=this.getrNode();
		Avl k1=this.getlNode();
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

	private Avl doubleRotateWithRight() {
		// TODO Auto-generated method stub
		this.setrNode(this.getrNode().singleRotateWithLeft());
		return this.singleRotateWithRight();
	}


	private Avl singleRotateWithRight() {
		// TODO Auto-generated method stub
		Avl k1=this.getrNode();
		this.setrNode(k1.getlNode());
		k1.setlNode(this);
		this.height=Math.max(height(this.getrNode()), height(this.getlNode()))+1;
		k1.setHeight(Math.max(this.getHeight(), height(k1.getrNode()))+1);
		return k1;
	}


	public Avl singleRotateWithLeft() {
		Avl k1=this.getlNode();
		this.setlNode(k1.getrNode());
		k1.setrNode(this);
		this.height=Math.max(height(this.getrNode()), height(this.getlNode()))+1;
		k1.setHeight(Math.max(this.getHeight(), height(k1.getlNode()))+1);
		return k1;
	}
	
	public Avl doubleRotateWithLeft() {
		this.setlNode(this.getlNode().singleRotateWithRight());
		 return  this.singleRotateWithLeft();
	}
	
	@Override
	public Avl findNode(int data) {
		Avl bTree =this;
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
	
	public Avl findMin(Avl bTree) {
		Avl pTree=bTree;
		while(pTree.getlNode()!=null) {
			pTree=pTree.getlNode();
		}
		return pTree;
	}
		
	@Override
	public Avl findNodePre(int data) {
		Avl bTree =this;
		Avl bTreePre=null;
		
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
	
	@Override
	public void delNode(int data) {
		Avl dTree=this.findNode(data);
		Avl dTreePre=this.findNodePre(data);
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
			Avl mTree=this.findMin(dTree.getrNode());
			dTree.delNode(mTree.getData());
			dTree.setData(mTree.getData());
		}
	}
}
