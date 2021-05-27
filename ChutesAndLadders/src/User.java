
public class User extends Board implements Player {
	
	//instance variables
	private String name;
	private int rowIndex=9;
	private int colIndex=0;
	private int[][] board;
	
	//constructor
	public User (String n) {
//		board = super.getBoard();
		name = n;
	}
	
	//play turns
	public void turn() {
		int moveNum = (int)(Math.random()*5) + 1;
		boolean isEven = this.isEven();
		int numSpaces;
		
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
//			if (board[rowIndex][colIndex].isChute()) {
				//go back
				if (rowIndex<=4) {
					rowIndex = rowIndex + 4;
					numSpaces=4;
				}else if (rowIndex!=9) {
					rowIndex = rowIndex + 1;
					numSpaces=1;
				}
				//left off: need to do print for going back, maybe do the chutes and ladders in another method'
				
			
//			}else if (board[rowIndex][colIndex].isLadder()) {
//				//go forward
//			}
			
		}else {
			System.out.println(name + " has won.");
		}
		
	}
	
	//returns whether or not player is in even row 
	public boolean isEven() {
		if (rowIndex%2 == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	//return row
	public int getRowIndex() {
		return rowIndex;
	}
	
	//return column
	public int getColumnIndex() {
		return colIndex;
	}
}
