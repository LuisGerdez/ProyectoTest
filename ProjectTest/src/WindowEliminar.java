import java.awt.Color;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import java.awt.Window.Type;

public class WindowEliminar {

	private JDialog frame;
	private JTable table;
	private static DefaultTableModel dm = new DefaultTableModel(new Object[][] {},new String[] {"ID", "Nombre", "Apellido", "Edad"});

	public WindowEliminar() {
		initialize();
	}

	private void initialize() {
		frame = new JDialog(frame, "Eliminar");
		frame.setType(Type.UTILITY);
		frame.setResizable(false);
		frame.setModal(true);
		frame.setBounds(100, 100, 439, 328);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 414, 168);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setToolTipText("");
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		table.setModel(dm);
		scrollPane.setViewportView(table);
		
		JSpinner spinner = new JSpinner();
		SpinnerNumberModel sm = new SpinnerNumberModel(0, 0, Persona.lista_p.size(), 1);
		spinner.setModel(sm);
		spinner.setBounds(192, 224, 43, 20);
		frame.getContentPane().add(spinner);
		
		JLabel lblSeleccioneIdA = new JLabel("Seleccione ID a eliminar");
		lblSeleccioneIdA.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccioneIdA.setBounds(148, 205, 148, 14);
		frame.getContentPane().add(lblSeleccioneIdA);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int ind = (int) spinner.getValue() - 1;
					Persona.lista_p.remove(ind);
					updateTable();
					FileSave.exportarInfo(Persona.lista_p);
					JOptionPane.showMessageDialog(null, "Se ha eliminado la persona con exito!");
				} catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Introduzca una ID valida");
				} catch (IndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Introduzca una ID valida");
				}
			}
		});
		btnEliminar.setBounds(166, 255, 97, 23);
		frame.getContentPane().add(btnEliminar);
		
		updateTable();
		
		frame.setVisible(true);
		
	}
	
	private static void updateTable() {
		if(Persona.lista_p.size() > 0) {
			dm.setRowCount(0);
			for(int i = 0;i < Persona.lista_p.size();i++) {
				int ind = Persona.lista_p.indexOf(Persona.lista_p.get(i)) + 1;
				Object info[] = {ind,Persona.lista_p.get(i).getNombre(),Persona.lista_p.get(i).getApellido(),Persona.lista_p.get(i).getEdad()};
				dm.addRow(info);
			}
		} else {
			dm.setRowCount(0);
		}
	}
}
