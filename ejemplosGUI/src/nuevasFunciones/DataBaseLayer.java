package nuevasFunciones;
	
	import java.awt.Container;
	import java.awt.FlowLayout;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	
	
	//buscar libro clean code, leer
	
	//investigar como se utiliza, como se escribe Left Join
	
	//practicar en consola
	
	//crear un nuevo boton
	
	//nombre tipo nacionalidad todo esto Left join
	
	// tambien investigar Riglit join
	
	
	
	
	public class DataBaseLayer {
	private String sql;
	private Connection conn;
	private Statement stm;
	//va a trater los registro de la base de datos
	private ResultSet rs;

	ArrayList<FormEvent> lista=new ArrayList<FormEvent>();
	
	
	
	private String server = "localhost";
	private String db = "progra3";
	private String user = "root";
	private String pwd = "1994_1994Ramiro";
		
		public DataBaseLayer()
		{
		try {
				Class.forName("com.mysql.jdbc.Driver");//paquetes
				conn = DriverManager.getConnection("jdbc:mysql://"+server+"/"+db,user,pwd);//adeonde conectar
				
				stm = conn.createStatement();
				/*
				if(conn!=null)
				{
					System.out.println("conexion establecida");
				}
				else
				{
					System.out.println("fallo conexion");
				}*/
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();//importe de libreria
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("fallo");
				e.printStackTrace();
			}
			
		}
		public boolean isConnercted(){
			
			try {
				return !conn.isClosed();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}		
		}
		public void queryExec(String sql){
			try {			
				stm.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Ven venn = new Ven("La informacion fue guardada correctamente");
		}
		private Container getContentPane() {
			// TODO Auto-generated method stub
			return null;
		}
		public ArrayList<FormEvent> resultQueryExec(String sql)
		{	
			ArrayList<FormEvent> lista=new ArrayList<FormEvent>();
			try {
				rs = stm.executeQuery(sql);	
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
			try {	
				
				while(rs.next()){		
					//indica la columna de la llave primaria
					//int id=Integer.parseInt(rs.getString(1)); 					
					
					FormEvent item = new FormEvent(this);
					
					item.setTipoEmpleado(rs.getString("tipo"));
					item.setNacion(rs.getString("nacion"));
					item.setName(rs.getString("nombre"));
					
					
					lista.add(item);
					
				
					
					/*
					item.setId(rs.getInt("id"));
					item.setTipo_empleado_id(rs.getInt("tipo_empleado_id"));
					item.setName(rs.getString("nombre"));
					item.setOccupation(rs.getString("ocupacion"));
					item.setEdad(rs.getInt("edad"));
					item.setGender(rs.getString("genero"));
					item.setNacionalidad_id(rs.getInt("nacionalidad_id"));
					
					lista.add(item);			
					*/
					
					
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			return lista;
		}
		public ArrayList<Nacionalidad> resultQueryExecNacion()
		{		
			ArrayList<Nacionalidad> lista=new ArrayList<Nacionalidad>();
			try {
				rs = stm.executeQuery("select * from nacionalidad");				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
			try {	
				
				while(rs.next()){							
											
					lista.add(new Nacionalidad(rs.getInt("id"),rs.getString("nacion")));					
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			return lista;
		}	
		public ArrayList<Empleado> resultQueryExecEmpleado()
		{	
			ArrayList<Empleado> lista=new ArrayList<Empleado>();
			try {
				rs = stm.executeQuery("select * from tipo_empleado");				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
			try {	
				
				while(rs.next()){							
											
					lista.add(new Empleado(rs.getInt("id"),rs.getString("tipo")));					
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			return lista;
		}	
		
		
		//con este metodo se elimina un registro completo
		public void delete(int id)
		{
			try {
				stm.executeUpdate("delete from trabajador where id='"+id+"'");				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Ven venn = new Ven("Su registro ha sido borrado correctamente");
		}
		public void update(int id,int contrato, String nombre, String ocupacion, int edad, String genero, int nacionalidad)
		{
			try {
				stm.executeUpdate("update trabajador set nombre = '"+nombre+"' where id='"+id+"'");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
	
	}
	
