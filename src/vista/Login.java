package vista;
import controlador.ControladorUsuario;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bdclass.UsuariosDAO;

import java.awt.Color;
import javax.swing.JLayeredPane;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 256, 139);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("DNI:");
		label.setBounds(10, 10, 24, 22);
		contentPane.add(label);
		
		Label label_1 = new Label("Password:");
		label_1.setBounds(10, 38, 70, 22);
		contentPane.add(label_1);
		
		TextField textDNI = new TextField();
		textDNI.setBounds(125, 10, 104, 22);
		contentPane.add(textDNI);
		
		TextField textPassword = new TextField();
		textPassword.setBounds(125, 38, 104, 22);
		contentPane.add(textPassword);
		
		Button button = new Button("Entrar");
		button.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        ControladorUsuario.iniciarSesion(textDNI.getText().trim(), textPassword.getText().trim());
		    }
		});
		button.setBounds(10, 66, 70, 22);
		contentPane.add(button);
		
		Button button_1 = new Button("Salir");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_1.setBounds(159, 66, 70, 22);
		contentPane.add(button_1);
	}
}
