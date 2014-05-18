package principal;

/**
 * Conjuro "Escudo"
 * @author Óscar Díaz Olivares
 * @version 1.0
 */
public class Escudo extends Hechizo implements AlcanceDefinible, Mostrable, Bonificante {

	public Escudo() {
		super(
				"Escudo",
				Escuela.ABJURACION,
				"",
				Descriptor.FUERZA,
				1,
				new Componente[] { Componente.VERBAL, Componente.SOMATICO },
				"Este conjuro crea un disco de fuerza, móvil e invisible, del tamaño de un escudo pavés que flota delante de ti, "
				+ "negando el efecto de los proyectiles mágicos. No puedes utilizar el escudo para obtener cobertura",
				TiempoLanzamiento.ESTANDAR, "1 min/nivel", "", "media//escudo.png");
	}

	@Override
	public void bonificarPersonaje(Personaje pj) {
		pj.setCa(pj.getCa()+4);

	}

	@Override
	public String mostrarResolucion() {
		String resolucion = "Creas un disco invisible, del tamaño de un escudo pavés, que flota ante tí, otorgándote un bonificador "
				+ "de escudo de +4 a la CA. Además niega todos los efectos del conjuro 'Proyectil mágico'.";
		return resolucion;
	}
	
	@Override
	public void setAlcance(int nivel) {
		super.alcancePies=Alcance.calcularAlcance(AlcanceEnum.PERSONAL,nivel);
		
	}

}
