import java.util.Scanner;

public class EscuelaXYZ {

	// int tamañoLista;
	Alumno[] listaAlumnos = new Alumno[0]; // se que va a tener una lista de alumnos

	// constructor
	public EscuelaXYZ() {

		crearListaAlumnos(listaAlumnos());
	}

	// metodos

	int listaAlumnos() {
		Scanner pidoNumero = new Scanner(System.in);
		System.out.println("Ingrese la cantidad de alumnos por favor. 0 para Salir");
		int tamanio=0;
		
		do {
			System.out.println("Solo valores numericos mayores a 0: ");
			tamanio = pidoNumero.nextInt();
		} while (tamanio<=0 ); //nose por que no toma el 0 si pongo =

		return tamanio;

	}

	void crearListaAlumnos(int tamanio) { //en el constructor al creardo le pasa el tamaño del vec
		Alumno[] listaActualizada = new Alumno[tamanio];
		listaAlumnos = listaActualizada; // apunta al nuevo espacio de memoria de la nueva lista
	}

	void agregarAlumnos() {
		
		if (this.listaAlumnos.length > 0) {
			cargarDatosAlumno();
		} else {
			System.out.println("No se agregaron alumnos");
		}
	}

	void cargarDatosAlumno() {
		System.out.println("Agregando alumnos en la lista...");// puedo agregar alumnos
		Scanner pidoAlumno = new Scanner(System.in);
		for (int i = 0; i < this.listaAlumnos.length; i++) {
			mensajePedirDatos(i, "Ingrese NOMBRE del ");
			String nombre = pidoAlumno.nextLine();
			mensajePedirDatos(i, "Ingrese APELLIDO del ");
			String apellido = pidoAlumno.nextLine();
			mensajePedirDatos(i, "Ingrese ID del EXAMEN del ");
			long idExamen = pidoAlumno.nextLong(); // pongo long por que nose como maneja los ID, quizas es muy
													// grande
			byte nota = -1;
			mensajePedirDatos(i, "Ingrese la NOTA del alumno ");
			do {
				System.out.println("La nota debe ser entre 0 y 10");
				nota = pidoAlumno.nextByte();
			} while ((nota < 0) || (nota > 10));
			// despues de pedir lo agrego a la lista
			listaAlumnos[i] = new Alumno(nombre, apellido, idExamen, nota);
		}

	}

	void mensajePedirDatos(int contador, String mensaje) {
		System.out.println(mensaje + (contador + 1) + "º alumno");

	}

	// Pide buiscar alumnos, osea devuelvo una nueva lista si hay nota repetidas max
	// hacerlo con vector es una REEEEEEE paja
	Alumno[] buscoListaConNotaMAx() {
		int notaMax = saberNotaMax();
		int cantNotaMAx = cantNotaMaxRepetida();
		int contador = 0;
		Alumno[] listaNotaMax = new Alumno[cantNotaMAx];

		if (cantNotaMAx > 0) {
			do { // si es menor sigo buscando
				for (int i = 0; i < this.listaAlumnos.length; i++) {
					if (listaAlumnos[i].nota == notaMax) {
						
						listaNotaMax[contador] = listaAlumnos[i];
						contador++;
					}

				} //pregunto si habia 2 resultados al pedo seguir buscando en la lista
			} while (contador <= cantNotaMAx);
		}
		return listaNotaMax;
	}
	
	void imprimirAlumnosNotaMax() {
		Alumno[] imprimirLista=buscoListaConNotaMAx();
		System.out.println("Los alumnos con la nota mas alta son: ");
		for (Alumno alumno : imprimirLista) {
			System.out.println(alumno.nombre.toUpperCase()+" "+alumno.apellido.toUpperCase()+ " con la nota "+alumno.nota);
			
		}
	}

	int saberNotaMax() {
		int notaMax = 0;
		for (Alumno alumno : listaAlumnos) {
			if (alumno.nota > notaMax) {
				notaMax = alumno.nota;
			}
		}

		return notaMax;
	}

	int cantNotaMaxRepetida() {
		int notaMaxRepe = 0;
		int notaMAx = saberNotaMax();
		for (Alumno alumno : listaAlumnos) {
			if (alumno.nota == notaMAx) {
				notaMaxRepe++;
			}
		}

		return notaMaxRepe;
	}

}
