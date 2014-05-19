package interfaz;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
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

import principal.BolaDeFuego;
import principal.Clase;
import principal.Hechizo;
import principal.OrdenarHechizo;
import principal.Personaje;
import principal.Raza;

import java.awt.Font;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.color.CMMException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

/**
 * Interfaz que muestra el personaje en detalle, así como sus hechizos preparados. Permite modificar un personaje o bien
 * crear uno nuevo.
 * 
 * @author Óscar Díaz Olivares
 * @version 1.0
 */
public class DetallePersonaje extends JInternalFrame {
	
	private Personaje pj;
	private JList<Hechizo> listConocidos;
	private JList<Hechizo> listPreparados;
	private DefaultListModel<Hechizo> conjConocidos;
	private DefaultListModel<Hechizo> conjPreparados; //static para poder cerrarlo al lanzar el hechizo desde DetalleHchizo
	private int indicePj;

	private JTextField textField_nombre;
	private JTextField textField_alineamiento;
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
	private JPanel panel_Caracteristicas;
	private JPanel panel_infoBasica;
	private JPanel panel_Conjuros;
	private SpinnerModel spinnerModelFue;
	private SpinnerModel spinnerModelDes;
	private SpinnerModel spinnerModelCon;
	private SpinnerModel spinnerModelInt;
	private SpinnerModel spinnerModelSab;
	private SpinnerModel spinnerModelCar;
	private SpinnerModel spinnerModelNivel;
	private SpinnerModel spinnerModelCa;
	private SpinnerModel spinnerModelPg;
	private SpinnerModel spinnerModelAtaque;
	private JSpinner spFue;
	private JSpinner spDes;
	private JSpinner spCon;
	private JSpinner spInt;
	private JSpinner spSab;
	private JSpinner spCar;
	private JSpinner spNivel;
	private JSpinner spCa;
	private JSpinner spPg;
	private JSpinner spAtaqueBase;
	private JLabel lblModInt;
	private JLabel lblModCon;
	private JLabel lblModSab;
	private JLabel lblModCar;
	private JLabel lblModFue;
	private JLabel lblModDes;
	private JComboBox<Clase> comboBox_clase;
	private JComboBox<Raza> comboBox_raza;
	private JButton btnRestaurar;
	private JButton btnAgregarConj;
	private JButton btnEliminarConj;
	private JButton btnGuardarPj;
	private JButton btnModificar;
	private JLabel lblFue;
	private JLabel lblDes;
	private JLabel lblCaract;
	private JLabel lblMod;
	private JLabel lblSab;
	private JLabel lblCar;
	private JLabel lblPuntos_1;
	private JLabel label_3;
	private JLabel lblCon;
	private JLabel lblInt;
	private JLabel lblPuntos;
	private JLabel label_1;
	private JLabel lblRaza;
	private JLabel lblClase;
	private JLabel lblNivel;
	private JLabel lblAlineamiento;
	private JLabel lblCa;
	private JLabel lblPg;
	private JLabel lblAtBase;
	private JLabel lblConjurosDiarios;
	private JLabel lblConjurosConocidos;
	private JLabel lblConjurosPreparados;
	private JLabel lblNiveles;
	private JLabel label;
	private JLabel label_2;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_20;
	private JButton btnVerConj;
	private JLabel lblNombre;
	private JButton btnRefrescar;
	

	/**
	 * Constructor de la interfaz para mostrar y modificar al personaje y sus hechizos.
	 * @param personaje - el personaje a mostrar
	 * @param indicePj - índice del personaje a mostrar en el ArrayList "personajes" de la clase Principal.
	 */
	public DetallePersonaje(Personaje personaje, final int indicePj) {
				
		this.indicePj=indicePj;
		this.pj=personaje;
		setTitle(pj.getNombre() + ": " + pj.getClase().getNombre() + " de nivel " + pj.getNivel() + "(ID: " + pj.ID +")");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 853, 419);
		getContentPane().setLayout(null);
		
		generarPanels();

		generarSpinnerModels();
		
		generarSpinners();
		
		generarLabelsMod();
				
		generarCombos();
		//Seleccionar la opcion correspondiente de cada combobox
		comboBox_clase.setSelectedItem(pj.getClase());
		comboBox_raza.setSelectedItem(pj.getRaza());
		
