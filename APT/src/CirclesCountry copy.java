import static java.lang.Math.sqrt;

public class CirclesCountry {
	public int leastBorders(int[] x, int[] y, int[] r, int x1, int y1, int x2, int y2) {
		int borders = 0;
		for (int i = x.length - 1; i >= 0; i--) {
			double beforeRadiusOfBeginning = ((x1 - x[i]) * (x1 - x[i])) + ((y1 - y[i]) * (y1 - y[i]));
			double beforeRadiusOfEnd = ((x2 - x[i]) * (x2 - x[i])) + ((y2 - y[i]) * (y2 - y[i]));
			double radiusOfBeginning = sqrt(beforeRadiusOfBeginning);
			double radiusOfEnd = sqrt(beforeRadiusOfEnd);
			if (radiusOfBeginning < r[i] && radiusOfEnd < r[i]) {

			} else if (radiusOfBeginning < r[i] ^ radiusOfEnd < r[i]) {
				borders++;
			} else {
				continue;
			}
		}
		return borders;
	}
}