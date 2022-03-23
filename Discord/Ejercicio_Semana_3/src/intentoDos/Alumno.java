package intentoDos;

public class Alumno {

	private String nombre;
	private String apellido;
	private String idExamen;
	private int nota; //del 0 al 10
	
	
	public String getNombre() {
		return nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public String getIdExamen() {
		return idExamen;
	}


	public int getNota() {
		return this.nota;
	}


	//constructor 
	public Alumno(String nombre, String apellido, String idExamen, int nota) {		
		this.nombre = nombre;
		this.apellido = apellido;
		this.idExamen = idExamen;
		this.nota = nota;
	}


	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido=" + apellido + ", idExamen=" + idExamen + ", nota=" + nota
				+ "]";
	}

	
	
	
	
}
