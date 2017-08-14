package controller;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Main.Main;
import model.Pannello;
import model.PedModel;
import view.Casella;
import view.Damone;
import view.PedView;
import view.Scacchiera;

public class Controllore {
	
	public static int pedine_mangiate;
	public static boolean mangiato;
	public static int x;
	public static int y;
	private static boolean prima_volta=true;	

	public Controllore() {
		// TODO Auto-generated constructor stub
	}
	
	public static void controlli(int x1, int y1) {		
		iniz(x1, y1);
		if(valido())
			if(!prima_volta){
				if(devoMangiare()){
					if(possoMangiare())
						spostamento();
				}else
					spostamento();
			}
			else{
				spostamento();
				prima_volta=false;
			}
	}
	
	public static boolean valido() {
		if((PedModel.ycomune != getMyY()) && (possoMangiare() || casellaVuota()))
			return true;	
		return false;
	}

	private static boolean possoMangiare() {
				
		if(PedModel.xcomune - getMyX() == 2 && PedModel.ycomune - getMyY() == 2){
			if(Pannello.pan.matrice[getMyX()+1][getMyY()+1].valore == 3 || Pannello.pan.matrice[getMyX()+1][getMyY()+1].valore == 5)
				if(Pannello.pan.matrice[getMyX()+1][getMyY()+1].valore == 3)
					return true;
				else 
					if(Pannello.pan.matrice[PedModel.xcomune][PedModel.ycomune].valore == 4)
						return true;
					else
						return false;
		}
		else{
			if((PedModel.xcomune - getMyX() == 2 && PedModel.ycomune - getMyY() == -2))
				if(Pannello.pan.matrice[getMyX()+1][getMyY()-1].valore == 3 || Pannello.pan.matrice[getMyX()+1][getMyY()-1].getValore() == 5)
					if(Pannello.pan.matrice[getMyX()+1][getMyY()-1].valore == 3)
						return true;
					else 
						if(Pannello.pan.matrice[PedModel.xcomune][PedModel.ycomune].valore == 4)
							return true;
		}
		
		if(Pannello.pan.matrice[PedModel.xcomune][PedModel.ycomune].valore == 4){
			if(PedModel.xcomune - getMyX() == -2 && PedModel.ycomune - getMyY() == 2){
				if(Pannello.pan.matrice[getMyX()-1][getMyY()+1].valore == 3 || Pannello.pan.matrice[getMyX()-1][getMyY()+1].valore == 5)
					return true;
			}
			else{
				if((PedModel.xcomune - getMyX() == -2 && PedModel.ycomune - getMyY() == -2))
					if(Pannello.pan.matrice[getMyX()-1][getMyY()-1].valore == 3 || Pannello.pan.matrice[getMyX()-1][getMyY()-1].valore == 5)
						return true;
			}
		}
		
		return false;
	}
	
	private static boolean possoMangiareVal(){ // mi serve per vedere se con la prossima mossa posso mangiare
		
		if(Pannello.pan.cordXvecchie > 1){
			if(Pannello.pan.cordYvecchie == 0)
				if((Pannello.pan.matrice[Pannello.pan.cordXvecchie-1][Pannello.pan.cordYvecchie+1].valore) == 3 || (Pannello.pan.matrice[Pannello.pan.cordXvecchie-1][Pannello.pan.cordYvecchie+1].valore) == 5)
					if(Pannello.pan.matrice[Pannello.pan.cordXvecchie-2][Pannello.pan.cordYvecchie+2].valore == 1)
						if(!((Pannello.pan.matrice[Pannello.pan.cordXvecchie-1][Pannello.pan.cordYvecchie+1].valore) == 5))
							return true;							
						else 
							if((Pannello.pan.matrice[Pannello.pan.cordXvecchie][Pannello.pan.cordYvecchie].valore) == 4)
								return true;
					
			 if(Pannello.pan.cordYvecchie == 7)
				if(Pannello.pan.matrice[Pannello.pan.cordXvecchie-1][Pannello.pan.cordYvecchie-1].valore == 3 || Pannello.pan.matrice[Pannello.pan.cordXvecchie-1][Pannello.pan.cordYvecchie-1].valore == 5) 
					if(Pannello.pan.matrice[Pannello.pan.cordXvecchie-2][Pannello.pan.cordYvecchie-2].valore == 1)
						if(!(Pannello.pan.matrice[Pannello.pan.cordXvecchie-1][Pannello.pan.cordYvecchie-1].valore == 5)) 
							return true;						 
						else
							if(Pannello.pan.matrice[Pannello.pan.cordXvecchie][Pannello.pan.cordYvecchie].valore == 4)
								return true;	
			
			 if(Pannello.pan.cordYvecchie == 1)
				if(Pannello.pan.matrice[Pannello.pan.cordXvecchie-1][Pannello.pan.cordYvecchie+1].valore == 3 || Pannello.pan.matrice[Pannello.pan.cordXvecchie-1][Pannello.pan.cordYvecchie+1].valore == 5) 
					if(Pannello.pan.matrice[Pannello.pan.cordXvecchie-2][Pannello.pan.cordYvecchie+2].valore == 1)
						if(Pannello.pan.matrice[Pannello.pan.cordXvecchie-1][Pannello.pan.cordYvecchie+1].valore == 3) 
							return true;					 
						else
							if(Pannello.pan.matrice[Pannello.pan.cordXvecchie][Pannello.pan.cordYvecchie].valore == 4)
								return true;	 
			 
			 if(Pannello.pan.cordYvecchie == 6) 
				if(Pannello.pan.matrice[Pannello.pan.cordXvecchie-1][Pannello.pan.cordYvecchie-1].valore == 3 || Pannello.pan.matrice[Pannello.pan.cordXvecchie-1][Pannello.pan.cordYvecchie-1].valore == 5) 
					if(Pannello.pan.matrice[Pannello.pan.cordXvecchie-2][Pannello.pan.cordYvecchie-2].valore == 1)
						if(Pannello.pan.matrice[Pannello.pan.cordXvecchie-1][Pannello.pan.cordYvecchie-1].valore == 3) 
							return true;								 
						else
							if(Pannello.pan.matrice[Pannello.pan.cordXvecchie][Pannello.pan.cordYvecchie].valore == 4)
								return true;
			 
			 if(Pannello.pan.cordYvecchie > 1 && Pannello.pan.cordYvecchie < 6)
				if((Pannello.pan.matrice[Pannello.pan.cordXvecchie-1][Pannello.pan.cordYvecchie+1].valore) == 3 || (Pannello.pan.matrice[Pannello.pan.cordXvecchie-1][Pannello.pan.cordYvecchie+1].valore) == 5){
					if(Pannello.pan.matrice[Pannello.pan.cordXvecchie-2][Pannello.pan.cordYvecchie+2].valore == 1)
						if((Pannello.pan.matrice[Pannello.pan.cordXvecchie-1][Pannello.pan.cordYvecchie+1].valore) == 3) 
							return true;
						else
							if(Pannello.pan.matrice[Pannello.pan.cordXvecchie][Pannello.pan.cordYvecchie].valore == 4)
								return true;
				}else
					if(Pannello.pan.matrice[Pannello.pan.cordXvecchie-1][Pannello.pan.cordYvecchie-1].valore == 3 || Pannello.pan.matrice[Pannello.pan.cordXvecchie-1][Pannello.pan.cordYvecchie-1].valore == 5) 
						if(Pannello.pan.matrice[Pannello.pan.cordXvecchie-2][Pannello.pan.cordYvecchie-2].valore == 1)
							if(Pannello.pan.matrice[Pannello.pan.cordXvecchie-1][Pannello.pan.cordYvecchie-1].valore == 3) 
								return true;
							else
								if(Pannello.pan.matrice[Pannello.pan.cordXvecchie][Pannello.pan.cordYvecchie].valore == 4)
									return true;
		
				if(Pannello.pan.matrice[Pannello.pan.cordXvecchie][Pannello.pan.cordYvecchie].valore == 4)
					if(Pannello.pan.cordXvecchie < 6 && Pannello.pan.cordYvecchie < 6)
						if((Pannello.pan.matrice[Pannello.pan.cordXvecchie+1][Pannello.pan.cordYvecchie+1].valore) == 3 || (Pannello.pan.matrice[Pannello.pan.cordXvecchie+1][Pannello.pan.cordYvecchie+1].valore) == 5){
							if(Pannello.pan.matrice[Pannello.pan.cordXvecchie+2][Pannello.pan.cordYvecchie+2].valore == 1)
								return true;
						}else
							if(Pannello.pan.cordXvecchie < 6 && Pannello.pan.cordYvecchie > 2)
								if(Pannello.pan.matrice[Pannello.pan.cordXvecchie+1][Pannello.pan.cordYvecchie-1].valore == 3 || Pannello.pan.matrice[Pannello.pan.cordXvecchie+1][Pannello.pan.cordYvecchie-1].valore == 5) 
									if(Pannello.pan.matrice[Pannello.pan.cordXvecchie+2][Pannello.pan.cordYvecchie-2].valore == 1)
										return true;
				
		}else{
			if(Pannello.pan.matrice[Pannello.pan.cordXvecchie][Pannello.pan.cordYvecchie].valore == 4){
				if(Pannello.pan.cordYvecchie == 0 || Pannello.pan.cordYvecchie == 1)
					if((Pannello.pan.matrice[Pannello.pan.cordXvecchie+1][Pannello.pan.cordYvecchie+1].valore) == 3 || (Pannello.pan.matrice[Pannello.pan.cordXvecchie+1][Pannello.pan.cordYvecchie+1].valore) == 5)
						if(Pannello.pan.matrice[Pannello.pan.cordXvecchie+2][Pannello.pan.cordYvecchie+2].valore == 1)
							return true;
						
				 if(Pannello.pan.cordYvecchie == 7 || Pannello.pan.cordYvecchie == 6)
					 if(Pannello.pan.matrice[Pannello.pan.cordXvecchie+1][Pannello.pan.cordYvecchie-1].valore == 3 || Pannello.pan.matrice[Pannello.pan.cordXvecchie+1][Pannello.pan.cordYvecchie-1].valore == 5) 
						if(Pannello.pan.matrice[Pannello.pan.cordXvecchie+2][Pannello.pan.cordYvecchie-2].valore == 1)
							return true;			 
				
				if(Pannello.pan.cordYvecchie > 1 && Pannello.pan.cordYvecchie < 6)
					if((Pannello.pan.matrice[Pannello.pan.cordXvecchie+1][Pannello.pan.cordYvecchie+1].valore) == 3 || (Pannello.pan.matrice[Pannello.pan.cordXvecchie+1][Pannello.pan.cordYvecchie+1].valore) == 5){
						if(Pannello.pan.matrice[Pannello.pan.cordXvecchie+2][Pannello.pan.cordYvecchie+2].valore == 1)
							return true;
					}else
						if(Pannello.pan.matrice[Pannello.pan.cordXvecchie+1][Pannello.pan.cordYvecchie-1].valore == 3 || Pannello.pan.matrice[Pannello.pan.cordXvecchie+1][Pannello.pan.cordYvecchie-1].valore == 5) 
							if(Pannello.pan.matrice[Pannello.pan.cordXvecchie+2][Pannello.pan.cordYvecchie-2].valore == 1)
								return true;
			}
		}	
		return false;
		
	}
	
