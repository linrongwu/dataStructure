package adt;
/**
 * @author String
 */
public final class Node {
	public Node getNode() {
		return node;
	}


	public void setNode(Node node) {
		this.node = node;
	}


	public int getData() {
		return data;
	}


	public void setData(int data) {
		this.data = data;
	}

	private Node node;
	private int data;
	
	public Node() {
		node = null;
		data = 0;
	}

	public Node find(int data) {
		if(this.getData()==data) {
			return this;
		}
		Node p = this.getNode();
		while(null!=p) {
			if(p.getData()==data) {
				return p;
			}
			p=p.getNode();
		}
		return null;
	}
	
	public Node findPrevious(int data) {
		if(this.getData()==data) {
			return null;
		}
		Node p = this.getNode();
		Node pF = this;
		while(null!=p) {
			if(p.getData()==data) {
				return pF;
			}
			p=p.getNode();
			pF=pF.getNode();
		}
		return null;
	}
	
	public boolean isLast(int data) {
		Node pNode = find(data);
		return null==pNode.node?true:false;
		
	}
	
	public void insert(int data, int position) {
		Node pNode = find(position);
		if(null!=pNode) {
			Node p = new Node();
			p.setData(data);
			p.setNode(pNode.getNode());
			pNode.setNode(p);
		}
	}

	public void delete(int data) {
		Node pf= findPrevious(data);
		if(null!=pf) {
			pf.setNode(pf.getNode().getNode());
		}
	}
}
