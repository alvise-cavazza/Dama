package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Pannello;
import model.PedModel;

public class Scacchiera extends JPanel {
	
	public JButton[][] matrice;
	public JPanel[][] matricePanel;
	public static Scacchiera chequer=new Scacchiera();	
	
	public Scacchiera() {
		setLayout(new GridLayout (8,8));		
		matrice = new JButton[8][8];
		matricePanel= new JPanel[8][8];		
		inizializzaMatrice();
		inizializzaPanel();
		creaScacchiera();	
	}

	public Scacchiera(int n) {
		setLayout(new GridLayout (8,8));		
		matrice = new JButton[8][8];
		matricePanel= new JPanel[8][8];	
		inizializzaMatrice();
		inizializzaPanel();	
	}
	
	private void creaScacchiera() {
		int i,j;
		//prime 3 righe
		for(i=0, j=0; j<8; j+=2){			
			add(matrice[i][j]);
			add(matricePanel[i][j+1]);
		}
		for(i=1, j=1; j<8; j+=2){
			add(matricePanel[i][j-1]);
			add(matrice[i][j]);
		}
		for(i=2, j=0; j<8; j+=2){			
			add(matrice[i][j]);
			add(matricePanel[i][j+1]);
		}
		//righe senza pedina
		for(i=3, j=1; j<8; j+=2){
			add(matricePanel[i][j-1]);
			add(matrice[i][j]);
		}
		for(i=4, j=0; j<8; j+=2){			
			add(matrice[i][j]);
			add(matricePanel[i][j+1]);
		}
		//ultime 3 righe
		for(i=5, j=1; j<8; j+=2){
			add(matricePanel[i][j-1]);
			add(matrice[i][j]);			
		}
		for(i=6, j=0; j<8; j+=2){			
			add(matrice[i][j]);
			add(matricePanel[i][j+1]);
		}
		for(i=7, j=1; j<8; j+=2){
			add(matricePanel[i][j-1]);
			add(matrice[i][j]);			
		}
	}
	
	private void inizializzaMatrice() {
		int i,j;
		//prime 3 righe
		for(i=0, j=0; j<8; j+=2)
			matrice[i][j] = (PedView)creaPedinaNera(i,j);
		for(i=1, j=1; j<8; j+=2)
			matrice[i][j] = (PedView)creaPedinaNera(i,j);
		for(i=2, j=0; j<8; j+=2)
			matrice[i][j] = (PedView)creaPedinaNera(i,j);
		//righe senza pedina
		for(i=3, j=1; j<8; j+=2)
			matrice[i][j] = (JButton)creaSpazio(i,j);
		for(i=4, j=0; j<8; j+=2)
			matrice[i][j] = (JButton)creaSpazio(i,j);
		//ultime 3 righe
		for(i=5, j=1; j<8; j+=2)
			matrice[i][j] = (PedView)creaPedinaBianca(i,j);
		for(i=6, j=0; j<8; j+=2)
			matrice[i][j] = (PedView)creaPedinaBianca(i,j);
		for(i=7, j=1; j<8; j+=2)
			matrice[i][j] = (PedView)creaPedinaBianca(i,j);		
	}
	
	private void inizializzaPanel() {
		int i,j;
		//prime 3 righe
		for(i=0, j=1; j<8; j+=2)
			matricePanel[i][j] = aggiungiSpazio();
		for(i=1, j=0; j<8; j+=2)
			matricePanel[i][j] = aggiungiSpazio();
		for(i=2, j=1; j<8; j+=2)
			matricePanel[i][j] = aggiungiSpazio();
		//righe senza pedina
		for(i=3, j=0; j<8; j+=2)
			matricePanel[i][j] = aggiungiSpazio();
		for(i=4, j=1; j<8; j+=2)
			matricePanel[i][j] = aggiungiSpazio();
		//ultime 3 righe
		for(i=5, j=0; j<8; j+=2)
			matricePanel[i][j] = aggiungiSpazio();
		for(i=6, j=1; j<8; j+=2)
			matricePanel[i][j] = aggiungiSpazio();
		for(i=7, j=0; j<8; j+=2)
			matricePanel[i][j] = aggiungiSpazio();
	}

	private JPanel aggiungiSpazio() {
		JPanel p = new JPanel();
		p.setBackground(Color.WHITE);
		return p;
	}

	private PedView creaPedinaBianca(int i, int j) {
		PedView p = new PedView(i,j,true);
		return p;
	}

	private Casella creaSpazio(int i, int j) {
		Casella c = new Casella(i,j);
		return c;
	}

	private PedView creaPedinaNera(int i, int j) {
		PedView p = new PedView(i,j,false);
		return p;
	}
	
	public void creaPannello(){
		int i,j;		
		// chequer.removeAll();		
		Scacchiera prova=new Scacchiera(4);
		for(i=0; i<8; i++){
			for(j=0; j<8; j++)
				switch (Pannello.matrice[i][j].valore){
					case 0:prova.add(matricePanel[i][j]);break;
					case 1:prova.add(new Casella(i,j));break;
					case 2:prova.add(new PedView(i,j, true));break;
					case 3:prova.add(new PedView(i,j, false));break;
					case 4:prova.add(new Damone(i,j, true));break;
					case 5:prova.add(new Damone(i,j, false));break;
			}
		}
		chequer=prova;
		chequer.setVisible(true);
	}
	
}