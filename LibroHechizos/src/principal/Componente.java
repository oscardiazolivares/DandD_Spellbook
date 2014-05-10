package principal;

/**
 * Define los cuatro tipos de componentes que puede tener un hechizo. No define
 * CADA componente en concreto (definido en la descripción del hechizo).
 * 
 * @author Oscar Diaz Olivares
 * 
 */
public enum Componente {
	VERBAL("V", "Verbal"), SOMATICO("S", "Somático"), MATERIAL("M", "Material"), FOCO(
			"F", "Foco");

	private String abreviatura;
	private String nombreSimple;

	/**
	 * @param abreviatura
	 * @param nombreSimple
	 */
	private Componente(String abreviatura, String nombreSimple) {
		this.abreviatura = abreviatura;
		this.nombreSimple = nombreSimple;
	}

	/**
	 * @return Devuelve el valor del atributo abreviatura
	 */
	public String getAbreviatura() {
		return abreviatura;
	}

	/**
	 * @return Devuelve el valor del atributo nombreSimple
	 */
	public String getNombreSimple() {
		return nombreSimple;
	}
	
	

}
