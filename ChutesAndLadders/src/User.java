
public class User extends Board implements Player {
	
	//instance variables
	private String name;
	private int rowIndex=9;
	private int colIndex=0;
	private Space[][] board;
	int numSpaces=0;
	boolean win=false;
	//Note to Annika: null pointer exception because array gets set to null here instead of Space objects 
	
	//constructor
	public User (String n) {
//		board = super.getBoard();
		name = n;
	}
	
	//return board
	public Space[][] getBoard() {
		return board;
	}
	
	//play turns
	public void turn() {
		int moveNum = (int)(Math.random()*6) + 1;
		System.out.println("Dice rolled: " + moveNum);
		
		boolean isEven = this.isEven(rowIndex);
		
		/*moves user to the left, right, up, or down depending on
		if user is in even row, or at end of row*/
		if (!isEven) {
			if (moveNum + colIndex > 9) {
				rowIndex = rowIndex-1;
				colIndex = 9;
			}else {
				colIndex = colIndex + moveNum;
			}
			
		}else {
			if (colIndex - moveNum < 0) {
				rowIndex = rowIndex-1;
				colIndex = 0;
			}else {
				colIndex = colIndex - moveNum;
			}
		}
		
		
		//test for chutes and ladders and winner
		if (colIndex != 0 && rowIndex !=0) {
			//Note: tried to change this if statement to use getValue method 
//			if (board[rowIndex][colIndex].isChute()) {
//				//go back
//				this.chutes();
//			
//			}else if (board[rowIndex][colIndex].isLadder()) {
//				//go forward
//				this.ladders();
//			}
			
			if (super.getValue(rowIndex, colIndex).isChute()) {
				//go back
				this.chutes();
			
			}else if (super.getValue(rowIndex, colIndex).isLadder()) {
				//go forward
				this.ladders();
			}
			
			System.out.println(name + " is now at " + rowIndex + " " + colIndex);
		}else {
			System.out.println(name + " has won.");
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
		System.out.println("Oh no, " + name + " hit a chute. They went " + numSpaces + " back. ");
	}
	
	//changes rowIndex and colIndex if chute is hit
	public void ladders() {
		if (rowIndex>=4) {
			rowIndex = rowIndex - 4;
			numSpaces=4;
		}else if (rowIndex!=0) {
			rowIndex = rowIndex - 1;
			numSpaces=1;
		}
		System.out.println("Yay, " + name + " hit a chute. They went " + numSpaces + " forward. ");
	}
	
	//return row
	public int getRowIndex() {
		return rowIndex;
	}
	
	//return column
	public int getColumnIndex() {
		return colIndex;
	}
	
	public boolean getWin() {
		return win;
	}
}
