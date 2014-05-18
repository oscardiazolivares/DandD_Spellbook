package principal;

/**
 * Enumración de los distintos tiempos de lanzamiento que puede tener un hechizo.
 * @author Óscar Díaz Olivares
 * @version 1.0
 */
public enum TiempoLanzamiento {
	ASALTO ("Asalto completo"),
	ESTANDAR ("Acción estándar"),
	RAPIDA ("Acción rápida"),
	GRATUITA ("Acción gratuíta");
	
	private String nombre;
	
	TiempoLanzamiento (String nombre) {
		this.nombre=nombre;
	}

	/**
	 * @return Devuelve el valor del atributo nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	
}
