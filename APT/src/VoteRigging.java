import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class VoteRigging {
	public int minimumVotes(int[] votes) {
		int boughtVotes = 0;
		List<Integer> list = Arrays.stream(votes).boxed().collect(Collectors.toList());
		int best = list.get(0);
		list.remove(0);
		if (list.size() == 0)
			return 0;
		while (true) {
			if (best > Collections.max(list))
				break;
			int maxDex = list.indexOf(Collections.max(list));
			best += 1;
			boughtVotes += 1;
			list.set(maxDex, list.get(maxDex) - 1);
		}
		return boughtVotes;
	}
}