	private static boolean devoMangiare() {
		
		for(PedModel b[]: Pannello.pan.matrice)
			for(PedModel c: b)
				if(c.valore == 2 || c.valore == 4){
					if((Pannello.pan.matrice[c.getMyX()][c.getMyY()].valore) == 4){
						if (c.getMyX() > 1){
							if(c.getMyY() == 0)
								if((Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore) == 3 || Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore == 5)
									if(Pannello.pan.matrice[c.getMyX()-2][c.getMyY()+2].valore == 1)
										return true;											
							 if(c.getMyY() == 7)
								if(Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore == 3 || Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore == 5) 
									if(Pannello.pan.matrice[c.getMyX()-2][c.getMyY()-2].valore == 1)
										return true;							
							 if(c.getMyY() == 1)
								if(Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore == 3 || Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore == 5) 
									if(Pannello.pan.matrice[c.getMyX()-2][c.getMyY()+2].valore == 1) 
										return true;							 
							 if(c.getMyY() == 6) 
								if(Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore == 3 || Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore == 5) 
									if(Pannello.pan.matrice[c.getMyX()-2][c.getMyY()-2].valore == 1)
										return true;						 							
							if(c.getMyY() > 1 && c.getMyY() < 6)
								if((Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore) == 3 || (Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore) == 5){
									if(Pannello.pan.matrice[c.getMyX()-2][c.getMyY()+2].valore == 1)
										return true;
							}else	
								if((Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore) == 3 || (Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore) == 5)
									if(Pannello.pan.matrice[c.getMyX()-2][c.getMyY()-2].valore == 1)
										return true;						
						}						
						if(c.getMyX() <= 1){
							if(c.getMyY() == 0)
								if((Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore == 3 || Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore == 5))
									if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()+2].valore == 1)
										return true;
							 if(c.getMyY() == 7)
								if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 3 || Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 5) 
										if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()-2].valore == 1) 
												return true;
							 if(c.getMyY() == 1)
								if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore == 3 || Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore == 5) 
									if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()+2].valore == 1) 
										return true;
							 if(c.getMyY() == 6) 
								if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 3 || Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 5) 
									if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()-2].valore == 1) 
										return true;
							if(c.getMyY() > 1 && c.getMyY() < 6)
								if((Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore == 3 || Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore == 5)){
									if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()+2].valore == 1)
										return true;
								}else if((Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 3 || Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 5))
									if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()-2].valore == 1)
										return true;									
						}				
						if(c.getMyX() < 6 && c.getMyX() > 1){
							//primo blocco
							if(c.getMyY() == 0)
								if((Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore) == 3 || Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore == 5)
									if(Pannello.pan.matrice[c.getMyX()-2][c.getMyY()+2].valore == 1)
										return true;
							 if(c.getMyY() == 7)
								if(Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore == 3 || Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore == 5) 
									if(Pannello.pan.matrice[c.getMyX()-2][c.getMyY()-2].valore == 1)
										return true;
							 if(c.getMyY() == 1)
								if(Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore == 3 || Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore == 5) 
									if(Pannello.pan.matrice[c.getMyX()-2][c.getMyY()+2].valore == 1) 
										return true;
							 if(c.getMyY() == 6)
								if(Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore == 3 || Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore == 5) 
									if(Pannello.pan.matrice[c.getMyX()-2][c.getMyY()-2].valore == 1)
										return true;
							if(c.getMyY() > 1 && c.getMyY() < 6)
								if((Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore) == 3 || (Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore) == 5){
									if(Pannello.pan.matrice[c.getMyX()-2][c.getMyY()+2].valore == 1)
										return true;			
							}else
								if((Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore) == 3 || (Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore) == 5)
									if(Pannello.pan.matrice[c.getMyX()-2][c.getMyY()-2].valore == 1)
										return true;															
							//secondo blocco
							if(c.getMyY() == 0)
								if((Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore == 3 || Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore == 5))
									if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()+2].valore == 1)
										return true;							
							 if(c.getMyY() == 7)
								if(Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore == 3 || Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 5)
									if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()-2].valore == 1) 
										return true;							
							 if(c.getMyY() == 1)
								if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore == 3 || Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore == 5) 
									if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()+2].valore == 1) 
										return true;							 
							 if(c.getMyY() == 6) 
								if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 3 || Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 5) 
									if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()-2].valore == 1) 
										return true;																
							if(c.getMyY() > 1 && c.getMyY() < 6)
								if((Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore == 3 || Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore == 5)){
									if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()+2].valore == 1)
										return true;
							}else	
								if((Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 3 || Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 5))
									if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()-2].valore == 1)
										return true;
						}
					}
					else{ // se è una pedina
						if (c.getMyX() > 1){
							if(c.getMyY() == 0){								
								if((Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore) == 3 || (Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore) == 5)
									if(Pannello.pan.matrice[c.getMyX()-2][c.getMyY()+2].valore == 1)
										if (!((Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore) == 5))
											return true;
										else 
											if((Pannello.pan.matrice[c.getMyX()][c.getMyY()].valore) == 4)
												return true;
							}											
							 if(c.getMyY() == 7)
								if(Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore == 3 || Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore == 5) 
									if(Pannello.pan.matrice[c.getMyX()-2][c.getMyY()-2].valore == 1)
										if(!(Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore == 3)) 
											return true;
										else
											if(Pannello.pan.matrice[c.getMyX()][c.getMyY()].valore == 4)
												return true;							
							 if(c.getMyY() == 1)
								if(Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore == 3 || Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore == 5) 
									if(Pannello.pan.matrice[c.getMyX()-2][c.getMyY()+2].valore == 1)
										if(Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore == 3) 
											return true;										 
										else
											if(Pannello.pan.matrice[c.getMyX()][c.getMyY()].valore == 4)
												return true;							 
							 if(c.getMyY() == 6)
								if(Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore == 3 || Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore == 5) 
									if(Pannello.pan.matrice[c.getMyX()-2][c.getMyY()-2].valore == 1)
										if(Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore == 3) 
											return true; 
										else
											if(Pannello.pan.matrice[c.getMyX()][c.getMyY()].valore == 4)
												return true;							
							if(c.getMyY() > 1 && c.getMyY() < 6)
								if((Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore) == 3 || (Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore) == 5){
										if(Pannello.pan.matrice[c.getMyX()-2][c.getMyY()+2].valore == 1)
											if((Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore) == 3) 
												return true; 
											else
												if(Pannello.pan.matrice[c.getMyX()][c.getMyY()].valore == 4)
													return true;
								}else												
									if(Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore == 3 || Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore == 5) 
										if(Pannello.pan.matrice[c.getMyX()-2][c.getMyY()-2].valore == 1)
											if(Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore == 3) 
												return true;	
											else
												if(Pannello.pan.matrice[c.getMyX()][c.getMyY()].valore == 4)
													return true;
					}					
				}
			}		
		return false;
		
	}			

	private static boolean casellaVuota() {
		if((PedModel.xcomune - getMyX() == 1) && (PedModel.ycomune - getMyY() == 1))			
			if(Pannello.pan.matrice[getMyX()][getMyY()].valore == 1)
				return true;
		if(PedModel.xcomune - getMyX() == 1 && PedModel.ycomune - getMyY() == -1)
			if(Pannello.pan.matrice[getMyX()][getMyY()].valore == 1)
				return true;		
		if (Pannello.pan.matrice[PedModel.xcomune][PedModel.ycomune].valore == 4){
			if(PedModel.xcomune - getMyX() == -1 && PedModel.ycomune - getMyY() == 1)
				if(Pannello.pan.matrice[getMyX()][getMyY()].valore == 1)
					return true;
			if(PedModel.xcomune - getMyX() == -1 && PedModel.ycomune - getMyY() == -1)
				if(Pannello.pan.matrice[getMyX()][getMyY()].valore == 1)
					return true;
		}
		return false;
	}

	private static void spostamento() {
		Boolean controllo_mangiato = false;
		if(Pannello.pan.mangiato_utente == true && Pannello.pan.conta_utente < 4){
			if(Pannello.pan.cordXvecchie == PedModel.xcomune && Pannello.pan.cordYvecchie == PedModel.ycomune){
				if(possoMangiareVal()){
					//se è un damone
					if(Pannello.pan.matrice[PedModel.xcomune][PedModel.ycomune].valore == 4){					
						if(PedModel.xcomune - getMyX() == 2 && PedModel.ycomune - getMyY() == 2){
							if(Pannello.pan.matrice[getMyX()+1][getMyY()+1].valore == 3 || Pannello.pan.matrice[getMyX()+1][getMyY()+1].valore == 5){
								Pannello.pan.matrice[getMyX()+1][getMyY()+1].valore = 1;
								Pannello.pan.matrice[getMyX()][getMyY()].valore = 4;
								Pannello.pan.matrice[PedModel.xcomune][PedModel.ycomune].valore = 1;
								Pannello.pan.conta_utente++;
								Pannello.pan.cordXvecchie = getMyX();
								Pannello.pan.cordYvecchie = getMyY();
								if(possoMangiare())
									Pannello.pan.mangiato_utente = true;
								else
									Pannello.pan.mangiato_utente = false;
							}
						}
						else 
							if(Pannello.pan.matrice[getMyX()+1][getMyY()-1].valore == 3 || Pannello.pan.matrice[getMyX()+1][getMyY()-1].valore == 5){
								Pannello.pan.matrice[getMyX()+1][getMyY()-1].valore = 1;
								Pannello.pan.matrice[getMyX()][getMyY()].valore = 4;
								Pannello.pan.matrice[PedModel.xcomune][PedModel.ycomune].valore = 1;
								Pannello.pan.conta_utente++;
								Pannello.pan.cordXvecchie = getMyX();
								Pannello.pan.cordYvecchie = getMyY();
								if(possoMangiare())
									Pannello.pan.mangiato_utente = true;
								else
									Pannello.pan.mangiato_utente = false;
							}						
						if(PedModel.xcomune - getMyX() == -2 && PedModel.ycomune - getMyY() == 2){
							if(Pannello.pan.matrice[getMyX()-1][getMyY()+1].valore == 3 || Pannello.pan.matrice[getMyX()-1][getMyY()+1].valore == 5){
								Pannello.pan.matrice[getMyX()-1][getMyY()+1].valore = 1;
								Pannello.pan.matrice[getMyX()][getMyY()].valore = 4;
								Pannello.pan.matrice[PedModel.xcomune][PedModel.ycomune].valore = 1;
								Pannello.pan.conta_utente++;
								Pannello.pan.cordXvecchie = getMyX();
								Pannello.pan.cordYvecchie = getMyY();
								if(possoMangiare())
									Pannello.pan.mangiato_utente = true;
								else
									Pannello.pan.mangiato_utente = false;
							}
						}
						else 
							if (Pannello.pan.matrice[getMyX()-1][getMyY()-1].valore == 3 || Pannello.pan.matrice[getMyX()-1][getMyY()-1].valore == 5){
								Pannello.pan.matrice[getMyX()-1][getMyY()-1].valore = 1;
								Pannello.pan.matrice[getMyX()][getMyY()].valore = 4;
								Pannello.pan.matrice[PedModel.xcomune][PedModel.ycomune].valore = 1;
								Pannello.pan.conta_utente++;
								Pannello.pan.cordXvecchie = getMyX();
								Pannello.pan.cordYvecchie = getMyY();
								if(possoMangiare())
									Pannello.pan.mangiato_utente = true;
								else
									Pannello.pan.mangiato_utente = false;
							}					
					}
					else{ //se è una pedina
						if(PedModel.xcomune - getMyX() == 2 && PedModel.ycomune - getMyY() == 2){
							if(Pannello.pan.matrice[getMyX()+1][getMyY()+1].valore == 3 || Pannello.pan.matrice[getMyX()+1][getMyY()+1].valore == 5){
								Pannello.pan.matrice[getMyX()+1][getMyY()+1].valore = 1;
								Pannello.pan.matrice[getMyX()][getMyY()].valore = 2;
								Pannello.pan.matrice[PedModel.xcomune][PedModel.ycomune].valore = 1;
								Pannello.pan.conta_utente++;
								Pannello.pan.cordXvecchie = getMyX();
								Pannello.pan.cordYvecchie = getMyY();
								if(possoMangiare())
									Pannello.pan.mangiato_utente = true;
								else
									Pannello.pan.mangiato_utente = false;
							}
						}
						else 
							if (Pannello.pan.matrice[getMyX()+1][getMyY()-1].valore == 3 || Pannello.pan.matrice[getMyX()+1][getMyY()-1].valore == 5){
								Pannello.pan.matrice[getMyX()+1][getMyY()-1].valore = 1;
								Pannello.pan.matrice[getMyX()][getMyY()].valore = 2;
								Pannello.pan.matrice[PedModel.xcomune][PedModel.ycomune].valore = 1;
								Pannello.pan.conta_utente++;
								Pannello.pan.cordXvecchie = getMyX();
								Pannello.pan.cordYvecchie = getMyY();
								if(possoMangiare())
									Pannello.pan.mangiato_utente = true;
								else
									Pannello.pan.mangiato_utente = false;
							}						
						}					
					}
					else{
						Pannello.pan.mangiato_utente = false;
					}
				}
			}	
			else{
				//se non ho mangiato o ho mangiato troppe volte				
				if(Pannello.pan.conta_utente == 0){
					//però bisogna controllare tutte le pedine se possono mangiare o meno
					if(possoMangiare()){
						if(Pannello.pan.matrice[PedModel.xcomune][PedModel.ycomune].valore == 4){
							if(PedModel.xcomune - getMyX() == 2 && PedModel.ycomune - getMyY() == 2){
								if(Pannello.pan.matrice[getMyX()+1][getMyY()+1].valore == 3 || Pannello.pan.matrice[getMyX()+1][getMyY()+1].valore == 5){
									Pannello.pan.matrice[getMyX()+1][getMyY()+1].valore = 1;
									Pannello.pan.matrice[getMyX()][getMyY()].valore = 4;
									Pannello.pan.matrice[PedModel.xcomune][PedModel.ycomune].valore = 1;
									Pannello.pan.conta_utente++;
									Pannello.pan.cordXvecchie = getMyX();
									Pannello.pan.cordYvecchie = getMyY();
									Pannello.pan.mangiato_utente = true;
								}
							}
							else 
								if(PedModel.xcomune - getMyX() == 2 && PedModel.ycomune - getMyY() == -2)
									if(Pannello.pan.matrice[getMyX()+1][getMyY()-1].valore == 3 || Pannello.pan.matrice[getMyX()+1][getMyY()-1].valore == 5){
										Pannello.pan.matrice[getMyX()+1][getMyY()-1].valore = 1;
										Pannello.pan.matrice[getMyX()][getMyY()].valore = 4;
										Pannello.pan.matrice[PedModel.xcomune][PedModel.ycomune].valore = 1;
										Pannello.pan.conta_utente++;
										Pannello.pan.cordXvecchie = getMyX();
										Pannello.pan.cordYvecchie = getMyY();
										Pannello.pan.mangiato_utente = true;
									}							
							if(PedModel.xcomune - getMyX() == -2 && PedModel.ycomune - getMyY() == 2){
								if(Pannello.pan.matrice[getMyX()-1][getMyY()+1].valore == 3 || Pannello.pan.matrice[getMyX()-1][getMyY()+1].valore == 5){
									Pannello.pan.matrice[getMyX()-1][getMyY()+1].valore = 1;
									Pannello.pan.matrice[getMyX()][getMyY()].valore = 4;
									Pannello.pan.matrice[PedModel.xcomune][PedModel.ycomune].valore = 1;
									Pannello.pan.conta_utente++;
									Pannello.pan.cordXvecchie = getMyX();
									Pannello.pan.cordYvecchie = getMyY();
									Pannello.pan.mangiato_utente = true;
								}
							}
							else 	
								if(PedModel.xcomune - getMyX() == -2 && PedModel.ycomune - getMyY() == -2)
									if(Pannello.pan.matrice[getMyX()-1][getMyY()-1].valore == 3 || Pannello.pan.matrice[getMyX()-1][getMyY()-1].valore == 5){
										Pannello.pan.matrice[getMyX()-1][getMyY()-1].valore = 1;
										Pannello.pan.matrice[getMyX()][getMyY()].valore = 4;
										Pannello.pan.matrice[PedModel.xcomune][PedModel.ycomune].valore = 1;
										Pannello.pan.conta_utente++;
										Pannello.pan.cordXvecchie = getMyX();
										Pannello.pan.cordYvecchie = getMyY();
										Pannello.pan.mangiato_utente = true;
									}
						}// se è una pedina
						else{
							if(PedModel.xcomune - getMyX() == 2 && PedModel.ycomune - getMyY() == 2){
								if(Pannello.pan.matrice[getMyX()+1][getMyY()+1].valore == 3){
									Pannello.pan.matrice[getMyX()+1][getMyY()+1].valore = 1;
									Pannello.pan.matrice[getMyX()][getMyY()].valore = 2;
									Pannello.pan.matrice[PedModel.xcomune][PedModel.ycomune].valore = 1;
									Pannello.pan.conta_utente++;
									Pannello.pan.cordXvecchie = getMyX();
									Pannello.pan.cordYvecchie = getMyY();
									Pannello.pan.mangiato_utente = true;
								}
							}
							else 
								if(Pannello.pan.matrice[getMyX()+1][getMyY()-1].valore == 3){
									Pannello.pan.matrice[getMyX()+1][getMyY()-1].valore = 1;
									Pannello.pan.matrice[getMyX()][getMyY()].valore = 2;
									Pannello.pan.matrice[PedModel.xcomune][PedModel.ycomune].valore = 1;
									Pannello.pan.conta_utente++;
									Pannello.pan.cordXvecchie = getMyX();
									Pannello.pan.cordYvecchie = getMyY();
									Pannello.pan.mangiato_utente = true;
								}							
						}						
						//controllo se qui ho mangiato quando potevo mangiare
						if(Pannello.pan.mangiato_utente == false)
							controllo_mangiato = true;
					}else
						if(Pannello.pan.mangiato_utente == false){
							if (Pannello.pan.matrice[PedModel.xcomune][PedModel.ycomune].valore == 2){
								Pannello.pan.matrice[getMyX()][getMyY()].valore = 2;
								Pannello.pan.matrice[PedModel.xcomune][PedModel.ycomune].valore = 1;
								Pannello.pan.mangiato_utente = false;
								Pannello.pan.cordXvecchie = getMyX();
								Pannello.pan.cordYvecchie = getMyY();
							}
							else{
								Pannello.pan.matrice[getMyX()][getMyY()].valore = 4;
								Pannello.pan.matrice[PedModel.xcomune][PedModel.ycomune].valore = 1;
								Pannello.pan.mangiato_utente = false;
								Pannello.pan.cordXvecchie = getMyX();
								Pannello.pan.cordYvecchie = getMyY();								
							}
						}					
				}
				else
					Pannello.pan.mangiato_utente = false;
		}		
		if(getMyX() == 0)
			Pannello.pan.matrice[getMyX()][getMyY()].valore = 4;
		//vedere se si ha vinto guardando se le pedine sono tutte dello stesso colore
		if(haiVinto()){
			JFrame finestra = new JFrame();
			finestra.setSize(200,100);
			finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			finestra.add(new JLabel("Hai vinto"));
			finestra.setVisible(true);
		}		
		//qui, prima di stampare la Pannello, implemento la mossa che farà il computer		
		if(!possoMangiareVal()){
			Pannello.pan.mangiato_utente = false;
			controllo_mangiato = false;
		}	
		if (Pannello.pan.mangiato_utente == false && !controllo_mangiato){
			Pannello.pan.conta_utente = 0;
			mossaIA();
		}		
		if(haiPerso()){
			JFrame finestra = new JFrame();
			finestra.setSize(200,100);
			finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			finestra.add(new JLabel("Hai perso"));
			finestra.setVisible(true);
		}
		if (!haiPerso()){
			Scacchiera.chequer.creaPannello();
			Main.creaFinestra();
		}		
	}

	private static boolean haiPerso() {
		boolean vincita = true;
		for(PedModel b[]: Pannello.pan.matrice)
			for(PedModel c: b)
				if(c.valore == 2 || c.valore == 4)
						vincita = false;							
		return vincita;
	}

	private static boolean haiVinto() {
		boolean vincita = true;
		for(PedModel b[]: Pannello.pan.matrice)
			for (PedModel c: b)
				if(c.valore == 3 || c.valore == 5)
						vincita = false;							
		return vincita;
	}
	
	private static void mossaIA() {
		mangiato = false;
		pedine_mangiate = 0;		
		int[] array = {-1,-1,-1,-1};
		do{		
			if(pedine_mangiate > 0)
				mangiata_multipla(array[2], array[3], array);
			else
				possoMangiareIA(array); //guardo se posso mangiare e se posso mangio			
			if(array[0] != -1 && array[1] != -1 && array[2] != -1 && array[3] != -1){ 
				//se ho mangiato faccio questo
				if (Pannello.pan.matrice[array[0]][array[1]].valore == 5){					
					if(array[0] < array[2]){					
						if(array[1] < array[3]){
							Pannello.pan.matrice[array[0]][array[1]].valore = 1;
							Pannello.pan.matrice[array[2]][array[3]].valore = 5;
							Pannello.pan.matrice[array[0]+1][array[1]+1].valore = 1;
						}
						else{
							Pannello.pan.matrice[array[0]][array[1]].valore = 1;
							Pannello.pan.matrice[array[2]][array[3]].valore = 5;
							Pannello.pan.matrice[array[0]+1][array[1]-1].valore = 1;
						}
					}
					else{
						if(array[1]<array[3]){
							Pannello.pan.matrice[array[0]][array[1]].valore = 1;
							Pannello.pan.matrice[array[2]][array[3]].valore = 5;
							Pannello.pan.matrice[array[0]-1][array[1]+1].valore = 1;
						}
						else{
							Pannello.pan.matrice[array[0]][array[1]].valore = 1;
							Pannello.pan.matrice[array[2]][array[3]].valore = 5;
							Pannello.pan.matrice[array[0]-1][array[1]-1].valore = 1;
						}
					}				
				}
				else{ // una pedina sta mangiando
					if(array[1] < array[3]){
						Pannello.pan.matrice[array[0]][array[1]].valore = 1;
						Pannello.pan.matrice[array[2]][array[3]].valore = 3;
						Pannello.pan.matrice[array[0]+1][array[1]+1].valore = 1;
					}
					else{
						Pannello.pan.matrice[array[0]][array[1]].valore = 1;
						Pannello.pan.matrice[array[2]][array[3]].valore = 3;
						Pannello.pan.matrice[array[0]+1][array[1]-1].valore = 1;
					}
					if(array[2] == 7)
						Pannello.pan.matrice[array[2]][array[3]].valore = 5;					
					mangiato = true;
					pedine_mangiate++;
				} 
			}
			else if(mangiato == false){
				spostamentoIA(array);				
				if(array[0] == -1 && array[1] == -1 && array[2] == -1 && array[3] == -1){
					JFrame finestra = new JFrame();
					finestra.setSize(200,100);
					finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					finestra.add(new JLabel("HAI VINTO!!!"));
					finestra.setVisible(true);
				}				
				if (Pannello.pan.matrice[array[0]][array[1]].valore == 5)
					Pannello.pan.matrice[array[2]][array[3]].valore = 5;
				else
					Pannello.pan.matrice[array[2]][array[3]].valore = 3;					
				Pannello.pan.matrice[array[0]][array[1]].valore = 1;		
				if(array[2] == 7)
					Pannello.pan.matrice[array[2]][array[3]].valore = 5;
				mangiato = false;
				pedine_mangiate = 0;
			}		
		}while(mangiato && pedine_mangiate < 4);
	}

	private static void mangiata_multipla(int x, int y, int[] array) {	
		if((Pannello.pan.matrice[x][y].valore) == 5){
			if(x < 6){
				if(y == 0)
					if(Pannello.pan.matrice[x+1][y+1].valore == 2 || Pannello.pan.matrice[x+1][y+1].valore == 4)
						if(Pannello.pan.matrice[x+2][y+2].valore == 1){
							array[0] = x;
							array[1] = y;
							array[2] = x+2;
							array[3] = y+2;
						}					
				 if(y == 7)
					if(Pannello.pan.matrice[x+1][y-1].valore ==2 || Pannello.pan.matrice[x+1][y-1].valore ==4) 
						if(Pannello.pan.matrice[x+2][y-2].valore == 1){
							array[0] = x;
							array[1] = y;
							array[2] = x+2;
							array[3] = y-2;
						}
				 if(y == 1)
					if(Pannello.pan.matrice[x+1][y+1].valore == 2 || Pannello.pan.matrice[x+1][y+1].valore == 4) 
						if(Pannello.pan.matrice[x+2][y+2].valore == 1){
							array[0] = x;
							array[1] = y;
							array[2] = x+2;
							array[3] = y+2;
						}	 
				 if(y == 6)
					if(Pannello.pan.matrice[x+1][y-1].valore == 2 || Pannello.pan.matrice[x+1][y-1].valore == 4) 
						if(Pannello.pan.matrice[x+2][y-2].valore == 1){
							array[0] = x;
							array[1] = y;
							array[2] = x+2;
							array[3] = y-2;
						}		
				if(y > 1 && y < 6){
					if(Pannello.pan.matrice[x+1][y+1].valore == 2 || Pannello.pan.matrice[x+1][y+1].valore == 4)
						if(Pannello.pan.matrice[x+2][y+2].valore == 1){
							array[0] = x;
							array[1] = y;
							array[2] = x+2;
							array[3] = y+2;
						}else;				
					else if(Pannello.pan.matrice[x+1][y-1].valore == 2 || Pannello.pan.matrice[x+1][y-1].valore == 4) 
							if(Pannello.pan.matrice[x+2][y-2].valore == 1){
									array[0] = x;
									array[1] = y;
									array[2] = x+2;
									array[3] = y-2;
							}
				}			
				//caso solo del damone
				if(y == 0)
					if(Pannello.pan.matrice[x-1][y+1].valore == 2 || Pannello.pan.matrice[x-1][y+1].valore == 4)
						if(Pannello.pan.matrice[x-2][y+2].valore == 1){
							array[0] = x;
							array[1] = y;
							array[2] = x-2;
							array[3] = y+2;
						}						
				 if(y == 7)
					if(Pannello.pan.matrice[x-1][y-1].valore == 2 || Pannello.pan.matrice[x-1][y-1].valore == 4) 
						if(Pannello.pan.matrice[x-2][y-2].valore == 1){
							array[0] = x;
							array[1] = y;
							array[2] = x-2;
							array[3] = y-2;
						}			 
				 if(y == 1)
					if(Pannello.pan.matrice[x-1][y+1].valore == 2 || Pannello.pan.matrice[x-1][y+1].valore == 4) 
						if(Pannello.pan.matrice[x-2][y+2].valore == 1){
							array[0] = x;
							array[1] = y;
							array[2] = x-2;
							array[3] = y+2;
						}			 
				 if(y == 6)
					if(Pannello.pan.matrice[x-1][y-1].valore == 2 || Pannello.pan.matrice[x-1][y-1].valore == 4) 
						if(Pannello.pan.matrice[x-2][y-2].valore == 1){
							array[0] = x;
							array[1] = y;
							array[2] = x-2;
							array[3] = y-2;
						}			
				if(y > 1 && y < 6){
					if(Pannello.pan.matrice[x-1][y+1].valore == 2 || Pannello.pan.matrice[x-1][y+1].valore == 4)
						if(Pannello.pan.matrice[x-2][y+2].valore == 1){
							array[0] = x;
							array[1] = y;
							array[2] = x-2;
							array[3] = y+2;
						}else;
					else if(Pannello.pan.matrice[x-1][y-1].valore == 2 || Pannello.pan.matrice[x-1][y-1].valore == 4) 
							if(Pannello.pan.matrice[x-2][y-2].valore == 1){
								array[0] = x;
								array[1] = y;
								array[2] = x-2;
								array[3] = y-2;
							}
				}
			}	
		}
		else{
			if(x<6){
				if(y == 0)
					if(Pannello.pan.matrice[x+1][y+1].valore == 2 || Pannello.pan.matrice[x+1][y+1].valore == 4)
						if(Pannello.pan.matrice[x+2][y+2].valore == 1){
							array[0] = x;
							array[1] = y;
							array[2] = x+2;
							array[3] = y+2;
						}						
				 if(y == 7)
					if(Pannello.pan.matrice[x+1][y-1].valore == 2 || Pannello.pan.matrice[x+1][y-1].valore == 4) 
						if(Pannello.pan.matrice[x+2][y-2].valore == 1){
							array[0] = x;
							array[1] = y;
							array[2] = x+2;
							array[3] = y-2;
						} 			 
				 if(y == 1)
					if(Pannello.pan.matrice[x+1][y+1].valore == 2 || Pannello.pan.matrice[x+1][y+1].valore == 4) 
						if(Pannello.pan.matrice[x+2][y+2].valore == 1){
							array[0] = x;
							array[1] = y;
							array[2] = x+2;
							array[3] = y+2;
						}		 
				 if(y == 6)
					if(Pannello.pan.matrice[x+1][y-1].valore == 2 || Pannello.pan.matrice[x+1][y-1].valore == 4) 
						if(Pannello.pan.matrice[x+2][y-2].valore == 1){
							array[0] = x;
							array[1] = y;
							array[2] = x+2;
							array[3] = y-2;
						}		
				if(y > 1 && y < 6){
					if(Pannello.pan.matrice[x+1][y+1].valore == 2 || Pannello.pan.matrice[x+1][y+1].valore == 4)
						if(Pannello.pan.matrice[x+2][y+2].valore ==1){
							array[0] = x;
							array[1] = y;
							array[2] = x+2;
							array[3] = y+2;
						}else;
					else if(Pannello.pan.matrice[x+1][y-1].valore == 2 || Pannello.pan.matrice[x+1][y-1].valore == 4) 
							if(Pannello.pan.matrice[x+2][y-2].valore == 1){
								array[0] = x;
								array[1] = y;
								array[2] = x+2;
								array[3] = y-2;
							}  
				}
			}
		}				
	}

	private static void spostamentoIA(int[] array) {
		boolean mossa = false;
		for(PedModel b[]: Pannello.pan.matrice)
			for(PedModel c: b)
				if(c.valore == 3 || c.valore == 5){
					if(c.getMyX() >= 6 && c.getMyY() > 0 && c.getMyY() < 7){
						if(c.valore == 3){
							if(c.getMyX() == 6){
								if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore == 1){
									array[0] = c.getMyX();
									array[1] = c.getMyY();
									array[2] = c.getMyX()+1;
									array[3] = c.getMyY()+1;
									mossa = true;
								}
								else
									if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 1){
										array[0] = c.getMyX();
										array[1] = c.getMyY();
										array[2] = c.getMyX()+1;
										array[3] = c.getMyY()-1;
										mossa = true;
									}
							}
						}
						//se è un damone ho 2 mosse in più a disposizione
						else{		
							if(c.getMyX() == 6){
								if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore == 1){
									array[0] = c.getMyX();
									array[1] = c.getMyY();
									array[2] = c.getMyX()+1;
									array[3] = c.getMyY()+1;
									mossa = true;
								}
								else
									if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 1){
										array[0] = c.getMyX();
										array[1] = c.getMyY();
										array[2] = c.getMyX()+1;
										array[3] = c.getMyY()-1;
										mossa = true;								
									}								
								if(Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore == 1){
									array[0] = c.getMyX();
									array[1] = c.getMyY();
									array[2] = c.getMyX()-1;
									array[3] = c.getMyY()+1;
									mossa = true;
								}
								else
									if(Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore == 1){
										array[0] = c.getMyX();
										array[1] = c.getMyY();
										array[2] = c.getMyX()-1;
										array[3] = c.getMyY()-1;
										mossa = true;								
									}							
							} //finisce se è sulla penultima riga
							else{ // è nell'ultima quindi vado solo indietro
								if(Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore == 1){
									array[0] = c.getMyX();
									array[1] = c.getMyY();
									array[2] = c.getMyX()-1;
									array[3] = c.getMyY()-1;
									mossa = true;									
								}
								else{
									if(Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore == 1){
										array[0] = c.getMyX();
										array[1] = c.getMyY();
										array[2] = c.getMyX()-1;
										array[3] = c.getMyY()+1;
										mossa = true;
									}
								}
							}
						}						
					}					
					else
						if(c.getMyX() < 6){
							switch(c.getMyY()){
							case 0:
								if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore == 1){
									if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()].valore == 1 || (Pannello.pan.matrice[c.getMyX()+2][c.getMyY()].valore == 3 || Pannello.pan.matrice[c.getMyX()+2][c.getMyY()].valore == 5) && (Pannello.pan.matrice[c.getMyX()+2][c.getMyY()+2].valore == 1 || (Pannello.pan.matrice[c.getMyX()+2][c.getMyY()+2].valore == 3 || Pannello.pan.matrice[c.getMyX()+2][c.getMyY()+2].valore == 5))){
										array[0] = c.getMyX();
										array[1] = c.getMyY();			
										array[2] = c.getMyX()+1;
										array[3] = c.getMyY()+1;
										mossa = true;
									}	
								}
								break;
							case 1: 
								if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore == 1 && (Pannello.pan.matrice[c.getMyX()+2][c.getMyY()+2].valore == 1 || (Pannello.pan.matrice[c.getMyX()+2][c.getMyY()+2].valore == 3 || Pannello.pan.matrice[c.getMyX()+2][c.getMyY()+2].valore == 5))){
									array[0] = c.getMyX();
									array[1] = c.getMyY();
									array[2] = c.getMyX()+1;
									array[3] = c.getMyY()+1;
									mossa = true;
								}
								else
									if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 1){
										array[0] = c.getMyX();
										array[1] = c.getMyY();
										array[2] = c.getMyX()+1;
										array[3] = c.getMyY()-1;
										mossa = true;
									}
								break;
							case 2: 
							case 3:
							case 4:
							case 5:
								if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 1){
									if((Pannello.pan.matrice[c.getMyX()+2][c.getMyY()-2].valore == 1 || (Pannello.pan.matrice[c.getMyX()+2][c.getMyY()-2].valore == 3  || Pannello.pan.matrice[c.getMyX()+2][c.getMyY()-2].valore == 5)) && (Pannello.pan.matrice[c.getMyX()+2][c.getMyY()].valore == 1 || (Pannello.pan.matrice[c.getMyX()+2][c.getMyY()].valore == 3 || Pannello.pan.matrice[c.getMyX()+2][c.getMyY()].valore == 5))){
										array[0] = c.getMyX();
										array[1] = c.getMyY();
										array[2] = c.getMyX()+1;
										array[3] = c.getMyY()-1;
										mossa = true;
									}	
									else 
										if((Pannello.pan.matrice[c.getMyX()+2][c.getMyY()].valore == 3 || Pannello.pan.matrice[c.getMyX()+2][c.getMyY()].valore == 5) && (Pannello.pan.matrice[c.getMyX()][c.getMyY()-2].valore == 3 || Pannello.pan.matrice[c.getMyX()][c.getMyY()-2].valore == 5) && (Pannello.pan.matrice[c.getMyX()+2][c.getMyY()-2].valore == 1 || (Pannello.pan.matrice[c.getMyX()+2][c.getMyY()-2].valore == 3  || Pannello.pan.matrice[c.getMyX()+2][c.getMyY()-2].valore == 5))){
											array[0] = c.getMyX();
											array[1] = c.getMyY();
											array[2] = c.getMyX()+1;
											array[3] = c.getMyY()-1;
											mossa = true;
										}
								}
								else
									if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore == 1){
										if((Pannello.pan.matrice[c.getMyX()+2][c.getMyY()].valore == 1 || (Pannello.pan.matrice[c.getMyX()+2][c.getMyY()].valore == 3 || Pannello.pan.matrice[c.getMyX()+2][c.getMyY()].valore == 5) && (Pannello.pan.matrice[c.getMyX()+2][c.getMyY()+2].valore == 1 || (Pannello.pan.matrice[c.getMyX()+2][c.getMyY()+2].valore == 3 || Pannello.pan.matrice[c.getMyX()+2][c.getMyY()+2].valore == 5)))){
											array[0] = c.getMyX();
											array[1] = c.getMyY();
											array[2] = c.getMyX()+1;
											array[3] = c.getMyY()+1;
											mossa = true;
										}	
										else 
											if((Pannello.pan.matrice[c.getMyX()+2][c.getMyY()+2].valore == 3 || Pannello.pan.matrice[c.getMyX()+2][c.getMyY()+2].valore == 5) && (Pannello.pan.matrice[c.getMyX()][c.getMyY()+2].valore == 3 || Pannello.pan.matrice[c.getMyX()][c.getMyY()+2].valore == 5) && (Pannello.pan.matrice[c.getMyX()+2][c.getMyY()+2].valore == 1 || (Pannello.pan.matrice[c.getMyX()+2][c.getMyY()+2].valore == 3 || Pannello.pan.matrice[c.getMyX()+2][c.getMyY()+2].valore == 5))){
												array[0] = c.getMyX();
												array[1] = c.getMyY();
												array[2] = c.getMyX()+1;
												array[3] = c.getMyY()+1;
												mossa = true;
											}
									}
								break;
							case 6:
								if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 1 && (Pannello.pan.matrice[c.getMyX()+2][c.getMyY()-2].valore == 1 || (Pannello.pan.matrice[c.getMyX()+2][c.getMyY()-2].valore == 3  || Pannello.pan.matrice[c.getMyX()+2][c.getMyY()-2].valore == 5))){
									array[0] = c.getMyX();
									array[1] = c.getMyY();
									array[2] = c.getMyX()+1;
									array[3] = c.getMyY()-1;
									mossa = true;
								}
								else
									if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore == 1){
										array[0] = c.getMyX();
										array[1] = c.getMyY();
										array[2] = c.getMyX()+1;
										array[3] = c.getMyY()+1;
										mossa = true;
										
									}									
								break;
							case 7: 
								if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 1){
									if((Pannello.pan.matrice[c.getMyX()+2][c.getMyY()-2].valore == 1 || (Pannello.pan.matrice[c.getMyX()+2][c.getMyY()-2].valore == 3  || Pannello.pan.matrice[c.getMyX()+2][c.getMyY()-2].valore == 5)) && (Pannello.pan.matrice[c.getMyX()+2][c.getMyY()].valore == 1 || (Pannello.pan.matrice[c.getMyX()+2][c.getMyY()].valore == 3 || Pannello.pan.matrice[c.getMyX()+2][c.getMyY()].valore == 5))){
										array[0] = c.getMyX();
										array[1] = c.getMyY();
										array[2] = c.getMyX()+1;
										array[3] = c.getMyY()-1;
										mossa = true;
									}	
								}
								break;
							default: break;	
						}						
					}else
						if(c.getMyX() == 6){ // se sei alla penultima riga puoi muovere sempre senza essere mangiato
							switch(c.getMyY()){
							case 0:
								if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore == 1){
										array[0] = c.getMyX();
										array[1] = c.getMyY();			
										array[2] = c.getMyX()+1;
										array[3] = c.getMyY()+1;
										mossa = true;	
								}
								break;
							case 1: 
							case 2: 
							case 3:
							case 4:
							case 5:
							case 6:
								if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 1){
										array[0] = c.getMyX();
										array[1] = c.getMyY();
										array[2] = c.getMyX()+1;
										array[3] = c.getMyY()-1;
										mossa = true;
									}	
									else 
									if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore == 1){
											array[0] = c.getMyX();
											array[1] = c.getMyY();
											array[2] = c.getMyX()+1;
											array[3] = c.getMyY()+1;
											mossa = true;	
									}
								break;
							case 7:
								if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 1){
										array[0] = c.getMyX();
										array[1] = c.getMyY();
										array[2] = c.getMyX()+1;
										array[3] = c.getMyY()-1;
										mossa = true;
									}	
								break;
							default: break;						
						}										
					}						
		if(!mossa)
			for(PedModel b1[]: Pannello.pan.matrice)
				for(PedModel c1: b1)
					if(c1.valore == 3 || c1.valore == 5){
						if(c1.getMyX() < 7){
							if(c1.getMyY() == 0)
								if(Pannello.pan.matrice[c1.getMyX()+1][c1.getMyY()+1].valore == 1){
									array[0] = c1.getMyX();
									array[1] = c1.getMyY();
									array[2] = c1.getMyX()+1;
									array[3] = c1.getMyY()+1;
								}
							if(c1.getMyY() == 7)
								if(Pannello.pan.matrice[c1.getMyX()+1][c1.getMyY()-1].valore == 1){
									array[0] = c1.getMyX();
									array[1] = c1.getMyY();
									array[2] = c1.getMyX()+1;
									array[3] = c1.getMyY()-1;
								}						
							if(c1.getMyY() != 0 &&  c1.getMyY() != 7)
								if(Pannello.pan.matrice[c1.getMyX()+1][c1.getMyY()-1].valore == 1){
									array[0] = c1.getMyX();
									array[1] = c1.getMyY();
									array[2] = c1.getMyX()+1;
									array[3] = c1.getMyY()-1;
								}
								else 
									if(Pannello.pan.matrice[c1.getMyX()+1][c1.getMyY()+1].valore == 1){
										array[0] = c1.getMyX();
										array[1] = c1.getMyY();
										array[2] = c1.getMyX()+1;
										array[3] = c1.getMyY()+1;
									}
						}
					}
				}
	}

	private static void possoMangiareIA(int[] array) {
		boolean mangiato_interno;
		for(PedModel b[]: Pannello.pan.matrice)
			for(PedModel c: b){
				if(c.valore == 3 || c.valore == 5){
					mangiato_interno = false;						
					if((Pannello.pan.matrice[c.getMyX()][c.getMyY()].valore) == 5){
						if (c.getMyX() < 2){
							if(c.getMyY() == 0){
								if((Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore) == 2 || Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore == 4)
									if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()+2].valore == 1){
										array[0] = c.getMyX();
										array[1] = c.getMyY();
										array[2] = c.getMyX()+2;
										array[3] = c.getMyY()+2;
									}														
							}				
							if(c.getMyY() == 7){
								if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 2 || Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 4) 
									if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()-2].valore == 1){
										array[0] = c.getMyX();
										array[1] = c.getMyY();
										array[2] = c.getMyX()+2;
										array[3] = c.getMyY()-2;
									} 
							 }							
							 if(c.getMyY() == 1){
								if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore == 2 || Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore == 4) 
									if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()+2].valore == 1){
										array[0] = c.getMyX();
										array[1] = c.getMyY();
										array[2] = c.getMyX()+2;
										array[3] = c.getMyY()+2;
									} 
							 }							 
							 if(c.getMyY() == 6 ){
								if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 2 || Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 4) 
									if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()-2].valore == 1){
										array[0] = c.getMyX();
										array[1] = c.getMyY();
										array[2] = c.getMyX()+2;
										array[3] = c.getMyY()-2;
									} 
							 }							
							if(c.getMyY() > 1 && c.getMyY() < 6){
								if((Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore) == 2 || (Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore) ==4){
									if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()+2].valore == 1){
										array[0] = c.getMyX();
										array[1] = c.getMyY();
										array[2] = c.getMyX()+2;
										array[3] = c.getMyY()+2;
									}
								}
								if((Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore) == 2 || (Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore) == 4){
									if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()-2].valore == 1){
											array[0] = c.getMyX();
											array[1] = c.getMyY();
											array[2] = c.getMyX()+2;
											array[3] = c.getMyY()-2;
										}
									}
							}
						}						 
						if(c.getMyX() > 6){
							if(getMyY() == 0){
								if((Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore == 2 || Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore == 4))
									if(Pannello.pan.matrice[c.getMyX()-2][c.getMyY()+2].valore == 1){
										array[0] = c.getMyX();
										array[1] = c.getMyY();
										array[2] = c.getMyX()-2;
										array[3] = c.getMyY()+2;
									}
												
							}				
							if(c.getMyY() == 7){
								if(Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore == 2 || Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore == 4) 
									if(Pannello.pan.matrice[c.getMyX()-2][c.getMyY()-2].valore == 1){
										array[0] = c.getMyX();
										array[1] = c.getMyY();
										array[2] = c.getMyX()-2;
										array[3] = c.getMyY()-2;
									}	
							 }							
							 if(c.getMyY() == 1){
								if(Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore == 2 || Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore == 4) 
									if(Pannello.pan.matrice[c.getMyX()-2][c.getMyY()+2].valore == 1){
										array[0] = c.getMyX();
										array[1] = c.getMyY();
										array[2] = c.getMyX()-2;
										array[3] = c.getMyY()+2;
									} 
							 }							 
							 if(c.getMyY() == 6){
								if(Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore == 2 || Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore == 4) 
									if(Pannello.pan.matrice[c.getMyX()-2][c.getMyY()-2].valore == 1){
										array[0] = c.getMyX();
										array[1] = c.getMyY();
										array[2] = c.getMyX()-2;
										array[3] = c.getMyY()-2;
									} 
							}					
							if(c.getMyY() > 1 && c.getMyY() < 6){
								if((Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore == 2 || Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore == 4)){
									if(Pannello.pan.matrice[c.getMyX()-2][c.getMyY()+2].valore == 1){
										array[0] = c.getMyX();
										array[1] = c.getMyY();
										array[2] = c.getMyX()-2;
										array[3] = c.getMyY()+2;
									} 
								
								}
								if((Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore == 2 || Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore == 4)){
									if(Pannello.pan.matrice[c.getMyX()-2][c.getMyY()-2].valore == 1){
										array[0] = c.getMyX();
										array[1] = c.getMyY();
										array[2] = c.getMyX()-2;
										array[3] = c.getMyY()-2;
									} 
									
								}
							}
						}
						if(c.getMyX() < 6 && c.getMyX() > 1){
							//primo blocco
							if(c.getMyY() == 0){
								if((Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore) == 2 || Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore == 4)
									if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()+2].valore == 1){
											array[0] = c.getMyX();
											array[1] = c.getMyY();
											array[2] = c.getMyX()+2;
											array[3] = c.getMyY()+2;
									}														
							}		
							if(c.getMyY() == 7){
								if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 2 || Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 4) 
									if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()-2].valore == 1){
											array[0] = c.getMyX();
											array[1] = c.getMyY();
											array[2] = c.getMyX()+2;
											array[3] = c.getMyY()-2;
										} 
							 }							
							 if(c.getMyY() == 1){
								if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore == 2 || Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore == 4) 
									if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()+2].valore == 1){
										array[0] = c.getMyX();
										array[1] = c.getMyY();
										array[2] = c.getMyX()+2;
										array[3] = c.getMyY()+2;
									} 
							 }							 
							 if(c.getMyY() == 6){
								if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 2 || Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 4) 
									if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()-2].valore == 1){
											array[0] = c.getMyX();
											array[1] = c.getMyY();
											array[2] = c.getMyX()+2;
											array[3] = c.getMyY()-2;
									} 
							 }							
							if(c.getMyY() > 1 && c.getMyY() < 6){
								if((Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore) == 2 || (Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore) == 4){
									if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()+2].valore == 1){
										array[0] = c.getMyX();
										array[1] = c.getMyY();
										array[2] = c.getMyX()+2;
										array[3] = c.getMyY()+2;
										mangiato_interno=true;
									}
								}
								if((Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore) == 2 || (Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore) ==4){
									if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()-2].valore == 1){
											array[0] = c.getMyX();
											array[1] = c.getMyY();
											array[2] = c.getMyX()+2;
											array[3] = c.getMyY()-2;
									}
								}
							}
							//secondo blocco
							if(getMyY() == 0){
								if((Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore== 2 || Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore== 4))
										if(Pannello.pan.matrice[c.getMyX()-2][c.getMyY()+2].valore == 1){
												array[0] = c.getMyX();
												array[1] = c.getMyY();
												array[2] = c.getMyX()-2;
												array[3] = c.getMyY()+2;
											}
												
							}				
							 if(c.getMyY() == 7){
								if(Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore == 2 || Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore== 4) 
										if(Pannello.pan.matrice[c.getMyX()-2][c.getMyY()-2].valore == 1) {
												array[0] = c.getMyX();
												array[1] = c.getMyY();
												array[2] = c.getMyX()-2;
												array[3] = c.getMyY()-2;
											} 											
							 }
							
							 if(c.getMyY() == 1){
									if(Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore==2 || Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore==4) 
											if(Pannello.pan.matrice[c.getMyX()-2][c.getMyY()+2].valore == 1) {
													array[0] = c.getMyX();
													array[1] = c.getMyY();
													array[2] = c.getMyX()-2;
													array[3] = c.getMyY()+2;
												} 
							 }
							 
							 if(c.getMyY() == 6 ) {
									if(Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore == 2 || Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore== 4) 
											if(Pannello.pan.matrice[c.getMyX()-2][c.getMyY()-2].valore == 1) {
													array[0] = c.getMyX();
													array[1] = c.getMyY();
													array[2] = c.getMyX()-2;
													array[3] = c.getMyY()-2;
												} 
							} 
							 
							
							if(c.getMyY()>1 && c.getMyY()<6){
								if((Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore== 2 || Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore== 4)){
										if(Pannello.pan.matrice[c.getMyX()-2][c.getMyY()+2].valore == 1){
												array[0] = c.getMyX();
												array[1] = c.getMyY();
												array[2] = c.getMyX()-2;
												array[3] = c.getMyY()+2;
												mangiato_interno = true;
										}											
								}
								if((Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore == 2 || Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore== 4)){
									if(Pannello.pan.matrice[c.getMyX()-2][c.getMyY()-2].valore == 1){
										array[0] = c.getMyX();
										array[1] = c.getMyY();
										array[2] = c.getMyX()-2;
										array[3] = c.getMyY()-2;
									} 										
								}
								if((Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore == 2 || Pannello.pan.matrice[c.getMyX()-1][c.getMyY()+1].valore == 4)){
									if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()+2].valore == 1){
										array[0] = c.getMyX();
										array[1] = c.getMyY();
										array[2] = c.getMyX()+2;
										array[3] = c.getMyY()+2;
										mangiato_interno = true;
									}											
								}
								if((Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 2 || Pannello.pan.matrice[c.getMyX()-1][c.getMyY()-1].valore == 4)){
									if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()-2].valore == 1){
										array[0] = c.getMyX();
										array[1] = c.getMyY();
										array[2] = c.getMyX()+2;
										array[3] = c.getMyY()-2;
									} 										
								}
							}
						}
					}					
					else{ // se è una pedina
						if(c.getMyX() < 6){
							if(c.getMyY() == 0){
								if((Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore) == 2 || (Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore) == 4)
									if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()+2].valore == 1)
										if (!((Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore) == 4)){
											array[0] = c.getMyX();
											array[1] = c.getMyY();
											array[2] = c.getMyX()+2;
											array[3] = c.getMyY()+2;
										}
										else 
											if((Pannello.pan.matrice[c.getMyX()][c.getMyY()].valore) == 5){
												array[0] = c.getMyX();
												array[1] = c.getMyY();
												array[2] = c.getMyX()+2;
												array[3] = c.getMyY()+2;
											}
													
							}				
							if(c.getMyY() == 7){
								if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 2 || Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 4) 
									if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()-2].valore == 1)
										if(!(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 4)){
											array[0] = c.getMyX();
											array[1] = c.getMyY();
											array[2] = c.getMyX()+2;
											array[3] = c.getMyY()-2;
										} 
										else
											if(Pannello.pan.matrice[c.getMyX()][c.getMyY()].valore == 5){
												array[0] = c.getMyX();
												array[1] = c.getMyY();
												array[2] = c.getMyX()+2;
												array[3] = c.getMyY()-2;
											} 
							 }							
							 if(c.getMyY() == 1){
								if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore == 2 || Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore == 4) 
									if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()+2].valore == 1)
										if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore == 2){
											array[0] = c.getMyX();
											array[1] = c.getMyY();
											array[2] = c.getMyX()+2;
											array[3] = c.getMyY()+2;
										} 
										else
											if(Pannello.pan.matrice[c.getMyX()][c.getMyY()].valore == 5){
												array[0] = c.getMyX();
												array[1] = c.getMyY();
												array[2] = c.getMyX()+2;
												array[3] = c.getMyY()+2;
											}
							 }							 
							 if(c.getMyY() == 6){
								if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore ==2 || Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore ==4) 
									if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()-2].valore == 1){
										if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 2){
											array[0] = c.getMyX();
											array[1] = c.getMyY();
											array[2] = c.getMyX()+2;
											array[3] = c.getMyY()-2;
										} 
										else
											if(Pannello.pan.matrice[c.getMyX()][c.getMyY()].valore == 5){
												array[0] = c.getMyX();
												array[1] = c.getMyY();
												array[2] = c.getMyX()+2;
												array[3] = c.getMyY()-2;
											}
									} 
							 }							
							if(c.getMyY() > 1 && c.getMyY() < 6){
								if((Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore) == 2 || (Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore) == 4){
									if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()+2].valore == 1){
										if((Pannello.pan.matrice[c.getMyX()+1][c.getMyY()+1].valore) == 2){
											array[0] = c.getMyX();
											array[1] = c.getMyY();
											array[2] = c.getMyX()+2;
											array[3] = c.getMyY()+2;
											mangiato_interno=true;
										} 
										else{
											if(Pannello.pan.matrice[c.getMyX()][c.getMyY()].valore == 5){
												array[0] = c.getMyX();
												array[1] = c.getMyY();
												array[2] = c.getMyX()+2;
												array[3] = c.getMyY()+2;
												mangiato_interno=true;
											}
										}
									}
								}
							}
							if(c.getMyX() < 6 && c.getMyY() > 1)
								if(!mangiato_interno)
									if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 2 || Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 4){
										if(Pannello.pan.matrice[c.getMyX()+2][c.getMyY()-2].valore == 1){
											if(Pannello.pan.matrice[c.getMyX()+1][c.getMyY()-1].valore == 2){
												array[0] = c.getMyX();
												array[1] = c.getMyY();
												array[2] = c.getMyX()+2;
												array[3] = c.getMyY()-2;
											} 
											else
												if(Pannello.pan.matrice[c.getMyX()][c.getMyY()].valore == 5){
													array[0] = c.getMyX();
													array[1] = c.getMyY();
													array[2] = c.getMyX()+2;
													array[3] = c.getMyY()-2;
												}
										}  
									}
							}
						}//chiusura else							
				}//chiusura se è una pedina nera	
			}//chiusura per ogni pedina			
	}//chiusura metodo

	public static int getMyX() {
		return x;
	}

	public static int getMyY() {
		return y;
	}

	public static void iniz(int x1, int y1){
		x=x1;
		y=y1;
	}

}