package tree;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author String
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Avl extends BinarySortTree{
	private int height;
	private Character data;
	private Avl leftNode;
	private Avl rightNode;

	public static int height(Avl avl) {
		if (avl==null) {
			return -1;
		}
		return avl.height;
	}

	/**
	 * @param parameterData
	 */
	@Override
	public void buildTree(char parameterData) {
		if(null==this.data) {
			this.data=parameterData;
			return;
		}
		if(parameterData<this.data) {
			if(null==this.getLeftNode()) {
				this.setLeftNode(new Avl());
			}
			this.getLeftNode().buildTree(parameterData);
			if((height(this.getLeftNode())- height(this.getRightNode()))==TreeConstantsUtils.HEIGHT_DIFFERENCE) {
				if(parameterData<this.getLeftNode().getData()) {
					if(findNodePre(this,this.getData())==null) {
						dealWithAvlLeft();
					}else {
						Avl dTreePre= (Avl) findNodePre(this,this.getData());
						if(dTreePre.getData()<this.getData()) {
							dTreePre.setRightNode(singleRotateWithLeft());
						}else {
							dTreePre.setLeftNode(singleRotateWithLeft());
						}
					}
				}else {
					if(findNodePre(this,this.getData())==null) {
						this.setLeftNode(this.getLeftNode().singleRotateWithRight());
						dealWithAvlLeft();
					}else {
						Avl dTreePre= (Avl) findNodePre(this,this.getData());
						if(dTreePre.getData()<this.getData()) {
							dTreePre.setRightNode(doubleRotateWithLeft());
						}else {
							dTreePre.setLeftNode(doubleRotateWithLeft());
						}
					}
				}
			}
		}else {
			if (null==this.getRightNode()) {
				this.setRightNode(new Avl());
			}
			this.getRightNode().buildTree(parameterData);
			if((height(this.getRightNode())- height(this.getLeftNode()))==TreeConstantsUtils.HEIGHT_DIFFERENCE) {
				if(parameterData>=this.getRightNode().getData()) {
					if(findNodePre(this,this.getData())==null) {
						dealWithAvlRight();
					}else {
						Avl dTreePre= (Avl) findNodePre(this,this.getData());
						if(dTreePre.getData()<this.getData()) {
							dTreePre.setRightNode(singleRotateWithRight());
						}else {
							dTreePre.setLeftNode(singleRotateWithRight());
						}
					}
				}else {
					if(findNodePre(this,this.getData())==null) {
						this.setRightNode(this.getRightNode().singleRotateWithLeft());
						dealWithAvlRight();
					}else {
						Avl dTreePre= (Avl) findNodePre(this,this.getData());
						if(dTreePre.getData()<this.getData()) {
							dTreePre.setRightNode(doubleRotateWithRight());
						}else {
							dTreePre.setLeftNode(doubleRotateWithRight());
						}
					}
				}
			}
		}
		this.setHeight(Math.max(height(this.getRightNode()), height(this.getLeftNode()))+1);
	}

	/**
	 * @param parameterData
	 */
	@Override
	public void delNode(char parameterData) {
		Avl dTree = (Avl) findNode(this,parameterData);
		Avl dTreePre = (Avl) findNodePre(this,parameterData);
		if(null==dTree) {return ;}
		if((dTree.getLeftNode()==null)&&(dTree.getRightNode()==null)) {
			if(dTreePre.getData()<parameterData) {
				dTreePre.setRightNode(null);
			}else {
				dTreePre.setLeftNode(null);
			}
		}else if((dTree.getLeftNode()!=null)&&(dTree.getRightNode()==null)) {
			if(dTreePre.getData()<parameterData) {
				dTreePre.setRightNode(dTree.getLeftNode());
			}else {
				dTreePre.setLeftNode(dTree.getLeftNode());
			}
		}else if((dTree.getLeftNode()==null)&&(dTree.getRightNode()!=null)) {
			if(dTreePre.getData()<parameterData) {
				dTreePre.setRightNode(dTree.getRightNode());
			}else {
				dTreePre.setLeftNode(dTree.getRightNode());
			}
		}else {
			Avl mTree= (Avl) findMin(dTree.getRightNode());
			dTree.delNode(mTree.getData());
			dTree.setData(mTree.getData());
		}
	}

	private void dealWithAvlRight() {
		Avl zAvl=this.getLeftNode();
		Avl k1 = this.getRightNode();
		this.setRightNode(k1.getRightNode());
		k1.setRightNode(k1.getLeftNode());
		k1.setLeftNode(zAvl);
		this.setLeftNode(k1);
		setDataAndHeight(k1);
		this.setHeight(Math.max(k1.getHeight(), height(this.getRightNode()))+1);
	}

	private void dealWithAvlLeft() {
		Avl zAvl=this.getRightNode();
		Avl k1=this.getLeftNode();
		this.setLeftNode(k1.getLeftNode());
		k1.setLeftNode(k1.getRightNode());
		k1.setRightNode(zAvl);
		this.setRightNode(k1);
		setDataAndHeight(k1);
		this.setHeight(Math.max(k1.getHeight(), height(this.getLeftNode()))+1);
	}

	private void setDataAndHeight(Avl k1) {
		char k2data = this.data;
		this.data=k1.getData();
		k1.setData(k2data);
		k1.setHeight(Math.max(height(k1.getRightNode()), height(k1.getLeftNode()))+1);
	}

	private Avl doubleRotateWithRight() {
		this.setRightNode(this.getRightNode().singleRotateWithLeft());
		return this.singleRotateWithRight();
	}

	private Avl doubleRotateWithLeft() {
		this.setLeftNode(this.getLeftNode().singleRotateWithRight());
		return  this.singleRotateWithLeft();
	}

	private Avl singleRotateWithLeft() {
		Avl k1=this.getLeftNode();
		this.setLeftNode(k1.getRightNode());
		k1.setRightNode(this);
		this.height=Math.max(height(this.getRightNode()), height(this.getLeftNode()))+1;
		k1.setHeight(Math.max(this.getHeight(), height(k1.getLeftNode()))+1);
		return k1;
	}

	private Avl singleRotateWithRight() {
		Avl k1=this.getRightNode();
		this.setRightNode(k1.getLeftNode());
		k1.setLeftNode(this);
		this.height=Math.max(height(this.getRightNode()), height(this.getLeftNode()))+1;
		k1.setHeight(Math.max(this.getHeight(), height(k1.getRightNode()))+1);
		return k1;
	}

}
