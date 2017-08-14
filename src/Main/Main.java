package Main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.*;
import view.*;
import controller.*;

public class Main {

	public static void main(String args[]) {
		creaFinestra();
		
	}
	
	public static void creaFinestra() {
		JFrame finestra = new JFrame();
		finestra.setLayout(new BorderLayout());
		finestra.add(Scacchiera.chequer, BorderLayout.CENTER);
		finestra.add(createSouth(), BorderLayout.SOUTH);
		finestra.setTitle("Dama");
		finestra.setSize(500,500);
		finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		finestra.setVisible(true);		
	}
	
	public static JPanel createSouth() {
		JPanel south = new JPanel();
		
		JButton resa = new JButton("Arrenditi");
		resa.addActionListener(new ActionListener(){			
			
			@Override
            public void actionPerformed(ActionEvent e) {
				JFrame finestra = new JFrame();
				finestra.setSize(200,100);
				finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				finestra.add(new JLabel("Hai perso"));
				finestra.setVisible(true);
			}                        
		});
		south.add(resa);
		return south;
	}

}
