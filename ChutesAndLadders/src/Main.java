import javax.swing.*;
import java.util.Scanner;

class Main{
	public static void main(String args[]){
		Board b = new Board();
		Scanner scn = new Scanner(System.in);
		String name;
		int goesFirst, rIndexUse, cIndexUse, rIndexComp, cIndexComp, type;
    int compOrUser = 1; //1 = user, 2 = computer

        //user interface
        System.out.println("Hello and welcome to Chutes and Ladders. "
        		+ "\nYou will be playing against the computer, named Randy Melvin Bartholomew the Third. "
        		+ "\n*Insert rules here* ");
        //TODO: add rules
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
        b.testPrints(9, 0, compOrUser);
        
        compOrUser = 2;
        b.testPrints(9, 0, compOrUser);
        
        //play turns 
        int k=goesFirst;
//        use.setBoard();
        
        //TODO: maybe use rIndex and cIndex !=0  in while loop 
//        (use.getRowIndex()!=0 && use.getColumnIndex()!=0) || (comp.getRowIndex()!=0 && comp.getColumnIndex()!=0)
        
        while (use.getWin()==false && comp.getWin()==false){
        	
        	//computer goes 
        	if (k%2==0) {
        		comp.turn();
//        		System.out.println(comp.getName() + " is at " + comp.getRowIndex() + " " + comp.getColumnIndex());
        		
        		rIndexComp = comp.getRowIndex();
        		cIndexComp = comp.getColumnIndex();
        		
        	
        		
        		if ((rIndexComp==0 && cIndexComp==0) || rIndexComp<0) {
        			continue;
        			//TODO: check if won
        		}else {
              compOrUser = 2;
        			System.out.println(comp.getName() + " is at " + comp.getRowIndex() + " " + comp.getColumnIndex());
        			type = b.spaceType(rIndexComp, cIndexComp);
        			comp.playChutesOrLadder(type);
              b.testPrints(rIndexComp, cIndexComp, compOrUser);
        		}
        		
//        		System.out.println(comp.getName() + " is at " + comp.getRowIndex() + " " + comp.getColumnIndex());
        		
        	//user goes	
        	}else {
        		use.turn();
//        		System.out.println(use.getName() + " is at " + use.getRowIndex() + " " + use.getColumnIndex());
        		
        		rIndexUse = use.getRowIndex();
        		cIndexUse = use.getColumnIndex();
        		
        		if ((rIndexUse==0 && cIndexUse==0) || rIndexUse<0){
        			continue;
        			//TODO: check if won
        		}else {
              compOrUser = 1;
        			System.out.println(use.getName() + " is at " + use.getRowIndex() + " " + use.getColumnIndex());
        			type = b.spaceType(rIndexUse, cIndexUse);
        			use.playChutesOrLadder(type);
              b.testPrints(rIndexUse, cIndexUse, compOrUser);
        		}
        		
//        		System.out.println(use.getName() + " is at " + use.getRowIndex() + " " + use.getColumnIndex());
        	}
        	
        	k++;
        }
        
       if (use.getWin()==true) {
    	   System.out.println("Congratulations, " + use.getName() + " has won!");
       }else {
    	   System.out.println("Oh no, " + comp.getName() + " has won. Better luck next time.");
       }
       
    }
}
