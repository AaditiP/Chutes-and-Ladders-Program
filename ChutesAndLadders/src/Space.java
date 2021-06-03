public class Space {
	//instance variables
	public boolean isChute, isLadder, isNormal;
	public int type;
	
	//constructors
	
	public Space(int type) {
		if (type==1) {
			isNormal=false;
			isChute=false;
			isLadder=true;
			type=1;
		}else if (type==2) {
			isNormal=false;
			isChute=true;
			isLadder=false;
			type=2;
		}else {
			isNormal=true;
			isChute=false;
			isLadder=false;
			type=0;
		}
	}
	
	//return true if space is a chute
	public boolean isChute() {
		if (isChute) {
			return true;
		}else {
			return false;
		}
	}
	
	//return true if space is a chute
	public boolean isLadder() {
		if (isLadder) {
			return true;
		}else {
			return false;
		}
    }
    
   public int getType() {
	   return type;
   }
	
}
