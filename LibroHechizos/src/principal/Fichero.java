package principal;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Realiza las operaciones necesarias de entrada y salida para poder guardar y recuperar personajes desde un archivo.
 * @author Óscar Díaz Olivares
 * @version 1.0
 */
public class Fichero {

	private String ruta;
	
	public Fichero(String ruta) {
		this.ruta = ruta;
	}
	
	/**
	 * Guarda en un archivo una lista de personajes
	 * 
	 * @param list
	 *            - JList con los lenguajes a almacenar en archivo
	 */
	public void guardarFichero(ArrayList<Personaje> personajes) {
		try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ruta))) {
			
			for (Iterator iterator = personajes.iterator(); iterator.hasNext();) {
				Personaje personaje = (Personaje) iterator.next();
				salida.writeObject(personaje);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Lee Personajes desde un archivo, y devuelve un ArrayList<Personaje> con todos ellos. Si no hay, devuelve un ArrayList vacío.
	 * @return
	 */
	public ArrayList<Personaje> leerFichero() {
		ArrayList<Personaje> personajes = new ArrayList<Personaje>();
		try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(ruta))) {
			while (true) {
				personajes.add((Personaje) entrada.readObject());
			}
		} catch (EOFException e) {
			// Cuando se llega al final del archivo, se devuelve el ArrayList y termina el método.
			return personajes;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return personajes;
	}
}
