import java.util.*;
import java.util.Map.Entry;

public class MaxDonor {
	public String generous(String[] orgs, int[] amount) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		String yes = new String();
		for (int i = 0; i < orgs.length; i++) {
			if (!m.containsKey(orgs[i])) {
				m.put(orgs[i], 0);
			} else {
				continue;
			}
		}
		for (int j = 0; j < orgs.length; j++) {
			int counter = amount[j] + m.get(orgs[j]);
			m.put(orgs[j], counter);
		}
		int max = Collections.max(m.values());
		for (Entry<String, Integer> entry : m.entrySet()) {
			if (entry.getValue() == max) {
				yes = entry.getKey() + ":" + "$" + max;
			} else {
				continue;
			}

		}
		return yes;
	}
}
