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
        		+ "\nYou will be playing against the computer, named Randy Melvin Bartholomew III.");
        System.out.println();
        
        System.out.println("Rules: "
        		+ "\n1. There is a 10x10 square game board and 2 players. Each player starts at index [9][0]. "
        		+ "\n2. Play will go across the row to the right, up to the next column, across the row to left, and repeats. "
        		+ "\n   The goal is to reach index [0][0] or go past it. "
        		+ "\n3. Each player rolls a dice which determines how many spaces forward they will move. "
        		+ "\n4. If a player lands on a square with a ladder, they move up to the specified square on the board. "
        		+ "\n   If a player lands on a square with a chute, they move down to the specified square on the board. "
        		+ "\n   If after moving up/down a player lands on another chute or ladder, they do not move up or down. "
        		+ "\n5. Play continues until one player reaches the uppermost right or left square."
        		+ "\n6. Computer is represented by '#' and you are represented by '%'.");
       
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
        System.out.println("Now let's see who goes first. A dice will be rolled for you and the computer.");
        
        goesFirst = b.goesFirst();
        System.out.println();
        
        
        System.out.println("The board looks like this, the @ represents where both players are currently: ");
        b.testPrints(0, 9, 0);	
        
        //play turns 
        int k=goesFirst;

        
        while (use.getWin()==false && comp.getWin()==false){
        	
        
        	//computer goes 
        	if (k%2==0) {
        		comp.turn();
        		
        		rIndexComp = comp.getRowIndex();
        		cIndexComp = comp.getColumnIndex();
        		

        		
        		if ((rIndexComp==0 && cIndexComp==0) || rIndexComp<0) {
        			continue;
        		}else {
        			compOrUser = 2;
        			System.out.println(comp.getName() + " is at " + comp.getRowIndex() + " " + comp.getColumnIndex());
        			type = b.spaceType(rIndexComp, cIndexComp);
        			comp.playChutesOrLadder(type);
        		}
        		b.testPrints(comp.getRowIndex(), comp.getColumnIndex(), compOrUser);
        		
        	//user turn	
        	}else { 
        		//asks user to roll dice
        		System.out.println();
	            System.out.print("Solve a simple arithmetic problem to roll the dice: ");
	
	            //user solves arithmetic problem to roll dice
	            int oper = (int)(Math.random() * 4) + 1;
	            int firstNum, secNum, ans;
	            firstNum = (int)(Math.random() * 1000) + 1;
	            secNum = (int)(Math.random() * 1000) + 1;
	
	            if (oper == 1) {
	              ans = firstNum + secNum; 
	              System.out.print("What is " + firstNum + " + " + secNum + "? ");
	            }
	            else if (oper == 2) {
	              ans = firstNum - secNum; 
	              System.out.print("What is " + firstNum + " - " + secNum + "? ");
	            }
	            else if (oper == 3) {
	              ans = firstNum * secNum; 
	              System.out.print("What is " + firstNum + " * " + secNum + "? " );
	            }
	            else {
	              ans = firstNum / secNum;
	              System.out.print("What is " + firstNum + " / " + secNum + " rounded down to the nearest integer? ");
	            }
	
	            //dice is rolled if answer is correct
	            int rollDie = scn.nextInt();
	            while (rollDie != ans) {
	              System.out.print("That's incorrect, please try again: ");
	              rollDie = scn.nextInt();
	            }
        		System.out.println("Correct, nice job!");
        		
        		//user rolls
        		use.turn();
        		
        		rIndexUse = use.getRowIndex();
        		cIndexUse = use.getColumnIndex();
        		
        		if ((rIndexUse==0 && cIndexUse==0) || rIndexUse<0){
        			continue;
        		}else {
        			compOrUser = 1;
        			System.out.println(use.getName() + " is at " + use.getRowIndex() + " " + use.getColumnIndex());
        			type = b.spaceType(rIndexUse, cIndexUse);
        			use.playChutesOrLadder(type);
        		
        		}
    			b.testPrints(use.getRowIndex(), use.getColumnIndex(), compOrUser);
    			
        	}//end of else
        	
        	k++;
        }
        
       if (use.getWin()==true) {
    	   System.out.println("Congratulations, " + use.getName() + " has won!");
       }else {
    	   System.out.println("Oh no, " + comp.getName() + " has won. Better luck next time.");
       }
       
       scn.close();
    }
}
