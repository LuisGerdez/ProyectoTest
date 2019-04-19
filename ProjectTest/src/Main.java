import java.util.ArrayList;

public class Main {
	
	public static ArrayList<Persona> lista_p = new ArrayList<Persona>();
	
	public static void main(String[] args) {
		
		lista_p = FileSave.importarInfo();
		
		WindowMenu wm = new WindowMenu();
		
		if (FileSave.main_folder.exists() == false) {
			FileSave.main_folder.mkdir();
		}
		
//		//Creando objetos
//		Persona p1 = new Persona("Luis","Gerdez1",18);
//		Persona p2 = new Persona("Luis","Gerdez2",19);
//		Persona p3 = new Persona("Luis","Gerdez3",20);
//		
//		//Añadiendo a la array
//		lista_p.add(p1);
//		lista_p.add(p2);
//		lista_p.add(p3);
		
//		//Leyendo la array
//		//System.out.println("Leyendo array");
//		for(int i = 0;i < lista_p.size();i++) {
//			System.out.println(lista_p.indexOf(lista_p.get(i))+1 + ".- " + lista_p.get(i).getNombre() + " " + lista_p.get(i).getApellido());
//		}
//		System.out.println("");
//		
//		//Buscando en el array por nombre
//		System.out.println("Se encuentra alguien con nombre 'Luis1': "+Persona.buscarNombre("Luis1"));
//		System.out.println("Se encuentra alguien con nombre 'Carlos': "+Persona.buscarNombre("Carlos"));
//		
//		System.out.println("Se encuentra alguien con apellido 'Gerdez1': "+Persona.buscarApellido("Gerdez1"));
//		System.out.println("Se encuentra alguien con apellido 'Pitre': "+Persona.buscarApellido("Pitre"));
//		
//		System.out.println("Buscando en el array por nombre a 'Luisa'");
//		String busq_nombre = "Luisa";
//		
//		boolean encontrado = false;
//		for(int i = 0;i < lista_p.size();i++) {
//			if(encontrado == false && busq_nombre == lista_p.get(i).getNombre()) {
//				encontrado = true;
//				System.out.println("Si se encontro a '"+busq_nombre+"'");
//			}
//		}
//		
//		if (encontrado == false) {
//			System.out.println("No se encontro a '"+busq_nombre+"'");
//		}

	}
	

	

}
