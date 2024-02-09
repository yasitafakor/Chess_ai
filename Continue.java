package kkkkkkkk;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
 
public class Continue extends JFrame implements MouseListener, MouseMotionListener{

	
	
  JLayeredPane Pane;
  JPanel Board;
  JLabel Piece;
  JLabel n;
  int x;
  int y;
  int round;

  
  Cell cell;
  int[][] a;
  Point parentLocation ;
  Dimension Size;
  Dimension board ;
 
public Continue(){
	  
	
	 a = new int[8][8];
	  
	  cell = new Cell();
	  
	  Scanner scan;
		try {
			scan = new Scanner(new File("src/test2.txt"));
			
				  for(int i = 0; i < 8 ; i++) {
					  for(int j = 0; j < 8; j++) {
						a[i][j] = scan.nextInt();  
					  }
				  }
			  
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	  cell.a = a;

	  Size = new Dimension(800, 800);
	  board = new Dimension(800, 800);
	  Pane = new JLayeredPane();
	  getContentPane().add(Pane);
	  Pane.setPreferredSize(board);
	  
	  
	  Board = new JPanel();
	  Pane.add(Board, JLayeredPane.DEFAULT_LAYER);
	  Board.setLayout( new GridLayout(8, 8) );
	  Board.setPreferredSize( Size );
	  Board.setBounds(0, 0, Size.width, Size.height);

	  for (int i = 0; i < 64; i++) {
		  JPanel p = new JPanel( new BorderLayout() );
		  Board.add( p );
		  
		  
  		  Color n = new Color(116, 192, 244);
  		  Color m = new Color(22, 36, 118);
  		  

		  int row = (i / 8) % 2;
		  if (row == 0)
			  p.setBackground( i % 2 == 0 ? m : n );
		  else
			  p.setBackground( i % 2 == 0 ? n : m );
	  	}

	 
	  
	  for(int i = 0; i < 8; i++) {
		  for(int j = 0; j < 8; j++) {
			  
			  
			  if(cell.a[i][j] == 3) {//w_rook
				  JLabel piece = new JLabel( new ImageIcon("w_rook.png") );
			  	  JPanel panel = (JPanel)Board.getComponent((i*8)+j);
			  	  panel.add(piece);
			  	  
			  	  
			  	  
			  }else if(cell.a[i][j] == 5) {
				  JLabel piece_1 = new JLabel(new ImageIcon("w_knight.png"));
			  	  JPanel panel_1 = (JPanel)Board.getComponent((i*8)+j);
			  	  panel_1.add(piece_1);
			  	  
			  	  
			  }else if(cell.a[i][j] == 4) {
				  
			  	  JLabel piece_2 = new JLabel(new ImageIcon("w_bishop.png"));
			  	  JPanel panel_2 = (JPanel)Board.getComponent((i*8)+j);
			  	  panel_2.add(piece_2);
				  
			  	  
			  }else if(cell.a[i][j] == 1) {

			  	  JLabel piece_3 = new JLabel(new ImageIcon("w_king.png"));
			  	  JPanel panel_3 = (JPanel)Board.getComponent((i*8)+j);
			  	  panel_3.add(piece_3);
			  	  
			  	  
			  }else if(cell.a[i][j] == 2) {

			  	  JLabel piece_4 = new JLabel(new ImageIcon("w_queen.png"));
			  	  JPanel panel_4 = (JPanel)Board.getComponent((i*8)+j);
			  	  panel_4.add(piece_4);
			  
			  	  
			  }else if(cell.a[i][j] == 6) {
				  JLabel piece_8 = new JLabel(new ImageIcon("w_pawn.png"));
			  	  JPanel panel_8 = (JPanel)Board.getComponent((i*8)+j);
			  	  panel_8.add(piece_8);
			  	  
			  	  
			  }else if(cell.a[i][j] == -3) {

				  
			  	  JLabel piece_16 = new JLabel(new ImageIcon("b_rook.png"));
			  	  JPanel panel_16 = (JPanel)Board.getComponent((i*8)+j);
			  	  panel_16.add(piece_16);
			  
			  	  
			  	  
			  }else if(cell.a[i][j] == -5) {

			  	  JLabel piece_17 = new JLabel(new ImageIcon("b_knight.png"));
			  	  JPanel panel_17 = (JPanel)Board.getComponent((i*8)+j);
			  	  panel_17.add(piece_17);
			  
			  	  
			  }else if(cell.a[i][j] == -4) {
				  

			  	  JLabel piece_18 = new JLabel(new ImageIcon("b_bishop.png"));
			  	  JPanel panel_18 = (JPanel)Board.getComponent((i*8)+j);
			  	  panel_18.add(piece_18);
			  }else if(cell.a[i][j] == -2) {

			  	  JLabel piece_19 = new JLabel(new ImageIcon("b_queen.png"));
			  	  JPanel panel_19 = (JPanel)Board.getComponent((i*8)+j);
			  	  panel_19.add(piece_19);
			  
			  }else if(cell.a[i][j] == -1) {

			  	  JLabel piece_20 = new JLabel(new ImageIcon("b_king.png"));
			  	  JPanel panel_20 = (JPanel)Board.getComponent((i*8)+j);
			  	  panel_20.add(piece_20);
			  }else if(cell.a[i][j] == -6) {
				  JLabel piece_24 = new JLabel(new ImageIcon("b_pawn.png"));
			  	  JPanel panel_24 = (JPanel)Board.getComponent((i*8)+j);
			  	  panel_24.add(piece_24);
			  }
		  }
	  }
	  
  	 
	  Pane.addMouseListener(this);
	  Pane.addMouseMotionListener(this);
  
  }
 
 
  public void mousePressed(MouseEvent e){
	  Piece = null;
	  Component c =  Board.findComponentAt(e.getX(), e.getY());
 
	  if (c instanceof JPanel) 
		  return;
 
	  parentLocation = c.getParent().getLocation();
  
	  
  
	  x = parentLocation.x - e.getX();
	  y = parentLocation.y - e.getY();
  
	  Piece = (JLabel)c;
	  
	  Piece.setLocation(e.getX() + x, e.getY() + y);
	  Piece.setSize(Piece.getWidth(), Piece.getHeight());
	  Pane.add(Piece, JLayeredPane.DRAG_LAYER);
  
  
  }
 
  //Move the chess piece around
  
  public void mouseDragged(MouseEvent me) {
	  if (Piece == null)
		  return;
  
  
	  Piece.setLocation(me.getX() + x, me.getY() + y);
 }
 
  //Drop the chess piece back onto the chess board
 
public void mouseReleased(MouseEvent e) {
	  if(Piece == null) {
		  return;
	  }
 
	 
	  
	  Piece.setVisible(false);
  
	  Component c =  Board.findComponentAt(e.getX(), e.getY());
	  Component p =  Board.findComponentAt(parentLocation.x, parentLocation.y);
	  
	  
	  if (c instanceof JLabel){
		 
		  Container p2 = (Container)p;
		  Container parent = c.getParent();
		  
		  
		  if(round == 1 && cell.a[parentLocation.y/100][parentLocation.x/100] < 0) {
			  p2.add(Piece);
			  Piece.setVisible(true);
		  }else if(round == 0 && cell.a[parentLocation.y/100][parentLocation.x/100] > 0) {
			  p2.add(Piece);
			  Piece.setVisible(true);
		  }
		 
		  else if(cell.a[parentLocation.y/100][parentLocation.x/100] > 0 && cell.a[parent.getY()/100][parent.getX()/100] > 0) {
			  p2.add(Piece);
			  Piece.setVisible(true);
			  
		  }else if(cell.a[parentLocation.y/100][parentLocation.x/100] < 0 && cell.a[parent.getY()/100][parent.getX()/100] < 0) {
			  p2.add(Piece);
			  Piece.setVisible(true);
			  
		  }else if(cell.a[parentLocation.y/100][parentLocation.x/100] == 3 || cell.a[parentLocation.y/100][parentLocation.x/100] == -3) {
			  
			  	int flag = 1;
			  	
			  		Rook rook = new Rook();
					  
					  if(rook.canMove(parentLocation.y/100, parentLocation.x/100, parent.getY()/100, parent.getX()/100, cell.a)) {
						  parent.remove(0);
						  parent.add(Piece );
						  Piece.setVisible(true);
						  
						  if(cell.a[parent.getY()/100][parent.getX()/100] == 1 || cell.a[parent.getY()/100][parent.getX()/100] == -1 ) {

							  round = 1;
							  flag = 0;
							  
								  JFrame frame = new JFrame();
								  JPanel panel = new JPanel();
								  JLabel b = new JLabel("End of the match!");
								  JButton end = new JButton("Press for Close");
								  
								  
								  frame.setSize(800,800);
								  panel.setBackground(Color.black);
								  panel.setLayout(null);
								  panel.setOpaque(true);
								  
								  
								  b.setBackground(Color.black);
								  b.setBounds(100, 100, 400, 400);
								  end.setBounds(100,400,200,30);
								  end.setBackground(Color.pink);
								  end.setForeground(Color.black);
								  end.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {		
											System.exit(0);
										}
									});
								  b.setForeground(Color.pink);
								  
								  panel.add(end);
								  panel.add(b);
								  
								 
								  frame.add(panel);
								  frame.setVisible(true);
						  }
						  
						  if(cell.a[parentLocation.y/100][parentLocation.x/100] == 3 ) {
							  cell.a[parent.getY()/100][parent.getX()/100] = 3;
							  round = 0;
							 
							  
						  }else {
							  cell.a[parent.getY()/100][parent.getX()/100] = -3; 
							  round = 1;
							  
							 
						  }
						  cell.a[parentLocation.y/100][parentLocation.x/100] = 0;
						  
						  try {
							  if(flag == 0) {
								  a = new int[9][9];
								  
								  cell = new Cell();
								  cell.a = a;
								  a = cell.newCell();
								  
							  }
							  
								PrintStream out = new PrintStream(new File("src/test2.txt"));
								
								for(int i = 0; i < 8; i++) {
									for(int j = 0; j < 8; j++) {
										out.println(cell.a[i][j]);
									}
								}
								
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						  
						  
						  
					}else {
						p2.add(Piece);
						Piece.setVisible(true);
					}
			  	
			  
		  		
			  
			  
		  }else if(cell.a[parentLocation.y/100][parentLocation.x/100] == 5 || cell.a[parentLocation.y/100][parentLocation.x/100] == -5) {
				
			  		int flag = 1;
			  		Knight knight = new Knight();
					
					if(knight.canMove(parentLocation.y/100, parentLocation.x/100, parent.getY()/100, parent.getX()/100)) {
						parent.remove(0);
						parent.add(Piece );
						Piece.setVisible(true);
						
						if(cell.a[parent.getY()/100][parent.getX()/100] == 1 || cell.a[parent.getY()/100][parent.getX()/100] == -1 ) {

							  flag = 0;
							  round = 1;
							
							  JFrame frame = new JFrame();
							  JPanel panel = new JPanel();
							  JLabel b = new JLabel("End of the match!");
							  JButton end = new JButton("Press for Close");
							  
							  
							  frame.setSize(800,800);
							  panel.setBackground(Color.black);
							  panel.setLayout(null);
							  panel.setOpaque(true);
							  
							  
							  b.setBackground(Color.black);
							  b.setBounds(100, 100, 400, 400);
							  end.setBounds(100,400,200,30);
							  end.setBackground(Color.pink);
							  end.setForeground(Color.black);
							  end.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {		
										System.exit(0);
									}
								});
							  b.setForeground(Color.pink);
							  
							  panel.add(end);
							  panel.add(b);
							  
							 
							  frame.add(panel);
							  frame.setVisible(true);
					  }
						
						
						
						if(cell.a[parentLocation.y/100][parentLocation.x/100] == 5) {
							cell.a[parent.getY()/100][parent.getX()/100] = 5;
							round = 0;
						}else {
							cell.a[parent.getY()/100][parent.getX()/100] = -5;
							round = 1;
						}
						
						cell.a[parentLocation.y/100][parentLocation.x/100] = 0;
						
						try {
							
							 if(flag == 0) {
								 a = new int[9][9];
								  
								  cell = new Cell();
								  cell.a = a;
								  a = cell.newCell();
								  
							  }
							  
							PrintStream out = new PrintStream(new File("src/test2.txt"));
							
							for(int i = 0; i < 8; i++) {
								for(int j = 0; j < 8; j++) {
									out.println(cell.a[i][j]);
								}
							}
							
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}else {
						p2.add(Piece);
						Piece.setVisible(true);
					}
			  
			  
				
				
				
				
				//Bishop
				
			}else if(cell.a[parentLocation.y/100][parentLocation.x/100] == 4 || cell.a[parentLocation.y/100][parentLocation.x/100] == -4) {
				
					int flag = 1;
				
					Bishop bishop = new Bishop();
					
					if(bishop.canMove(parentLocation.y/100, parentLocation.x/100, parent.getY()/100, parent.getX()/100, cell.a)) {
						parent.remove(0);
						parent.add(Piece );
						Piece.setVisible(true);
						
						if(cell.a[parent.getY()/100][parent.getX()/100] == 1 || cell.a[parent.getY()/100][parent.getX()/100] == -1 ) {

							  round = 1;
							  flag = 0;
							  JFrame frame = new JFrame();
							  JPanel panel = new JPanel();
							  JLabel b = new JLabel("End of the match!");
							  JButton end = new JButton("Press for Close");
							  
							  
							  frame.setSize(800,800);
							  panel.setBackground(Color.black);
							  panel.setLayout(null);
							  panel.setOpaque(true);
							  
							  
							  b.setBackground(Color.black);
							  b.setBounds(100, 100, 400, 400);
							  end.setBounds(100,400,200,30);
							  end.setBackground(Color.pink);
							  end.setForeground(Color.black);
							  end.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {		
										System.exit(0);
									}
								});
							  b.setForeground(Color.pink);
							  
							  panel.add(end);
							  panel.add(b);
							  
							 
							  frame.add(panel);
							  frame.setVisible(true);
					  }
						
						if(cell.a[parentLocation.y/100][parentLocation.x/100] == 4) {
							cell.a[parent.getY()/100][parent.getX()/100] = 4; 
							round = 0;
						}else {
							cell.a[parent.getY()/100][parent.getX()/100] = -4; 
							round = 1;
						}
						cell.a[parentLocation.y/100][parentLocation.x/100] = 0;
						
						try {
							
							 if(flag == 0) {
								 a = new int[9][9];
								  
								  cell = new Cell();
								  cell.a = a;
								  a = cell.newCell();
								  
							  }
							  
							PrintStream out = new PrintStream(new File("src/test2.txt"));
							
							for(int i = 0; i < 8; i++) {
								for(int j = 0; j < 8; j++) {
									out.println(cell.a[i][j]);
								}
							}
							
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}else {
						p2.add(Piece);
						Piece.setVisible(true);
					}
					
				
				
				
				
				
				
				
				//Queen
				
			}
		  
