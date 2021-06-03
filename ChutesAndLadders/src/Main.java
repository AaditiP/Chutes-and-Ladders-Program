import javax.swing.*;
import java.util.Scanner;

class Main{
	public static void main(String args[]){
		Board board = new Board();
		Scanner scn = new Scanner(System.in);
		String name;
		int goesFirst;

        //user interface
        System.out.println("Hello and welcome to Chutes and Ladders. "
        		+ "\nYou will be playing against the computer, named Randy Melvin Bartholomew the Third. "
        		+ "\n*Insert rules here* ");
        System.out.println();
        
        //set board
        board.origBoard();
        board.spaceSet();
        
        //set user and computer
        Computer comp = new Computer();
        System.out.println("Please enter your name: ");
        name = scn.nextLine();
        
        User use = new User(name);
        System.out.println();
        
        
        //goes first
        System.out.println("Now let's see who goes first. A dice will be rollled for you and the computer.");
        
        goesFirst = board.goesFirst();
        System.out.println();
        
        
        //test if board is what we expect
        board.testPrints();
        
        //play turns 
        int k=goesFirst;
//        use.setBoard();
        
        while (use.getWin()==false && comp.getWin()==false) {
        	
        	//computer goes 
        	if (k%2==0) {
        		comp.turn();
        		
        	//user goes	
        	}else {
        		use.turn();
        	}
        	
        	k++;
        }
        
        
    }
}
