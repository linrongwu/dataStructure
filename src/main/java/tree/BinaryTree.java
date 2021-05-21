package tree;

import lombok.Data;

/**
 * @author String
 */
@Data
public class BinaryTree {
	private Character data;
	private BinaryTree leftNode;
	private BinaryTree rightNode;

	/**
	 * @param index
	 * @param string
	 * @return
	 */
	public int buildTreeByPre(int index, String string) {
		if(index>=string.length()) {return -1;}
		char c=string.charAt(index);
		if (TreeConstantsUtils.EMPTY==c) {return index;}
		this.setData(c);
		int lIndex = index+1;
		if(lIndex>=string.length()){return -1;}
		if(TreeConstantsUtils.EMPTY!=string.charAt(lIndex)){
			this.setLeftNode(new BinaryTree());
			lIndex=this.getLeftNode().buildTreeByPre(lIndex, string);
		}
		int rIndex = lIndex+1;
		if(rIndex>=string.length()){return -1;}
		if(TreeConstantsUtils.EMPTY!=string.charAt(rIndex)){
			this.setRightNode(new BinaryTree());
			rIndex=this.getRightNode().buildTreeByPre(rIndex, string);
		}
		return rIndex;
	}

	/**
	 * @param lastIndex
	 * @param string
	 * @return
	 */
	public int buildTreeByPost(int lastIndex,String string) {
		if(lastIndex<0) {return -1;}
		char c=string.charAt(lastIndex);
		if(TreeConstantsUtils.EMPTY==c) {return lastIndex;}
		this.setData(c);

		int rIndex = lastIndex-1;
		if(rIndex<0){return -1;}
		if(TreeConstantsUtils.EMPTY!=string.charAt(rIndex)){
			this.setRightNode(new BinaryTree());
			rIndex=this.getRightNode().buildTreeByPost(rIndex, string);
		}

		int lIndex = rIndex-1;
		if(lIndex<0){return -1;}
		if(TreeConstantsUtils.EMPTY!=string.charAt(lIndex)){
			this.setLeftNode(new BinaryTree());
			lIndex=this.getLeftNode().buildTreeByPost(lIndex, string);
		}
		return lIndex;
	}
	
	public static void orderByPre(BinaryTree tree,StringBuilder stringBuilder) {
		stringBuilder.append(tree.getData());
		if(null!=tree.getLeftNode()) {
			orderByPre(tree.getLeftNode(),stringBuilder);
		}else {
			stringBuilder.append(TreeConstantsUtils.EMPTY);
		}
		if(null!=tree.getRightNode()) {
			orderByPre(tree.getRightNode(),stringBuilder);
		}else {
			stringBuilder.append(TreeConstantsUtils.EMPTY);
		}
	}

	public static void orderByIn(BinaryTree tree,StringBuilder stringBuilder) {
		if(null!=tree.getLeftNode()) {
			orderByIn(tree.getLeftNode(),stringBuilder);
		}else {
			stringBuilder.append(TreeConstantsUtils.EMPTY);
		}
		stringBuilder.append(tree.getData());
		if(null!=tree.getRightNode()) {
			orderByIn(tree.getRightNode(),stringBuilder);
		}else {
			stringBuilder.append(TreeConstantsUtils.EMPTY);
		}
	}

	public static void orderByPost(BinaryTree tree,StringBuilder stringBuilder) {
		if(null!=tree.getLeftNode()) {
			orderByPost(tree.getLeftNode(),stringBuilder);
		}else {
			stringBuilder.append(TreeConstantsUtils.EMPTY);
		}
		if(null!=tree.getRightNode()) {
			orderByPost(tree.getRightNode(),stringBuilder);
		}else {
			stringBuilder.append(TreeConstantsUtils.EMPTY);
		}
		stringBuilder.append(tree.getData());
	}

}
