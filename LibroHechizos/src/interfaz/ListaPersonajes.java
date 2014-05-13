package interfaz;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JList;

import principal.Personaje;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class ListaPersonajes extends JInternalFrame {

	private JList<Personaje> list = new JList<Personaje>();
	private DefaultListModel<Personaje> modelPersonajes = new DefaultListModel<Personaje>();
	
	/**
	 * Create the frame.
	 * @param desktopPane 
	 */
	public ListaPersonajes(ArrayList<Personaje> personajes, final JDesktopPane desktopPane) {
		setClosable(true);
		setTitle("Lista de personajes");
		setBounds(100, 100, 255, 300);
		getContentPane().setLayout(null);
		
		list.setBounds(12, 12, 223, 243);
		getContentPane().add(list);
		
		//Carga listModel
		Personaje personajeAux;
		for (Iterator iterator = personajes.iterator(); iterator.hasNext();) {
			personajeAux = (Personaje) iterator.next();
			modelPersonajes.addElement(personajeAux);
		}
		
		list.setModel(modelPersonajes);
		
		//Selección de un personaje
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				DetallePersonaje detallePj = new DetallePersonaje(list.getSelectedValue());
//				ListaHechizosPreparados listaHechizos = new ListaHechizosPreparados(list.getSelectedValue().getConjurosPreparados(), desktopPane);
				detallePj.setVisible(true);
				desktopPane.add(detallePj);
				try {
					detallePj.setSelected(true);
				} catch (java.beans.PropertyVetoException e) {
				}
			}
		});

	}

}
