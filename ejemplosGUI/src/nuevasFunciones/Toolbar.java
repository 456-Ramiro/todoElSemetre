package nuevasFunciones;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener {
	private JButton eliminar;	
	private JButton actualizar;	
	private JButton desplegarList;
	private StringListener textListener;
	private FormArrayListener arrayListener;
	private ArrayList <FormEvent>myList;
	private int accion=0;	
	

	public Toolbar() {
		eliminar = new JButton("Eliminar");
		actualizar = new JButton("Actualizar");
		desplegarList = new JButton("DesplegarLista");
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		eliminar.addActionListener(this);
		actualizar.addActionListener(this);
		desplegarList.addActionListener(this);	
		
		add(desplegarList);
		//add(actualizar);
		//add(eliminar);
		

	}
	
	public void setMyList(ArrayList<FormEvent> myList) {
		this.myList = myList;
	}
 // se crea este set para hacer referencia
	public void setArrayListener(FormArrayListener arrayListener) {
		this.arrayListener = arrayListener;
	}

	public void setStringListener(StringListener Listener) {
		this.textListener = Listener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//permite saber que boton se clickeo
		JButton clicked = (JButton)e.getSource();
		if(clicked == eliminar){						
			if(textListener != null){
				textListener.textEmitted("Eliminar\n");	
				
			}
			
		}
		else if(clicked == actualizar){
			//textPanel.appendText("goodbyeButton\n");	
			if(textListener != null){
				textListener.textEmitted("Actualizar\n");
				
			}
		}
		if(clicked == desplegarList)
		{			
			if(arrayListener != null){
				arrayListener.arrayEmiteed(myList);
			
			}
				
		}
		
	}

	public int getAccion() {
		return accion;
	}	
	
	
}

