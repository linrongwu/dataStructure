package adt;

import lombok.Data;

/**
 * @author String
 */
@Data
public final class Stack {
	private Node node;
	
	public Stack() {
		node=new Node();
	}
	
	public Node top() {
		Node p = node;
		while(null!=p.getNode()) {
			p=p.getNode();
		}
		return p;
	}
	
	public Node topPre() {
		Node p = node;
		while(null!=p.getNode().getNode()) {
			p=p.getNode();
		}
		return p;
	}
	
	public void push(char data) {
		Node pNode = new Node();
		pNode.setData(data);
		Node top = top();
		top.setNode(pNode);
	}
	
	public String pop() {
		Node top = topPre();
		top.setNode(null);
		return this.show();
	}
	
	public String show() {
		return this.getNode().show();
	}
}
