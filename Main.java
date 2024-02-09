package kkkkkkkk;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		
		Font myFontt = new Font("Serif", Font.BOLD,12);
		JFrame f = new JFrame();
		JPanel p = new JPanel();
		JButton t = new JButton();
		JButton ai = new JButton();
		
		f.setSize(1200,800);
		f.setTitle("Chess");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t.setText("Human Player");
		t.setBounds(30, 100, 150, 30);
		t.setFont(myFontt);
		t.setBackground(Color.pink);
		t.setForeground(Color.black);
		t.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f.setVisible(false);
				Font myFont = new Font("Serif", Font.BOLD,12);
				
				JFrame frame = new JFrame();
				JPanel panel = new JPanel();
				JButton newG = new JButton();
				JButton con = new JButton();

				
				frame.setSize(1200,800);
				frame.setTitle("Chess");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				newG.setText("New Game");
				newG.setBounds(30, 100, 150, 30);
				newG.setFont(myFont);
				newG.setBackground(Color.pink);
				newG.setForeground(Color.black);
				newG.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
						 
						  JFrame frame2 = new NewGame();
						  frame2.pack();
						  frame2.setResizable(true);
						  frame2.setLocationRelativeTo( null );
						  
						  frame2.setVisible(true);
						  frame.setVisible(false);
						
					}
				});
				
				con.setText("Continue");
				con.setBounds(30, 150, 150, 30);
				con.setFont(myFont);
				con.setBackground(Color.pink);
				con.setForeground(Color.black);
				con.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						  JFrame frame3 = new Continue();
						  frame3.pack();
						  frame3.setResizable(true);
						  frame3.setLocationRelativeTo( null );
						  frame3.setVisible(true);
						  frame.setVisible(false);
					}
				});
				
				panel.add(con);
				panel.add(newG);
				panel.setLayout(null);
				panel.setOpaque(true);
				panel.setBackground(Color.black);
				
				
				
				frame.add(panel);
				
				frame.setVisible(true);
			}
			
		});
		
		ai.setText("AI Player");
		ai.setBounds(30, 150, 150, 30);
		ai.setFont(myFontt);
		ai.setBackground(Color.pink);
		ai.setForeground(Color.black);
		ai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				  
				  JFrame frame4 = new Ai();
				  frame4.pack();
				  frame4.setResizable(true);
				  frame4.setLocationRelativeTo( null );
				  frame4.setVisible(true);
				  f.setVisible(false);
			}
			
		});
		
		p.add(ai);
		p.add(t);
		p.setLayout(null);
		p.setOpaque(true);
		p.setBackground(Color.black);
		
		
		
		f.add(p);
		
		f.setVisible(true);
	  
	}
	
	
	
	
}
