package interfaz;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import principal.Hechizo;
import principal.Mostrable;
import principal.Personaje;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;

import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Ventana que muestra el detalle de un conjuro concreto preparado.
 * @author Óscar Díaz Olivares
 */
public class DetalleHechizo extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private static int openFrameCount = 0;
	private static final int xOffset = 30, yOffset = 30;
	private Hechizo hechizo;
	private int indicePj;
	private JButton btnLanzar;
	private int indiceHechizo;

	/**
	 * Create the frame.
	 */
	public DetalleHechizo(final Hechizo hechizo, final int indicePj, final int indiceHechizo) {
		super("Conjuro: " + hechizo.getNombre(),
		          false, //resizable
		          true, //closable
		          false, //maximizable
		          true);//iconifiable
		    // Set the window's location.
		    
		this.indiceHechizo=indiceHechizo;
		this.indicePj=indicePj;
		this.hechizo=hechizo;

		    ++openFrameCount;
		setBounds(xOffset*openFrameCount, yOffset*openFrameCount, 445, 520);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, hechizo.getNombre() + " - NL " + hechizo.getNivelDelLanzador(), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 12, 411, 422);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblImage = new JLabel(new ImageIcon("F:\\Users\\oscar\\git\\DandD_Spellbook\\LibroHechizos\\media\\boladefuego.png"));
		lblImage.setBounds(12, 24, 150, 150);
		panel.add(lblImage);
		
		JLabel lblEscuela = new JLabel("Escuela: ");
		lblEscuela.setBounds(174, 24, 55, 16);
		panel.add(lblEscuela);
		
		JLabel lblSubescuela = new JLabel("Subescuela:");
		lblSubescuela.setBounds(174, 50, 75, 16);
		panel.add(lblSubescuela);
		
		JLabel lblNivel = new JLabel("Nivel:");
		lblNivel.setBounds(174, 78, 91, 16);
		panel.add(lblNivel);
		
		JLabel lblComponentes = new JLabel("Componentes:");
		lblComponentes.setBounds(174, 106, 91, 16);
		panel.add(lblComponentes);
		
		JLabel lblTiempoDeLanzamiento = new JLabel("Tiempo lanzamiento:");
		lblTiempoDeLanzamiento.setBounds(174, 134, 124, 16);
		panel.add(lblTiempoDeLanzamiento);
		
		JLabel lblAlcance = new JLabel("Alcance:");
		lblAlcance.setBounds(174, 158, 55, 16);
		panel.add(lblAlcance);
		
		JLabel lblEscuelaMostrada = new JLabel(hechizo.getEscuela().getNombre());
		lblEscuelaMostrada.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEscuelaMostrada.setBounds(258, 24, 141, 16);
		panel.add(lblEscuelaMostrada);
		
		JLabel lblSubescuelaMostrada = new JLabel(hechizo.getSubescuela());
		lblSubescuelaMostrada.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubescuelaMostrada.setBounds(290, 50, 109, 16);
		panel.add(lblSubescuelaMostrada);
		
		JLabel lblNivelMostrado = new JLabel(String.valueOf((int)hechizo.getNivelHechizo()));
		lblNivelMostrado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNivelMostrado.setBounds(344, 78, 55, 16);
		panel.add(lblNivelMostrado);
		
		//Listar los componentes en un String para crear el JLabel:
		StringBuffer componentes = new StringBuffer("");
		for (int i = 0; i < hechizo.getComponentes().length; i++) {
			componentes.append(hechizo.getComponentes()[i].getAbreviatura());
			if (i==(hechizo.getComponentes().length -1)) { //Si es el último componente
				componentes.append(".");
			} else {
				componentes.append(", ");
			}
		}
		
		JLabel lblComponentesMostrado = new JLabel(componentes.toString());
		lblComponentesMostrado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblComponentesMostrado.setBounds(344, 106, 55, 16);
		panel.add(lblComponentesMostrado);
		
		JLabel lblTiempoLanzamientoMostrado = new JLabel(hechizo.getTiempoLanzamiento().getNombre());
		lblTiempoLanzamientoMostrado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTiempoLanzamientoMostrado.setBounds(302, 134, 97, 16);
		panel.add(lblTiempoLanzamientoMostrado);
		
		JLabel lblAlcanceMostrado = new JLabel(String.valueOf(hechizo.getAlcance()));
		lblAlcanceMostrado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlcanceMostrado.setBounds(344, 158, 55, 16);
		panel.add(lblAlcanceMostrado);
		
		JTextArea txtDescripcion = new JTextArea();
		txtDescripcion.setWrapStyleWord(true);
		txtDescripcion.setBackground(UIManager.getColor("Button.background"));
		txtDescripcion.setLineWrap(true);
		txtDescripcion.setText(hechizo.getDescripcion());
		txtDescripcion.setEditable(false);
		txtDescripcion.setBounds(12, 184, 387, 193);
		panel.add(txtDescripcion);
		
		JLabel lblTs = new JLabel("TS: ");
		lblTs.setBounds(12, 389, 28, 16);
		panel.add(lblTs);
		
		JLabel lblTsMostrado = new JLabel(hechizo.getTs());
		lblTsMostrado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTsMostrado.setBounds(52, 389, 110, 16);
		panel.add(lblTsMostrado);
		
		JLabel lblDuracion = new JLabel("Duración:");
		lblDuracion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDuracion.setBounds(174, 389, 55, 16);
		panel.add(lblDuracion);
		
		JLabel lblDuracionMostrado = new JLabel(hechizo.getDuracion());
		lblDuracionMostrado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDuracionMostrado.setBounds(278, 389, 121, 16);
		panel.add(lblDuracionMostrado);
		
		btnLanzar = new JButton("Lanzar");
		btnLanzar.setBounds(325, 449, 98, 26);
		getContentPane().add(btnLanzar);
		
		btnLanzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Crear popUp con el resultado del hechizo
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
				} catch (Throwable e) {
					e.printStackTrace();
				}
				try {
					LanzamientoHechizo dialog = new LanzamientoHechizo(((Mostrable)hechizo).mostrarResolucion()); //¿Que mensaje se le pasa? Tiene que valer para todos¿? ¿Donde se genera?
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//Elimina el conj. preparado del pj
				Personaje nor = Principal.personajes.get(indicePj);
				ArrayList<Hechizo> preparados = nor.getConjurosPreparados();
				preparados.remove(indiceHechizo);
				Principal.personajes.get(indicePj).setConjurosPreparados(preparados);
				preparados = nor.getConjurosPreparados();
				
				//Cierra la ventana del hechizo
				dispose();
			}
		});

	}
	
	
	
}