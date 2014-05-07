package principal;

/**
 * Representa las escuelas de magia que existen. Una escuela es un grupo de sortilegios relacionados entre sí que funcionan de forma parecida.
 * @author Oscar Diaz Olivares
 *
 */
public enum Escuela {
	ABJURACION ("Abjuración", "Conjuros protectores. Crean barreras, niegan aptitudes, inflingen daño a intrusos o destierran extraplanarios", new String[]{}), 
	ADIVINACION ("Adivinación", "Conjuros que permiten predecir el futuro, encontrar cosas ocultas y frustar intentos de engaño", new String[]{"Escudriñamiento"}),
	CONJURACION ("Conjuración", "Conjuros que traen manifestaciones de otro plano, ya sean monstruos, objetos o energías", new String[]{"Convocación","Creación","Curación","Llamada","Teleportación"}),
	ENCANTAMIENTO ("Encantamiento", "Conjuros que afectan a las mentes de los demás influyendo en su comportamiento", new String[]{"Compulsión","Hechizo"}),
	EVOCACION ("Evocación", "Conjuros que manipulan la energía, creando algo 'de la nada'", new String[]{}),
	ILUSION ("Ilusión", "Conjuros que engañan los sentidos o las mentes de los demás", new String[]{"Engaño","Fantasmagoría","Pauta","Quimera","Sombra"}),
	NIGROMANCIA ("Nigromancia", "Conjuros que manipulan el poder de la muerte y la vida, generalmente relacionados con muertos vivientes", new String[]{}), 
	TRANSMUTACION ("Transmutación", "Conjuros que cambias las propiedades de criaturas, cosas o condiciones", new String[]{}), 
	UNIVERSAL ("Universal", "Conjuros que no pertenecen a ninguna escuela", new String[]{});
	
	private String nombre;
	private String descripcion;
	private String[] subescuelas;
	//private String subescuela; => ESTO PERTENECE AL HECHIZO CONCRETO

	Escuela(String nombre, String descripcion, String[] subescuelas) {
		setNombre(nombre);
		setDescripcion(descripcion);
		setSubescuelas(subescuelas);
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String[] getSubescuelas() {
		return subescuelas;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	private void setSubescuelas(String[] subescuelas) {
		this.subescuelas = subescuelas;
	}
}