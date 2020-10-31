package tree;

public class TreeNode {
	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public TreeNode getlNode() {
		return lNode;
	}

	public void setlNode(TreeNode lNode) {
		this.lNode = lNode;
	}

	public TreeNode getrNode() {
		return rNode;
	}

	public void setrNode(TreeNode rNode) {
		this.rNode = rNode;
	}

	private char data;
	private TreeNode lNode;
	private TreeNode rNode;
	
	public TreeNode() {
		this.data=' ';
		this.lNode=null;
		this.rNode=null;
	}
	

	public int buildTreeByPre(int index,String string) {
		if(index>=string.length()) {
			return 0;
		}
		char c=string.charAt(index);
		if (' '==c) {
			return index;
		}
		this.setData(c);
		this.setlNode(new TreeNode());
		int rindex=this.getlNode().buildTreeByPre(index+1, string);
		if(rindex==index+1) {
			this.setlNode(null);
		}
		this.setrNode(new TreeNode());
		int end=this.getrNode().buildTreeByPre(rindex+1, string);
		if(end==rindex+1) {
			this.setrNode(null);
		}
		return end;
	}

	public int buildTreeByPost(int lastIndex,String string) {
		if(lastIndex<0) {
			return -1;
		}
		char c=string.charAt(lastIndex);
		if(' '==c) {
			return lastIndex;
		}
		this.setData(c);
		this.setrNode(new TreeNode());
		int rindex=this.getrNode().buildTreeByPost(lastIndex-1, string);
		if(rindex==lastIndex-1) {
			this.setrNode(null);
		}
		this.setlNode(new TreeNode());
		int end=this.getlNode().buildTreeByPost(rindex-1, string);
		if(end==rindex-1) {
			this.setlNode(null);
		}
		return end;
	}
	

	
	public void orderByPre() {
			System.out.print(this.getData());
			if(null!=this.getlNode()) {
			this.getlNode().orderByPre();
			}
			else {
				System.out.print("0");
			}
			if(null!=this.getrNode()) {
			this.getrNode().orderByPre();
			}
			else {
				System.out.print("0");
			}
	}
	
	public void orderByPost() {
		if(null!=this.getlNode()) {
		this.getlNode().orderByPost();
		}
		else {
			System.out.print("0");
		}
		if(null!=this.getrNode()) {
		this.getrNode().orderByPost();
		}
		else {
			System.out.print("0");
		}
		System.out.print(this.getData());
}
	
	public void orderByIn() {
		if(null!=this.getlNode()) {
		this.getlNode().orderByIn();
		}
		else {
			System.out.print("0");
		}
		System.out.print(this.getData());
		if(null!=this.getrNode()) {
		this.getrNode().orderByIn();
		}
		else {
			System.out.print("0");
		}
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode treeNode=new TreeNode();
		treeNode.buildTreeByPost(8, "   CB  DA");
		treeNode.orderByPre();
		System.out.println("");
		treeNode.orderByPost();
		System.out.println("");
		treeNode.orderByIn();
		System.out.println("");
		treeNode.buildTreeByPre(0, "AB C  D  ");
		treeNode.orderByPre();
		System.out.println("");
		treeNode.orderByPost();
		System.out.println("");
		treeNode.orderByIn();
		
	}

}
