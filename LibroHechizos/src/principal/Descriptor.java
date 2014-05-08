package principal;

public enum Descriptor {
	ACIDO ("Ácido"),
	AGUA ("Agua"),
	AIRE ("Aire"),
	BUENO ("Bueno"),
	CAOTICO ("Caótico"),
	ELECTRICIDAD ("Electricidad"),
	ENAJENADOR ("Enajenador"),
	FRIO ("Frío"),
	FUEGO ("Fuego"),
	FUERZA ("Fuerza"),
	DEPENDIENTE_DEL_IDIOMA ("Dependiente del idioma"),
	LEGAL ("Legal"),
	LUZ ("Luz"),
	MALIGNO ("Maligno"),
	MIEDO ("Miedo"),
	MUERTE ("Muerte"),
	OSCURIDAD ("Oscuridad"),
	SONICO ("Sónico"),
	TIERRA ("Tierra");
	
	private String nombre;
	
	Descriptor(String nombre) {
		this.nombre=nombre;
	}
	
}
