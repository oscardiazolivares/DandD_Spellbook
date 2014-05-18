package principal;

/**
 * Hechizo "Toque vampírico". Este hechizo es tanto Hiriente como Bonificante.
 * @author Óscar Díaz Olivares
 * @version 1.0
 */
public class ToqueVampirico extends Hechizo implements AlcanceDefinible, Bonificante, Mostrable, Hiriente {

	/**
	 * Este campo representa el valor de la última tirada realizada de este hechizo. Sirve para que
	 * bonificarPersonaje(Personaje pj) asigne el mismo valor de PG adicionales que la tirada de daño de la resolución
	 * del hechizo. 0 si no se ha realizado ninguna.
	 */
	private int ultimaTirada=0;
	
	public ToqueVampirico() {
		super(
				"Toque vampírico",
				Escuela.NIGROMANCIA,
				"",
				Descriptor.NINGUNO,
				3,
				new Componente[] { Componente.VERBAL, Componente.SOMATICO },
				"Teniendo éxito en un ataque de toque cuerpo a cuerpo, inflinge 1d6 puntos de daño por cada 2 niveles de lanzados "
				+ "(máximo 10d6). Además, obtendrás tantos puntos de golpe adicionales como daño causes de esta manera. Estos puntos "
				+ "de golpe temporales desaparecerán en 1 hora.",
				TiempoLanzamiento.ESTANDAR, "1h / nivel", "Voluntad niega", "media\\toquevampirico.png");
	}

	@Override
	public int calcularPuntosGolpe() {

		// Crea la matriz que representa la tirada de dados (ver clase "Tirada"). En este caso, 1d6 x  cada 2 niveles, max 10d6.
		int[][] matrizTirada;
		if (super.nivelDelLanzador < 20) {
			matrizTirada = new int[][] {{(int)(super.nivelDelLanzador/2), 6},{0,0}};
		} else {
			matrizTirada = new int[][] {{10,6},{0,0}};
		}
		Tirada tirada = new Tirada(matrizTirada, 0);
		ultimaTirada = tirada.resolverTirada();
		return ultimaTirada;
	}

	@Override
	public String mostrarResolucion() {
		String resolucion = "Si tienes éxito en el ataque de toque, inflinge " + calcularPuntosGolpe() + "puntos de daño, y tu ganas"
				+ " esos mismos puntos de golpe temporales, que desaparecerán en 1 hora.";
		
		return resolucion;
	}

	@Override
	public void bonificarPersonaje(Personaje pj) {
		pj.setPg(pj.getPg()+ultimaTirada);

	}

	@Override
	public void setAlcance(int nivel) {
		super.alcancePies=Alcance.calcularAlcance(AlcanceEnum.TOQUE,nivel);

	}

}
