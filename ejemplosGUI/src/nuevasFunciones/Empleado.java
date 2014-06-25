package nuevasFunciones;

public class Empleado {
	private int id;
	private String empleado;
	
	public Empleado(int id,String empleado)
	{
		this.id=id;
		this.empleado=empleado;
	}
	public Empleado()
	{
		
	}
	
	public String getEmpleado() {
		return empleado;
	}

	public int getId() {
		return id;
	}
	
	public String toString(){
		return empleado;
	}

}
