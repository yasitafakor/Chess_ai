package kkkkkkkk;

public class Pawn extends Piece{

	Pawn(){
		id = 6;
	}
	
	public boolean canMove(int x1,int y1, int x2,int y2) {
	
		if((y1 == y2) && ((x1 - x2) == 1)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean BcanMove(int x1,int y1, int x2,int y2) {
		
		if((y1 == y2) && ((x2 - x1) == 1)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean clearW(int x1,int y1, int x2,int y2) {
		
		if( ( Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2))) == Math.sqrt(2) && ((x1 - x2) == 1)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean clearB(int x1,int y1, int x2,int y2) {
		
		if( ( Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2))) == Math.sqrt(2) && ((x2 - x1) == 1)) {
			return true;
		}else {
			return false;
		}
	}
	
}