		generarTextFields();
		
		generarLists();
		
		generarButtons();
		
		generarLabels();
		
		generarLabelsDiarios();
		
		generarListeners();
		
		//Guardar el personaje

		btnGuardarPj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Valida los valores de los componentes gráficos
				if (textField_nombre.getText().length()<2) {
					Error err = new Error("Debe introducir un nombre de al menos 2 caracteres.");
					err.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					err.setVisible(true);
				} else if (textField_alineamiento.getText().length()<6){
					Error err = new Error("Debe introducir un alineamiento válido. El que ha introducido es demasiado corto.");
					err.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					err.setVisible(true);
				} else {
					//Crea nuevo personaje con los valores de los componentes gráficos
					Personaje pjModificado = new Personaje(
							textField_nombre.getText(),
							(Raza) comboBox_raza.getSelectedItem(),
							(Clase) comboBox_clase.getSelectedItem(),
							(int) spNivel.getValue(),
							textField_alineamiento.getText(),
							(int) spFue.getValue(),
							(int) spDes.getValue(),
							(int) spCon.getValue(),
							(int) spInt.getValue(),
							(int) spSab.getValue(),
							(int) spCar.getValue(),
							(int) spCa.getValue(),
							(int) spPg.getValue(),
							(int) spAtaqueBase.getValue() );
					
					//Extrae los conj. preparados de la interfaz y los pasa al personaje
					ArrayList<Hechizo> preparados = new ArrayList<Hechizo>();
					Hechizo aux;
					for (int i = 0; i < conjPreparados.getSize(); i++) {
						aux=conjPreparados.get(i);
						preparados.add(aux);
					}
					//Ordena por nivel los conj. preparados
					Collections.sort(preparados, new OrdenarHechizo());
					
					pjModificado.setConjurosPreparados(preparados);
					
					//Si no ha cambiado el nivel, define los conj.diarios del nuevo personaje en base a los del anterior:
					if (pjModificado.getNivel()==pj.getNivel()) {
						pjModificado.setConjurosDiarios(pj.getConjurosDiarios());
					} else { //Si ha cambiado, entonces se recalculan y se borran los conj.preparados
						pjModificado.setConjurosDiarios();
						pjModificado.setConjurosPreparados(new ArrayList<Hechizo>());
					}
					
					
					//Introduce el personaje creado en el arraylist de personajes, y elimina el anterior.
					if (Principal.anyadirPj(pjModificado)) {
						Principal.eliminarPj(indicePj);
						dispose();
					}
				}
				
			}
		});
		
	}
	/**
	 * Constructor de la interfaz para mostrar las características de un personaje nuevo y poder guardarlo.
	 */
	public DetallePersonaje() {
		setTitle("Nuevo personaje");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 437, 419);
		getContentPane().setLayout(null);
		
		this.pj=new Personaje("", null, null, 1, "", 10, 10, 10, 10, 10, 10, 10, 1, 1);
		
		generarPanels();
		
		generarSpinnerModels();
		
		generarSpinners();
		
		generarLabelsMod();
		
		generarCombos();
		
		generarTextFieldsPjNuevo();
		
		generarLists();
		
		generarButtons();
		
		generarLabels();
		
		generarLabelsDiarios();
		
		generarListeners();
		
		modificarVisibilidad();
		
		//La forma de guardar cambia entre ambos constructores
		btnGuardarPj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Valida los valores de los componentes gráficos
				if (textField_nombre.getText().length()<2) {
					Error err = new Error("Debe introducir un nombre de al menos 2 caracteres.");
					err.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					err.setVisible(true);
				} else if (textField_alineamiento.getText().length()<6){
					Error err = new Error("Debe introducir un alineamiento válido. El que ha introducido es demasiado corto.");
					err.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					err.setVisible(true);
				} else {
					//Crea nuevo personaje con los valores de los componentes gráficos
					Personaje pjModificado = new Personaje(
							textField_nombre.getText(),
							(Raza) comboBox_raza.getSelectedItem(),
							(Clase) comboBox_clase.getSelectedItem(),
							(int) spNivel.getValue(),
							textField_alineamiento.getText(),
							(int) spFue.getValue(),
							(int) spDes.getValue(),
							(int) spCon.getValue(),
							(int) spInt.getValue(),
							(int) spSab.getValue(),
							(int) spCar.getValue(),
							(int) spCa.getValue(),
							(int) spPg.getValue(),
							(int) spAtaqueBase.getValue() );
							
					//Define los conj.diarios del nuevo personaje
					pjModificado.setConjurosDiarios();
					
					
					//Introduce el personaje creado en el arraylist de personajes
					if (Principal.anyadirPj(pjModificado)) {
						dispose();
					}
				}
			}
		});
	}
	/**
 	* Actualiza los labels que representan los conj. diarios que quedan por gastar.
 	*/
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
	/**
	 * Carga el listModel de conjuros conocidos con los datos del ArrayList constante de la clase Principal.
	 * @see Principal
	 */
	private void generarConjConocidos() {
		for (Iterator iterator = Principal.hechizos.iterator(); iterator.hasNext();) {
			Hechizo hechizo = (Hechizo) iterator.next();
			conjConocidos.addElement(hechizo);
		}
		
	}
	/**
	 * Limpia y carga los conjuros preparados de un personaje en el listModel correspondiente.S
	 */
	private void generarConjPreparados() {
		if (pj.getConjurosPreparados()!=null) {
			conjPreparados.removeAllElements();
			for (Iterator iterator = pj.getConjurosPreparados().iterator(); iterator.hasNext();) {
				Hechizo hechizo = (Hechizo) iterator.next();
				conjPreparados.addElement(hechizo);
			}
		}
		
	}
	/**
	 * Genera los listeners necesarios para controlar todas las funciones.
	 */
	private void generarListeners() {
		//Eventos al modificar una caracteristica en el Splitter (uno para cada caracteristica!)
		spInt.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				//lblModInt.setText(String.valueOf(pj.calcularModificador((int)spInt.getValue())));
				int valorSpinner=(int) spInt.getValue();
				int mod = pj.calcularModificador(valorSpinner);
				String cadena = String.valueOf(mod);
				lblModInt.setText(cadena);
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
		btnAgregarConj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (listConocidos.getSelectedValue()!=null) { //asegura que no es null (es decir, que hay un hechizo seleccionado)
					if (pj.getConjurosDiarios()[listConocidos.getSelectedValue().getNivelHechizo()]!=0) { //Si tiene algún conjuro diario del nivel del conjuro que quiere prepararse
						//Reduce en 1 el nivel de conj. diario del conjuro a preparar 
						// => Esto OBLIGA a crear un boton "Restaurar conj. diarios" que los devuelva a la normalidad y borre los conjuros.
						pj.setConjuroDiarioNivel(pj.getConjurosDiarios()[listConocidos.getSelectedValue().getNivelHechizo()]-1, listConocidos.getSelectedValue().getNivelHechizo());
						
						//Asigna el nivel del pj al nivel de lanzador del hechizo
						Hechizo hechizoPreparado = listConocidos.getSelectedValue();
						hechizoPreparado.setNivelDelLanzador(pj.getNivel());
						
						hechizoPreparado.setAlcance(pj.getNivel());
						
						//hechizoPreparado.setPies();
						//hechizoPreparado.setAlcance(nivel);
						
						//Añade el conjuro a la lista de preparados
						conjPreparados.addElement(hechizoPreparado);
						listPreparados.setModel(conjPreparados);
						//Actualiza el texto de los label de conjuros diarios
						actualizarLabelConjDiario();
					} else {

					}
				}
			}
		});
		
		btnEliminarConj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (listPreparados.getSelectedValue()!=null) {
					conjPreparados.removeElement(listPreparados.getSelectedValue());
					pj.setConjuroDiarioNivel(pj.getConjurosDiarios()[listConocidos.getSelectedValue().getNivelHechizo()]+1, listConocidos.getSelectedValue().getNivelHechizo());
					actualizarLabelConjDiario();
				}
			}
		});
		
		//Restaurar valores de hechizos diarios
		
		btnRestaurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Borrar la lista
				conjPreparados= new DefaultListModel<Hechizo>();
				listPreparados.setModel(conjPreparados);
				//Restaurar los conjuros diarios del personaje
				pj.setConjurosDiarios();
				
				actualizarLabelConjDiario();
			}
		});
		
		//Modificar - activar todos los elementos que puedan ser editables por el usuario
		
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarVisibilidad();
			}

			
		});
		
		//Ver el hechizo selecionado
		
		btnVerConj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listPreparados.getSelectedValue()!=null) {
					
					DetalleHechizo internalFrame = new DetalleHechizo(listPreparados.getSelectedValue(), indicePj, listPreparados.getSelectedIndex());
					internalFrame.setVisible(true);
					Principal.desktopPane.add(internalFrame);
					try {
						internalFrame.setSelected(true);
					} catch (java.beans.PropertyVetoException e1) {
						e1.printStackTrace();
					}
					
					//Recargar lista de conj. preparados por si se hubiera lanzado.
					generarConjPreparados();
					listPreparados.setModel(conjPreparados);
				}
			}
		});
		
		
		
		//Refrescos cada vez que se lanza un hechizo (no encuentro otro evento que sea más efectivo que este)
		
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameActivated(InternalFrameEvent e) {
					generarConjPreparados();//Refresca la lista cada vez que se lanza un hechizo
			}
		});
		
		btnRefrescar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				generarSpinnerModels();//Refresca los spinnerModel
				asignarSpinnerModels();//Recarga los models en sus respectivos spinners
			}
		});
		
		
	}
	/**
	 * Modifica la visibilidad y 'editabilidad' de los elementos para habilitar la modificación.
	 */
	private void modificarVisibilidad() {
		textField_nombre.setEditable(true);
		textField_alineamiento.setEditable(true);
		
		comboBox_clase.setEnabled(true);
		comboBox_raza.setEnabled(true);
		
		spCa.setEnabled(true);
		spPg.setEnabled(true);
		spNivel.setEnabled(true);
		spAtaqueBase.setEnabled(true);
		
		spFue.setEnabled(true);
		spDes.setEnabled(true);
		spCon.setEnabled(true);
		spSab.setEnabled(true);
		spInt.setEnabled(true);
		spCar.setEnabled(true);
		
		btnAgregarConj.setEnabled(true);
		btnEliminarConj.setEnabled(true);
		btnGuardarPj.setEnabled(true);
	}
	/**
	 * Genera los elementos label de la interfaz.
	 */
	private void generarLabels() {
		lblFue = new JLabel("FUE");
		lblFue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFue.setBounds(12, 44, 26, 16);
		panel_Caracteristicas.add(lblFue);
		
		lblDes = new JLabel("DES");
		lblDes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDes.setBounds(12, 72, 26, 16);
		panel_Caracteristicas.add(lblDes);
		
		lblCaract = new JLabel("Puntos");
		lblCaract.setBounds(40, 23, 55, 16);
		panel_Caracteristicas.add(lblCaract);
		
		lblMod = new JLabel("Mod.");
		lblMod.setBounds(90, 23, 35, 16);
		panel_Caracteristicas.add(lblMod);
		
		lblSab = new JLabel("SAB");
		lblSab.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSab.setBounds(276, 44, 26, 16);
		panel_Caracteristicas.add(lblSab);
		
		lblCar = new JLabel("CAR");
		lblCar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCar.setBounds(276, 72, 26, 16);
		panel_Caracteristicas.add(lblCar);
		
		lblPuntos_1 = new JLabel("Puntos");
		lblPuntos_1.setBounds(301, 23, 55, 16);
		panel_Caracteristicas.add(lblPuntos_1);
		
		label_3 = new JLabel("Mod.");
		label_3.setBounds(351, 23, 35, 16);
		panel_Caracteristicas.add(label_3);
		
		lblCon = new JLabel("CON");
		lblCon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCon.setBounds(140, 44, 26, 16);
		panel_Caracteristicas.add(lblCon);
		
		lblInt = new JLabel("INT");
		lblInt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInt.setBounds(140, 72, 26, 16);
		panel_Caracteristicas.add(lblInt);
		
		lblPuntos = new JLabel("Puntos");
		lblPuntos.setBounds(168, 23, 55, 16);
		panel_Caracteristicas.add(lblPuntos);
		
		label_1 = new JLabel("Mod.");
		label_1.setBounds(218, 23, 35, 16);
		panel_Caracteristicas.add(label_1);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 29, 55, 16);
		panel_infoBasica.add(lblNombre);
		
		lblRaza = new JLabel("Raza:");
		lblRaza.setBounds(235, 29, 55, 16);
		panel_infoBasica.add(lblRaza);
		
		lblClase = new JLabel("Clase:");
		lblClase.setBounds(12, 57, 42, 16);
		panel_infoBasica.add(lblClase);
		
		lblNivel = new JLabel("Nivel:");
		lblNivel.setBounds(235, 57, 55, 16);
		panel_infoBasica.add(lblNivel);
		
		lblAlineamiento = new JLabel("Alineamiento:");
		lblAlineamiento.setBounds(12, 85, 77, 16);
		panel_infoBasica.add(lblAlineamiento);
		
		lblCa = new JLabel("CA:");
		lblCa.setBounds(235, 85, 26, 16);
		panel_infoBasica.add(lblCa);
		
		lblPg = new JLabel("PG:");
		lblPg.setBounds(328, 57, 26, 16);
		panel_infoBasica.add(lblPg);
		
		lblAtBase = new JLabel("At. base:");
		lblAtBase.setBounds(299, 85, 55, 16);
		panel_infoBasica.add(lblAtBase);
		
		lblConjurosDiarios = new JLabel("Conjuros diarios:");
		lblConjurosDiarios.setHorizontalAlignment(SwingConstants.LEFT);
		lblConjurosDiarios.setBounds(12, 36, 96, 16);
		panel_Conjuros.add(lblConjurosDiarios);
		
		lblConjurosConocidos = new JLabel("Conjuros conocidos:");
		lblConjurosConocidos.setHorizontalAlignment(SwingConstants.LEFT);
		lblConjurosConocidos.setBounds(12, 54, 153, 16);
		panel_Conjuros.add(lblConjurosConocidos);
		
		lblConjurosPreparados = new JLabel("Conjuros preparados:");
		lblConjurosPreparados.setHorizontalAlignment(SwingConstants.LEFT);
		lblConjurosPreparados.setBounds(236, 56, 150, 16);
		panel_Conjuros.add(lblConjurosPreparados);
		
		lblNiveles = new JLabel("Niveles:");
		lblNiveles.setHorizontalAlignment(SwingConstants.LEFT);
		lblNiveles.setBounds(12, 22, 55, 16);
		panel_Conjuros.add(lblNiveles);
		
		label = new JLabel("0");
		label.setBounds(115, 22, 12, 16);
		panel_Conjuros.add(label);
		
		label_2 = new JLabel("1");
		label_2.setBounds(139, 22, 12, 16);
		panel_Conjuros.add(label_2);
		
		label_4 = new JLabel("2");
		label_4.setBounds(163, 22, 12, 16);
		panel_Conjuros.add(label_4);
		
		label_5 = new JLabel("3");
		label_5.setBounds(187, 22, 12, 16);
		panel_Conjuros.add(label_5);
		
		label_6 = new JLabel("4");
		label_6.setBounds(211, 22, 12, 16);
		panel_Conjuros.add(label_6);
		
		label_7 = new JLabel("5");
		label_7.setBounds(235, 22, 12, 16);
		panel_Conjuros.add(label_7);
		
		label_8 = new JLabel("6");
		label_8.setBounds(259, 22, 12, 16);
		panel_Conjuros.add(label_8);
		
		label_9 = new JLabel("7");
		label_9.setBounds(283, 22, 12, 16);
		panel_Conjuros.add(label_9);
		
		label_10 = new JLabel("8");
		label_10.setBounds(307, 22, 12, 16);
		panel_Conjuros.add(label_10);
		
		label_20 = new JLabel("9");
		label_20.setBounds(331, 22, 12, 16);
		panel_Conjuros.add(label_20);
	}
	/**
	 * Genera los labels de los conjuros diarios.
	 */
	private void generarLabelsDiarios() {
		lblDiarios0 = new JLabel(String.valueOf(pj.getConjurosDiarios()[0]));
		lblDiarios0.setBounds(115, 36, 12, 16);
		panel_Conjuros.add(lblDiarios0);
		
		lblDiarios1 = new JLabel(String.valueOf(pj.getConjurosDiarios()[1]));
		lblDiarios1.setBounds(139, 36, 12, 16);
		panel_Conjuros.add(lblDiarios1);
		
		lblDiarios2 = new JLabel(String.valueOf(pj.getConjurosDiarios()[2]));
		lblDiarios2.setBounds(163, 36, 12, 16);
		panel_Conjuros.add(lblDiarios2);
		
		lblDiarios3 = new JLabel(String.valueOf(pj.getConjurosDiarios()[3]));
		lblDiarios3.setBounds(187, 36, 12, 16);
		panel_Conjuros.add(lblDiarios3);
		
		lblDiarios4 = new JLabel(String.valueOf(pj.getConjurosDiarios()[4]));
		lblDiarios4.setBounds(211, 36, 12, 16);
		panel_Conjuros.add(lblDiarios4);
		
		lblDiarios5 = new JLabel(String.valueOf(pj.getConjurosDiarios()[5]));
		lblDiarios5.setBounds(235, 36, 12, 16);
		panel_Conjuros.add(lblDiarios5);
		
		lblDiarios6 = new JLabel(String.valueOf(pj.getConjurosDiarios()[6]));
		lblDiarios6.setBounds(259, 36, 12, 16);
		panel_Conjuros.add(lblDiarios6);
		
		lblDiarios7 = new JLabel(String.valueOf(pj.getConjurosDiarios()[7]));
		lblDiarios7.setBounds(283, 36, 12, 16);
		panel_Conjuros.add(lblDiarios7);
		
		lblDiarios8 = new JLabel(String.valueOf(pj.getConjurosDiarios()[8]));
		lblDiarios8.setBounds(307, 36, 12, 16);
		panel_Conjuros.add(lblDiarios8);
		
		lblDiarios9 = new JLabel(String.valueOf(pj.getConjurosDiarios()[9]));
		lblDiarios9.setBounds(331, 36, 12, 16);
		panel_Conjuros.add(lblDiarios9);
	}
	/**
	 * Genera los botos de la interfaz.
	 */
	private void generarButtons() {
		
		btnRestaurar = new JButton("Restaurar diarios");
		btnRestaurar.setBounds(239, 330, 150, 20);
		panel_Conjuros.add(btnRestaurar);
		
		btnAgregarConj = new JButton(">");
		btnAgregarConj.setEnabled(false);
		btnAgregarConj.setFont(new Font("Dialog", Font.BOLD, 12));
		btnAgregarConj.setBounds(177, 75, 47, 32);
		panel_Conjuros.add(btnAgregarConj);
		
		btnEliminarConj = new JButton("<");
		btnEliminarConj.setEnabled(false);
		btnEliminarConj.setFont(new Font("Dialog", Font.BOLD, 12));
		btnEliminarConj.setBounds(177, 119, 47, 32);
		panel_Conjuros.add(btnEliminarConj);
		
		btnGuardarPj = new JButton("Guardar PJ");
		btnGuardarPj.setEnabled(false);
		btnGuardarPj.setBounds(290, 348, 126, 26);
		getContentPane().add(btnGuardarPj);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(152, 348, 126, 26);
		getContentPane().add(btnModificar);
		
		btnVerConj = new JButton("Lanzar conjuro");
		btnVerConj.setBounds(239, 308, 150, 20);
		panel_Conjuros.add(btnVerConj);
		
		btnRefrescar = new JButton("Refrescar");
		btnRefrescar.setBounds(12, 348, 126, 26);
		getContentPane().add(btnRefrescar);
	}
	/**
	 * Genera y rellena los listModels y los JList de la interfaz.
	 */
	private void generarLists() {
		//LIstmodels
		
		conjConocidos = new DefaultListModel<Hechizo>();
		generarConjConocidos();
		conjPreparados = new DefaultListModel<Hechizo>();
		generarConjPreparados();
		
		//Lists
		
		listConocidos = new JList<Hechizo>(conjConocidos);
		listConocidos.setBounds(12, 75, 153, 221);
		panel_Conjuros.add(listConocidos);
		
		listPreparados = new JList<Hechizo>(conjPreparados);
		listPreparados.setBounds(236, 75, 153, 221);
		panel_Conjuros.add(listPreparados);
	}
	/**
	 * Crea y carga los textFields de la interfaz.
	 */
	private void generarTextFields() {
		
		textField_nombre = new JTextField(pj.getNombre());
		textField_nombre.setEditable(false);
		textField_nombre.setBounds(70, 27, 153, 20);
		panel_infoBasica.add(textField_nombre);
		textField_nombre.setColumns(10);
		
		textField_alineamiento = new JTextField(pj.getAlineamiento());
		textField_alineamiento.setEditable(false);
		textField_alineamiento.setBounds(96, 83, 127, 20);
		panel_infoBasica.add(textField_alineamiento);
		textField_alineamiento.setColumns(10);
	}
	/**
	 * Crea los textFields necesarios para un personaje nuevo.
	 */
	private void generarTextFieldsPjNuevo() {
		
		textField_nombre = new JTextField("");
		textField_nombre.setEditable(false);
		textField_nombre.setBounds(70, 27, 153, 20);
		panel_infoBasica.add(textField_nombre);
		textField_nombre.setColumns(10);
		
		textField_alineamiento = new JTextField("");
		textField_alineamiento.setEditable(false);
		textField_alineamiento.setBounds(96, 83, 127, 20);
		panel_infoBasica.add(textField_alineamiento);
		textField_alineamiento.setColumns(10);
	}
	/**
	 * Genera los combobox de la interfaz.
	 */
	private void generarCombos() {
		
		comboBox_clase = new JComboBox(Clase.values());
		comboBox_clase.setEnabled(false);
		comboBox_clase.setBounds(70, 53, 153, 25);
		panel_infoBasica.add(comboBox_clase);
		
		comboBox_raza = new JComboBox(Raza.values());
		comboBox_raza.setEnabled(false);
		comboBox_raza.setBounds(274, 25, 121, 25);
		panel_infoBasica.add(comboBox_raza);
	}
	/**
	 * Genera los labels de los modificadores de características.
	 */
	private void generarLabelsMod() {
		
		lblModInt = new JLabel(String.valueOf(pj.getModInt()));
		lblModInt.setHorizontalAlignment(SwingConstants.LEFT);
		lblModInt.setBounds(215, 72, 35, 16);
		panel_Caracteristicas.add(lblModInt);
		
		lblModCon = new JLabel(String.valueOf(pj.getModCon()));
		lblModCon.setHorizontalAlignment(SwingConstants.LEFT);
		lblModCon.setBounds(215, 45, 35, 16);
		panel_Caracteristicas.add(lblModCon);
		
		lblModSab = new JLabel(String.valueOf(pj.getModSab()));
		lblModSab.setHorizontalAlignment(SwingConstants.LEFT);
		lblModSab.setBounds(351, 45, 35, 16);
		panel_Caracteristicas.add(lblModSab);
		
		lblModCar = new JLabel(String.valueOf(pj.getModCar()));
		lblModCar.setHorizontalAlignment(SwingConstants.LEFT);
		lblModCar.setBounds(351, 73, 35, 16);
		panel_Caracteristicas.add(lblModCar);
		
		lblModFue = new JLabel(String.valueOf(pj.getModFue()));
		lblModFue.setHorizontalAlignment(SwingConstants.LEFT);
		lblModFue.setBounds(90, 45, 35, 16);
		panel_Caracteristicas.add(lblModFue);
		
		lblModDes = new JLabel(String.valueOf(pj.getModDes()));
		lblModDes.setHorizontalAlignment(SwingConstants.LEFT);
		lblModDes.setBounds(90, 72, 35, 16);
		panel_Caracteristicas.add(lblModDes);
	}
	/**
	 * Genera y carga los spinners de la interfaz.
	 */
	private void generarSpinners() {

		spFue = new JSpinner(spinnerModelFue);
		spFue.setEnabled(false);
		spFue.setBounds(40, 42, 35, 20);
		panel_Caracteristicas.add(spFue);
		
		spDes = new JSpinner(spinnerModelDes);
		spDes.setEnabled(false);
		spDes.setBounds(40, 70, 35, 20);
		panel_Caracteristicas.add(spDes);
		
		spCon = new JSpinner(spinnerModelCon);
		spCon.setEnabled(false);
		spCon.setBounds(168, 42, 35, 20);
		panel_Caracteristicas.add(spCon);
		
		spInt = new JSpinner(spinnerModelInt);
		spInt.setEnabled(false);
		spInt.setBounds(168, 70, 35, 20);
		panel_Caracteristicas.add(spInt);
		
		spSab = new JSpinner(spinnerModelSab);
		spSab.setEnabled(false);
		spSab.setBounds(304, 42, 35, 20);
		panel_Caracteristicas.add(spSab);
		
		spCar = new JSpinner(spinnerModelCar);
		spCar.setEnabled(false);
		spCar.setBounds(304, 70, 35, 20);
		panel_Caracteristicas.add(spCar);
		
		spNivel = new JSpinner(spinnerModelNivel);
		spNivel.setEnabled(false);
		spNivel.setBounds(274, 55, 42, 20);
		panel_infoBasica.add(spNivel);
		
		spCa = new JSpinner(spinnerModelCa);
		spCa.setEnabled(false);
		spCa.setBounds(259, 83, 35, 20);
		panel_infoBasica.add(spCa);
		
		spPg = new JSpinner(spinnerModelPg);
		spPg.setEnabled(false);
		spPg.setBounds(352, 55, 35, 20);
		panel_infoBasica.add(spPg);
		
		spAtaqueBase = new JSpinner(spinnerModelAtaque);
		spAtaqueBase.setEnabled(false);
		spAtaqueBase.setBounds(352, 83, 35, 20);
		panel_infoBasica.add(spAtaqueBase);
		
	}
	/**
	 * Asigna los modelos a sus spinner correspondientes, recargando así los spinner.
	 */
	private void asignarSpinnerModels() {
		//asignar spinners 
		spFue.setModel(spinnerModelFue);
		spDes.setModel(spinnerModelDes);
		spCon.setModel(spinnerModelCon);
		spInt.setModel(spinnerModelInt);
		spSab.setModel(spinnerModelSab);
		spCar.setModel(spinnerModelCar);
		
		spNivel.setModel(spinnerModelNivel);
		spCa.setModel(spinnerModelCa);
		spPg.setModel(spinnerModelPg);
		spAtaqueBase.setModel(spinnerModelAtaque);
	}
	/**
	 * Genera los spinnerModel con los atributos del personaje.
	 */
	private void generarSpinnerModels() {
		spinnerModelFue = new SpinnerNumberModel(pj.getFuerza(), 1, 29, 1);
		spinnerModelDes = new SpinnerNumberModel(pj.getDestreza(), 1, 29, 1);
		spinnerModelCon = new SpinnerNumberModel(pj.getConstitucion(), 1, 29, 1);
		spinnerModelInt = new SpinnerNumberModel(pj.getInteligencia(), 1, 29, 1);
		spinnerModelSab = new SpinnerNumberModel(pj.getInteligencia(), 1, 29, 1);
		spinnerModelCar = new SpinnerNumberModel(pj.getCarisma(), 1, 29, 1);
		spinnerModelNivel = new SpinnerNumberModel(pj.getNivel(), 1, 20, 1);
		spinnerModelCa = new SpinnerNumberModel(pj.getCa(), 0, 40, 1);
		spinnerModelPg = new SpinnerNumberModel(pj.getPg(), -10, 999, 1);
		spinnerModelAtaque = new SpinnerNumberModel(pj.getAtaqueBase(), 1, 20, 1);
	}
	/**
	 * Genera los panels necesarios.
	 */
	private void generarPanels() {
		
		panel_Caracteristicas = new JPanel();
		panel_Caracteristicas.setBorder(new TitledBorder(null, "Caracter\u00EDsticas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Caracteristicas.setBounds(12, 147, 404, 123);
		getContentPane().add(panel_Caracteristicas);
		panel_Caracteristicas.setLayout(null);
		
		panel_infoBasica = new JPanel();
		panel_infoBasica.setBorder(new TitledBorder(null, "Informaci\u00F3n b\u00E1sica", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_infoBasica.setBounds(12, 12, 404, 123);
		getContentPane().add(panel_infoBasica);
		panel_infoBasica.setLayout(null);
		
		panel_Conjuros = new JPanel();
		panel_Conjuros.setBorder(new TitledBorder(null, "Conjuros", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Conjuros.setBounds(428, 12, 404, 362);
		getContentPane().add(panel_Conjuros);
		panel_Conjuros.setLayout(null);
	}
}
