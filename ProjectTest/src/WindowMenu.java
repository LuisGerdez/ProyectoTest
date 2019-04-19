import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WindowMenu {

	private JFrame frame;

	public WindowMenu() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 251, 226);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btn_registrar = new JButton("Registrar");
		btn_registrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//frame.dispose();
				WindowRegistrar wr = new WindowRegistrar();
			}
		});
		btn_registrar.setBounds(76, 24, 89, 23);
		frame.getContentPane().add(btn_registrar);
		
		JButton btn_buscar = new JButton("Buscar");
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WindowBuscar wb = new WindowBuscar();
			}
		});
		btn_buscar.setBounds(76, 58, 89, 23);
		frame.getContentPane().add(btn_buscar);
		
		JButton btn_eliminar = new JButton("Eliminar");
		btn_eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WindowEliminar we = new WindowEliminar();
			}
		});
		btn_eliminar.setBounds(76, 92, 89, 23);
		frame.getContentPane().add(btn_eliminar);
		
		JButton btn_opciones = new JButton("Opciones");
		btn_opciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WindowOpciones wo = new WindowOpciones();
			}
		});
		btn_opciones.setBounds(76, 155, 89, 23);
		frame.getContentPane().add(btn_opciones);
		
		frame.setVisible(true);
	}
}
