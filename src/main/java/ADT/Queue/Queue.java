package ADT.Queue;

import ADT.ChainTable.Node;
import ADT.Stack.Stack;

public class Queue {
	private Node node;
	
	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public Queue() {
		node = new Node();
	}
	
	public void enQueue(int data) {
		Node pNode =new Node();
		pNode.setData(data);

		Node p = this.getNode();
		while(null!=p.getNode()) {
			p=p.getNode();
		}
		p.setNode(pNode);
	}
	
	public void deQueue() {
		Node p = this.getNode();
		p.setNode(p.getNode().getNode());
		this.show();
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
		Queue stack=new Queue();
		stack.enQueue(1);
		stack.show();//01
		stack.deQueue();//0
		System.out.println("-");
		stack.enQueue(2);
		stack.enQueue(3);
		stack.show();//023
		stack.deQueue();//03
		System.out.println("-");
		stack.deQueue();//0
	}

}
