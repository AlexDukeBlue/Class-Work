import java.util.Stack;

public class QBalance {

	private static String LEFTS = "{[(";
	private static String RIGHTS = "}])";

	public int bindex(String symbols) {
		Stack<Integer> st = new Stack<Integer>();
		for (int k = 0; k < symbols.length(); k++) {
			char ch = symbols.charAt(k);
			if (Character.isWhitespace(ch) || ch == '+' || ch == '*' || ch == '-' || ch == '/' || (ch >= '0' && ch <= '9') )
				continue;
			int leftIndex = LEFTS.indexOf(ch);
			if (leftIndex >= 0) {
				st.push(leftIndex);
			} else {
				if(st.isEmpty()) return k;
				int rightIndex = RIGHTS.indexOf(ch);
				if (st.peek() != rightIndex)
					return k;
				st.pop();
			}
		}
		if(!st.isEmpty()) return symbols.length();
		return -1;
	}
}