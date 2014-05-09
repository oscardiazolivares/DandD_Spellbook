package principal;

public class BolaDeFuego extends Hechizo implements Hiriente {

	
	public BolaDeFuego (short nivelMago) {
		Escuela escuela;
		Descriptor descriptor;
		super("Bola de Fuego",escuela.EVOCACION , "",
				descriptor.FUEGO, nivelMago, Componente[] componentes,
				String descripcion, TiempoLanzamiento tiempoLanzamiento,
				Alcance alcance);
	}
	
	
	
	@Override
	public int calcularPuntosGolpe() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
