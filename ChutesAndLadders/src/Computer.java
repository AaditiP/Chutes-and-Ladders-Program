
public class Computer extends User{
	
	//instance variables
	private String name="Randy Melvin Bartholomew III";
	
	//constructor
	public Computer() {
		super("Randy Melvin Bartholomew III");
	}
		

	//play turns
	public void turn() {
		super.turn();
	}
		
	//return rowIndex	
	public int getRowIndex() {
		return super.getRowIndex();
	}
		
	//return colIndex	
	public int getColumnIndex() {
		return super.getColumnIndex();
	}
	
	//return name
	public String getName() {
		return name;
	}
	
	//return whether or not Computer has won
	public boolean getWin() {
		if ((super.getRowIndex()==0 && super.getColumnIndex()==0)|| super.getRowIndex()<0) {
			return true;
		}else {
			return false;
		}
	}

}
