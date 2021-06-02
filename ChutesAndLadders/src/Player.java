
public interface Player {
	
	//moves player
	public void turn();
	
	//returns indexes of Board array that player is now at
	public int getRowIndex();
	public int getColumnIndex();
	
	//return true if even number 
	public boolean isEven(int rI);
}
