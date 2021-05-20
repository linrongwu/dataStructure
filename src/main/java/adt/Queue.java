package adt;
/**
 * @author String
 */
public final class Queue {
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

}
