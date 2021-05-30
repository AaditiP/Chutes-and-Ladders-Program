import java.lang.Math.*;
class Board {
    //Creates array of spaces to move on
    private Space[][] board = new Space[10][10]; 
    
    void origBoard() {
        for (int a = 0; a < board.length; a++) {
            for (int b = 0; b < board[a].length; b++) {
                Space normal = new Space(0);
                board[a][b] = normal;
            }
        }
    }

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

    // 1 = ladder, 2 = chutes, anything else = normal
    void spaceSet() {
        //Sets ladders
        for (int x = 0; x < 5; x++) {
            int xCoord = (int)(Math.random() * 10);
            int yCoord = (int)(Math.random() * 10);
            Space ladder = new Space(1);
            board[xCoord][yCoord] = ladder;
            
        }
        int y = 0;
        while (y < 5) {
            int xCoord = (int)(Math.random() * 10);
            int yCoord = (int)(Math.random() * 10);
            if (board[xCoord][yCoord].isLadder) {
                y = y;
            }
            else {
                Space chute = new Space(2);
                board[xCoord][yCoord] = chute;
                y++;
            }
        }

        for (int a = 0; a < 9; a++) {
            for (int b = 0; b < 9; b++) {
                System.out.print(board[a][b]);
            }
        }
    }

    //Returns board array
    public Space[][] getBoard() {
        return board;
    }
}
