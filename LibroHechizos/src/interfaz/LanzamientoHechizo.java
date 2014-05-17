package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.Window.Type;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LanzamientoHechizo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextPane txtpnBolaDeFuego;
	private JPanel buttonPane;
	private JButton okButton;

	/**
	 * Create the dialog.
	 */
	public LanzamientoHechizo(String mensajeMostrado) {
		setModal(true);
		setType(Type.POPUP);
		setBounds(100, 100, 450, 192);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtpnBolaDeFuego = new JTextPane();
		txtpnBolaDeFuego.setText(mensajeMostrado);
		txtpnBolaDeFuego.setBounds(12, 12, 410, 101);
		contentPanel.add(txtpnBolaDeFuego);
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	}
}
