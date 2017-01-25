import java.util.Arrays;
import java.util.HashSet;

public class SandwichBar {
	public int whichOrder(String[] available, String[] orders) {
		HashSet<String> bar = new HashSet<String>(Arrays.asList(available));

		int current = 0;
		for (String s : orders) {
			HashSet<String> cs = new HashSet<String>(Arrays.asList(s.split(" ")));
			if (bar.containsAll(cs)) {
				break;
			} else if (s.equals(orders[orders.length - 1])) {
				current = -1;
				break;
			} else {
				current += 1;
				continue;
			}
		}
		return current;
	}
}