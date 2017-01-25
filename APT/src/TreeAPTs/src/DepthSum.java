public class DepthSum {
        
	  public int height(TreeNode t){
		  if(t == null) return 0;
		  return 1 + Math.max(height(t.left), height(t.right));
	  }
	  
	  public int helper(TreeNode t, int level){
		  if(t == null) return 0;
		  return (level * t.info) + helper(t.left, level + 1) + helper(t.right, level + 1) ;
	  }
	  
	  public int value(TreeNode tree){
        	return helper(tree, 1);
        }
    }
