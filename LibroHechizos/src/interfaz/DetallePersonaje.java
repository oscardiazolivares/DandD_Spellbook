package interfaz;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JPanel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JButton;

import principal.Clase;
import principal.Hechizo;
import principal.Personaje;
import principal.Raza;

import java.awt.Font;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DetallePersonaje extends JInternalFrame {
	private JTextField textField_nombre;
	private JTextField textField_alineamiento;
	private Personaje pj;
	private JList<Hechizo> listConocidos;
	private JList<Hechizo> listPreparados;
	private DefaultListModel<Hechizo> conjConocidos;
	private DefaultListModel<Hechizo> conjPreparados;
	private JLabel lblDiarios0;
	private JLabel lblDiarios1;
	private JLabel lblDiarios2;
	private JLabel lblDiarios3;
	private JLabel lblDiarios4;
	private JLabel lblDiarios5;
	private JLabel lblDiarios6;
	private JLabel lblDiarios7;
	private JLabel lblDiarios8;
	private JLabel lblDiarios9;

	/**
	 * Create the frame.
	 */
	public DetallePersonaje(Personaje personaje) {
		this.pj=personaje;
		setTitle(pj.getNombre() + ": " + pj.getClase().getNombre() + " de nivel " + pj.getNivel());
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 432, 641);
		getContentPane().setLayout(null);
		
		//Panels
		
		JPanel panel_Caracteristicas = new JPanel();
		panel_Caracteristicas.setBorder(new TitledBorder(null, "Caracter\u00EDsticas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Caracteristicas.setBounds(12, 136, 404, 112);
		getContentPane().add(panel_Caracteristicas);
		panel_Caracteristicas.setLayout(null);
		
		JPanel panel_infoBasica = new JPanel();
		panel_infoBasica.setBorder(new TitledBorder(null, "Informaci\u00F3n b\u00E1sica", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_infoBasica.setBounds(12, 12, 404, 112);
		getContentPane().add(panel_infoBasica);
		panel_infoBasica.setLayout(null);
		
		JPanel panel_Conjuros = new JPanel();
		panel_Conjuros.setBorder(new TitledBorder(null, "Conjuros", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Conjuros.setBounds(12, 260, 404, 315);
		getContentPane().add(panel_Conjuros);
		panel_Conjuros.setLayout(null);
		
		//Spinner Models
		
		SpinnerModel spinnerModelFue = new SpinnerNumberModel(pj.getFuerza(), 1, 29, 1);
		SpinnerModel spinnerModelDes = new SpinnerNumberModel(pj.getDestreza(), 1, 29, 1);
		SpinnerModel spinnerModelCon = new SpinnerNumberModel(pj.getConstitucion(), 1, 29, 1);
		SpinnerModel spinnerModelInt = new SpinnerNumberModel(pj.getInteligencia(), 1, 29, 1);
		SpinnerModel spinnerModelSab = new SpinnerNumberModel(pj.getInteligencia(), 1, 29, 1);
		SpinnerModel spinnerModelCar = new SpinnerNumberModel(pj.getCarisma(), 1, 29, 1);
		
		SpinnerModel spinnerModelFueMod = new SpinnerNumberModel(pj.getModFue(), -5, 8, 1);
		SpinnerModel spinnerModelDesMod = new SpinnerNumberModel(pj.getModDes(), -5, 8, 1);
		SpinnerModel spinnerModelConMod = new SpinnerNumberModel(pj.getModCon(), -5, 8, 1);
		SpinnerModel spinnerModelIntMod = new SpinnerNumberModel(pj.getModInt(), -5, 8, 1);
		SpinnerModel spinnerModelSabMod = new SpinnerNumberModel(pj.getModSab(), -5, 8, 1);
		SpinnerModel spinnerModelCarMod = new SpinnerNumberModel(pj.getModCar(), -5, 8, 1);
		
		SpinnerModel spinnerModelNivel = new SpinnerNumberModel(pj.getNivel(), 1, 20, 1);
		SpinnerModel spinnerModelCa = new SpinnerNumberModel(pj.getCa(), 0, 40, 1);
		SpinnerModel spinnerModelPg = new SpinnerNumberModel(pj.getPg(), -10, 999, 1);
		SpinnerModel spinnerModelAtaque = new SpinnerNumberModel(pj.getAtaqueBase(), 1, 20, 1);

		//Spinners
		final JSpinner spFue = new JSpinner(spinnerModelFue);
		spFue.setBounds(40, 42, 35, 20);
		panel_Caracteristicas.add(spFue);
		
		final JSpinner spDes = new JSpinner(spinnerModelDes);
		spDes.setBounds(40, 70, 35, 20);
		panel_Caracteristicas.add(spDes);
		
		final JSpinner spCon = new JSpinner(spinnerModelCon);
		spCon.setBounds(168, 42, 35, 20);
		panel_Caracteristicas.add(spCon);
		
		final JSpinner spInt = new JSpinner(spinnerModelInt);
		spInt.setBounds(168, 70, 35, 20);
		panel_Caracteristicas.add(spInt);
		
		final JSpinner spSab = new JSpinner(spinnerModelSab);
		spSab.setBounds(304, 42, 35, 20);
		panel_Caracteristicas.add(spSab);
		
		final JSpinner spCar = new JSpinner(spinnerModelCar);
		spCar.setBounds(304, 70, 35, 20);
		panel_Caracteristicas.add(spCar);
		
		JSpinner spNivel = new JSpinner(spinnerModelNivel);
		spNivel.setBounds(274, 55, 42, 20);
		panel_infoBasica.add(spNivel);
		
		JSpinner spCa = new JSpinner(spinnerModelCa);
		spCa.setBounds(259, 83, 35, 20);
		panel_infoBasica.add(spCa);
		
		JSpinner spPg = new JSpinner(spinnerModelPg);
		spPg.setBounds(352, 55, 35, 20);
		panel_infoBasica.add(spPg);
		
		JSpinner spAtaqueBase = new JSpinner(spinnerModelAtaque);
		spAtaqueBase.setBounds(352, 83, 35, 20);
		panel_infoBasica.add(spAtaqueBase);
		
		//Labels de modificadores
		
		final JLabel lblModInt = new JLabel(String.valueOf(pj.getModInt()));
		lblModInt.setHorizontalAlignment(SwingConstants.LEFT);
		lblModInt.setBounds(215, 72, 35, 16);
		panel_Caracteristicas.add(lblModInt);
		
		final JLabel lblModCon = new JLabel(String.valueOf(pj.getModCon()));
		lblModCon.setHorizontalAlignment(SwingConstants.LEFT);
		lblModCon.setBounds(215, 45, 35, 16);
		panel_Caracteristicas.add(lblModCon);
		
		final JLabel lblModSab = new JLabel(String.valueOf(pj.getModSab()));
		lblModSab.setHorizontalAlignment(SwingConstants.LEFT);
		lblModSab.setBounds(351, 45, 35, 16);
		panel_Caracteristicas.add(lblModSab);
		
		final JLabel lblModCar = new JLabel(String.valueOf(pj.getModCar()));
		lblModCar.setHorizontalAlignment(SwingConstants.LEFT);
		lblModCar.setBounds(351, 73, 35, 16);
		panel_Caracteristicas.add(lblModCar);
		
		final JLabel lblModFue = new JLabel(String.valueOf(pj.getModFue()));
		lblModFue.setHorizontalAlignment(SwingConstants.LEFT);
		lblModFue.setBounds(90, 45, 35, 16);
		panel_Caracteristicas.add(lblModFue);
		
		final JLabel lblModDes = new JLabel(String.valueOf(pj.getModDes()));
		lblModDes.setHorizontalAlignment(SwingConstants.LEFT);
		lblModDes.setBounds(90, 72, 35, 16);
		panel_Caracteristicas.add(lblModDes);
				
		//Comboboxes
		
		JComboBox comboBox_clase = new JComboBox(Clase.values());
		comboBox_clase.setBounds(70, 53, 153, 25);
		panel_infoBasica.add(comboBox_clase);
		
		JComboBox comboBox_raza = new JComboBox(Raza.values());
		comboBox_raza.setBounds(274, 25, 121, 25);
		panel_infoBasica.add(comboBox_raza);
		
		//Textfields
		
		textField_nombre = new JTextField(pj.getNombre());
		textField_nombre.setBounds(70, 27, 153, 20);
		panel_infoBasica.add(textField_nombre);
		textField_nombre.setColumns(10);
		
		textField_alineamiento = new JTextField(pj.getAlineamiento());
		textField_alineamiento.setBounds(96, 83, 127, 20);
		panel_infoBasica.add(textField_alineamiento);
		textField_alineamiento.setColumns(10);
		
		//LIstmodels
		
		conjConocidos = new DefaultListModel<Hechizo>();
		for (Hechizo hechizo : LibroConjurosPrincipal.HECHIZOS) {
			conjConocidos.addElement(hechizo);
		}
		conjPreparados = new DefaultListModel<Hechizo>();
		
		//Lists
		
		listConocidos = new JList<Hechizo>(conjConocidos);
		listConocidos.setBounds(12, 75, 153, 200);
		panel_Conjuros.add(listConocidos);
		
		listPreparados = new JList<Hechizo>();
		listPreparados.setBounds(236, 75, 153, 200);
		panel_Conjuros.add(listPreparados);
		
		//Buttons
		
		JButton btnBorrar = new JButton("Borrar todos");
		btnBorrar.setBounds(236, 286, 150, 20);
		panel_Conjuros.add(btnBorrar);
		
		JButton btnNewButton = new JButton(">");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton.setBounds(177, 75, 47, 32);
		panel_Conjuros.add(btnNewButton);
		
		JButton button = new JButton("<");
		button.setFont(new Font("Dialog", Font.BOLD, 12));
		button.setBounds(177, 119, 47, 32);
		panel_Conjuros.add(button);
		
		JButton btnGuardarPj = new JButton("Guardar PJ");
		btnGuardarPj.setBounds(288, 581, 126, 26);
		getContentPane().add(btnGuardarPj);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(150, 581, 126, 26);
		getContentPane().add(btnModificar);
		
		JButton btnNuevoPersonaje = new JButton("Nuevo PJ");
		btnNuevoPersonaje.setBounds(12, 581, 126, 26);
		getContentPane().add(btnNuevoPersonaje);
		
		//Labels
		JLabel lblFue = new JLabel("FUE");
		lblFue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFue.setBounds(12, 44, 26, 16);
		panel_Caracteristicas.add(lblFue);
		
		JLabel lblDes = new JLabel("DES");
		lblDes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDes.setBounds(12, 72, 26, 16);
		panel_Caracteristicas.add(lblDes);
		
		JLabel lblCaract = new JLabel("Puntos");
		lblCaract.setBounds(40, 23, 55, 16);
		panel_Caracteristicas.add(lblCaract);
		
		JLabel lblMod = new JLabel("Mod.");
		lblMod.setBounds(90, 23, 35, 16);
		panel_Caracteristicas.add(lblMod);
		
		JLabel lblSab = new JLabel("SAB");
		lblSab.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSab.setBounds(276, 44, 26, 16);
		panel_Caracteristicas.add(lblSab);
		
		JLabel lblCar = new JLabel("CAR");
		lblCar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCar.setBounds(276, 72, 26, 16);
		panel_Caracteristicas.add(lblCar);
		
		JLabel lblPuntos_1 = new JLabel("Puntos");
		lblPuntos_1.setBounds(301, 23, 55, 16);
		panel_Caracteristicas.add(lblPuntos_1);
		
		JLabel label_3 = new JLabel("Mod.");
		label_3.setBounds(351, 23, 35, 16);
		panel_Caracteristicas.add(label_3);
		
		JLabel lblCon = new JLabel("CON");
		lblCon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCon.setBounds(140, 44, 26, 16);
		panel_Caracteristicas.add(lblCon);
		
		JLabel lblInt = new JLabel("INT");
		lblInt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInt.setBounds(140, 72, 26, 16);
		panel_Caracteristicas.add(lblInt);
		
		JLabel lblPuntos = new JLabel("Puntos");
		lblPuntos.setBounds(168, 23, 55, 16);
		panel_Caracteristicas.add(lblPuntos);
		
		JLabel label_1 = new JLabel("Mod.");
		label_1.setBounds(218, 23, 35, 16);
		panel_Caracteristicas.add(label_1);
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 29, 55, 16);
		panel_infoBasica.add(lblNombre);
		
		JLabel lblRaza = new JLabel("Raza:");
		lblRaza.setBounds(235, 29, 55, 16);
		panel_infoBasica.add(lblRaza);
		
		JLabel lblClase = new JLabel("Clase:");
		lblClase.setBounds(12, 57, 42, 16);
		panel_infoBasica.add(lblClase);
		
		JLabel lblNivel = new JLabel("Nivel:");
		lblNivel.setBounds(235, 57, 55, 16);
		panel_infoBasica.add(lblNivel);
		
		JLabel lblAlineamiento = new JLabel("Alineamiento:");
		lblAlineamiento.setBounds(12, 85, 77, 16);
		panel_infoBasica.add(lblAlineamiento);
		
		JLabel lblCa = new JLabel("CA:");
		lblCa.setBounds(235, 85, 26, 16);
		panel_infoBasica.add(lblCa);
		
		JLabel lblPg = new JLabel("PG:");
		lblPg.setBounds(328, 57, 26, 16);
		panel_infoBasica.add(lblPg);
		
		JLabel lblAtBase = new JLabel("At. base:");
		lblAtBase.setBounds(299, 85, 55, 16);
		panel_infoBasica.add(lblAtBase);
		
		JLabel lblConjurosDiarios = new JLabel("Conjuros diarios:");
		lblConjurosDiarios.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConjurosDiarios.setBounds(56, 26, 96, 16);
		panel_Conjuros.add(lblConjurosDiarios);
		
		JLabel lblConjurosConocidos = new JLabel("Conjuros conocidos:");
		lblConjurosConocidos.setHorizontalAlignment(SwingConstants.LEFT);
		lblConjurosConocidos.setBounds(12, 54, 153, 16);
		panel_Conjuros.add(lblConjurosConocidos);
		
		JLabel lblConjurosPreparados = new JLabel("Conjuros preparados:");
		lblConjurosPreparados.setHorizontalAlignment(SwingConstants.LEFT);
		lblConjurosPreparados.setBounds(236, 56, 150, 16);
		panel_Conjuros.add(lblConjurosPreparados);
		
		JLabel lblNiveles = new JLabel("Niveles:");
		lblNiveles.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNiveles.setBounds(97, 12, 55, 16);
		panel_Conjuros.add(lblNiveles);
		
		JLabel label = new JLabel("0");
		label.setBounds(164, 12, 12, 16);
		panel_Conjuros.add(label);
		
		JLabel label_2 = new JLabel("1");
		label_2.setBounds(188, 12, 12, 16);
		panel_Conjuros.add(label_2);
		
		JLabel label_4 = new JLabel("2");
		label_4.setBounds(212, 12, 12, 16);
		panel_Conjuros.add(label_4);
		
		JLabel label_5 = new JLabel("3");
		label_5.setBounds(236, 12, 12, 16);
		panel_Conjuros.add(label_5);
		
		JLabel label_6 = new JLabel("4");
		label_6.setBounds(260, 12, 12, 16);
		panel_Conjuros.add(label_6);
		
		JLabel label_7 = new JLabel("5");
		label_7.setBounds(284, 12, 12, 16);
		panel_Conjuros.add(label_7);
		
		JLabel label_8 = new JLabel("6");
		label_8.setBounds(308, 12, 12, 16);
		panel_Conjuros.add(label_8);
		
		JLabel label_9 = new JLabel("7");
		label_9.setBounds(332, 12, 12, 16);
		panel_Conjuros.add(label_9);
		
		JLabel label_10 = new JLabel("8");
		label_10.setBounds(356, 12, 12, 16);
		panel_Conjuros.add(label_10);
		
		JLabel label_20 = new JLabel("9");
		label_20.setBounds(380, 12, 12, 16);
		panel_Conjuros.add(label_20);
		
		lblDiarios0 = new JLabel(String.valueOf(pj.getConjurosDiarios()[0]));
		lblDiarios0.setBounds(164, 26, 12, 16);
		panel_Conjuros.add(lblDiarios0);
		
		lblDiarios1 = new JLabel(String.valueOf(pj.getConjurosDiarios()[1]));
		lblDiarios1.setBounds(188, 26, 12, 16);
		panel_Conjuros.add(lblDiarios1);
		
		lblDiarios2 = new JLabel(String.valueOf(pj.getConjurosDiarios()[2]));
		lblDiarios2.setBounds(212, 26, 12, 16);
		panel_Conjuros.add(lblDiarios2);
		
		lblDiarios3 = new JLabel(String.valueOf(pj.getConjurosDiarios()[3]));
		lblDiarios3.setBounds(236, 26, 12, 16);
		panel_Conjuros.add(lblDiarios3);
		
		lblDiarios4 = new JLabel(String.valueOf(pj.getConjurosDiarios()[4]));
		lblDiarios4.setBounds(260, 26, 12, 16);
		panel_Conjuros.add(lblDiarios4);
		
		lblDiarios5 = new JLabel(String.valueOf(pj.getConjurosDiarios()[5]));
		lblDiarios5.setBounds(284, 26, 12, 16);
		panel_Conjuros.add(lblDiarios5);
		
		lblDiarios6 = new JLabel(String.valueOf(pj.getConjurosDiarios()[6]));
		lblDiarios6.setBounds(308, 26, 12, 16);
		panel_Conjuros.add(lblDiarios6);
		
		lblDiarios7 = new JLabel(String.valueOf(pj.getConjurosDiarios()[7]));
		lblDiarios7.setBounds(332, 26, 12, 16);
		panel_Conjuros.add(lblDiarios7);
		
		lblDiarios8 = new JLabel(String.valueOf(pj.getConjurosDiarios()[8]));
		lblDiarios8.setBounds(356, 26, 12, 16);
		panel_Conjuros.add(lblDiarios8);
		
		lblDiarios9 = new JLabel(String.valueOf(pj.getConjurosDiarios()[9]));
		lblDiarios9.setBounds(380, 26, 12, 16);
		panel_Conjuros.add(lblDiarios9);
		
		//Eventos al modificar una caracteristica en el Splitter (uno para cada caracteristica!)
		spInt.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblModInt.setText(String.valueOf(pj.calcularModificador((int)spInt.getValue())));
			}
		});
		
		spSab.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblModSab.setText(String.valueOf(pj.calcularModificador((int)spSab.getValue())));
			}
		});
		
		spCar.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblModCar.setText(String.valueOf(pj.calcularModificador((int)spCar.getValue())));
			}
		});
		
		spFue.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblModFue.setText(String.valueOf(pj.calcularModificador((int)spFue.getValue())));
			}
		});
		
		spDes.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblModDes.setText(String.valueOf(pj.calcularModificador((int)spDes.getValue())));
			}
		});
		
		spCon.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblModCon.setText(String.valueOf(pj.calcularModificador((int)spCon.getValue())));
			}
		});
		
		//Eventos para agregar o quitar conjuros de la lista de preparados
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (listConocidos.getSelectedValue()!=null) { //asegura que no es null (es decir, que hay un hechizo seleccionado)
					if (pj.getConjurosDiarios()[listConocidos.getSelectedValue().getNivelHechizo()]!=0) { //Si tiene algún conjuro diario del nivel del conjuro que quiere prepararse
						//Reduce en 1 el nivel de conj. diario del conjuro a preparar 
						// => Esto OBLIGA a crear un boton "Restaurar conj. diarios" que los devuelva a la normalidad y borre los conjuros.
						pj.setConjuroDiarioNivel(pj.getConjurosDiarios()[listConocidos.getSelectedValue().getNivelHechizo()]-1, listConocidos.getSelectedValue().getNivelHechizo());
						//Añade el conjuro a la lista de preparados
						conjPreparados.addElement(listConocidos.getSelectedValue());
						listPreparados.setModel(conjPreparados);
						//Actualiza el texto de los label de conjuros diarios
						actualizarLabelConjDiario();
					} else {

					}
				}
			}

			private void actualizarLabelConjDiario() {
				lblDiarios0.setText(String.valueOf(pj.getConjurosDiarios()[0]));
				lblDiarios1.setText(String.valueOf(pj.getConjurosDiarios()[1]));
				lblDiarios2.setText(String.valueOf(pj.getConjurosDiarios()[2]));
				lblDiarios3.setText(String.valueOf(pj.getConjurosDiarios()[3]));
				lblDiarios4.setText(String.valueOf(pj.getConjurosDiarios()[4]));
				lblDiarios5.setText(String.valueOf(pj.getConjurosDiarios()[5]));
				lblDiarios6.setText(String.valueOf(pj.getConjurosDiarios()[6]));
				lblDiarios7.setText(String.valueOf(pj.getConjurosDiarios()[7]));
				lblDiarios8.setText(String.valueOf(pj.getConjurosDiarios()[8]));
				lblDiarios9.setText(String.valueOf(pj.getConjurosDiarios()[9]));				
			}
		});
	}
}
