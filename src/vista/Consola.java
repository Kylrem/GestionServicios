package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorUsuario;
import usuario.User;

import javax.swing.JTextField;
import javax.swing.JLabel;

public class Consola extends JFrame {

	private JPanel contentPane;
	private static ControladorUsuario controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consola frame = new Consola(controlador);
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
	public Consola(ControladorUsuario controlador) {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 693, 602);
	    this.setLocationRelativeTo(null);
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
	    contentPane.setLayout(null);

	    User user = controlador.getLoger();
	    String propiedades = controlador.mostrarPropiedadesUsuario(user);
	    JLabel lblNewLabel_3 = new JLabel(propiedades);
	    lblNewLabel_3.setBounds(10, 11, 657, 77);
	    contentPane.add(lblNewLabel_3);
	}
}
