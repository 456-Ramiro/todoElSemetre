package nuevasFunciones;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ven extends JFrame{

	public Ven(String nombre){
		
		setSize(300,120);
		setVisible(true);
		setLocationRelativeTo(null);
		//ven.setResizable(false);;
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JPanel p = new JPanel();
		p.add(new JLabel(nombre));		
		
		JButton ok = new JButton("Aceptar");
		
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub			
				
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					setVisible(false);	
				
			}});
	
		c.add(p);	
		add(ok);
		
		
		
		
	}

}
