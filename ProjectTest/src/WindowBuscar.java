import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Window.Type;

public class WindowBuscar {

	private JDialog frame;
	private JTextField txtbox_info;
	private JTable table;

	public WindowBuscar() {
		initialize();
	}

	private void initialize() {
		frame = new JDialog(frame, "Buscar");
		frame.setResizable(false);
		frame.setType(Type.UTILITY);
		frame.setModal(true);
		frame.setBounds(100, 100, 260, 317);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_info = new JLabel("Informaci\u00F3n:");
		lbl_info.setBounds(45, 25, 86, 14);
		frame.getContentPane().add(lbl_info);
		
		txtbox_info = new JTextField();
		txtbox_info.setBounds(120, 22, 86, 20);
		frame.getContentPane().add(txtbox_info);
		txtbox_info.setColumns(10);
		
		JComboBox combo_info = new JComboBox();
		combo_info.setMaximumRowCount(2);
		combo_info.setModel(new DefaultComboBoxModel(new String[] {"Nombre", "Apellido"}));
		combo_info.setSelectedIndex(0);
		combo_info.setBounds(120, 50, 86, 20);
		frame.getContentPane().add(combo_info);
		
		JLabel lbl_tipobusqueda = new JLabel("Buscar por:");
		lbl_tipobusqueda.setBounds(45, 50, 86, 14);
		frame.getContentPane().add(lbl_tipobusqueda);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 130, 234, 99);
		frame.getContentPane().add(scrollPane);
		
		JLabel lbl_amount = new JLabel("(0/"+Persona.lista_p.size()+")");
		lbl_amount.setForeground(SystemColor.windowBorder);
		lbl_amount.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_amount.setBounds(70, 229, 109, 14);
		frame.getContentPane().add(lbl_amount);
		
		table = new JTable();
		table.setEnabled(false);
		table.setToolTipText("");
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		DefaultTableModel dm = new DefaultTableModel(new Object[][] {},new String[] {"ID", "Nombre", "Apellido", "Edad"});
		table.setModel(dm);
		scrollPane.setViewportView(table);
		
		JButton btn_buscar = new JButton("Buscar");
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(combo_info.getSelectedItem() == "Nombre") {
					
					dm.setRowCount(0);
					boolean encontrado = false;
					int count = 0;
					
					for(int i = 0;i < Persona.lista_p.size();i++) {
						if(txtbox_info.getText().equals(Persona.lista_p.get(i).getNombre())) {
							int ind = Persona.lista_p.indexOf(Persona.lista_p.get(i)) + 1;
							Object info[] = {ind,Persona.lista_p.get(i).getNombre(),Persona.lista_p.get(i).getApellido(),Persona.lista_p.get(i).getEdad()};
							dm.addRow(info);
							encontrado = true;
							count++;
						}
					}
					
					lbl_amount.setText("("+count+"/"+Persona.lista_p.size()+")");
					
					if (encontrado == false) {
						JOptionPane.showMessageDialog(null, "No se encontro ningún resultado");
					}
				}
				
				if(combo_info.getSelectedItem() == "Apellido") {
					
					dm.setRowCount(0);
					boolean encontrado = false;
					int count = 0;
					
					for(int i = 0;i < Persona.lista_p.size();i++) {
						if(txtbox_info.getText().equals(Persona.lista_p.get(i).getApellido())) {
							int ind = Persona.lista_p.indexOf(Persona.lista_p.get(i)) + 1;
							Object info[] = {ind,Persona.lista_p.get(i).getNombre(),Persona.lista_p.get(i).getApellido(),Persona.lista_p.get(i).getEdad()};
							dm.addRow(info);
							encontrado = true;
							count++;
						}
					}
					
					lbl_amount.setText("("+count+"/"+Persona.lista_p.size()+")");
					
					if (encontrado == false) {
						JOptionPane.showMessageDialog(null, "No se encontro ningún resultado");
					}
				}
				
			}
		});
		
		btn_buscar.setBounds(83, 91, 89, 23);
		frame.getContentPane().add(btn_buscar);
		
		JButton btn_mostrartodo = new JButton("Mostrar todo");
		btn_mostrartodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(Persona.lista_p.size() > 0) {
					dm.setRowCount(0);
					int count = 0;
					for(int i = 0;i < Persona.lista_p.size();i++) {
						int ind = Persona.lista_p.indexOf(Persona.lista_p.get(i)) + 1;
						Object info[] = {ind,Persona.lista_p.get(i).getNombre(),Persona.lista_p.get(i).getApellido(),Persona.lista_p.get(i).getEdad()};
						dm.addRow(info);
						count++;
					}
					
					lbl_amount.setText("("+count+"/"+Persona.lista_p.size()+")");
					
				} else {
					dm.setRowCount(0);
					lbl_amount.setText("(0/"+Persona.lista_p.size()+")");
					JOptionPane.showMessageDialog(null, "No se encontro ningún resultado");
				}
				
			}
		});
		btn_mostrartodo.setBounds(70, 252, 109, 23);
		frame.getContentPane().add(btn_mostrartodo);

		
		frame.setVisible(true);
	}
}
