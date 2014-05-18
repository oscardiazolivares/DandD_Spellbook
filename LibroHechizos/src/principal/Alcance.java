package principal;

/**
 * Clase estática que define el cálculo del alcance de un hechizo dado su nivel de lanzador y su tipo de alcance
 * @author Óscar Díaz Olivares
 * @version 1.0
 */
public final class Alcance {

	/**
	 * Calcula un alcance en pies (int) dado un tipo de alcance y un nivel de lanzador (int)
	 * @see TipoAlcance
	 * @param tipoAlcance
	 * @param nivel
	 * @return alcance en pies
	 */
	public static int calcularAlcance (AlcanceEnum tipoAlcance, int nivel) {
		
		switch (tipoAlcance) {
		case CORTO:
			return alcanceCorto(nivel);
		case INTERMEDIO:
			return alcanceIntermedio(nivel);
		case LARGO:
			return alcanceLargo(nivel);
		case PERSONAL:
			return 0;
		case TOQUE:
			return 5;
		case ILIMITADO:
			return -1;
		default:
			break;
		}
		
		return nivel;
		
	}
	
	private static int alcanceCorto(int nivelLanzador) {
		int bonificador = 5*((int)nivelLanzador/2);
		return 25+bonificador;
	}
	
	private static int alcanceIntermedio(int nivelLanzador) {
		return 100+10*nivelLanzador;
	}
	
	private static int alcanceLargo(int nivelLanzador) {
		return 400+40*nivelLanzador;
	}
	
	
}
