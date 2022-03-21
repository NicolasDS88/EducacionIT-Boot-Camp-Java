import java.util.Scanner;

public class EscuelaXYZ {

	int tamañoLista;
	Alumno[] listaAlumnos = new Alumno[0]; // se que va a tener una lista de alumnos

	// constructor
	public EscuelaXYZ() {
		
		crearListaAlumnos(listaAlumnos());
	}

	// metodos

	int listaAlumnos() {
		Scanner pidoNumero = new Scanner(System.in);
		System.out.println("Ingrese la cantidad de alumnos pro favor: ");
		int tamanio;
		do {
			System.out.println("Solo valores numericos:");
			tamanio = pidoNumero.nextInt();
		} while (tamanio <=0);

		return tamanio;

	}

	void crearListaAlumnos(int tamanio) {
		Alumno[] listaActualizada = new Alumno[tamanio];
		listaAlumnos = listaActualizada; // apunta al nuevo espacio de memoria de la nueva lista
	}

	void agregarAlumnos(){
		if (this.listaAlumnos.length>0) {
			System.out.println("Agregando alumnos en la lista...");//puedo agregar alumnos
			Scanner pidoAlumno = new Scanner(System.in);
			for (int i = 0; i < this.listaAlumnos.length; i++) {
				System.out.println("Ingrese NOMBRE del "+(i+1)+"º alumno");
				String nombre=pidoAlumno.nextLine();
				System.out.println("Ingrese APELLIDO del "+(i+1)+"º alumno");
				String apellido=pidoAlumno.nextLine();
				System.out.println("Ingrese ID del EXAMEN del "+(i+1)+"º alumno");
				long idExamen=pidoAlumno.nextLong(); //pongo long por que nose como maneja los ID, quizas es muy grande
				
				byte nota;
				do{System.out.println("Ingrese la NOTA del "+(i+1)+"º alumno");
					nota=pidoAlumno.nextByte();}
				while (((nota>-1)&&(nota<11)));// se que va del 0 al 10
				
				listaAlumnos[i]=new Alumno(nombre, apellido, idExamen, nota);
			}
			
		} else {System.out.println("No se pueden agregar alumnos");}
		
	}
	
	
	
}
