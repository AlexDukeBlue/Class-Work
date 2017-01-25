import java.util.ArrayList;
import java.util.List;

public class HashTaggery {
	public String maxTag(String[] tags, String[] messages) {
		String[] newMess = new String[0];
		// String[] newNewMess = new String[0];
		List<String> see = new ArrayList<>();
		for (int j = 0; j < tags.length; j++) {
			see.add(tags[j]);
		}
		double counter = 0.0;
		for (int i = 0; i < messages.length; i++) {
			newMess = messages[i].split(" ");
			for (String s : newMess) {
				if (see.contains(s)) {
					counter = counter + 1.0;
					break;
				} else {
					continue;
				}
			}

		}
		String po = new String();
		double perc = .75;
		double oop = counter / (double) messages.length;
		if ((oop) >= (perc)) {
			po = "tagged";
		} else {
			po = "missed";
		}
		return po;
	}
}
