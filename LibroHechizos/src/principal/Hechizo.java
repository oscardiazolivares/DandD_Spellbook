package principal;

public class Hechizo implements AlcanceDefinible{

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
	private int nivelHechizo;
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
	protected int alcancePies;
	/**
	 * Duración del conjuro
	 */
	private String duracion;
	/**
	 * Define el tipo de Tirada de Salvación y qué ocurre al pasarla
	 */
	private String ts;
	/**
	 * Nivel de clase del personaje que lanza el conjuro
	 */
	protected int nivelDelLanzador;
	

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
			Descriptor descriptor, int nivelConjuro, Componente[] componentes,
			String descripcion, TiempoLanzamiento tiempoLanzamiento, String duracion, String ts) {
		super();
		this.nombre = nombre;
		this.escuela = escuela;
		this.subescuela = subescuela;
		this.descriptor = descriptor;
		this.nivelHechizo = nivelConjuro;
		this.componentes = componentes;
		this.descripcion = descripcion;
		this.tiempoLanzamiento = tiempoLanzamiento;
		this.duracion=duracion;
		this.ts=ts;
		//this.nivelDelLanzador=nivel;
	}

	/**
	 * @return Devuelve el valor del atributo nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return Devuelve el valor del atributo escuela
	 */
	public Escuela getEscuela() {
		return escuela;
	}

	/**
	 * @return Devuelve el valor del atributo subescuela
	 */
	public String getSubescuela() {
		return subescuela;
	}

	/**
	 * @return Devuelve el valor del atributo descriptor
	 */
	public Descriptor getDescriptor() {
		return descriptor;
	}

	/**
	 * @return Devuelve el valor del atributo nivelMago
	 */
	public int getNivelHechizo() {
		return nivelHechizo;
	}

	/**
	 * @return Devuelve el valor del atributo componentes
	 */
	public Componente[] getComponentes() {
		return componentes;
	}

	/**
	 * @return Devuelve el valor del atributo descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @return Devuelve el valor del atributo tiempoLanzamiento
	 */
	public TiempoLanzamiento getTiempoLanzamiento() {
		return tiempoLanzamiento;
	}

	/**
	 * @return Devuelve el valor del atributo alcance
	 */
	public int getAlcance() {
		return alcancePies;
	}

	/**
	 * @return Devuelve el valor del atributo duracion
	 */
	public String getDuracion() {
		return duracion;
	}

	/**
	 * @return Devuelve el valor del atributo nivelDelLanzador
	 */
	public int getNivelDelLanzador() {
		return nivelDelLanzador;
	}

	/**
	 * @return Devuelve el valor del atributo ts
	 */
	public String getTs() {
		return ts;
	}

	public void setNivelDelLanzador(int nivelDelLanzador) {
		this.nivelDelLanzador = nivelDelLanzador;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return nombre + " [" + nivelHechizo + "]";
	}

	@Override
	public void setAlcance(int nivel) {
		// TODO Auto-generated method stub
		
	}
	
}
