import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Tourney {
	
	public String winner(String[] bracket, String results) {
		ArrayList<String> brack = new ArrayList<>();
		Queue<Character> result = new LinkedList<Character>();
		int rounds = (int) (Math.log(bracket.length) / Math.log(2));
		for (int z = 0; z < bracket.length; z++) {
			brack.add(bracket[z]);
		}
		for (int p = 0; p < results.length(); p++) {
			result.add(results.charAt(p));
		}
		for (int y = 0; y < rounds; y++) {
			int bSize = brack.size()/2;
			for (int h = 0; h < bSize; h++) {
				if (!(brack.get(h)).equals("bye") && !(brack.get(h + 1)).equals("bye")) {
					if (result.element() == 'H') {
						brack.remove(h + 1);
						result.remove();
						continue;
					} else {
						brack.remove(h);
						result.remove();
						continue;
					}
				} else if ((brack.get(h)).equals("bye")) {
					brack.remove(h);
					continue;
				} else if ((brack.get(h + 1)).equals("bye")) {
					brack.remove(h + 1);
					continue;
				}
			}
		}
		return brack.get(0);
	}
}
