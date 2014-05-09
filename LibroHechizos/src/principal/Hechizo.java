package principal;

public class Hechizo {

	/**
	 * Nombre normal del hechizo
	 */
	private String nombre;
	/**
	 * Escuela a la que pertenece el hechizo
	 */
	private Escuela escuela;
	/**
	 * Subescuela del hechizo, que depende de su escuela
	 */
	private String subescuela;
	/**
	 * Descriptor del hechizo, si lo tuviera. Puede ser de muchos tipos.
	 */
	private Descriptor descriptor;
	/**
	 * Nivel del hechizo para Magos y Hechiceros (de 0 a 9).
	 */
	private short nivelMago;
	/**
	 * Tipos de componentes del hechizo.
	 */
	private Componente[] componentes;
	/**
	 * Descripción completa del hechizo
	 */
	private String descripcion;
	/**
	 * Tipo de acción necesaria para ejecutar el sortilegio.
	 */
	private TiempoLanzamiento tiempoLanzamiento;
	/**
	 * Distancia máxima a la que puede lanzarse un conjuro.
	 */
	private Alcance alcance;
	/**
	 * Duración del conjuro
	 */
	/**
	 * @param nombre
	 * @param escuela
	 * @param subescuela
	 * @param descriptor
	 * @param nivelMago
	 * @param componentes
	 * @param descripcion
	 * @param tiempoLanzamiento
	 * @param alcance
	 */
	public Hechizo(String nombre, Escuela escuela, String subescuela,
			Descriptor descriptor, short nivelMago, Componente[] componentes,
			String descripcion, TiempoLanzamiento tiempoLanzamiento,
			Alcance alcance) {
		super();
		this.nombre = nombre;
		this.escuela = escuela;
		this.subescuela = subescuela;
		this.descriptor = descriptor;
		this.nivelMago = nivelMago;
		this.componentes = componentes;
		this.descripcion = descripcion;
		this.tiempoLanzamiento = tiempoLanzamiento;
		this.alcance = alcance;
	}
	
	public Hechizo() {}
	
	
}
