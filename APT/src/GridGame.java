public class GridGame {
	public int winningMoves(String[] grid) {
		char[][] board = new char[grid.length][grid[0].length()];
		for (int y = 0; y < grid.length; y++) {
				board[y] = grid[y].toCharArray();
		}
		return countWinners(board);
	}

	private int countWinners(char[][] board) {
		int wins = 0;
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 4; c++) {
				if (canMove(board, r, c)) {
					board[r][c] = 'X';
					int opponentWins = countWinners(board);
					if (opponentWins == 0) {
						wins += 1;
					}
					board[r][c] = '.';
				}
			}
		}
		return wins;
	}

	private boolean canMove(char[][] board, int r, int c) {
		boolean hey = true;
		if (board[r][c] == '.') {
			for (int g = 0; g < 2; g++) {
				for (int h = 0; h < 2; h++) {
					if ((r + g) <= 3) {
						if (board[r + g][c] == '.') {
						} else {
							hey = false;
							break;
						}
					}
					if ((r - g) >= 0) {
						if (board[r - g][c] == '.') {
						} else {
							hey = false;
							break;
						}
					}
					if ((c - h) >= 0) {
						if (board[r][c - h] == '.') {
						} else {
							hey = false;
							break;
						}
					}
					if ((c + h) <= 3) {
						if (board[r][c + h] == '.') {
						} else {
							hey = false;
							break;
						}
					}
				}
			}
		} else {
			hey = false;
		}
		return hey;
	}

}