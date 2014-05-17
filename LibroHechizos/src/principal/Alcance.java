package principal;

public final class Alcance {

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
