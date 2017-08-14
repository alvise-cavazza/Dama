package model;

public class Cas {
	
	public static int x;
	public static int y;
	private boolean mangiato;
	private int pedine_mangiate;

	public Cas(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getMyX() {
		return x;
	}
	
	public int getMyY() {
		return y;
	}

}