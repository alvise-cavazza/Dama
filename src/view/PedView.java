package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import model.PedModel;

public class PedView extends JButton {
	
	private int x;
	private int y;
	
	public PedView(int x, int y, boolean c) {
		this.x=x;
		this.y=y;
		setBackground(Color.GRAY);
		if(c== true)
			setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/white.png")));
		else setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/black.png")));
		setBorderPainted(false); //NO al rettangolo 3D intorno
		setFocusPainted(false); //NO al rettangolo di selezione	
		
	    addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				PedModel.xcomune = getMyX();
				PedModel.ycomune = getMyY();
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