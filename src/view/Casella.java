package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Cas;
import controller.Controllore;

public class Casella extends JButton {
	
	private int x;
	private int y;
	
	public Casella(int x, int y) {		
		this.x=x;
		this.y=y;		
		this.setBackground(Color.GRAY);
		setBorderPainted(false); //NO al rettangolo 3D intorno
		setFocusPainted(false); //NO al rettangolo di selezione
		
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Cas.x=getMyX();
				Cas.y=getMyY();
				
				Controllore.controlli(getMyX(), getMyY());
						
			}

		});
		
	}
	
	public int getMyX() {
		return x;
	}
	
	public int getMyY() {
		return y;
	}
	
}