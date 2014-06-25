package javaProyectos.uabcs;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	private JButton btn;
	private TextPanel textPanel;
	private Toolbar toolbar;
	
	public MainFrame() 
	{
		super("Calculadora");		
		setLayout(new BorderLayout());
		
		toolbar = new Toolbar();		
		textPanel = new TextPanel();		
		
		
		toolbar.setStringListener(new StringListener(){

			public void textEmitted(String text) {
				// TODO Auto-generated method stub
				//aqui se agrega el texto al panel :D
				textPanel.appendText(text);
			}			
		});				
		add(textPanel, BorderLayout.NORTH);		
		add(toolbar, BorderLayout.CENTER);		
		
		setSize(300,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		this.setResizable(false);
		//ajusta la ventana ahicia el centro
		this.setLocationRelativeTo(null);
		
	}
}

