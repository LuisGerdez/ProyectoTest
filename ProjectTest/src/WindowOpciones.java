import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class WindowOpciones {

	private JDialog frame;
	private JTextField textField;

	public WindowOpciones() {
		initialize();
	}

	private void initialize() {
		frame = new JDialog(frame, "Opciones");
		frame.setType(Type.UTILITY);
		frame.setResizable(false);
		frame.setModal(true);
		frame.setBounds(100, 100, 353, 143);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSeleccionaUnDirectorio = new JLabel("Selecciona un directorio para guardar archivos");
		lblSeleccionaUnDirectorio.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionaUnDirectorio.setBounds(21, 25, 304, 14);
		frame.getContentPane().add(lblSeleccionaUnDirectorio);
		
		textField = new JTextField();
		textField.setText(FileSave.main_folder.getAbsolutePath());
		textField.setEditable(false);
		textField.setBounds(10, 51, 263, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("...");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc=new JFileChooser(FileSave.main_folder);
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int sel = fc.showSaveDialog(frame);
				
				if(sel==JFileChooser.APPROVE_OPTION){
					FileSave.main_folder = fc.getSelectedFile();
					File file = new File(FileSave.main_folder.getAbsolutePath());
					file.mkdir();
					
					textField.setText(FileSave.main_folder.getAbsolutePath());
					
					FileSave.exportarInfo(Persona.lista_p);
				}
			}		   
		});
		button.setBounds(283, 50, 55, 23);
		frame.getContentPane().add(button);
		
		frame.setVisible(true);
	}
}
