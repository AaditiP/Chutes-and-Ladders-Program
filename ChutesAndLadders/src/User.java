
public class User {
	
	//instance variables
	private String name;
	private int rowIndex=9;
	private int colIndex=0;
	int numSpaces=0;
	boolean win=false;
	Board b = new Board();
	
	//constructor
	public User (String n) {
		name = n;
	}
	
	
	//play turns
	public void turn() {
		int moveNum = (int)(Math.random()*6) + 1;
		
		System.out.println();
		System.out.println("Dice rolled: " + moveNum);
		
		boolean isEven = this.isEven(rowIndex);
		
		/*moves user to the left, right, up, or down depending on
		if user is in even row, or at end of row*/
		if (!isEven) {
			if (moveNum + colIndex > 9) {
				rowIndex = rowIndex-1;
				colIndex = 9-(moveNum - (9-colIndex))+1;
				
			}else {
				colIndex = colIndex + moveNum;
			}
			
		}else {
			if (colIndex - moveNum < 0) {
				rowIndex = rowIndex-1;
				colIndex = (moveNum-colIndex)-1;
			}else {
				colIndex = colIndex - moveNum;
			}
		}
		
		if ((rowIndex==0 && colIndex==0) || rowIndex<0){
			win=true;
		}
		
	}
	
	//call chutes or ladder method if type=2 or type=1 respectively
	public void playChutesOrLadder(int type) {
		if (type==2) {
			this.chutes();
			System.out.println(name + " is at " + rowIndex + " " + colIndex);
		}else if (type==1) {
			this.ladders();
			System.out.println(name + " is at " + rowIndex + " " + colIndex);
		}
		
		if ((rowIndex==0 && colIndex==0) || rowIndex<0) {
			win=true;
		}
	}
	
	//returns whether or not player is in even row 
	public boolean isEven(int rIndex) {
		if (rIndex%2 == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	//changes rowIndex and colIndex if chute is hit
	public void chutes() {
		if (rowIndex<=4) {
			rowIndex = rowIndex + 4;
			numSpaces=4;
		}else if (rowIndex!=9) {
			rowIndex = rowIndex + 1;
			numSpaces=1;
		}
		System.out.println("Oh no, " + name + " hit a chute. They went " + numSpaces + " rows back. ");
	}
	
	//changes rowIndex and colIndex if ladder is hit
	public void ladders() {
		if (rowIndex>=4) {
			rowIndex = rowIndex - 4;
			numSpaces=4;
		}else if (rowIndex!=0) {
			rowIndex = rowIndex - 1;
			numSpaces=1;
		}
		System.out.println("Yay, " + name + " hit a ladder. They went " + numSpaces + " rows forward. ");
	}
	
	//return row
	public int getRowIndex() {
		return rowIndex;
	}
	
	//return column
	public int getColumnIndex() {
		return colIndex;
	}
	
	//returns boolean win to represent if User has won
	public boolean getWin() {
		return win;
	}
	
	//return name 
	public String getName() {
		return name;
	}
	
}
