package kkkkkkkk;

import java.util.ArrayList;

public class Cell {
	
	int x;
	int y;
	int KING = 1;
	int QUEEN = 2;
	int ROOK = 3;
	int BISHOP = 4;
	int KNIGHT = 5;
	int PAWN = 6;
	int BKING = -1;
	int BQUEEN = -2;
	int BROOK = -3;
	int BBISHOP = -4;
	int BKNIGHT = -5;
	int BPAWN = -6;
	int[][] a;
	
	
	
	
	public int[][] newCell(){
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(i == 0 && j == 0) {
					a[i][j] = -3;
				}
				else if(i == 0 && j == 7 ) {
					a[i][j] = -3;
				}else if(i == 7 && j == 0) {
					a[i][j] = 3;
				}else if(i == 7 && j == 7) {
					a[i][j] = 3;
				}else if(i == 0 && j == 1) {
					a[i][j] = -5;
				}else if(i == 0 && j == 6) {
					a[i][j] = -5;
				}else if(i == 7 && j == 1) {
					a[i][j] = 5;
				}else if(i == 7 && j == 6) {
					a[i][j] = 5;
				}else if(i == 0 && j == 2) {
					a[i][j] = -4;
				}else if(i == 0 && j == 5) {
					a[i][j] = -4;
				}else if(i == 7 && j == 2) {
					a[i][j] = 4;
				}else if(i == 7 && j == 5) {
					a[i][j] = 4;
				}else if(i == 0 && j == 3) {
					a[i][j] = -2;
				}else if(i == 0 && j == 4) {
					a[i][j] = -1;
				}else if(i == 7 && j == 3) {
					a[i][j] = 2;
				}else if(i == 7 && j == 4) {
					a[i][j] = 1;
				}else if(i == 1 && j == 0) {
					a[i][j] = -6;
					a[i][j + 1] = -6;
					a[i][j + 2] = -6;
					a[i][j + 3] = -6;
					a[i][j + 4] = -6;
					a[i][j + 5] = -6;
					a[i][j + 6] = -6;
					a[i][j + 7] = -6;
				}
				
				else if(i == 6 && j == 0) {
					a[i][j] = 6;
					a[i][j + 1] = 6;
					a[i][j + 2] = 6;
					a[i][j + 3] = 6;
					a[i][j + 4] = 6;
					a[i][j + 5] = 6;
					a[i][j + 6] = 6;
					a[i][j + 7] = 6;
				}
			}
		}
		
		return a;
	}
}


