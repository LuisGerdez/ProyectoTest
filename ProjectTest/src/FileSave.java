import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class FileSave {
	public static File main_folder = new File(System.getProperty("user.home")+File.separator+"Desktop"+File.separator+"data"+File.separator);  // Set default value
	public static File config_rute = new File(System.getProperty("user.home")+File.separator+"config.data");
	
	public static void exportarInfo(ArrayList<Persona> list) {
		File file;
		
		try {
			file = new File(main_folder.getAbsolutePath()+File.separator+"info.txt");
			System.out.println("Creando obj file: "+ main_folder.getAbsolutePath());
			FileWriter file_wr;
			
			file_wr = new FileWriter(file);
			
			if(list.size() > 0) {
				for(int i = 0;i < Persona.lista_p.size();i++) {
					int ind = list.indexOf(list.get(i)) + 1;
					String nombre = list.get(i).getNombre();
					String apellido = list.get(i).getApellido();
					int edad = list.get(i).getEdad();
					
					file_wr.write(ind+">>"+nombre+">>"+apellido+">>"+edad+System.getProperty("line.separator"));
				}
			}
			file_wr.close();
			
			file = new File(config_rute.getAbsolutePath());
			
			file_wr = new FileWriter(file);
			file_wr.write(FileSave.main_folder.getAbsolutePath()+File.separator);
			file_wr.close();
			
		} catch (IOException e) {
			
		}

	}
	
	public static ArrayList<Persona> importarInfo() {
		ArrayList<Persona> list = new ArrayList<Persona>();
		Persona p;
		File file;
		FileReader file_rd;
		BufferedReader file_br;
		
		file = new File(config_rute.getAbsolutePath());
		
		if (file.exists() == true) {
			try {
				file_rd = new FileReader(file);
				file_br = new BufferedReader(file_rd);
				
				main_folder = new File(file_br.readLine());
				file_br.close();
			} catch (IOException e) {
				
			}
			
		} else {
			System.out.println("Error");
			main_folder = new File(System.getProperty("user.home")+File.separator+"Desktop"+File.separator+"data"+File.separator);
		}
		
		file = new File(main_folder.getAbsolutePath()+File.separator+"info.txt");
		
		if (file.exists() == true) {
			try {
				file_rd = new FileReader(file);
				file_br = new BufferedReader(file_rd);
				
				String line = file_br.readLine();
				while (line != null) {
					String[] split = line.split(">>");
					String nombre = split[1];
					String apellido = split[2];
					int edad = Integer.valueOf(split[3]);
					
					p = new Persona(nombre, apellido, edad);
					list.add(p);
					
					line = file_br.readLine();
				}
				file_br.close();
			} catch (IOException e) {
			}
		} else {
			JOptionPane.showMessageDialog(null, "No se ha encontrado la ubicación para guardar archivos");			
			main_folder = new File(System.getProperty("user.home")+File.separator+"Desktop"+File.separator+"data"+File.separator);
			file = new File(config_rute.getAbsolutePath());
			file.delete();
			FileSave.exportarInfo(Persona.lista_p);
			JOptionPane.showMessageDialog(null, "Se ha establecido la ubicación por defecto '"+main_folder.getAbsolutePath()+File.separator+"'");
		}
	
		return list;
	}
	
}
