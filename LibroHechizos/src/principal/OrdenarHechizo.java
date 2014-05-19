package principal;

import java.util.Comparator;
/**
 * Clase de apoyo para poder ordenar los hechizos por nivel, ha ciendo uso del interfaz Comparator.
 * @author Óscar Díaz Olivares
 * @version 1.0
 */
public class OrdenarHechizo implements Comparator<Hechizo>{

	public int compare(Hechizo conj1, Hechizo conj2){
	      return conj1.getNivelHechizo() - conj2.getNivelHechizo();
	   }
}
