import java.util.Scanner;

public class EscuelaXYZ {

	int tama�oLista;
	Alumno[] listaAlumnos = new Alumno[0]; // se que va a tener una lista de alumnos

	// constructor
	public EscuelaXYZ() {
		tama�oLista = pedirTamanioLista();
		crearListaAlumnos(tama�oLista);
	}

	// metodos

	int pedirTamanioLista() {
		Scanner pidoNumero = new Scanner(System.in);
		System.out.println("Ingrese la cantidad de alumnos pro favor: ");
		int tamanio;
		do {
			System.out.println("Solo valores numericos:");
			tamanio = pidoNumero.nextInt();
		} while (tamanio <= 0);

		return tamanio;

	}

	void crearListaAlumnos(int tamanio) {
		Alumno[] listaActualizada = new Alumno[tamanio];
		listaAlumnos = listaActualizada; // apunta al nuevo espacio de memoria de la nueva lista
	}

}
