import java.lang.Math.*;
class Board {
    //Creates array of spaces to move on
    public Space[][] board = new Space[10][10]; 
    
    //sets all spaces to normal
    void origBoard() {
        for (int a = 0; a < board.length; a++) {
            for (int b = 0; b < board[a].length; b++) {
//                Space normal = new Space(0);
//                board[a][b] = normal;
            	board[a][b] = new Space(0);
            }
        }
    }

    //Method to determine which player goes first
    int goesFirst () {
        int userTurn = (int)(Math.random() * 6) + 1;
        int compTurn = (int)(Math.random() * 6) + 1;
        
        System.out.println("You have rolled " + userTurn);
        System.out.println("Randy Melvin Bartholomew the Third rolled " + compTurn);
        
        //Rerolls if same number
        while(userTurn == compTurn) {
            System.out.println("It's a tie! Reroll time...");
            userTurn = (int)(Math.random() * 6) + 1;
            compTurn = (int)(Math.random() * 6) + 1;
            System.out.println("You have rolled " + userTurn);
            System.out.println("Randy Melvin Bartholomew the Third rolled " + compTurn);
        }
        //Annika changed this to return int so main knows who goes first
        if (userTurn > compTurn) {
            System.out.println("You get the first roll!");
            return 1;
        }
        else {
            System.out.println("Randy Melvin Bartholomew the Third goes first!");
            return 0;
        }
    }

    // 1 = ladder, 2 = chutes, anything else = normal
    void spaceSet() {
    	
        //Sets ladders
        for (int x = 0; x < 5; x++) {
            int xCoord = (int)(Math.random() * 10);
            int yCoord = (int)(Math.random() * 10);
//            Space ladder = new Space(1);
            //Annika added this to avoid ladders in top row
            if (xCoord !=0) {
            	board[xCoord][yCoord] = new Space(1);
            }
        }
        int y = 0;
        while (y < 5) {
            int xCoord = (int)(Math.random() * 10);
            int yCoord = (int)(Math.random() * 10);
            if (board[xCoord][yCoord].isLadder()) {
                y = y;
            }
            else {
            	//Annika added this to avoid chutes in last row
            	if (xCoord!=9) {
//            		Space chute = new Space(2);
            		board[xCoord][yCoord] = new Space(2);
            	}
                y++;
            }
        }
    }
    
    //Annika made method to test if board is correct by printing board 
    public void testPrints() {
        //Note: I just made these little astricts as placeholders
        for (int a = 0; a < 10; a++) {
            for (int b = 0; b < 10; b++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        //testing for chutes and ladder spaces
        for (int i=0; i<board.length; i++) {
        	
        	for (int j=0; j<board.length; j++) {
        		
        		if (board[i][j].isChute() == true) {
        			System.out.print("C ");
        		}else if (board[i][j].isLadder() == true) {
        			System.out.print("L ");
        		}else {
        			System.out.print("* ");
        		}
        	}
        	System.out.println();
        }
    }

    //Returns board array
    public Space[][] getBoard() {
        return board;
    }
    
    /*Note: tried to add this to avoid null pointer exception*/
    //returns Space at give indexes
//    public Space getValue(int row, int col) {
//    	return board[row][col];
//    }
    
    public int getValue(int row, int col) {
    	if (board[row][col].isChute()) {
    		return 2;
    	}else if (board[row][col].isLadder()) {
    		return 1;
    	}else {
    		return 0;
    	}
    }
}
