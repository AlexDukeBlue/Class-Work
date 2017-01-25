public class HeightLabel {
	public int height(TreeNode t){
		if(t == null) return 0;
		if(t.left != null && t.right != null){return height(t.left) + height(t.right);}
		else if(t.left != null){ return 1 + height(t.left);}
		else if(t.right != null){ return 1 + height(t.right);}
		return 1;
	}
	
	public TreeNode rewire(TreeNode t) {
		if(t==null) return null;
		TreeNode ret= new TreeNode(height(t), rewire(t.left), rewire(t.right));
		return ret;
	}
}
