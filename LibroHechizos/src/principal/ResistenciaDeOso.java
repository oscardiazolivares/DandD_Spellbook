package principal;

public class ResistenciaDeOso extends Hechizo implements Bonificante, Mostrable, AlcanceDefinible {

	/**
	 * 
	 */
	public ResistenciaDeOso() {
		super(
				"Resistencia de oso",
				Escuela.TRANSMUTACION,
				"",
				Descriptor.NINGUNO,
				2,
				new Componente[] { Componente.VERBAL, Componente.SOMATICO, Componente.FOCO },
				"La criatura afectada obtiene mayor vitalidad y resistencia física. El conjuro concede al receptor un bonificador +4 de mejora a la Constitución.",
				TiempoLanzamiento.ESTANDAR, "1 min/nivel", "Voluntad niega", "media\\resistenciadeoso.png");

	}

	@Override
	public String mostrarResolucion() {
		String resultado = "Obtienes la vitalidad de un gran oso, aumentando temporalmente tus puntos de Constitución en +4. Además, gracias a esto, tus puntos de golpe aumentarán +2PG /nivel.";
		return resultado;
	}

	@Override
	public void bonificarPersonaje(Personaje pj) {
		pj.setConstitucion(pj.getConstitucion()+4);
		pj.setPg(pj.getPg()+(2*pj.getNivel()));

	}
	
	@Override
	public void setAlcance(int nivel) {
		super.alcancePies=Alcance.calcularAlcance(AlcanceEnum.TOQUE,nivel);
		
	}

}
