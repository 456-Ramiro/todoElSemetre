package nuevasFunciones;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class MainFrame extends JFrame {
	
	private JButton btn;
	private TextPanel textPanel;
	private Toolbar toolbar;
	private FormPanel formPanel;	
	
	
	// se crea la instancia de la base de datos
	private DataBaseLayer dbl;
	
	
	private ArrayList<FormEvent> lista; 
	
	public MainFrame() {
		super("Hello World");		
		setLayout(new BorderLayout());
		
		toolbar = new Toolbar();
		btn = new JButton("Clickeame");
		textPanel = new TextPanel();
		formPanel = new FormPanel();
		lista = new ArrayList <FormEvent>();	
		
		dbl =new DataBaseLayer();
		
		
		//dbl.delete(formPanel.getId());
		
		//dbl.update();	
			
		/*
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPanel.appendText("Hello\n");
			}		
		});*/
		
		//este mandan una cadena
		toolbar.setStringListener(new StringListener(){

			@Override
			public void textEmitted(String text) {
				// TODO Auto-generated method stub	
				textPanel.appendText(text);
			}			
		});
		toolbar.setArrayListener(new FormArrayListener(){

			@Override
			public void arrayEmiteed(ArrayList<FormEvent> Lista) {
				// TODO Auto-generated method stub
				//actualiza antes de desplegar
				
				if(dbl.isConnercted()){
					
					//ArrayList<FormEvent> list = dbl.resultQueryExec("select * from trabajador");
					ArrayList<FormEvent> list = dbl.resultQueryExec("select a.nombre, c.tipo, b.nacion from trabajador a " +
																	"inner join nacionalidad b inner join tipo_empleado c " +
																	"where a.nacionalidad_id=b.id  and c.id=a.tipo_empleado_id ");
					
					/*for(FormEvent f: list){
						textPanel.appendText("ID: "+f.getId()+"\n"+"Nombre: "+f.getName()+"\n"+"Ocupacion: "+f.getOccupation()+"\n"+
						"Edad: "+f.getEdad()+"\n"+"Categoria: "+f.getTipo_empleado_id()+"\n"+"Sexo: "+f.getGender()+"\n"+
						"Nacionalidad: "+f.getNacionalidad_id()+"\n"+"**********************************************"+"\n");				
					}*/
					for(FormEvent f: list){
						textPanel.appendText("Nombre: "+f.getName()+"\n"+"Categoria: "+f.getTipoEmpleado()+"\n"+"Nacionalidad: "+f.getNacion()+"\n"+"**********************************************"+"\n");
					
					 }
					}
			}});
		toolbar.setMyList(lista);	
		
		
		formPanel.setFormListener(new FormListener(){

			@Override
			public void forEventOcurre(FormEvent e) {
				// TODO Auto-generated method stub
				
					lista.add(e);				
					
					if(	dbl.isConnercted()){
						
						String sql="INSERT INTO trabajador" + "(tipo_empleado_id,nombre,ocupacion,edad,genero,nacionalidad_id)"+
							"VAlUES('" +e.getTipo_empleado_id()+"','"+e.getName()+"','"+e.getOccupation()+"','"+e.getEdad()+"','"+e.getGender()+"','"+e.getNacionalidad_id()+"')";
						dbl.queryExec(sql);	
					}		
			}});		
		
		add(formPanel,BorderLayout.WEST);
		add(toolbar, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);
		//add(btn, BorderLayout.SOUTH);		
		
		
		setSize(800, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		this.setTitle("Formulario");
		
		
		
		
	}
}


