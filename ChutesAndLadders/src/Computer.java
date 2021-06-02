
public class Computer extends User{
	
	//instance variables
	private String name="Randy Melvin Bartholomew the Third";
	private int rowIndex=9;
	private int colIndex=0;
	private Space[][] board;
	boolean win=false;
	
	//constructor
	public Computer() {
		super("Randy Melvin Bartholomew the Third");
	}
		
	//methods
	public void setBoard() {
		board = super.getBoard();
	}
	
	//play turns
	public void turn() {
		super.turn();
	}
	
//	//returns whether or not player is in even row 
//	public boolean isEven() {
//		return true;
//		//^placeholder
//	}
		
		
	public int getRowIndex() {
		return rowIndex;
	}
		
		
	public int getColumnIndex() {
		return colIndex;
	}

}
