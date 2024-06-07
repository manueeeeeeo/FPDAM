package practica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window.Type;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtClave;
	static Login frame1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame1 = new Login();
					frame1.setVisible(true);
					
					App.frame2 = new App();
					App.frame2.setVisible(false);
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
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 448);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INICIAR SESIÓN");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(new Color(255, 0, 128));
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 33));
		lblNewLabel.setBounds(190, 21, 284, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User:");
		lblNewLabel_1.setForeground(new Color(255, 0, 128));
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(138, 143, 75, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Clave");
		lblNewLabel_2.setForeground(new Color(255, 0, 128));
		lblNewLabel_2.setFont(new Font("Sitka Subheading", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(140, 221, 45, 18);
		contentPane.add(lblNewLabel_2);
		
		txtUser = new JTextField();
		txtUser.setBounds(232, 142, 210, 19);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtClave = new JTextField();
		txtClave.setBounds(232, 220, 210, 19);
		contentPane.add(txtClave);
		txtClave.setColumns(10);
		
		JButton btnBorrar = new JButton("BORRAR");
		btnBorrar.setBackground(new Color(255, 255, 255));
		btnBorrar.setForeground(new Color(255, 0, 128));
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Para borrar los campos de texto
				
				txtUser.setText("");
				txtClave.setText("");
			}
		});
		btnBorrar.setFont(new Font("Sitka Subheading", Font.BOLD, 24));
		btnBorrar.setBounds(128, 328, 138, 42);
		contentPane.add(btnBorrar);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setForeground(new Color(255, 0, 128));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Para verificar el login
				if (txtUser.getText().equalsIgnoreCase("Admin")) {
					if(txtClave.getText().equalsIgnoreCase("Admin")) {
						// Si la clave y el suer están bien pasamos a la siguiente pantalla
						JOptionPane.showMessageDialog(null, "Bienvenido "+txtUser.getText());
						frame1.setVisible(false);
						App.frame2.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
						txtUser.setText("");
						txtClave.setText("");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Campos incorrectos");
					txtUser.setText("");
					txtClave.setText("");
				}
			}
		});
		btnEntrar.setFont(new Font("Sitka Subheading", Font.BOLD, 24));
		btnEntrar.setBounds(430, 328, 116, 42);
		contentPane.add(btnEntrar);
	}
}
