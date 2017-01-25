import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OlympicCandles {
	public int numberOfNights(int[] candles) {
		List<Integer> list = Arrays.stream(candles).boxed().collect(Collectors.toList());
		int n = 1;
		while (list.size() >= n) {
			Collections.sort(list);
			ArrayList<Integer> keepers = new ArrayList<>();
			for (int k = 0; k < n; k++) {
				int burner = list.remove(list.size() - 1);
				burner -= 1;
				if (burner > 0) {
					keepers.add(burner);
				}
			}
			list.addAll(keepers);
			n += 1;
		}
		return n - 1;
	}
}
