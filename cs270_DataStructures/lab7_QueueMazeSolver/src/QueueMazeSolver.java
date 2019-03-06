
public class QueueMazeSolver implements MazeSolver {
	private MazeGUI gui;
	boolean sovable = false;//set the bollean sovable to false when start the program


/**
 * the Constructor
 */
	public QueueMazeSolver() {

	    gui = new MazeGUI( this );

	  }

	@Override
	/**
	 * This method is called when the start button is
	 * clicked in the MazeGUI.  This method should solve the maze.
	 * This method may call MazeGUI.drawMaze(...) whenever the
	 * GUI display should be updated (after each step of the solution).
	 *
	 * The maze is provided as the first parameter.  It is a 2D array containing
	 * characters that represent the spaces in the maze.  The following
	 * characters will be found in the array:
	 *    '#' - This represents a wall.
	 *    ' ' - This represents an open space (corridor)
	 *
	 * When calling MazeGUI.drawMaze(...) to update the display, the GUI
	 * will recognize the '#' and ' ' characters as well as the following:
	 *    '@' - Means the cell is a space that has been explored
	 *    '%' - Means that the cell is part of the best path to the goal.
	 *
	 * @param maze the maze (see above).
	 * @param startR the row of the start cell.
	 * @param startC the column of the start cell.
	 * @param endR the row of the end (goal) cell.
	 * @param endC the column of the end (goal) cell.
	 */
	public void solve(char[][] maze, int startR, int startC, int endR, int endC) {
		int row = startR;
		int col = startC;
		sovable = false; // Refresh the value when it loads a new maze.
		SLLQueue<cell> finder = new SLLQueue<cell>();
		finder.offer(new cell(row, col));
		while(!finder.isEmpty() && !sovable)
		{
			cell temp = (cell) finder.remove();
			row = temp.getRow();
			col = temp.getCol();
			if(maze[row][col-1]==' ')
			{
				finder.offer(new cell(row, col-1));
				if(row == endR && col-1 == endC)
				{
					sovable = true;
				}
				maze[row][col-1] = '@';
				gui.drawMaze(maze);

				try
				{
					Thread.sleep(150);
				}
				catch( InterruptedException e )
				{
					System.err.println("Thread interrupted!");
				}
			}
			if(maze[row-1][col]==' ')
			{
				finder.offer(new cell(row-1, col));
				if(row-1 == endR && col == endC)
				{
					sovable = true;
				}
				maze[row-1][col] = '@';
				gui.drawMaze(maze);

				try
				{
					Thread.sleep(150);
				}
				catch( InterruptedException e )
				{
					System.err.println("Thread interrupted!");
				}
			}
			if(maze[row][col+1]==' ')
			{
				finder.offer(new cell(row, col+1));
				if(row == endR && col+1 == endC)
				{
					sovable = true;
				}
				maze[row][col+1] = '@';
				gui.drawMaze(maze);

				try
				{
					Thread.sleep(150);
				}
				catch( InterruptedException e )
				{
					System.err.println("Thread interrupted!");
				}
			}
			if(maze[row+1][col]==' ')
			{
				finder.offer(new cell(row+1, col));
				if(row+1 == endR && col == endC)
				{
					sovable = true;
				}
				maze[row+1][col] = '@';
				gui.drawMaze(maze);

				try
				{
					Thread.sleep(150); 
				}
				catch( InterruptedException e )
				{
					System.err.println("Thread interrupted!");
				}
			}
		}
		if(sovable)
		{
			gui.setStatusText("The maze is sovable!!!");
		}
		else
		{
			gui.setStatusText("The maze is unsovable!!!");
		}
	}







  /**
	 * @param args
	 * Main method
	 */
  public static void main( String[] args ) {

     QueueMazeSolver solver = new QueueMazeSolver();

  }








	}
