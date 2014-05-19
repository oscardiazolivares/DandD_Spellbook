package principal;

/**
 * Hechizo "Vision en la oscuridad"
 * @author Óscar Díaz Olivares
 * @version 1.0
 */
public class VisionEnLaOscuridad extends Hechizo implements AlcanceDefinible, Mostrable {

	public VisionEnLaOscuridad() {
		super(
				"Visión en la oscuridad",
				Escuela.TRANSMUTACION,
				"",
				Descriptor.NINGUNO,
				2,
				new Componente[] { Componente.VERBAL, Componente.SOMATICO, Componente.MATERIAL },
				"El receptor obtiene la aptitud de poder ver hasta 60' de distancia incluso en la oscuridad total. La visión en la "
				+ "oscuridad sólo permite ver en blanco y negro, pero, por lo demás, es igual que la vista normal. Este tipo de "
				+ "visión no concede la aptitud de ver en la oscuridad mágica.",
				TiempoLanzamiento.ESTANDAR, "1 h/nivel", "Voluntad niega", "media//visionenlaoscuridad.png");
	}

	@Override
	public String mostrarResolucion() {
		String resolucion = "Ves en la oscuridad hasta 60 pies de distancia. Sólo puedes ver en blanco y negro.";
		return resolucion;
	}

	@Override
	public void setAlcance(int nivel) {
		super.alcancePies=Alcance.calcularAlcance(AlcanceEnum.TOQUE,nivel);

	}
}
