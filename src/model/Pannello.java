package model;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Pannello {
	public static PedModel[][] matrice;
	public static int conta_utente;
	public static int cordXvecchie;
	public static int cordYvecchie;
	public static boolean mangiato_utente;
	public static boolean inizializzazione = false;
	public static Pannello pan= new Pannello();

	public Pannello() {		
		mangiato_utente = false;
		conta_utente = 0;
		cordXvecchie = 0;
		cordYvecchie = 0;
		creaScacchiera();
	}
	
	public Pannello(PedModel[][] m) {		
		matrice = m;		
		creaScacchiera();		
	}
	
	private void creaScacchiera() {
		/*
		 * 0 casella bianca
		 * 1 casella nera
		 * 2 pedina bianca
		 * 3 pedina nera
		 * 4 dama bianca 
		 * 5 dama nera
		 */		
		matrice = new PedModel [8][8];
		int i,j;
		//prime 3 righe
		for(i=0, j=0; j<8; j+=2){			
			matrice[i][j] = new PedModel(i, j, 3);
			matrice[i][j+1] = new PedModel(i, j, 0);
		}
		for(i=1, j=1; j<8; j+=2){
			matrice[i][j-1] = new PedModel(i, j, 0);
			matrice[i][j] = new PedModel(i, j, 3);
		}
		for(i=2, j=0; j<8; j+=2){			
			matrice[i][j] = new PedModel(i, j, 3);
			matrice[i][j+1] = new PedModel(i, j, 0);
		}
		//righe senza pedina
		for(i=3, j=1; j<8; j+=2){
			matrice[i][j-1] = new PedModel(i, j, 0);
			matrice[i][j] = new PedModel(i, j, 1);
		}
		for(i=4, j=0; j<8; j+=2){			
			matrice[i][j] = new PedModel(i, j, 1);
			matrice[i][j+1] = new PedModel(i, j, 0);
		}
		//ultime 3 righe
		for(i=5, j=1; j<8; j+=2){
			matrice[i][j-1] = new PedModel(i, j, 0);
			matrice[i][j] = new PedModel(i, j, 2);			
		}
		for(i=6, j=0; j<8; j+=2){			
			matrice[i][j] = new PedModel(i, j, 2);
			matrice[i][j+1] = new PedModel(i, j, 0);
		}
		for(i=7, j=1; j<8; j+=2){
			matrice[i][j-1] = new PedModel(i, j, 0);
			matrice[i][j] = new PedModel(i, j, 2);		
		}
	}

}