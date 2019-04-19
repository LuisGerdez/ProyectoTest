
public class Persona extends Main{
	private String nombre;
	private String apellido;
	private int edad;
	
	public Persona(String n, String ap, int e) {
		nombre = n;
		apellido = ap;
		edad = e;
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public int getEdad() {
		return edad;
	}
}
