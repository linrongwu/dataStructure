package tree;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author String
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BinarySortTree extends BinaryTree{
	private Character data;
	private BinarySortTree leftNode;
	private BinarySortTree rightNode;

	/**
	 * @param parameterData
	 */
	public void buildTree(String parameterData){
		for(int i=0;i<parameterData.length();i++){
			this.buildTree(parameterData.charAt(i));
		}
	}

	/**
	 * @param parameterData
	 */
	public void buildTree(char parameterData) {
		if(null==this.data) {
			this.data=parameterData;
			return;
		}
		if(parameterData<this.data) {
			if(null==this.getLeftNode()) {
				this.setLeftNode(new BinarySortTree());
			}
			this.getLeftNode().buildTree(parameterData);
		}else {
			if (null==this.getRightNode()) {
				this.setRightNode(new BinarySortTree());
			}
			this.getRightNode().buildTree(parameterData);
		}
	}

	/**
	 * @param parameterData
	 */
    public void delNode(char parameterData) {
        BinarySortTree dTree=findNode(this,parameterData);
        BinarySortTree dTreePre=findNodePre(this,parameterData);
        if(null==dTree) {return ;}
        if(dTree.getLeftNode()==null && dTree.getRightNode()==null) {
            if(dTreePre.getData()<parameterData) {
                dTreePre.setRightNode(null);
            }else {
                dTreePre.setLeftNode(null);
            }
        }else if(dTree.getLeftNode()!=null && dTree.getRightNode()==null) {
            if(dTreePre.getData()<parameterData) {
                dTreePre.setRightNode(dTree.getLeftNode());
            }else {
                dTreePre.setLeftNode(dTree.getLeftNode());
            }
        }else if(dTree.getLeftNode()==null && dTree.getRightNode()!=null ) {
            if(dTreePre.getData()<parameterData) {
                dTreePre.setRightNode(dTree.getRightNode());
            }else {
                dTreePre.setLeftNode(dTree.getRightNode());
            }
        }else {
            BinarySortTree mTree=findMin(dTree.getRightNode());
            dTree.delNode(mTree.getData());
            dTree.setData(mTree.getData());
        }
    }
	
	public static BinarySortTree findNode(BinarySortTree bTree,char data) {
    	BinarySortTree binarySortTree = bTree;
		while(binarySortTree!=null) {
			if (binarySortTree.getData()>data) {
				if (binarySortTree.getLeftNode()==null) {
					return null;
				}
				binarySortTree=binarySortTree.getLeftNode();
			}else if (binarySortTree.getData()<data) {
				if (binarySortTree.getRightNode()==null) {
					return null;
				}
				binarySortTree=binarySortTree.getRightNode();
			}else {
				return binarySortTree;
			}
		}
		return null;
	}
	
	public static BinarySortTree findMin(BinarySortTree bTree) {
		BinarySortTree pTree=bTree;
		while(pTree.getLeftNode()!=null) {
			pTree=pTree.getLeftNode();
		}
		return pTree;
	}

	public static BinarySortTree findMax(BinarySortTree bTree) {
		BinarySortTree pTree=bTree;
		while(pTree.getRightNode()!=null) {
			pTree=pTree.getRightNode();
		}
		return pTree;
	}
		
	public static BinarySortTree findNodePre(BinarySortTree bTree,char data) {
		BinarySortTree bTreePre=null;
		BinarySortTree binarySortTree=bTree;
		while(binarySortTree!=null) {
			if (binarySortTree.getData()>data&&binarySortTree.getLeftNode()!=null) {
				bTreePre=binarySortTree;
				binarySortTree=binarySortTree.getLeftNode();
			}else if (binarySortTree.getData()<data&&binarySortTree.getRightNode()!=null) {
				bTreePre=binarySortTree;
				binarySortTree=binarySortTree.getRightNode();
			}else {
			    return bTreePre;
			}
		}
		return null;
	}

}
