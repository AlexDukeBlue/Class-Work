import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anonymous {
	public int howMany(String[] headlines, String[] messages) {
		int counter = 0;
		ArrayList<Character> headlinesChar = new ArrayList<Character>();
		for (int i = 0; i <= headlines.length - 1; i++) {
			for (int h = 0; h <= headlines[i].length() - 1; h++) {
				headlinesChar.add(headlines[i].toLowerCase().charAt(h));
			}
		}
		goHere: for (int f = 0; f <= messages.length - 1; f++) {
			ArrayList<Character> splitMessages = new ArrayList<Character>();
			for (int g = 0; g <= messages[f].length() - 1; g++) {
				splitMessages.add(messages[f].toLowerCase().charAt(g));
			}
			List<String> messNew = new ArrayList<String>(Arrays.asList(messages));
			for (char c : headlinesChar) {
				if (splitMessages.contains(c)) {
					splitMessages.remove(splitMessages.indexOf(c));
				} else if (splitMessages.isEmpty() || messNew.contains(" ")) {
					counter += 1;
					continue goHere;
				} else
					continue;
			}
		}
		return counter;
	}
}