			else if(cell.a[parentLocation.y/100][parentLocation.x/100] == 2 || cell.a[parentLocation.y/100][parentLocation.x/100] == -2) {
				
					int flag = 1;
					
					Bishop bishop = new Bishop();
					Rook rook = new Rook();
					
					if(bishop.canMove(parentLocation.y/100, parentLocation.x/100, parent.getY()/100, parent.getX()/100, cell.a) == true ||
						rook.canMove(parentLocation.y/100, parentLocation.x/100, parent.getY()/100, parent.getX()/100, cell.a) == true) {
						parent.remove(0);
						parent.add(Piece );
						Piece.setVisible(true);
						
						if(cell.a[parent.getY()/100][parent.getX()/100] == 1 || cell.a[parent.getY()/100][parent.getX()/100] == -1 ) {

							  round = 1;
							  flag = 0;
							  JFrame frame = new JFrame();
							  JPanel panel = new JPanel();
							  JLabel b = new JLabel("End of the match!");
							  JButton end = new JButton("Press for Close");
							  
							  
							  frame.setSize(800,800);
							  panel.setBackground(Color.black);
							  panel.setLayout(null);
							  panel.setOpaque(true);
							  
							  
							  b.setBackground(Color.black);
							  b.setBounds(100, 100, 400, 400);
							  end.setBounds(100,400,200,30);
							  end.setBackground(Color.pink);
							  end.setForeground(Color.black);
							  end.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {		
										System.exit(0);
									}
								});
							  b.setForeground(Color.pink);
							  
							  panel.add(end);
							  panel.add(b);
							  
							 
							  frame.add(panel);
							  frame.setVisible(true);
					  }
						
