package adt;

import lombok.Data;

/**
 * @author String
 */
@Data
public final class Node {

	private Node node;
	private Character data;

	public Node find(char parameterData) {
		Node p = this;
		while(null!=p) {
			if(p.getData()==parameterData) {
				return p;
			}
			p=p.getNode();
		}
		return null;
	}
	
	public Node findPrevious(char parameterData) {
		Node pF = this;
		Node p = this.getNode();
		while(null!=p) {
			if(p.getData()==parameterData) {
				return pF;
			}
			p=p.getNode();
			pF=pF.getNode();
		}
		return null;
	}
	
	public boolean isLast(char parameterData) {
		Node pNode = find(parameterData);
		return null != pNode && null == pNode.getNode();
		
	}
	
	public void insert(char parameterData, char positionData) {
		Node pNode = find(positionData);
		if(null!=pNode) {
			Node p = new Node();
			p.setData(parameterData);
			p.setNode(pNode.getNode());
			pNode.setNode(p);
		}
	}

	public void delete(char parameterData) {
		Node pf= findPrevious(parameterData);
		if(null!=pf) {
			pf.setNode(pf.getNode().getNode());
		}
	}

	public String show(){
		Node p = this;
		StringBuilder stringBuilder = new StringBuilder();
		while(null!=p) {
			stringBuilder.append(p.getData());
			p=p.getNode();
		}
		return stringBuilder.toString();
	}
}
