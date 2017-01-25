import java.util.HashSet;
import java.util.Set;

public class SimpleWordGame {
	public int points(String[] player, String[] dictionary) {
		Set<String> hashedDic = new HashSet<String>();
		int numOfPoints = 0;
		for (int i = 0; i <= dictionary.length - 1; i++) {
			hashedDic.add(dictionary[i]);
		}
		for (int i = 0; i <= player.length - 1; i++) {
			String guess = new String();
			guess = player[i];
			if (hashedDic.contains(guess)) {
				int pointAdder = 0;
				pointAdder = (guess.length()) * (guess.length());
				numOfPoints += pointAdder;
				hashedDic.remove(guess);
			} else {
				continue;
			}
		}
		return numOfPoints;
	}
}