package principal;

public class Tirada {
	/**
	 * Matriz que representa cuantos dados y de que tipo hay que lanzar.
	 */
	private int[][] dados;
	// ejemplo -> {{2,6},{2,8},{1,4}} -> 2d6 + 2d8 + 1d4
	
	/**
	 * Entero que representa el bonificador a sumar al final de la tirada.
	 */
	private int bonificador;

	public Tirada(int[][] dados, int bonificador) {
		super();
		this.dados = dados;
		this.bonificador = bonificador;
	}

	/**
	 * Resuelve una tirada de los dados del objeto Tirada. Multiplica valores aleatorios entre 1 y el dado indicado, el
	 * número de veces necesarias (definido en el array int[][] dados).
	 * 
	 * @return entero que representa la suma de todos los lanzamientos de dados de la tirada. -1 si no se definió una matriz adecuada.
	 */
	public int resolverTirada() {
		int resultado = 0;
		
		for (int i = 0; i < dados.length; i++) {
			resultado+=tirarDados(dados[i]);
		}
		
//		if (dados.length == 2) { // Si la dimensión de las filas es diferente de 2, no es una matriz válida.
//			int aux=0;
//			for (int i = 0; i < dados.length; i++) { // ejemplo -> dados.length=3
//				for (int j = 0; j <dados[0][i]; j++) { // ejemplo -> dados[0][i]= 2, 2 y 1
//					resultado += (int)((Math.random()*dados[1][i]));
//				}
//			}
//			resultado += bonificador;
//		} else {
//			resultado = -1;
//		}
		return resultado;
	}
	
	private int tirarDados(int dado[]) {
		
		int resultado=0;
		for (int j = 0; j < dado[0]; j++) {
			resultado+=(int)Math.floor(Math.random()*dado[1]+1);
		}
		
		return resultado;
	}

	/**
	 * @return Devuelve el valor del atributo dados
	 */
	public int[][] getDados() {
		return dados;
	}

	/**
	 * @return Devuelve el valor del atributo bonificador
	 */
	public int getBonificador() {
		return bonificador;
	}

	/**
	 * @param dados
	 *            the dados to set
	 */
	private void setDados(int[][] dados) {
		this.dados = dados;
	}

	/**
	 * @param bonificador
	 *            the bonificador to set
	 */
	private void setBonificador(int bonificador) {
		this.bonificador = bonificador;
	}

}
