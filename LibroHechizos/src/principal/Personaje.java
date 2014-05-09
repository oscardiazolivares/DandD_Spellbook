package principal;

/**
 * Clase que representa un personaje básico lanzador de conjuros e Dungeons & Dragons 3.5
 * 
 * @author Óscar Díaz Olivares
 * @version 1.0
 */
public class Personaje {

	/**
	 * Tabla de conjuros diarios para mago por nivel de lanzador. 
	 * Columnas - niveles de conjuro, del 0 al 9.
	 * Filas - nivel de lanzador
	 */
	private final int[][] CONJUROS_DIARIOS_MAGO = new int[][] {
			{ 3, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 4, 2, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 4, 2, 1, 0, 0, 0, 0, 0, 0, 0 },
			{ 4, 3, 1, 0, 0, 0, 0, 0, 0, 0 },
			{ 4, 3, 2, 1, 0, 0, 0, 0, 0, 0 },
			{ 4, 3, 3, 2, 0, 0, 0, 0, 0, 0 },
			{ 4, 4, 3, 2, 1, 0, 0, 0, 0, 0 },
			{ 4, 4, 3, 3, 2, 0, 0, 0, 0, 0 },
			{ 4, 4, 4, 3, 2, 1, 0, 0, 0, 0 },
			{ 4, 4, 4, 3, 3, 2, 0, 0, 0, 0 },
			{ 4, 4, 4, 4, 3, 2, 1, 0, 0, 0 },
			{ 4, 4, 4, 4, 3, 3, 2, 0, 0, 0 },
			{ 4, 4, 4, 4, 4, 3, 2, 1, 0, 0 },
			{ 4, 4, 4, 4, 4, 3, 3, 2, 0, 0 },
			{ 4, 4, 4, 4, 4, 4, 3, 2, 1, 0 },
			{ 4, 4, 4, 4, 4, 4, 3, 3, 2, 0 },
			{ 4, 4, 4, 4, 4, 4, 4, 3, 2, 1 },
			{ 4, 4, 4, 4, 4, 4, 4, 3, 3, 2 },
			{ 4, 4, 4, 4, 4, 4, 4, 4, 3, 3 },
			{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 }
	};
	
	/**
	 * Tabla de conjuros diarios para hechicero por nivel de lanzador. 
	 * Columnas - niveles de conjuro, del 0 al 9.
	 * Filas - nivel de lanzador
	 */
	private final int[][] CONJUROS_DIARIOS_HECHICERO = new int[][] {
			{ 5, 3, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 6, 4, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 6, 5, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 6, 6, 3, 0, 0, 0, 0, 0, 0, 0 },
			{ 6, 6, 4, 0, 0, 0, 0, 0, 0, 0 },
			{ 6, 6, 5, 3, 0, 0, 0, 0, 0, 0 },
			{ 6, 6, 6, 4, 0, 0, 0, 0, 0, 0 },
			{ 6, 6, 6, 5, 3, 0, 0, 0, 0, 0 },
			{ 6, 6, 6, 6, 4, 0, 0, 0, 0, 0 },
			{ 6, 6, 6, 6, 5, 3, 0, 0, 0, 0 },
			{ 6, 6, 6, 6, 6, 4, 0, 0, 0, 0 },
			{ 6, 6, 6, 6, 6, 5, 3, 0, 0, 0 },
			{ 6, 6, 6, 6, 6, 6, 4, 0, 0, 0 },
			{ 6, 6, 6, 6, 6, 6, 5, 3, 0, 0 },
			{ 6, 6, 6, 6, 6, 6, 6, 4, 0, 0 },
			{ 6, 6, 6, 6, 6, 6, 6, 5, 3, 0 },
			{ 6, 6, 6, 6, 6, 6, 6, 6, 4, 0 },
			{ 6, 6, 6, 6, 6, 6, 6, 6, 5, 3 },
			{ 6, 6, 6, 6, 6, 6, 6, 6, 6, 4 },
			{ 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 }
	};
	
