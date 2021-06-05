
public class User  implements Player {
	
	//instance variables
	private String name;
	private int rowIndex=9;
	private int colIndex=0;
//	private Space[][] boardArr;
	int numSpaces=0;
	boolean win=false;
	Board b = new Board();
	//Note to Annika: null pointer exception because array gets set to null here instead of Space objects 
	
	//constructor
	public User (String n) {
//		board = super.getBoard();
//		this.setBoard();
		name = n;
	}
	
//	//return board
//	public Space[][] getBoard() {
//		return board;
//	}
	
//	public void setBoard() {
//		
//		for (int i=0; i<10; i++) {
//			
//			for (int j=0; i<10; j++) {
////				Space spa = new Space(0);
//				if(super.getValue(i, j)==2) {
//					boardArr[i][j] = new Space(2);
//				}else if(super.getValue(i, j)==1) {
//					boardArr[i][j] = new Space(1);
//				}else {
//					boardArr[i][j] = new Space(0);
//				}
//			}
//			
//		}
//	}
	
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
				//TODO: do ^this to else 
//				colIndex = (9-colIndex) - (moveNum - 1);
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
		
		
		//test for chutes and ladders and winner
//		if (colIndex != 0 && rowIndex !=0) {
//			//Note: tried to change this if statement to use getValue method 
////			if (board[rowIndex][colIndex].isChute()) {
////				//go back
////				this.chutes();
////			
////			}else if (board[rowIndex][colIndex].isLadder()) {
////				//go forward
////				this.ladders();
////			}
//			
//			if (b.getValue(rowIndex, colIndex)==2) {
//				//go back
//				this.chutes();
//			
//			}else if (b.getValue(rowIndex, colIndex)==1) {
//				//go forward
//				this.ladders();
//			}
//			
//			System.out.println(name + " is now at " + rowIndex + " " + colIndex);
//		}else {
//			System.out.println(name + " has won.");
//			win=true;
//		}
		
	}
	
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
	
	//changes rowIndex and colIndex if chute is hit
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
	
	public boolean getWin() {
		return win;
	}
	
	
	public String getName() {
		return name;
	}
	
}
