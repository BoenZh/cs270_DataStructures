
public class cell {
	private int row;
	private int col;
	
	
	public cell(int r, int c){
		row=r;
		col=c;
	}
	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}
	
	/**
	 * @return the col
	 */
	public int getCol() {
		return col;
	}
	
	public String toString(){
		String result="("+row+", "+col+")";
		return result;
	}
	
	
	

}
