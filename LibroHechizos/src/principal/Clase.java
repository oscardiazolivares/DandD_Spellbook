package principal;

/**
 * Clase o profesión del personaje. En función de si es Mago o Hechicero, tendrá diferente número de conj. diarios para lanzar.
 * @author Óscar Díaz Olivares
 * @version 1.0
 */
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
