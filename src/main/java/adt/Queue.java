package adt;

import lombok.Data;

/**
 * @author String
 */
@Data
public final class Queue {
	private Node node;

	public Queue() {
		node = new Node();
	}
	
	public void enQueue(char data) {
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
	}

	public String show() {
		return this.getNode().show();
	}

}
