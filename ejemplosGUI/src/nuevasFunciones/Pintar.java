package nuevasFunciones;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;


class Pantalla extends JFrame{
	
	public Pantalla()
	{
		this.setSize(400,400);
		this.setVisible(true);
	}
	public void paint(Graphics g){
		g.setColor(Color.RED);
		g.drawLine(50,50,300,300);
		
	}
	
	
}

public class Pintar {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Pantalla p = new Pantalla();
	}

}
