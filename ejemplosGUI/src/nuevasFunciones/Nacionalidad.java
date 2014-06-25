package nuevasFunciones;

class Nacionalidad{
	private int id;
	private String nacion;
	
	public Nacionalidad(int id,String nacion)
	{
		this.id=id;
		this.nacion=nacion;
	}
	public Nacionalidad()
	{
		
	}
	
	public String getNacion() {
		return nacion;
	}

	public int getId() {
		return id;
	}
	
	public String toString(){
		return nacion;
	}
	
}
