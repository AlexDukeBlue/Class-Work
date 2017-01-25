
public class Isomorphic {
	public String sameShape(TreeNode s, TreeNode t) {
		if(s == null && t == null) return "same";
		if(s == null || t == null) return "different";
		boolean ll = "same".equals(sameShape(s.left,t.left));
		boolean rr = "same".equals(sameShape(s.right,t.right));
		if(ll && rr) return "same";
		return "different";
    }
}
