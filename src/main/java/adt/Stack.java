package adt;
/**
 * @author String
 */
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
	
	public void push(int data) {
		Node pNode = new Node();
		pNode.setData(data);
		Node top = top();
		top.setNode(pNode);
	}
	
	public void pop() {
		Node top = topPre();
		top.setNode(null);
		show();
	}
	
	public void show() {
		Node p = node;
		while(null!=p) {
			System.out.println(p.getData());
			p=p.getNode();
		}
	}
}
