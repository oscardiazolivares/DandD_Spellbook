package principal;

/**
 * Hechizo "Rayo de debilitamiento"
 * @author Óscar Díaz Olivares
 * @version 1.0
 */
public class RayoDeDebilitamiento extends Hechizo implements Hiriente, Mostrable, AlcanceDefinible{

	public RayoDeDebilitamiento() {
		super(
				"Rayo de debilitamiento",
				Escuela.NIGROMANCIA,
				"",
				Descriptor.NINGUNO,
				1,
				new Componente[] { Componente.VERBAL, Componente.SOMATICO },
				"De tu mano surge un rayo de gran fulgor con el que podrás alcanzar a un oponente si tienes éxito en un ataque de toque a "
				+ "distancia. El receptor sufrirá una penalización en su puntuación de Fuerza igual a 1d6+1 por cada dos nmiveles de lanzador"
				+ " (max 1d6+5). La Fuerza del receptor no puede quedar reducida por debajo de 1.",
				TiempoLanzamiento.ESTANDAR, "1 min/nivel", "Ninguna", "media\\rayodedebilitamiento.png");
	}

	@Override
	public int calcularPuntosGolpe() {
		int[][] matrizTirada = new int[][] {{1, 6},{0,0}};
		int bonificador;
		if (super.nivelDelLanzador>10) {
			bonificador=5;
		} else {
			bonificador = (int) Math.floor(nivelDelLanzador/2);
		}
		Tirada tirada = new Tirada(matrizTirada, bonificador);
		
		return tirada.resolverTirada();
	}

	@Override
	public String mostrarResolucion() {
		String resultado = "Un rayo de un intenso fulgor verde sale de tu mano, alcanzando al objetivo y provocándole " + calcularPuntosGolpe()
				+ "puntos de daño a la Fuerza (no puede reducirse a menos de 1).";
		return resultado;
	}
	
	@Override
	public void setAlcance(int nivel) {
		super.alcancePies=Alcance.calcularAlcance(AlcanceEnum.CORTO,nivel);
		
	}

}
