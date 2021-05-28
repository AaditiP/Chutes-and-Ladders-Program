
public class Board {
	import java.lang.Math.*;
	class Board {
	    Space spaces = new Space();

	    //Creates array of spaces to move on
	    private spaces[][] board = new spaces[10][10]; 

	    //Method to determine which player goes first
	    void goesFirst () {
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
		if (userTurn > compTurn) {
		    System.out.println("You get the first roll!");
		}
		else {
		    System.out.println("Randy Melvin Bartholomew the Third goes first!");
		}
	    }

	    /* void spaceSet() {

		for (int x = 0; x < )
	    }
	    */

	    //Returns board array
	    public int[][] getBoard() {
		return board;
	    }
	}
}
