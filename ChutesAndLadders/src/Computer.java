
public class Computer extends User{
	
	//instance variables
	private String name="Randy Melvin Bartholomew the Third";
//	private int rowIndex=9;
//	private int colIndex=0;
//	private Space[][] board;
//	boolean win=false;
	
	//constructor
	public Computer() {
		super("Randy Melvin Bartholomew the Third");
	}
		
	//methods
	//Later problem: how to copy array in here 
	public void setBoard() {
//		board = super.setBoard();
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
		return super.getRowIndex();
//		return rowIndex;
	}
		
		
	public int getColumnIndex() {
		return super.getColumnIndex();
//		return colIndex;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean getWin() {
		if ((super.getRowIndex()==0 && super.getColumnIndex()==0)|| super.getRowIndex()<0) {
			return true;
		}else {
			return false;
		}
	
	}

}