	/**
	 * Tabla de conjuros adicionales para los lanzadores de conjuros.
	 * Columnas - niveles de conjuro, del 0 al 9.
	 * Filas - nivel de lanzador
	 */
	private final int[][] CONJUROS_ADICIONALES = new int[][] {
			{0,1,0,0,0,0,0,0,0,0},
			{0,1,1,0,0,0,0,0,0,0},
			{0,1,1,1,0,0,0,0,0,0},
			{0,1,1,1,1,0,0,0,0,0},
			{0,2,1,1,1,1,0,0,0,0},
			{0,2,2,1,1,1,1,0,0,0},
			{0,2,2,2,1,1,1,1,0,0},
			{0,2,2,2,2,1,1,1,1,0},
			{0,3,2,2,2,2,1,1,1,1},
			{0,3,3,2,2,2,2,1,1,1}
	};
	
	// Básicos
	private String nombre;
	private Raza raza;
	private Clase clase;
	private int nivel;
	private String alineamiento;

	// Atributos
	private int fuerza;
	private int destreza;
	private int constitucion;
	private int inteligencia;
	private int sabiduria;
	private int carisma;

	// Modificadores de atributos
	private int modFue;
	private int modDes;
	private int modCon;
	private int modInt;
	private int modSab;
	private int modCar;

	// Otros
	private int ca; // Clase de Armadura
	private int pg; // Puntos de golpe
	private int[] ataqueBase;

	// Conjuros diarios (número de conjuros que puede lanzar por día y nivel)
	private int[] conjurosDiarios = new int[10]; // 10 porque los niveles de conjuro van desde el n0 al n9

	public Personaje(String nombre, Raza raza, Clase clase, int[] niveles, String alineamiento, int fuerza,
			int destreza, int constitucion, int inteligencia, int sabiduria, int carisma, int ca, int pg,
			int[] ataqueBase) {

		// Asignación de valores recibidos
		setNombre(nombre);
		setRaza(raza);
		setClase(clase);
		setNivel(nivel);
		setAlineamiento(alineamiento);
		setFuerza(fuerza);
		setDestreza(destreza);
		setConstitucion(constitucion);
		setInteligencia(inteligencia);
		setSabiduria(sabiduria);
		setCarisma(carisma);
		setCa(ca);
		setPg(pg);
		setAtaqueBase(ataqueBase);

		// Asignaciones automáticas
		// Calculo de los modificadores de atributos
		setModFue(calcularModificador(fuerza));
		setModDes(calcularModificador(destreza));
		setModCon(calcularModificador(constitucion));
		setModInt(calcularModificador(inteligencia));
		setModSab(calcularModificador(sabiduria));
		setModCar(calcularModificador(carisma));
		// Calculo de los conjuros diarios según clase y nivel.
		setConjurosDiarios(calcularConjurosDiarios());
		// Calculo y suma de os conjuros adicionales.
		setConjurosDiarios(calcularConjurosAdicionales());
	}

	/**
	 * Calcula el modificador de una característica
	 * 
	 * @param base
	 *            - base de la característica a la que queremos calcular el modificador
	 * @return entero con el modificador de la característica recibida como parámetro
	 */
	private int calcularModificador(int base) {
		switch (base) {
		case 1:
			return -5;
		case 2:
		case 3:
			return -4;
		case 4:
		case 5:
			return -3;
		case 6:
		case 7:
			return -2;
		case 8:
		case 9:
			return -1;
		case 10:
		case 11:
			return 0;
		case 12:
		case 13:
			return 1;
		case 14:
		case 15:
			return 2;
		case 16:
		case 17:
			return 3;
		case 18:
		case 19:
			return 4;
		case 20:
		case 21:
			return 5;
		case 22:
		case 23:
			return 5;
		case 24:
		case 25:
			return 6;
		case 26:
		case 27:
			return 7;
		case 28:
		case 29:
			return 8;
		default:
			break;
		}
		return -6;
	}

