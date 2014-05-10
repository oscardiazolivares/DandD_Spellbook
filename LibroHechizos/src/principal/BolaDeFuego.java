package principal;

public class BolaDeFuego extends Hechizo implements Hiriente {

	public BolaDeFuego(short nivelLanzador) {
		super(
				"Bola de Fuego",
				Escuela.EVOCACION,
				"",
				Descriptor.FUEGO,
				(short)3,
				new Componente[] { Componente.VERBAL, Componente.SOMATICO, Componente.MATERIAL },
				"Un conjuro de Bola de fuego es una explosión de llamas que detona con un estampido grave e inflige 1d6 puntos de daño por nivel de lanzador (máximo 10d6)",
				TiempoLanzamiento.ESTANDAR, new Alcance(), "Instantánea", "Reflejos mitad", nivelLanzador);
		super.alcance.alcanceLargo(nivelLanzador);
	}

	@Override
	public int calcularPuntosGolpe() {
		
		//Crea la matriz que representa la tirada de dados (ver clase "Tirada"). En este caso, 1d6 x nivel, max 10d6.
		int[][] matrizTirada;
		if (super.nivelDelLanzador<10) {
			matrizTirada = new int[][] {{super.nivelDelLanzador},{6}};
		} else {
			matrizTirada = new int[][] {{10},{6}};
		}
		//Crea una tirada
		Tirada tirada = new Tirada(matrizTirada,0);
		//Resuelve la tirada
		return tirada.resolverTirada();
	}

}
