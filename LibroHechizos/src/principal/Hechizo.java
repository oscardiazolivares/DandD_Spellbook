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
	 * Nivel del hechizo para Magos.
	 */
	private short nivel;
	/**
	 * Descripción completa del hechizo
	 */
	private String descripcion;
}
