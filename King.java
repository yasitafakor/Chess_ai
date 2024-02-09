package kkkkkkkk;

public class King extends Piece{


	King(){
		id = 1;
	}

	public boolean canMove(int x1, int y1, int x2, int y2) {
		if(Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2)) == 1 ||
				Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2)) == Math.sqrt(2)	) {
			return true;
		}else {
			return false;
		}
	}
	
}
