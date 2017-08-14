package view;

public class Damone extends PedView {

	public Damone(int x, int y, boolean c) {
		super(x, y, c);
		if(c)
			setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dwhite.png")));
		else setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dblack.png")));
	}

}