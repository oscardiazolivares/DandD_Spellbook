package principal;

public class Hechizo {

	/**
	 * Nombre normal del hechizo
	 */
	private String nombre;
	//Prueba
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
	private String descriptor; //fuego, sónico, enajenador...
	/**
	 * Nivel del hechizo para Magos y Hechiceros (de 0 a 9).
	 */
	private short nivelMago;
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
	private Distancia distMax;
	/**
	 * Duración del conjuro
	 */
	private Duracion duracion;
}
