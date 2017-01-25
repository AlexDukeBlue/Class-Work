public class BoggleScore {

	public static long MOD = (long) 1e13;

	private char[][] twod(String[] grid) {
		char[][] twod = new char[4][4];
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 4; c++) {
				twod[r][c] = grid[r].charAt(c);
			}
		}
		return twod;
	}

	private long[][] initial(char[][] board, char ch) {
		long[][] one = new long[4][4];
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 4; c++) {
				if (board[r][c] == ch) {
					one[r][c] = 1;
				}
			}
		}
		return one;
	}

	public long bestScore(String[] grid, String[] words) {

		long score = 0;
		char[][] board = twod(grid); 

		for (String s : words) {
			long[][] scoreboard = initial(board, s.charAt(0));
			long sc = check(s.substring(1), scoreboard, board);
			sc = (sc * s.length() * s.length()) % MOD; 
			score = (score + sc) % MOD;
		}

		return score;
	}

	private long check(String s, long[][] scoreboard, char[][] board) {

		if (s.length() == 0)
			return sum(scoreboard); // default
		long[][] newboard = new long[4][4];
		boolean found = false;
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 4; c++) {
				if (board[r][c] == s.charAt(0)) {
					found = true;
					newboard[r][c] = neighborsum(scoreboard, r, c);
				}
			}
		}
		if (!found)
			return 0L;

		long score = check(s.substring(1), newboard, board);
		return score;

	}

	private long sum(long[][] scoreboard) {
		long total = 0L;
		for (int r = 0; r < 4; r++)
			for (int c = 0; c < 4; c++)
				total = (total + scoreboard[r][c]) % MOD;
		return total;
	}

	private long neighborsum(long[][] scoreboard, int r, int c) {
		int[] dRow = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dCol = { -1, 0, 1, -1, 1, -1, 0, 1 };

		long sum = 0L;
		for (int d = 0; d < dRow.length; d++) {
			int nr = r + dRow[d];
			int nc = c + dCol[d];
			if (nr >= 0 && nc >= 0 && nr < 4 && nc < 4) {
				sum = (sum + scoreboard[nr][nc]) % MOD;
			}
		}
		return sum;
	}
}