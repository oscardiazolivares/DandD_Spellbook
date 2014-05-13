package principal;

public enum Clase {
	MAGO ("Mago"), 
	HECHICERO ("Hechicero");
	
	private String nombre;
	
	Clase(String nombre) {
		this.nombre=nombre;
	}

	/**
	 * @return Devuelve el valor del atributo nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	
}
