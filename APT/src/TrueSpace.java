public class TrueSpace {
	public long calculateSpace(int[] sizes, int clusterSize) {
		long total = 0;
		for (int p = 0; p < sizes.length; p++) {
			long temp = sizes[p];
			long multiple = temp / clusterSize;
			total += clusterSize * multiple;
			if (clusterSize * multiple < temp) {
				total += clusterSize;
			}
		}
		return total;
	}
}