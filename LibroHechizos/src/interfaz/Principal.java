package interfaz;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.UIManager;

import principal.BolaDeFuego;
import principal.Clase;
import principal.Hechizo;
import principal.Personaje;
import principal.Raza;

import javax.swing.border.TitledBorder;
import javax.swing.JList;

/**
 * Ventana principal de la interfaz gráfica
 * @author Óscar Díaz Olivares
 */
public class Principal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDesktopPane desktopPane=new JDesktopPane();
	
	//Arraylist de todos los personajes guardados (to-do: cargar desde archivo guardado)
	ArrayList<Personaje> personajes = new ArrayList<Personaje>();
	//ArrayList de todos los conjuros disponibles
	public static final ArrayList<Hechizo> HECHIZOS = new ArrayList<Hechizo>();
	
	private JList<Personaje> listPersonajes;
	private DefaultListModel<Personaje> modelPersonajes = new DefaultListModel<Personaje>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setResizable(false);
		setTitle("D&D Spellbook");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(2, 50, 1000, 700);
		
		//Carga el nuevo personaje en el arraylist
		personajes.add(new Personaje("Norgalis", Raza.HUMANO, Clase.MAGO, 9, "CAO-BUE", 9, 16, 15, 20, 12, 10, 18, 51, 6));
		
		//Carga todos los hechizos en su correspondiente arraylist
		HECHIZOS.add(new BolaDeFuego((short)0));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("Archivo");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Abrir");
		mnFile.add(mntmOpen);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmSave = new JMenuItem("Guardar");
		mnFile.add(mntmSave);
		
		JMenuItem mntmSaveAs = new JMenuItem("Guardar como...");
		mnFile.add(mntmSaveAs);
		
		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnFile.add(mntmSalir);
		
		JMenu mnVentana = new JMenu("Ventana");
		menuBar.add(mnVentana);
		
		JMenuItem mntmPersonajes = new JMenuItem("Personajes");
		mnVentana.add(mntmPersonajes);
		
		JMenu mnHelp = new JMenu("Ayuda");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelp = new JMenuItem("Ayuda");
		mnHelp.add(mntmHelp);
		
		JMenuItem mntmAbout = new JMenuItem("Acerca de");
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		desktopPane.setBounds(0, 12, 994, 640);
		contentPane.add(desktopPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Personajes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 12, 237, 582);
		desktopPane.add(panel);
		panel.setLayout(null);
		
		listPersonajes = new JList<Personaje>();
		listPersonajes.setBounds(12, 22, 213, 468);
		panel.add(listPersonajes);
		
		//Carga listModel
		Personaje personajeAux;
		for (Iterator<Personaje> iterator = personajes.iterator(); iterator.hasNext();) {
			personajeAux = (Personaje) iterator.next();
			modelPersonajes.addElement(personajeAux);
		}
				
				listPersonajes.setModel(modelPersonajes);
		
		JButton btnAadir = new JButton("Nuevo");
		btnAadir.setBounds(12, 502, 98, 26);
		panel.add(btnAadir);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.setBounds(127, 502, 98, 26);
		panel.add(btnMostrar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(127, 544, 98, 26);
		panel.add(btnEliminar);
		

		//Conjuros preparados de prueba - 2 Bola de Fuego
		ArrayList<Hechizo> conjurosPreparados= new ArrayList<Hechizo>();
		conjurosPreparados.add(new BolaDeFuego((short) personajes.get(0).getNivel()));
		conjurosPreparados.add(new BolaDeFuego((short) personajes.get(0).getNivel()));
		//Asigno los conjuros al pj
		personajes.get(0).setConjurosPreparados(conjurosPreparados);
		
		JButton btnBolaDeFuego = new JButton("Bola de fuego");
		btnBolaDeFuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DetalleHechizo internalFrame = new DetalleHechizo( new BolaDeFuego((short) 8));
				internalFrame.setVisible(true);
				desktopPane.add(internalFrame);
				try {
					internalFrame.setSelected(true);
				} catch (java.beans.PropertyVetoException e) {
				}
			}
		});
		btnBolaDeFuego.setBounds(869, 598, 89, 23);
		desktopPane.add(btnBolaDeFuego);
		
		// *** Abrir ventana "Personajes" ***
//		mntmPersonajes.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				ListaPersonajes listaPj = new ListaPersonajes(personajes, desktopPane);
//				listaPj.setVisible(true);
//				desktopPane.add(listaPj);
//				try {
//					listaPj.setSelected(true);
//				} catch (java.beans.PropertyVetoException e) {
//				}
//			}
//		});
		
		//Mostrar pj
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DetallePersonaje detallePj = new DetallePersonaje(listPersonajes.getSelectedValue());
//						ListaHechizosPreparados listaHechizos = new ListaHechizosPreparados(list.getSelectedValue().getConjurosPreparados(), desktopPane);
				detallePj.setVisible(true);
				desktopPane.add(detallePj);
				try {
					detallePj.setSelected(true);
				} catch (java.beans.PropertyVetoException e1) {
				}
			}
		});
	}
}
