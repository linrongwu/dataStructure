package tree;

/**
 * @author String
 */
public class BinarySortTree extends TreeNode{

	private static final int MIN=-1;
	private  int data;
	private BinarySortTree lNode;
	private BinarySortTree rNode;
	
	@Override
	public int getData() {
		return data;
	}


	public void setData(int data) {
		this.data = data;
	}


	@Override
	public BinarySortTree getlNode() {
		return lNode;
	}


	public void setlNode(BinarySortTree lNode) {
		this.lNode = lNode;
	}


	@Override
	public BinarySortTree getrNode() {
		return rNode;
	}


	public void setrNode(BinarySortTree rNode) {
		this.rNode = rNode;
	}
	
	public BinarySortTree() {
		lNode=null;
		rNode=null;
		data=MIN;
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
		System.out.println(this.getData());
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
				this.setlNode(new BinarySortTree());
			}
			this.getlNode().buildTree(data);
		}else {
			if (null==this.getrNode()) {
				this.setrNode(new BinarySortTree());
			}
			this.getrNode().buildTree(data);
		}
	}
	
	public BinarySortTree findNode(int data) {
		BinarySortTree bTree =this;
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
	
	public BinarySortTree findMin(BinarySortTree bTree) {
		BinarySortTree pTree=bTree;
		while(pTree.getlNode()!=null) {
			pTree=pTree.getlNode();
		}
		return pTree;
	}
		
	public BinarySortTree findNodePre(int data) {
		BinarySortTree bTree =this;
		BinarySortTree bTreePre=null;
		
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
		BinarySortTree dTree=this.findNode(data);
		BinarySortTree dTreePre=this.findNodePre(data);
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
			BinarySortTree mTree=this.findMin(dTree.getrNode());
			dTree.delNode(mTree.getData());
			dTree.setData(mTree.getData());
		}
	}
}