	/**
	 * Calcula los conjuros diarios que tiene el personaje en función de su clase y nivel
	 * 
	 * @return conjurosDiarios - int[] con los conjuros diarios básicos del personaje
	 */
	private int[] calcularConjurosDiarios() {

		int[] conjurosDiarios = new int[10];
		//Crear matriz final, y sacar filas en funcion del nivel
		if (getClase() == Clase.MAGO) {
			conjurosDiarios=CONJUROS_DIARIOS_MAGO[getNivel()-1];
		} else { // Puesto que sólo hay dos clases lanzadoras de magia implementadas, si no es Mago, entonces es
				 // Hechicero y se le aplican los conj. diarios de este.
			conjurosDiarios=CONJUROS_DIARIOS_HECHICERO[getNivel()-1];
		}

		return conjurosDiarios;
	}

	/**
	 * Calcula los conjuros adiocionales que tiene un personaje en función de su clase y de la característica principal
	 * de su clase. Devuelve un array de enteros con los conjuros básicos y adicionales por día (ya sumados).
	 * 
	 * @return
	 */
	private int[] calcularConjurosAdicionales() {

		int[] auxiliar = getConjurosDiarios();
		
		if (getClase() == Clase.MAGO) { 
			//Si es un mago, sus conj. adicionales depende del modificador de su Inteligencia
			return sumaVectores(auxiliar,CONJUROS_ADICIONALES[getModInt()-1]);
		} else { 
			//Sino, es hechicero, y sus conj. adicionales depende de su modificador de Sabiduria
			return sumaVectores(auxiliar,CONJUROS_ADICIONALES[getModSab()-1]);
		}
	}
	
	/**
	 * Método que suma dos vectores de longitud 10, de valores enteros y positivos.
	 * @param v1
	 * @param v2
	 * @return
	 */
	private int[] sumaVectores(int[] v1, int[] v2) {
		
		int[] resultado = new int[10];
		
		for (int i = 0; i < v1.length; i++) {
			resultado[i]=v1[i]+v2[i];
		}
		
		return resultado;
	}

	// Getters

	/**
	 * @return Devuelve el valor del atributo nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return Devuelve el valor del atributo raza
	 */
	public Raza getRaza() {
		return raza;
	}

	/**
	 * @return Devuelve el valor del atributo clases
	 */
	public Clase getClase() {
		return clase;
	}

	/**
	 * @return Devuelve el valor del atributo niveles
	 */
	public int getNivel() {
		return nivel;
	}

	/**
	 * @return Devuelve el valor del atributo alineamiento
	 */
	public String getAlineamiento() {
		return alineamiento;
	}

	/**
	 * @return Devuelve el valor del atributo fuerza
	 */
	public int getFuerza() {
		return fuerza;
	}

	/**
	 * @return Devuelve el valor del atributo destreza
	 */
	public int getDestreza() {
		return destreza;
	}

	/**
	 * @return Devuelve el valor del atributo constitucion
	 */
	public int getConstitucion() {
		return constitucion;
	}

	/**
	 * @return Devuelve el valor del atributo inteligencia
	 */
	public int getInteligencia() {
		return inteligencia;
	}

	/**
	 * @return Devuelve el valor del atributo sabiduria
	 */
	public int getSabiduria() {
		return sabiduria;
	}

	/**
	 * @return Devuelve el valor del atributo carisma
	 */
	public int getCarisma() {
		return carisma;
	}

	/**
	 * @return Devuelve el valor del atributo modFue
	 */
	public int getModFue() {
		return modFue;
	}

	/**
	 * @return Devuelve el valor del atributo modDes
	 */
	public int getModDes() {
		return modDes;
	}

	/**
	 * @return Devuelve el valor del atributo modCon
	 */
	public int getModCon() {
		return modCon;
	}

