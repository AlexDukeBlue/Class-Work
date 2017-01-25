import java.util.ArrayList;
import java.util.Collections;

public class SpreadingNews {

	public int kids(int num, int[] boss) {
		int total = 0;
		for (int p = 0; p < boss.length; p++) {
			if (boss[p] == num) {
				total += 1;
				num = boss[p];
			} else {
				continue;
			}
		}
		return total;
	}

	public int minTime(int[] supervisors) {
		ArrayList<Integer> lumber = new ArrayList<>();
		for (int d = supervisors.length; d > 0; d--) {
			lumber.add(kids(d, supervisors));
		}
		return kids(0,supervisors);
	}
}