						if(cell.a[parentLocation.y/100][parentLocation.x/100] == 2) {
							cell.a[parent.getY()/100][parent.getX()/100] = 2; 
							round = 0;
						}else {
							cell.a[parent.getY()/100][parent.getX()/100] = -2; 
							round = 1;
						} 
						cell.a[parentLocation.y/100][parentLocation.x/100] = 0;
						
						try {
							
							 if(flag == 0) {
								 a = new int[9][9];
								  
								  cell = new Cell();
								  cell.a = a;
								  a = cell.newCell();
							  }
							  
							PrintStream out = new PrintStream(new File("src/test2.txt"));
							
							for(int i = 0; i < 8; i++) {
								for(int j = 0; j < 8; j++) {
									out.println(cell.a[i][j]);
								}
							}
							
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}else {
						p2.add(Piece);
						Piece.setVisible(true);
					}
					
				
				
				
				
				//King
				
			}else if(cell.a[parentLocation.y/100][parentLocation.x/100] == 1 || cell.a[parentLocation.y/100][parentLocation.x/100] == -1) {
				
				
					int flag = 1;
					King king = new King();
					
					if(king.canMove(parentLocation.y/100, parentLocation.x/100, parent.getY()/100, parent.getX()/100)) {
						parent.remove(0);
						parent.add(Piece );
						Piece.setVisible(true);
						
						if(cell.a[parent.getY()/100][parent.getX()/100] == 1 || cell.a[parent.getY()/100][parent.getX()/100] == -1 ) {

							
							  round = 1;
							  flag = 0;
							  JFrame frame = new JFrame();
							  JPanel panel = new JPanel();
							  JLabel b = new JLabel("End of the match!");
							  JButton end = new JButton("Press for Close");
							  
							  
							  frame.setSize(800,800);
							  panel.setBackground(Color.black);
							  panel.setLayout(null);
							  panel.setOpaque(true);
							  
							  
							  b.setBackground(Color.black);
							  b.setBounds(100, 100, 400, 400);
							  end.setBounds(100,400,200,30);
							  end.setBackground(Color.pink);
							  end.setForeground(Color.black);
							  end.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {		
										System.exit(0);
									}
								});
							  b.setForeground(Color.pink);
							  
							  panel.add(end);
							  panel.add(b);
							  
							 
							  frame.add(panel);
							  frame.setVisible(true);
					  }
						
						if(cell.a[parentLocation.y/100][parentLocation.x/100] == 1) {
							cell.a[parent.getY()/100][parent.getX()/100] = 1; 
							round = 0;
							 
						}else {
							cell.a[parent.getY()/100][parent.getX()/100] = -1; 
							round = 1;
							
						}
						cell.a[parentLocation.y/100][parentLocation.x/100] = 0;
						
						try {
							
							 if(flag == 0) {
								 a = new int[9][9];
								  
								  cell = new Cell();
								  cell.a = a;
								  a = cell.newCell();
							  }
							  
							PrintStream out = new PrintStream(new File("src/test2.txt"));
							
							for(int i = 0; i < 8; i++) {
								for(int j = 0; j < 8; j++) {
									out.println(cell.a[i][j]);
								}
							}
							
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}else {
						p2.add(Piece);
						Piece.setVisible(true);
					}
					
				
				
				
				
				//Pawn
				
			}else if(cell.a[parentLocation.y/100][parentLocation.x/100] == 6 || cell.a[parentLocation.y/100][parentLocation.x/100] == -6){
				
					int flag = 1;
					Pawn pawn = new Pawn();
					
					if(cell.a[parentLocation.y/100][parentLocation.x/100] == 6) {
						if(pawn.clearW(parentLocation.y/100, parentLocation.x/100, parent.getY()/100, parent.getX()/100)) {
							parent.remove(0);
							parent.add(Piece );
							Piece.setVisible(true);
							
							if(cell.a[parent.getY()/100][parent.getX()/100] == 1 || cell.a[parent.getY()/100][parent.getX()/100] == -1 ) {

								  round = 1;
								  flag = 0;
								  JFrame frame = new JFrame();
								  JPanel panel = new JPanel();
								  JLabel b = new JLabel("End of the match!");
								  JButton end = new JButton("Press for Close");
								  
								  
								  frame.setSize(800,800);
								  panel.setBackground(Color.black);
								  panel.setLayout(null);
								  panel.setOpaque(true);
								  
								  
								  b.setBackground(Color.black);
								  b.setBounds(100, 100, 400, 400);
								  end.setBounds(100,400,200,30);
								  end.setBackground(Color.pink);
								  end.setForeground(Color.black);
								  end.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {		
											System.exit(0);
										}
									});
								  b.setForeground(Color.pink);
								  
								  panel.add(end);
								  panel.add(b);
								  
								 
								  frame.add(panel);
								  frame.setVisible(true);
						  }
							
							
							
							cell.a[parent.getY()/100][parent.getX()/100] = 6; 
							cell.a[parentLocation.y/100][parentLocation.x/100] = 0;
							round = 0;
							
							try {
								 if(flag == 0) {
									 a = new int[9][9];
									  
									  cell = new Cell();
									  cell.a = a;
									  a = cell.newCell();
									  
								  }
								  
								PrintStream out = new PrintStream(new File("src/test2.txt"));
								
								for(int i = 0; i < 8; i++) {
									for(int j = 0; j < 8; j++) {
										out.println(cell.a[i][j]);
									}
								}
								
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}else {
							p2.add(Piece);
							Piece.setVisible(true);
						}
					}else {
						if(pawn.clearB(parentLocation.y/100, parentLocation.x/100, parent.getY()/100, parent.getX()/100)) {
							parent.remove(0);
							parent.add(Piece );
							
							Piece.setVisible(true);
							
							if(cell.a[parent.getY()/100][parent.getX()/100] == 1 || cell.a[parent.getY()/100][parent.getX()/100] == -1 ) {

								  round = 1;
								  flag = 0;
								  JFrame frame = new JFrame();
								  JPanel panel = new JPanel();
								  JLabel b = new JLabel("End of the match!");
								  JButton end = new JButton("Press for Close");
								  
								  
								  frame.setSize(800,800);
								  panel.setBackground(Color.black);
								  panel.setLayout(null);
								  panel.setOpaque(true);
								  
								  
								  b.setBackground(Color.black);
								  b.setBounds(100, 100, 400, 400);
								  end.setBounds(100,400,200,30);
								  end.setBackground(Color.pink);
								  end.setForeground(Color.black);
								  end.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {		
											System.exit(0);
										}
									});
								  b.setForeground(Color.pink);
								  
								  panel.add(end);
								  panel.add(b);
								  
								 
								  frame.add(panel);
								  frame.setVisible(true);
						  }
							
							cell.a[parent.getY()/100][parent.getX()/100] = -6; 
							cell.a[parentLocation.y/100][parentLocation.x/100] = 0;
							round = 1;
							
							try {
								
								 if(flag == 0) {
									 a = new int[9][9];
									  
									  cell = new Cell();
									  cell.a = a;
									  a = cell.newCell();
									  
								  }
								  
								PrintStream out = new PrintStream(new File("src/test2.txt"));
								
								for(int i = 0; i < 8; i++) {
									for(int j = 0; j < 8; j++) {
										out.println(cell.a[i][j]);
									}
								}
								
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							
						}else {
							p2.add(Piece);
							Piece.setVisible(true);
						}
						
						
					}
				
				
				
				
				
			}
  
	  }
	  
	  //Going to a empty cell
	  
	  else {
		  
	  	Container parent = (Container)c;
	  	Container p2 = (Container)p;
	  	
	  	
	  	if(round == 1 && cell.a[parentLocation.y/100][parentLocation.x/100] < 0) {
			  p2.add(Piece);
			  Piece.setVisible(true);
		  }else if(round == 0 && cell.a[parentLocation.y/100][parentLocation.x/100] > 0) {
			  p2.add(Piece);
			  Piece.setVisible(true);
		  }
	  	//Rook
	  	
		  else if(cell.a[parentLocation.y/100][parentLocation.x/100] == 3 || cell.a[parentLocation.y/100][parentLocation.x/100] == -3) {
	  		
	  			Rook rook = new Rook();
	  			 
				if(rook.canMove(parentLocation.y/100, parentLocation.x/100, parent.getY()/100, parent.getX()/100, cell.a)) {
					  parent.add(Piece );
					  Piece.setVisible(true);
					  if(cell.a[parentLocation.y/100][parentLocation.x/100] == 3 ) {
						  cell.a[parent.getY()/100][parent.getX()/100] = 3; 
						  round = 0;
					  }else {
						  cell.a[parent.getY()/100][parent.getX()/100] = -3;  
						  round = 1;
					  }
					  cell.a[parentLocation.y/100][parentLocation.x/100] = 0;
					  
					  try {
							PrintStream out = new PrintStream(new File("src/test2.txt"));
							
							for(int i = 0; i < 8; i++) {
								for(int j = 0; j < 8; j++) {
									out.println(cell.a[i][j]);
								}
							}
							
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					  
					  
				}else {
					p2.add(Piece);
					Piece.setVisible(true);
				}
				
	  		
			
	  		
			
			//Knight  
			  
		}else if(cell.a[parentLocation.y/100][parentLocation.x/100] == 5 || cell.a[parentLocation.y/100][parentLocation.x/100] == -5) {
			
		
				Knight knight = new Knight();
				
				if(knight.canMove(parentLocation.y/100, parentLocation.x/100, parent.getY()/100, parent.getX()/100)) {
					parent.add(Piece );
					Piece.setVisible(true);
					if(cell.a[parentLocation.y/100][parentLocation.x/100] == 5) {
						cell.a[parent.getY()/100][parent.getX()/100] = 5; 
						round = 0;
					}else {
						cell.a[parent.getY()/100][parent.getX()/100] = -5;
						round = 1;
					}
					
					cell.a[parentLocation.y/100][parentLocation.x/100] = 0;
					
					try {
						PrintStream out = new PrintStream(new File("src/test2.txt"));
						
						for(int i = 0; i < 8; i++) {
							for(int j = 0; j < 8; j++) {
								out.println(cell.a[i][j]);
							}
						}
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}else {
					p2.add(Piece);
					Piece.setVisible(true);
				}
				
			
			
			
			
			
			//Bishop
			
		}else if(cell.a[parentLocation.y/100][parentLocation.x/100] == 4 || cell.a[parentLocation.y/100][parentLocation.x/100] == -4) {
			
			
				Bishop bishop = new Bishop();
				
				if(bishop.canMove(parentLocation.y/100, parentLocation.x/100, parent.getY()/100, parent.getX()/100, cell.a)) {
					parent.add(Piece );
					Piece.setVisible(true);
					if(cell.a[parentLocation.y/100][parentLocation.x/100] == 4) {
						cell.a[parent.getY()/100][parent.getX()/100] = 4;
						round = 0;
					}else {
						cell.a[parent.getY()/100][parent.getX()/100] = -4; 
						round = 1;
					}
					cell.a[parentLocation.y/100][parentLocation.x/100] = 0;
					
					try {
						PrintStream out = new PrintStream(new File("src/test2.txt"));
						
						for(int i = 0; i < 8; i++) {
							for(int j = 0; j < 8; j++) {
								out.println(cell.a[i][j]);
							}
						}
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else {
					p2.add(Piece);
					Piece.setVisible(true);
				}
				
			
			
			
			
			//Queen
			
		}else if(cell.a[parentLocation.y/100][parentLocation.x/100] == 2 || cell.a[parentLocation.y/100][parentLocation.x/100] == -2) {
			
			
				Bishop bishop = new Bishop();
				Rook rook = new Rook();
				
				if(bishop.canMove(parentLocation.y/100, parentLocation.x/100, parent.getY()/100, parent.getX()/100, cell.a) == true ||
						rook.canMove(parentLocation.y/100, parentLocation.x/100, parent.getY()/100, parent.getX()/100, cell.a) == true) {
					parent.add(Piece );
					Piece.setVisible(true);
					if(cell.a[parentLocation.y/100][parentLocation.x/100] == 2) {
						cell.a[parent.getY()/100][parent.getX()/100] = 2; 
						round = 0;
					}else {
						cell.a[parent.getY()/100][parent.getX()/100] = -2; 
						round = 1;
					} 
					cell.a[parentLocation.y/100][parentLocation.x/100] = 0;
					
					try {
						PrintStream out = new PrintStream(new File("src/test2.txt"));
						
						for(int i = 0; i < 8; i++) {
							for(int j = 0; j < 8; j++) {
								out.println(cell.a[i][j]);
							}
						}
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}else {
					p2.add(Piece);
					Piece.setVisible(true);
				}
				
			
			
			
			
			//King
			
		}else if(cell.a[parentLocation.y/100][parentLocation.x/100] == 1 || cell.a[parentLocation.y/100][parentLocation.x/100] == -1) {
			
				King king = new King();
				
				if(king.canMove(parentLocation.y/100, parentLocation.x/100, parent.getY()/100, parent.getX()/100)) {
					parent.add(Piece );
					Piece.setVisible(true);
					if(cell.a[parentLocation.y/100][parentLocation.x/100] == 1) {
						cell.a[parent.getY()/100][parent.getX()/100] = 1; 
						round = 0;
					}else {
						cell.a[parent.getY()/100][parent.getX()/100] = -1; 
						round = 1;
						
					}
					cell.a[parentLocation.y/100][parentLocation.x/100] = 0;
					
					try {
						PrintStream out = new PrintStream(new File("src/test2.txt"));
						
						for(int i = 0; i < 8; i++) {
							for(int j = 0; j < 8; j++) {
								out.println(cell.a[i][j]);
							}
						}
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}else {
					p2.add(Piece);
					Piece.setVisible(true);
				}
				
			
			
			
			
			//Pawn
			
		}else if(cell.a[parentLocation.y/100][parentLocation.x/100] == 6 || cell.a[parentLocation.y/100][parentLocation.x/100] == -6){
			
				Pawn pawn = new Pawn();
				
				if(cell.a[parentLocation.y/100][parentLocation.x/100] == 6) {
					if(pawn.canMove(parentLocation.y/100, parentLocation.x/100, parent.getY()/100, parent.getX()/100)) {
						parent.add(Piece );
						Piece.setVisible(true);
						cell.a[parent.getY()/100][parent.getX()/100] = 6; 
						cell.a[parentLocation.y/100][parentLocation.x/100] = 0;
						round = 0;
						
						try {
							PrintStream out = new PrintStream(new File("src/test2.txt"));
							
							for(int i = 0; i < 8; i++) {
								for(int j = 0; j < 8; j++) {
									out.println(cell.a[i][j]);
								}
							}
							
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}else {
						p2.add(Piece);
						Piece.setVisible(true);
					}
				}else {
					if(pawn.BcanMove(parentLocation.y/100, parentLocation.x/100, parent.getY()/100, parent.getX()/100)) {
						parent.add(Piece );
						Piece.setVisible(true);
						cell.a[parent.getY()/100][parent.getX()/100] = -6; 
						cell.a[parentLocation.y/100][parentLocation.x/100] = 0;
						round = 1;
						
						try {
							PrintStream out = new PrintStream(new File("src/test2.txt"));
							
							for(int i = 0; i < 8; i++) {
								for(int j = 0; j < 8; j++) {
									out.println(cell.a[i][j]);
								}
							}
							
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}else {
						p2.add(Piece);
						Piece.setVisible(true);
					}
					
					
				}
			
			
			
			
			
			
		}
	  	
	  	
	  	
	  	
	  	
	  	
	  	
	  	
	  	
	  }
  }
 
  public void mouseClicked(MouseEvent e) {
  
  }
  public void mouseMoved(MouseEvent e) {
 }
  public void mouseEntered(MouseEvent e){
  
  }
  public void mouseExited(MouseEvent e) {
  
  }
  
 
 
  public static void main(String[] args) {
	  
	  
	  JFrame frame = new Continue();
	  frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
	  frame.pack();
	  frame.setResizable(true);
	  frame.setLocationRelativeTo( null );
	  frame.setVisible(true);
	 
	  
 }
}