	/**
	 * @return Devuelve el valor del atributo modInt
	 */
	public int getModInt() {
		return modInt;
	}

	/**
	 * @return Devuelve el valor del atributo modSab
	 */
	public int getModSab() {
		return modSab;
	}

	/**
	 * @return Devuelve el valor del atributo modCar
	 */
	public int getModCar() {
		return modCar;
	}

	/**
	 * @return Devuelve el valor del atributo ca
	 */
	public int getCa() {
		return ca;
	}

	/**
	 * @return Devuelve el valor del atributo pg
	 */
	public int getPg() {
		return pg;
	}

	/**
	 * @return Devuelve el valor del atributo ataqueBase
	 */
	public int[] getAtaqueBase() {
		return ataqueBase;
	}

	/**
	 * @return Devuelve el valor del atributo conjurosDiarios
	 */
	public int[] getConjurosDiarios() {
		return conjurosDiarios;
	}

	// Setters

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param raza
	 *            the raza to set
	 */
	private void setRaza(Raza raza) {
		this.raza = raza;
	}

	/**
	 * @param niveles
	 *            the niveles to set
	 */
	private void setNivel(int nivel) {
		this.nivel = nivel;
	}

	/**
	 * @param alineamiento
	 *            the alineamiento to set
	 */
	private void setAlineamiento(String alineamiento) {
		this.alineamiento = alineamiento;
	}

	/**
	 * @param fuerza
	 *            the fuerza to set
	 */
	private void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	/**
	 * @param destreza
	 *            the destreza to set
	 */
	private void setDestreza(int destreza) {
		this.destreza = destreza;
	}

	/**
	 * @param constitucion
	 *            the constitucion to set
	 */
	private void setConstitucion(int constitucion) {
		this.constitucion = constitucion;
	}

	/**
	 * @param inteligencia
	 *            the inteligencia to set
	 */
	private void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	/**
	 * @param sabiduria
	 *            the sabiduria to set
	 */
	private void setSabiduria(int sabiduria) {
		this.sabiduria = sabiduria;
	}

	/**
	 * @param carisma
	 *            the carisma to set
	 */
	private void setCarisma(int carisma) {
		this.carisma = carisma;
	}

	/**
	 * @param modFue
	 *            the modFue to set
	 */
	private void setModFue(int modFue) {
		this.modFue = modFue;
	}

	/**
	 * @param modDes
	 *            the modDes to set
	 */
	private void setModDes(int modDes) {
		this.modDes = modDes;
	}

	/**
	 * @param modCon
	 *            the modCon to set
	 */
	private void setModCon(int modCon) {
		this.modCon = modCon;
	}

	/**
	 * @param modInt
	 *            the modInt to set
	 */
	private void setModInt(int modInt) {
		this.modInt = modInt;
	}

	/**
	 * @param modSab
	 *            the modSab to set
	 */
	private void setModSab(int modSab) {
		this.modSab = modSab;
	}

	/**
	 * @param modCar
	 *            the modCar to set
	 */
	private void setModCar(int modCar) {
		this.modCar = modCar;
	}

	/**
	 * @param ca
	 *            the ca to set
	 */
	private void setCa(int ca) {
		this.ca = ca;
	}

	/**
	 * @param pg
	 *            the pg to set
	 */
	private void setPg(int pg) {
		this.pg = pg;
	}

	/**
	 * @param ataqueBase
	 *            the ataqueBase to set
	 */
	private void setAtaqueBase(int[] ataqueBase) {
		this.ataqueBase = ataqueBase;
	}

	/**
	 * @param conjurosDiarios
	 *            the conjurosDiarios to set
	 */
	private void setConjurosDiarios(int[] conjurosDiarios) {
		this.conjurosDiarios = conjurosDiarios;
	}

	/**
	 * @param clase
	 *            the clase to set
	 */
	private void setClase(Clase clase) {
		this.clase = clase;
	}
}
