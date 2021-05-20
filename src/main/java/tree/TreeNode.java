package tree;
/**
 * @author String
 */
public class TreeNode {

    public static final char EMPTY = ' ';

	public int getData() {
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
		this.data=EMPTY;
		this.lNode=null;
		this.rNode=null;
	}
	

	public int buildTreeByPre(int index,String string) {
		if(index>=string.length()) {
			return 0;
		}
		char c=string.charAt(index);
		if (EMPTY==c) {
			return index;
		}
		this.setData(c);
		this.setlNode(new TreeNode());
		int rIndex=this.getlNode().buildTreeByPre(index+1, string);
		if(rIndex==index+1) {
			this.setlNode(null);
		}
		this.setrNode(new TreeNode());
		int end=this.getrNode().buildTreeByPre(rIndex+1, string);
		if(end==rIndex+1) {
			this.setrNode(null);
		}
		return end;
	}

	public int buildTreeByPost(int lastIndex,String string) {
		if(lastIndex<0) {
			return -1;
		}
		char c=string.charAt(lastIndex);
		if(EMPTY==c) {
			return lastIndex;
		}
		this.setData(c);
		this.setrNode(new TreeNode());
		int rIndex=this.getrNode().buildTreeByPost(lastIndex-1, string);
		if(rIndex==lastIndex-1) {
			this.setrNode(null);
		}
		this.setlNode(new TreeNode());
		int end=this.getlNode().buildTreeByPost(rIndex-1, string);
		if(end==rIndex-1) {
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
}
