public class PathSum {
        public int hasPath(int target, TreeNode tree){
        	int sum = 0;
        	if(tree==null) return 0;
        	if((sum+=tree.info)==target) return 1;
            if((hasPath(target-sum,tree.left)>0)||(hasPath(target-sum,tree.right)>0)) return 1;
            return 0;
	}
}