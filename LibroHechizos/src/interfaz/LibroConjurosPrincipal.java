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

/**
 * Ventana principal de la interfaz gráfica
 * @author Óscar Díaz Olivares
 */
public class LibroConjurosPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDesktopPane desktopPane=new JDesktopPane();
	//Personaje de prueba
	ArrayList<Personaje> personajes = new ArrayList<Personaje>();
	

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
					LibroConjurosPrincipal frame = new LibroConjurosPrincipal();
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
	public LibroConjurosPrincipal() {
		setResizable(false);
		setTitle("D&D Spellbook");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(2, 50, 1020, 700);
		
		//Carga el nuevo personaje en el arraylist
		personajes.add(new Personaje("Norgalis", Raza.HUMANO, Clase.MAGO, 9, "CAO-BUE", 9, 16, 15, 20, 12, 10, 18, 51, 6));
		
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
		
		desktopPane.setBounds(12, 12, 994, 626);
		contentPane.add(desktopPane);

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
		mntmPersonajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaPersonajes listaPj = new ListaPersonajes(personajes, desktopPane);
				listaPj.setVisible(true);
				desktopPane.add(listaPj);
				try {
					listaPj.setSelected(true);
				} catch (java.beans.PropertyVetoException e) {
				}
			}
		});
	}
}
