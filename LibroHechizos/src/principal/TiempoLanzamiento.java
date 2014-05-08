package principal;

public enum TiempoLanzamiento {
	ASALTO ("Asalto completo"),
	ESTANDAR ("Acción estándar"),
	RAPIDA ("Acción rápida"),
	GRATUITA ("Acción gratuíta");
	
	private String nombre;
	
	TiempoLanzamiento (String nombre) {
		this.nombre=nombre;
	}
}
