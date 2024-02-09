package kkkkkkkk;

public class Bishop extends Piece {

	Bishop(){
		id = 4;
	}
	
	public boolean canMove(int x1, int y1, int x2, int y2, int[][] b) {
		
		int flag = 1;
		int flag2 = 1;
		
		if(x1 == x2 || y1 == y2) {
			flag2 = 0;
		}
		
		if(x1 > x2 && y1 < y2) {
			for(int i = x1 - 1; i > x2; i--) {
				for(int j = y1 + 1; j < y2; j++) {
					if(b[i][j] != 0) {
						flag = 0;
					}
				}
			}
		}else if(x1 < x2 && y1 > y2) {
			for(int i = x1 + 1; i < x2; i++) {
				for(int j = y1 - 1; j > y2; j-- ) {
					if(b[i][j] != 0) {
						flag = 0;
					}
				}
			}
		}else if(x1 > x2 && y1 > y2) {
			for(int i = x1 - 1; i > x2; i--) {
				for(int j = y1-1; j > y2; j--) {
					if(b[i][j] != 0) {
						flag = 0;
					}
				}
			}
		}else if(x1 < x2 && y1 < y2) {
			for(int i = x1 + 1; i < x2;i++) {
				for(int j = y1 + 1 ; j < y2; j ++) {
					if(b[i][j] != 0) {
						flag = 0;
					}
				}
			}
		}
		
		if(flag == 1 && flag2 == 1) {
			return true;
		}else {
			return false;
		}
		
		
		
		
	}
	
	
	
	
	
}
