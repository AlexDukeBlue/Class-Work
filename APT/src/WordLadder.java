import java.util.LinkedList;
import java.util.Queue;

public class WordLadder {
	public boolean oneLetter(String thisOne, String other) {
		int howMany = 0;
		for (int p = 0; p < other.length(); p++) {
			if (other.charAt(p) == thisOne.charAt(p)) {
				continue;
			} else if (!(other.charAt(p) == thisOne.charAt(p))) {
				howMany += 1;
			}
		}
		if (howMany == 1) {
			return true;
		}
		return false;
	}

	public String ladderExists(String[] words, String from, String to) {
		if (oneLetter(from, words[0])) {
			for (int p = 0; p < words.length; p++) {
				if (!(oneLetter(words[p], to))) {
					continue;
				} else if (oneLetter(words[p], to)) {
					return "ladder";
				}
			}
			return "none";
		} else {
			Queue<String> myQueue = new LinkedList<>();
			for (int p = 0; p < words.length; p++) {
				myQueue.add(words[p]);
			}
			for (int p = 0; p < words.length; p++) {
				if (!(oneLetter(myQueue.element(), to))) {
					myQueue.remove();
					continue;
				} else if (oneLetter(myQueue.element(), to)) {
					return "ladder";
				}
			}
		}
		return "none";
	}
}
