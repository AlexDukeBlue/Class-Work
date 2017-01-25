import java.util.ArrayList;
import java.util.Arrays;
//import java.util.List;

public class MemberCheck {
	public String[] whosDishonest(String[] club1, String[] club2, String[] club3) {
		// TODO:
		ArrayList<String> finalList = new ArrayList<String>();
		for (int i = 0; i <= club1.length - 1; i++) {
			for (int j = 0; j <= club2.length - 1; j++) {
				if (club1[i].equals(club2[j]) && !finalList.contains(club1[i])) {
					finalList.add(club1[i]);
				} else {
					continue;
				}
			}
		}

		for (int f = 0; f <= club1.length - 1; f++) {
			for (int g = 0; g <= club3.length - 1; g++) {
				if (club1[f].equals(club3[g]) && !finalList.contains(club1[f])) {
					finalList.add(club1[f]);
				} else {
					continue;
				}
			}
		}

		for (int h = 0; h <= club2.length - 1; h++) {
			for (int k = 0; k <= club3.length - 1; k++) {
				if (club2[h].equals(club3[k]) && !finalList.contains(club2[h])) {
					finalList.add(club2[h]);
				} else {
					continue;
				}
			}
		}
		String[] finalArray = finalList.toArray(new String[finalList.size()]);
		Arrays.sort(finalArray);
		return finalArray;
	}
}
