package nuevasFunciones;

import java.util.EventObject;

public class FormEvent extends EventObject{
	
	private String name=null;
	private String occupation=null;
	private int edad=0;
	private int tipo_empleado_id;
	private String tipoEmpleado;
	
	private String gender=null;
	private int nacionalidad_id;
	private String nacion;
	
	private int id;


	public FormEvent(Object arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	public FormEvent(Object sourse,String name, String tipoEmpleado, String nacion)
	{
		super(sourse);
		this.name = name;
		this.tipoEmpleado = tipoEmpleado;
		this.nacion = nacion;
	}
	public FormEvent(Object sourse, String name, String occupation, int edad, int tipo_empleado_id, String gender,int nacionalidad_id,int id)
	{
		super(sourse);
		this.name = name;
		this.occupation = occupation;	
		this.edad = edad;		
		this.tipo_empleado_id = tipo_empleado_id;
		this.gender = gender;
		this.nacionalidad_id = nacionalidad_id;
		this.id=id;
		
	}
	
	
	public int getNacionalidad_id() {
		return nacionalidad_id;
	}
	public void setNacionalidad_id(int nacionalidad_id) {
		this.nacionalidad_id = nacionalidad_id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getTipo_empleado_id() {
		return tipo_empleado_id;
	}
	public void setTipo_empleado_id(int tipo_empleado_id) {
		this.tipo_empleado_id = tipo_empleado_id;
	}
	public String getName() {
		return name;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public int getId() {
		return id;
	}	
	public void setId(int id) {
		this.id = id;
	}
	public String getTipoEmpleado() {
		return tipoEmpleado;
	}
	public void setTipoEmpleado(String tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}
	public String getNacion() {
		return nacion;
	}
	public void setNacion(String nacion) {
		this.nacion = nacion;
	}
	
	
	
}
