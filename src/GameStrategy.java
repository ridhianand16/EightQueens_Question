public class GameStrategy {
	private boolean placedQueens[][] = new boolean[8][8];
	private int numQueens = 0;

	private int getColumn(int cellId) {
		// WRITE YOUR LOGIC HERE...................................		

		return (cellId%8);
	}
	
	private int getRow(int cellId) {
		// WRITE YOUR LOGIC HERE....................................
		return (cellId/8);	
	}

	public boolean isValidPosition(int cellId) {
		boolean isValid = true;

		if(numQueens == 8) throw new GameOverException();	// just return out of the method
				
		int col = getColumn(cellId);
		
		int row = getRow(cellId);
		
		for( int c = 0 ; c < 8; c++) {
			if( this.placedQueens[row][c] )
				return false;
		}

		for( int r = 0 ; r < 8; r++) {
			if( this.placedQueens[r][col] )
				return false;
		}

		for(int i = row-1, j = col-1; i>= 0 && j >= 0; i--, j--) {
			if(this.placedQueens[i][j])
				return false;
		}

		for(int i = row + 1, j = col+1; i < 8 && j < 8 ; i++, j++) {
			if(this.placedQueens[i][j])
				return false;
		}

		for(int i = row-1, j = col+1; i>= 0 && j<8; i--, j++) {
			if(this.placedQueens[i][j])
				return false;
		}

		for(int i = row + 1, j = col - 1; i < 8 &&j >=0 ; i++, j--) {
			if(this.placedQueens[i][j])
				return false;
		}

		this.placedQueens[row][col] = true;
		this.numQueens++;
		return true;
	}
}














