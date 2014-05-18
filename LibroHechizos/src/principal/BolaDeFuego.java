package principal;

public class BolaDeFuego extends Hechizo implements Hiriente, Mostrable, AlcanceDefinible{

	public BolaDeFuego() {
		super(
				"Bola de Fuego",
				Escuela.EVOCACION,
				"",
				Descriptor.FUEGO,
				(short) 3,
				new Componente[] { Componente.VERBAL, Componente.SOMATICO, Componente.MATERIAL },
				"Un conjuro de Bola de fuego es una explosión de llamas que detona con un estampido grave e inflige 1d6 puntos de daño por "
				+ "nivel de lanzador (máximo 10d6)",
				TiempoLanzamiento.ESTANDAR, "Instantánea", "Reflejos mitad");
		//super.alcance.alcanceLargo(nivelLanzador);
	}
	@Override
	public int calcularPuntosGolpe() {

		// Crea la matriz que representa la tirada de dados (ver clase "Tirada"). En este caso, 1d6 x nivel, max 10d6.
		int[][] matrizTirada;
		if (super.nivelDelLanzador < 10) {
			matrizTirada = new int[][] {{super.nivelDelLanzador, 6},{0,0}};
		} else {
			matrizTirada = new int[][] {{10,6},{0,0}};
		}
		// Crea una tirada
		Tirada tirada = new Tirada(matrizTirada, 0);
		// Resuelve la tirada
		return tirada.resolverTirada();
	}

	@Override
	public String mostrarResolucion() {
		String resultado = "La Bola de fuego explota provocando " + calcularPuntosGolpe()
				+ "PG a todas las criaturas situadas en un radio de 20' de la explosión.";
		return resultado;
	}
	
	@Override
	public void setAlcance(int nivel) {
		super.alcancePies=Alcance.calcularAlcance(AlcanceEnum.LARGO,nivel);
		
	}
}
