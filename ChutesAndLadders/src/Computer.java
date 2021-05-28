
public class Computer extends Board implements Player{
	
	//instance variables
	private String name="Randy Melvin Bartholomew the Third";
	private int rowIndex=9;
	private int colIndex=0;
	private Space[][] board;
	
	//constructor
	public Computer() {
		board = super.getBoard();
	}
		
	//methods
	public void turn() {
		
	}
	
	//returns whether or not player is in even row 
	public boolean isEven() {
		return true;
		//^placeholder
	}
		
		
	public int getRowIndex() {
		return rowIndex;
	}
		
		
	public int getColumnIndex() {
		return colIndex;
	}

}
