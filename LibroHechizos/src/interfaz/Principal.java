package interfaz;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import principal.ArmaduraDeMago;
import principal.BolaDeFuego;
import principal.Clase;
import principal.Fichero;
import principal.Hechizo;
import principal.Personaje;
import principal.RayoDeDebilitamiento;
import principal.Raza;
import principal.ResistenciaDeOso;

import javax.swing.border.TitledBorder;
import javax.swing.JList;

/**
 * Ventana principal de la interfaz gráfica
 * @author Óscar Díaz Olivares
 */
public class Principal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JDesktopPane desktopPane=new JDesktopPane();
	
	//Arraylist de todos los personajes guardados (to-do: cargar desde archivo guardado)
	public static ArrayList<Personaje> personajes = new ArrayList<Personaje>();
	//Arraylist de todos los hechizos que existan
	public static ArrayList<Hechizo> hechizos = new ArrayList<Hechizo>();
	
	private static JList<Personaje> listPersonajes;
	private static DefaultListModel<Personaje> modelPersonajes = new DefaultListModel<Personaje>();
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmOpen;
	private JSeparator separator;
	private JMenuItem mntmSave;
	private JMenuItem mntmSaveAs;
	private JSeparator separator_1;
	private JMenuItem mntmSalir;
	private JMenu mnHelp;
	private JMenuItem mntmHelp;
	private JMenuItem mntmAbout;
	private JPanel panel;
	
	private Fichero fichero;
	private JFileChooser selectorFichero;
	

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
		
		//Carga los hechizos existentes
		hechizos.add(new BolaDeFuego());
		hechizos.add(new RayoDeDebilitamiento());
		hechizos.add(new ArmaduraDeMago());
		hechizos.add(new ResistenciaDeOso());
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFile = new JMenu("Archivo");
		mnFile.setMnemonic('A');
		menuBar.add(mnFile);
		
		mntmOpen = new JMenuItem("Abrir");
		mnFile.add(mntmOpen);
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		
		separator = new JSeparator();
		mnFile.add(separator);
		
		mntmSave = new JMenuItem("Guardar");
		mnFile.add(mntmSave);
		mntmSave.setEnabled(false);
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_G, ActionEvent.CTRL_MASK));
		
		mntmSaveAs = new JMenuItem("Guardar como...");
		mnFile.add(mntmSaveAs);
		mntmSaveAs.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		
		separator_1 = new JSeparator();
		mnFile.add(separator_1);
		
		mntmSalir = new JMenuItem("Salir");
		mnFile.add(mntmSalir);
		mntmSaveAs.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		
		mnHelp = new JMenu("Ayuda");
		mnHelp.setMnemonic('U');
		menuBar.add(mnHelp);
		
		mntmHelp = new JMenuItem("Ayuda");
		mnHelp.add(mntmHelp);
		mntmHelp.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
		
		mntmAbout = new JMenuItem("Acerca de");
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		desktopPane.setBounds(0, 12, 994, 640);
		contentPane.add(desktopPane);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Personajes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 12, 237, 582);
		desktopPane.add(panel);
		panel.setLayout(null);
		
		listPersonajes = new JList<Personaje>();
		listPersonajes.setBounds(12, 22, 213, 468);
		panel.add(listPersonajes);
		
		cargarListModel();
		
		JButton btnAadir = new JButton("Nuevo");
		btnAadir.setBounds(12, 502, 98, 26);
		panel.add(btnAadir);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.setBounds(127, 502, 98, 68);
		panel.add(btnMostrar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(12, 544, 98, 26);
		panel.add(btnEliminar);
		
		//Mostrar pj
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listPersonajes.getSelectedValue()!=null) {
					DetallePersonaje detallePj = new DetallePersonaje(listPersonajes.getSelectedValue(), listPersonajes.getSelectedIndex());
					detallePj.setVisible(true);
					desktopPane.add(detallePj);
					try {
						detallePj.setSelected(true);
					} catch (java.beans.PropertyVetoException e1) {
					}
						}
						
					}
		});
		
		//Nuevo
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DetallePersonaje detallePj = new DetallePersonaje();
				detallePj.setVisible(true);
				desktopPane.add(detallePj);
			try {
				detallePj.setSelected(true);
			} catch (java.beans.PropertyVetoException e1) {
			}
	}
		});
		
		//Guardar como...
		mntmSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				selectorFichero = new JFileChooser();
				int seleccion = selectorFichero.showSaveDialog(contentPane);
				File file = selectorFichero.getSelectedFile();
				if (seleccion == JFileChooser.APPROVE_OPTION) {
					try {
						fichero = new Fichero(file.getCanonicalPath());
						fichero.guardarFichero(personajes);
						// Hasta que no se pulsa "Guardar como..." y no termina satisfactoriamente, no tenemos un path para el
						// fichero, y por tanto no se puede activar el botón "Guardar" hasta este momento.
						mntmSave.setEnabled(true);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		//Guardar
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fichero.guardarFichero(personajes);
			}
		});
		
		//Abrir
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectorFichero = new JFileChooser();
				int seleccion = selectorFichero.showOpenDialog(contentPane);
				File file = selectorFichero.getSelectedFile();

				if (seleccion == JFileChooser.APPROVE_OPTION) {
					try {
						fichero = new Fichero(file.getCanonicalPath());
						personajes = fichero.leerFichero();
						modelPersonajes.clear(); //Borra el listModel
						cargarListModel();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		//Eliminar
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (listPersonajes.getSelectedValue()!=null) {
					eliminarPj(listPersonajes.getSelectedIndex());
				}
			}
		});
		
		
	}

	private void cargarListModel() {
		Personaje personajeAux;
		for (Iterator<Personaje> iterator = personajes.iterator(); iterator.hasNext();) {
			personajeAux = (Personaje) iterator.next();
			modelPersonajes.addElement(personajeAux);
		}
				
		listPersonajes.setModel(modelPersonajes);
	}
	
	static boolean añadirPj(Personaje pjNuevo) {
		
		if (personajes.add(pjNuevo)) {
			modelPersonajes.addElement(pjNuevo);
			listPersonajes.setModel(modelPersonajes);
			return true;
		}
		return false;		
	}
	
	static boolean eliminarPj(int indice) {
		
		if (personajes.remove(indice)!=null) {
			modelPersonajes.removeElementAt(indice);
			listPersonajes.setModel(modelPersonajes);
			return true;
		}
		return false;		
	}
}
