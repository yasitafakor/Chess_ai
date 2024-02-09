package kkkkkkkk;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class cross extends JFrame implements  MouseListener, MouseMotionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLayeredPane pane;
	JLabel photo;
	JPanel Board;
	
	Dimension Size;
	Dimension board;
	
	Point parentLocation;
	 
	
	int round = 1;//0 circle 1 cross
	int x;
	int y;
	
	cross(){
		
		  
		  Size = new Dimension(600, 600);
		//  board = new Dimension(800, 800);
		  pane = new JLayeredPane();
		  getContentPane().add(pane);
		  pane.setPreferredSize(Size);
		  
		  
		  Board = new JPanel();
	  	  pane.add(Board, JLayeredPane.DEFAULT_LAYER);
	  	  Board.setLayout( new GridLayout(3, 3) );
	  	  Board.setPreferredSize( Size );
	  	  Board.setBounds(0, 0, Size.width, Size.height);
	 
	  	  for (int i = 0; i < 9; i++) {
	  		   JPanel p = new JPanel( new BorderLayout() );
	  		   Board.add( p );
	  		  
	  		   Color n = new Color(249, 159, 201);
	  		   Color m = new Color(204, 5, 98);
	  		  
	 
	  		   int row = (i / 8) % 2;
	  		   if (row == 0)
	  			  p.setBackground( i % 2 == 0 ? n : m );
	  		   else
	  			  p.setBackground( i % 2 == 0 ?m : n);
	  }
	  	  
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame = new cross();
		
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
		frame.pack();
		frame.setResizable(true);
		frame.setLocationRelativeTo( null );
		frame.setVisible(true);
		 
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
		  photo = null;
		  
		  Component c =  Board.findComponentAt(e.getX(), e.getY());
		 
	 
		  if (c instanceof JPanel) 
			  return;
	 
		  parentLocation = c.getParent().getLocation();
		 
		  
	  
		  x = parentLocation.x - e.getX();
		  y = parentLocation.y - e.getY();
	  
		  if(round == 0) {
			  photo = new JLabel(new ImageIcon("circle.png"));
			  round = 1;
		  }else {
			  photo = new JLabel(new ImageIcon("cross.png"));
			  round = 0;
		  }
		  
		  photo.setLocation(e.getX() + x, e.getY() + y);
		  
		  photo.setSize(photo.getWidth(), photo.getHeight());
		  photo.add(photo, JLayeredPane.DRAG_LAYER);
	  
		  Component p =  Board.findComponentAt(parentLocation.x, parentLocation.y);
		  
		  
		  Container parent = (Container)c;
		  Container p2 = (Container)p;
		  
		  parent.add(photo);
		  photo.setVisible(true);
		  
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
