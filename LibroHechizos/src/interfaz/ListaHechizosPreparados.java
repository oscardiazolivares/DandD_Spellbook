package interfaz;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import principal.Hechizo;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class ListaHechizosPreparados extends JInternalFrame {

	private JList<Hechizo> list = new JList<Hechizo>();
	private DefaultListModel<Hechizo> conjuros = new DefaultListModel<Hechizo>();
	
	/**
	 * Create the frame.
	 * @param desktopPane 
	 */
	public ListaHechizosPreparados(ArrayList<Hechizo> conjurosPreparados, final JDesktopPane desktopPane) {
		setClosable(true);
		setTitle("Conjuros preparados");
		setBounds(100, 100, 227, 385);
		getContentPane().setLayout(null);
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(12, 12, 193, 328);
		getContentPane().add(list);
		
		//Crea un listModel con los hechizos recibidos
		for (Iterator iterator = conjurosPreparados.iterator(); iterator.hasNext();) {
			Hechizo hechizo = (Hechizo) iterator.next();
			conjuros.addElement(hechizo);
		}
		//Asigna el model al JList
		list.setModel(conjuros);

		//Al seleccionar un hechizo
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				DetalleHechizo dtHechizo = new DetalleHechizo(list.getSelectedValue());
				dtHechizo.setVisible(true);
				desktopPane.add(dtHechizo);
				try {
					dtHechizo.setSelected(true);
				} catch (java.beans.PropertyVetoException e) {
				}
			}
		});
	}
}
