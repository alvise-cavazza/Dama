package model;

import java.awt.Color;

public class PedModel {

	private int x;
	private int y;
	public int valore;	
	public static int xcomune;
	public static int ycomune;
	
	public PedModel(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.valore = val;
	}	
	
	public int getMyX() {
		return x;
	}
	
	public int getMyY() {
		return y;
	}
	
	public int getValore() {
		return valore;
	}
	
}