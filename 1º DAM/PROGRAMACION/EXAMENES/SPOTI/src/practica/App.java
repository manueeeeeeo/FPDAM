package practica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Window.Type;

public class App extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static App frame2;
	private JTextField txtCod;
	private ArrayList<Grupos> grup;
	private ArrayList<Canciones> can;

	// Getters y Setters
	public ArrayList<Grupos> getGrup() {
		return grup;
	}

	public void setGrup(ArrayList<Grupos> grup) {
		this.grup = grup;
	}

	public ArrayList<Canciones> getCan() {
		return can;
	}

	public void setCan(ArrayList<Canciones> can) {
		this.can = can;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame2 = new App();
					frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public App() {
		setType(Type.UTILITY);
		this.grup = new ArrayList<Grupos>();
		this.can = new ArrayList<Canciones>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 531);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Grupos y Canciones");
		lblNewLabel.setForeground(new Color(255, 0, 128));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 27));
		lblNewLabel.setBounds(71, 28, 264, 47);
		contentPane.add(lblNewLabel);

		txtCod = new JTextField();
		txtCod.setBounds(49, 276, 147, 26);
		contentPane.add(txtCod);
		txtCod.setColumns(10);

		JTextArea txtResul = new JTextArea();
		txtResul.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtResul.setForeground(new Color(255, 255, 255));
		txtResul.setBackground(new Color(255, 0, 128));
		txtResul.setText("Grupos y Canciones:");
		txtResul.setBounds(233, 85, 546, 383);
		contentPane.add(txtResul);

		JButton btnNewButton_1 = new JButton("Ver Canciones");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Para ver las canciones
				txtResul.setText("Canciones:");
				boolean si = false;
				can.clear();
				cargarCanciones("canciones.csv");
				for (Canciones canciones : can) {
					if (canciones.getCodGrup().equals(txtCod.getText())) {
						si = true;
					}
				}
				if (si == false) {
					if (txtCod.getText().equals("")) {
						for (Canciones cab : can) {
							txtResul.setText(txtResul.getText() + "\n" + "\n" + cab);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Ese código no es valido");
						txtCod.setText("");
					}
				} else if (si == true) {
					for (Canciones cab : selectCanciones(txtCod.getText())) {
						txtResul.setText(txtResul.getText() + "\n" + "\n" + cab);
					}
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(33, 333, 175, 26);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton = new JButton("Ver Grupos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtResul.setText("Grupos:");
				grup.clear();
				cargarGrupos("grupos.csv");
				for (Grupos grupos : grup) {
					txtResul.setText(txtResul.getText() + "\n" + "\n" + grupos);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(33, 161, 175, 31);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("Código del Grupo:");
		lblNewLabel_1.setForeground(new Color(255, 0, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(49, 224, 138, 40);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton_2 = new JButton("BORRAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtResul.setText("Grupos y Canciones:");
				txtCod.setText("");
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_2.setBounds(42, 399, 154, 40);
		contentPane.add(btnNewButton_2);
	}

	// Metodo para cargar el fichero de los grupos
	public void cargarGrupos(String filename) {
		try {
			Scanner escritor = new Scanner(new File(filename));
			while (escritor.hasNext()) {
				String cadena = escritor.nextLine();
				String[] linea = cadena.split(";");

				String cod = linea[0];
				String nombre = linea[1];
				int fecha = Integer.parseInt(linea[2]);
				String genero = linea[3];

				this.getGrup().add(new Grupos(cod, nombre, fecha, genero));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Metodo para cargar el fichero de las canciones
	public void cargarCanciones(String filename) {
		try {
			Scanner escritor = new Scanner(new File(filename));
			while (escritor.hasNext()) {
				String cadena = escritor.nextLine();
				String[] linea = cadena.split(";");

				String codi = linea[0];
				String album = linea[1];
				String nombre = linea[2];
				int mit = Integer.parseInt(linea[3]);
				int seg = Integer.parseInt(linea[4]);

				this.getCan().add(new Canciones(codi, album, nombre, mit, seg));

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Metodo para elegir las canciones
	public ArrayList<Canciones> selectCanciones(String cod) {
		ArrayList<Canciones> aux = new ArrayList<Canciones>();
		for (Canciones canciones : this.getCan()) {
			if (canciones.getCodGrup().equals(cod)) {
				aux.add(canciones);
			}
		}
		return aux;
	}
}