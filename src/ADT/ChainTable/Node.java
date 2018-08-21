package ADT.ChainTable;

public class Node {
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
	
	
 	public boolean IsEmpty() {
		return this == null? true:false;
	}
	
	public Node Find(int data) {
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
	
	public Node FindPrevious(int data) {
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
	
	public boolean IsLast(int data) {
		Node pNode = Find(data);
		return null==pNode.node?true:false;
		
	}
	
	public void Insert(int data,int position) {
		Node pNode = Find(position);
		if(null!=pNode) {
			Node p = new Node();
			p.setData(data);
			p.setNode(pNode.getNode());
			pNode.setNode(p);
		}
	}

	public void delete(int data) {
		Node pf=FindPrevious(data);
		if(null!=pf) {
			pf.setNode(pf.getNode().getNode());
		}
	} 

	public static void main(String args[]) {
		Node head = new Node();
		head.Insert(1, 0);
		head.Insert(2, 1);
		Node pNode = head;
		while(null!=pNode) {
			System.out.println(pNode.getData());
			pNode=pNode.getNode();
		}
	}
}
