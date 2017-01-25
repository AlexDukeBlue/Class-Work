import java.util.ArrayList;
import java.util.List;

public class Starter {
	public int begins(String[] words, String first) {
		char f = first.charAt(0);
		List<String> newWords = new ArrayList<>();
		int count = 0;
		for (int j = 0; j < words.length; j++) {
			if (!newWords.contains(words[j])) {
				newWords.add(words[j]);
			}
		}
		for (String s : newWords) {
			if (s.charAt(0) == f) {
				count = count + 1;
			} else {
				continue;
			}
		}

		return count;
	}
}