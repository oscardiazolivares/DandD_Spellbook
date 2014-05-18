package principal;

public class ArmaduraDeMago extends Hechizo implements Bonificante, Mostrable, AlcanceDefinible{

	public ArmaduraDeMago() {
		super(
				"Armadura de mago",
				Escuela.CONJURACION,
				Escuela.CONJURACION.getSubescuelas()[1],
				Descriptor.FUERZA,
				1,
				new Componente[] { Componente.VERBAL, Componente.SOMATICO, Componente.FOCO },
				"Un campo de fuerza invisible, pero tangible, rodea al receptor proporcionándole un bonificador de +4 de armadura a la "
				+ "CA. Al contrario que la armadura mundana, la de este conjuro no impone penalizador de armadura.",
				TiempoLanzamiento.ESTANDAR, "1h / nivel", "Voluntad niega", "media\\armadurademago.png");
	}

	@Override
	public String mostrarResolucion() {
		String resultado = "Te rodea un campo de fuerza invisible pero tangible que te otorga +4 de armadura a la Clase de armadura.";
		return resultado;
	}
	
	@Override
	public void setAlcance(int nivel) {
		super.alcancePies=Alcance.calcularAlcance(AlcanceEnum.TOQUE,nivel);
		
	}
	
	@Override
	public void bonificarPersonaje(Personaje pj) {
		pj.setCa(pj.getCa()+4);
	}
}
