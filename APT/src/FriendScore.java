import java.util.*;

public class FriendScore {

	public int highestScore(String[] friends) {
		ArrayList<Set<Integer>> data = new ArrayList<Set<Integer>>();


		for (int r = 0; r < friends.length; r++) {
			data.add(new HashSet<>());
			for (int c = 0; c < friends[r].length(); c++) {
				if (friends[r].charAt(c) == 'Y') {
					data.get(r).add(c);
				}
			}
		}

		ArrayList<Integer> t = new ArrayList<>();
		for (int k = 0; k < data.size(); k++) {
			t.add(twof(k, data));
		}

		return Collections.max(t);
	}

	private int twof(int row, ArrayList<Set<Integer>> data) {
		Set<Integer> f = new HashSet<>();
		for (int friend : data.get(row)) {
			f.add(friend);
			f.addAll(data.get(friend));
		}
		f.remove(row);
		return f.size();
	}
}