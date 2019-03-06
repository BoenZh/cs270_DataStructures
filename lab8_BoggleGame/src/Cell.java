
public class Cell {
	private int[][] game;
	/**
	 * 
	 * @param size -  the one side size of the board
	 */
	public Cell(int size){
		game = new int[size][size];
		for(int x = 0; x < size; x++){
			for(int y = 0; y < size; y++){
				game[x][y] = 0;
			}
		}
	}
	/** mark the current point as visited by 1
	 * 
	 * @param row - the row number of current point
	 * @param col - the column number of current point
	 */
	public void markVisited(int row, int col){
		game[row][col] = 1;
	}
	
	/** unmark the current point as visited by 0
	 * 
	 * @param row - the row number of current point
	 * @param col - the column number of current point
	 */
	public void markUnVisited(int row, int col){
		game[row][col] = 0;
	}
	
	/** To make sure if the current point has been visited
	 * 
	 * @param row - the row number of current point
	 * @param col - the column number of current point
	 * @return return true if the current point is already visited, return false otherwise
	 */
	public boolean getVisited(int row, int col){
		if (game[row][col] == 1)
			return true;
		else
			return false;
	}
	
	/** clear all the points to be 0
	 * 
	 * @param size - one side size of the board
	 */
	public void clear(int size){
		for(int x = 0; x < size; x++){
			for(int y = 0; y < size; y++){
				game[x][y] = 0;
	}

		}
	}
}
