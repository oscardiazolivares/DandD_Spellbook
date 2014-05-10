package interfaz;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.UIManager;

import principal.BolaDeFuego;

/**
 * Ventana principal de la interfaz gráfica
 * @author Óscar Díaz Olivares
 */
public class LibroConjurosPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		setTitle("RPG Clash Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(2, 50, 1020, 700);
		
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
		
		final JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(12, 12, 994, 626);
		contentPane.add(desktopPane);
		
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
	}
}
