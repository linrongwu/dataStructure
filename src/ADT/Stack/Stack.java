package ADT.Stack;

import ADT.ChainTable.Node;

public class Stack {
	private Node node;
	
	public Stack() {
		node=new Node();
	}
	
	public Node Top() {
		Node p = node;
		while(null!=p.getNode()) {
			p=p.getNode();
		}
		return p;
	}
	
	public Node TopPre() {
		Node p = node;
		while(null!=p.getNode().getNode()) {
			p=p.getNode();
		}
		return p;
	}
	
	public void push(int data) {
		Node pNode = new Node();
		pNode.setData(data);
		Node top = Top();
		top.setNode(pNode);
	}
	
	public void pop() {
		Node top = TopPre();
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack=new Stack();
		stack.push(1);
		stack.pop();
		System.out.println("-");
		stack.push(2);
		stack.push(3);
		stack.pop();
		System.out.println("-");
		stack.pop();
	}

}
