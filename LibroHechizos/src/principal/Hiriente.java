package principal;

/**
 * Hechizos que realizan añgún tipo de daño, ya sean puntos de golpe o puntos de daño a características.
 * @author Óscar Díaz Olivares
 * @version 1.0
 */
public interface Hiriente {
/**
 * Calcula los puntos de daño que hace el hechizo hiriente
 * @return entero con los puntos de daño causados
 */
	public int calcularPuntosGolpe();
}
