public class DNAReverse {
	public String reverse(String dna) {
		// fill in code here
		String reverse = new String();
		int counter = 0;
		for (int i = dna.length(); i > 0; i--) {
			char and = dna.charAt(counter);
			reverse = and + reverse;
			counter++;
		}
		return reverse;
	}
}