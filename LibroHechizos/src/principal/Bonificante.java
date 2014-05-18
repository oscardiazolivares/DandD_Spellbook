package principal;

/**
 * Hechizos que realizan algún cambio positivo en la ficha del personaje.
 * @author Óscar Díaz Olivares
 * @version 1.0
 */
public interface Bonificante {
	/**
	 * Método que realiza una bonificación concreta en un personaje recibido por parámetro
	 * @param pj - personaje a modificar.
	 */
	public void bonificarPersonaje(Personaje pj);
}
