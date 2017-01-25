public class TreeCount {
	public int count(TreeNode tree) {
		int leafCount = 0;
		if (tree == null)
			return 0;
		leafCount += (1 + count(tree.left) + count(tree.right));
		return leafCount;
	}
}