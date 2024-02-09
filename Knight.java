package kkkkkkkk;

public class Knight extends Piece{

	Knight(){
		id = 5;
	}
	
	public boolean canMove(int x1, int y1, int x2, int y2) {
		
		if(Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y1-y2),2)) == Math.sqrt(5) ) {
			return true;
		}else {
			return false;
		}
		
	}
}
