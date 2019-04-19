import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class WindowRegistrar {

	private JDialog frame;
	private JTextField txtbox_nombre;
	private JTextField txtbox_apellido;

	public WindowRegistrar() {
		initialize();
	}

	private void initialize() {
		frame = new JDialog(frame, "Registrar");
		frame.setType(Type.UTILITY);
		frame.setResizable(false);
		frame.setModal(true);
		frame.setBounds(100, 100, 237, 232);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_nombre = new JLabel("Nombre:");
		lbl_nombre.setBounds(39, 40, 54, 14);
		frame.getContentPane().add(lbl_nombre);
		
		txtbox_nombre = new JTextField();
		txtbox_nombre.setBounds(93, 40, 86, 20);
		frame.getContentPane().add(txtbox_nombre);
		txtbox_nombre.setColumns(10);
		
		JLabel lbl_apellido = new JLabel("Apellido:");
		lbl_apellido.setBounds(39, 68, 54, 14);
		frame.getContentPane().add(lbl_apellido);
		
		txtbox_apellido = new JTextField();
		txtbox_apellido.setColumns(10);
		txtbox_apellido.setBounds(93, 65, 86, 20);
		frame.getContentPane().add(txtbox_apellido);
		
		JLabel lbl_edad = new JLabel("Edad:");
		lbl_edad.setBounds(39, 93, 54, 14);
		frame.getContentPane().add(lbl_edad);
		
		JComboBox<Integer> combo_edad = new JComboBox<Integer>();
		for(int i=16;i<29;i++) {
			combo_edad.addItem(i);
		}
		combo_edad.setBounds(93, 90, 54, 20);
		frame.getContentPane().add(combo_edad);
		
		JButton btn_registrar = new JButton("Registrar");
		btn_registrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int edad = (int) combo_edad.getSelectedItem();
				Persona p1 = new Persona(txtbox_nombre.getText(),txtbox_apellido.getText(),edad);
				Persona.lista_p.add(p1);
				JOptionPane.showMessageDialog(null, "Se ha registrado la persona con exito!");
				
				FileSave.exportarInfo(Persona.lista_p);
			}
		});
		btn_registrar.setBounds(63, 141, 89, 23);
		frame.getContentPane().add(btn_registrar);
		
		frame.setVisible(true);
	}

}
