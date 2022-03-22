package intentoDos;

import java.util.Arrays;
import java.util.Scanner;

public class EscuelaXYZ {

	Alumno[] arrayAlumnos;

	// Constructor vacio escuela invoca los metodos
	EscuelaXYZ() {
		if (crearArrayConTamanio()) {
			System.out.println("Se creo un array de tamaño " + this.arrayAlumnos.length);
			agregarAlumnosAlArray();

		} else {
			System.err.println("Eligio 0, saliendo del sistema...");

		}

	}

	private void agregarAlumnosAlArray() {
		Scanner string = new Scanner(System.in);
		Scanner bit = new Scanner(System.in);
		String nombre, apellido, id;
		byte nota;

		for (int i = 0; i < arrayAlumnos.length; i++) {
			nombre = pedirNombreApellido("Nombre", i, string);
			apellido = pedirNombreApellido("Apellido", i, string);
			id = pedirNombreApellido("ID", i, string);
			nota = pedirNota(i, bit);
			arrayAlumnos[i] = new Alumno(nombre, apellido, id, nota);
		}
		string.close();
		bit.close();
	}

	private String pedirNombreApellido(String queVoyAPedir, int numeroAlumno, Scanner string) {
		String texto = "";
		System.out.println("Por favor ingrese el " + queVoyAPedir + " del " + (numeroAlumno + 1) + "º estudiante:");
		if (string.hasNextLine()) {
			texto = string.next();
		}
		return texto;
	}

	private byte pedirNota(int numeroAlumno, Scanner bit) {
		byte nota = -1;
		do {
			System.out.println("Por favor ingrese la nota del " + (numeroAlumno + 1) + "º estudiante:");
			if (bit.hasNextLine()) {
				nota = bit.nextByte();
			}
		} while (!((nota >= 0) && (nota <= 10)));
		return nota;
	}

	public int pedirTamañoArray() {
		Scanner escanner = new Scanner(System.in);
		int tamanioArray = -1;
		do {
			System.out.println("Ingrese la cantidad de alumnos mayor a 0, 0 para Salir.");
			tamanioArray = escanner.nextInt();
		} while (!(tamanioArray >= 0));
		// escanner.close(); el .close cierra TODO hijo de puta
		return tamanioArray;
	}

	public boolean crearArrayConTamanio() {
		boolean devuelvo = false;
		int tamanio = pedirTamañoArray();
		if (tamanio > 0) {
			this.arrayAlumnos = new Alumno[tamanio];
			devuelvo = true;
		}
		return devuelvo;
	}

	public Alumno[] arrayAlumnosNotaMax() {
		int notaMax = buscarNotaMax();
		int tamañoNuevoArray = 1;//cantNotaMaxRepetida();
		int aux = 0;
		Alumno[] arrayNotaMax = new Alumno[tamañoNuevoArray];
		if (notaMax > -1) {// busco que tenga una nota max valida
			do { // recorro el array hasta que encuentro la cantidad de notas max
				for (int i = 0; i < arrayAlumnos.length; i++) {
					if (arrayAlumnos[i].getNota() == notaMax) {
						arrayNotaMax[aux] = arrayAlumnos[i];
						aux++;
					}
				}

			} while (aux <= tamañoNuevoArray);

		} else {
			System.err.println("No hay alumnos con nota");

		}

		return arrayNotaMax;
	}
	
	
	public void mostrarArray(Alumno[] arrayMostrar,String mensajeTitulo) {
		System.out.println("La lista con alumnos que tienen la nota "+mensajeTitulo);
		for (Alumno alumno : arrayMostrar) {
			System.out.println(alumno.toString());
		}
		
	}

	public int buscarNotaMax() {
		int notaMax = -1;
		if (arrayAlumnos.length > 0) {
			for (Alumno alumno : arrayAlumnos) {
				if (alumno.getNota() > notaMax) {
					notaMax = alumno.getNota();
				}
			}
		}
		return notaMax;
	}

	int cantNotaMaxRepetida() {
		int notaMaxRepe = 1; //pongo 1 por que una nota va a devolver.
		int notaMAx = buscarNotaMax();
		for (Alumno alumno : arrayAlumnos) {
			if (alumno.getNota() == notaMAx) {
				notaMaxRepe++;
			}
		}

		return notaMaxRepe;
	}

	public int buscarNotaMin() {
		int notaMin = 11;
		if (arrayAlumnos.length > 0) {
			for (Alumno alumno : arrayAlumnos) {
				if (alumno.getNota() < notaMin) {
					notaMin = alumno.getNota();
				}
			}
		}
		return notaMin;
	}

}
