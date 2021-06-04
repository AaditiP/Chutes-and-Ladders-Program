import javax.swing.*;
import java.util.Scanner;

class Main{
	public static void main(String args[]){
		Board b = new Board();
		Scanner scn = new Scanner(System.in);
		String name;
		int goesFirst, rIndex, cIndex, type;

        //user interface
        System.out.println("Hello and welcome to Chutes and Ladders. "
        		+ "\nYou will be playing against the computer, named Randy Melvin Bartholomew the Third. "
        		+ "\n*Insert rules here* ");
        System.out.println();
        
        //set board
        b.origBoard();
        b.spaceSet();
        
        //set user and computer
        Computer comp = new Computer();
        System.out.println("Please enter your name: ");
        name = scn.nextLine();
        
        User use = new User(name);
        System.out.println();
        
        
        //goes first
        System.out.println("Now let's see who goes first. A dice will be rollled for you and the computer.");
        
        goesFirst = b.goesFirst();
        System.out.println();
        
        
        //test if board is what we expect
        b.testPrints();
        
        //play turns 
        int k=goesFirst;
//        use.setBoard();
        
        //Note for future: maybe use rIndex and cIndex !=0  in while loop 
        while (use.getWin()==false && comp.getWin()==false) {
        	
        	//computer goes 
        	if (k%2==0) {
        		comp.turn();
        		
        	//user goes	
        	}else {
        		use.turn();
        		rIndex = use.getRowIndex();
        		cIndex = use.getColumnIndex();
        		
        		if (rIndex!=0 && cIndex!=0) {
        			type = b.spaceType(rIndex, cIndex);
        			//TODO: check if won
        		}else {
        			System.out.println("You won!");
        			break;
        		}
        	}
        	
        	k++;
        }
        
        
    }
}
