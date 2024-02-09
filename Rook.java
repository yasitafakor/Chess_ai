package kkkkkkkk;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Rook extends Piece{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean canMove(int x1,int y1,int x2, int y2, int[][] b) {
		
		int flag = 1;
		
		if(x1 != x2 && y1 != y2) {
			
			return false;
		
		
		}else {
			if(x1 == x2 && y1 != y2 ) {
				if(y2> y1) {
					for(int i = y1 + 1; i < y2; i++) {
						if(b[x1][i] != 0) {
							
							flag = 0;
						}
					}
				}else if(y1 > y2) {
					for(int i = y2 + 1; i < y1; i++) {
						if(b[x1][i] != 0) {
							flag = 0;
							
						}
					}
				}
				
			}else {
				
				
					if(x2> x1) {
						for(int i = x1 + 1; i < x2; i++) {
							if(b[i][y1] != 0) {
								flag = 0;
							}
						}
					}else if(x1 > x2) {
						for(int i = x2 + 1; i < x1; i++) {
							if(b[i][y1] != 0) {
								flag = 0;
							}
						}
					}
				}
				
				if(flag != 0) {
					return true;
				}else {
					return false;
				}
			}
		}
	
		
	}

