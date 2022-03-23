package intentoDos;

import java.util.Scanner;

public class EscuelaXYZ {

	Alumno[] arrayAlumnos;
	Alumno[] arrayNotaMin;
	Alumno[] arrayNotaMax;
	Alumno[] arrayAprobados;
	Alumno[] arrayDesaprobados;
	int notaAprobacion=7;

	// Constructor vacio escuela invoca los metodos
	EscuelaXYZ() {
		if (crearArrayConTamanio()) {
			System.out.println("Se creo un array de tamaño " + arrayAlumnos.length);
			agregarAlumnosAlArray();

		} else {
			System.err.println("Eligio 0, saliendo del sistema...");
			this.arrayAlumnos = new Alumno[0];
		}

	}

	public boolean crearArrayConTamanio() {
		boolean devuelvo = false;
		int tamanio = pedirTamañoArray();
		if (tamanio > 0) {
			this.arrayAlumnos = new Alumno[tamanio]; // seteo el tamaño de los alumno
			devuelvo = true;
		}
		return devuelvo;
	}

	private void agregarAlumnosAlArray() {
		Scanner string = new Scanner(System.in);
		Scanner inter = new Scanner(System.in);
		String nombre, apellido, id;
		int nota;
		System.out.println("Se deben agregar " + arrayAlumnos.length + " alumnos");
		for (int i = 0; i < arrayAlumnos.length; i++) {
			nombre = pedirNombreApellido("Nombre", i, string);
			apellido = pedirNombreApellido("Apellido", i, string);
			id = pedirNombreApellido("ID", i, string);
			nota = pedirNota(i, inter);
			arrayAlumnos[i] = new Alumno(nombre, apellido, id, nota);
			System.out.println("Se cargo el alumno en la lista");
		}
		cargarArrayNotaMax();
		cargarArrayNotaMin();
		//cargarUnArrayConMinOMax(arrayNotaMax, true); // le paso el array donde buscarlo
		//cargarUnArrayConMinOMax(arrayNotaMin, false);
		cargarAprobadosyDesaprobados();

		string.close();
		inter.close();

	}

	public void cargarAprobadosyDesaprobados() {
		int sizeAprobados=contadorAprobados();
		int sizeDesaprobados=arrayAlumnos.length-sizeAprobados;
		arrayAprobados=new Alumno[sizeAprobados];
		arrayDesaprobados=new Alumno[sizeDesaprobados];	
		int auxAprobados=0;
		int auxDesaprobados=0;
		for (Alumno alumno : arrayAlumnos) {
			if (alumno.getNota()>=notaAprobacion) {
				arrayAprobados[auxAprobados]=alumno;
				auxAprobados++;
			}else {
				arrayDesaprobados[auxDesaprobados]=alumno;
				auxDesaprobados++;				
			}			
		}					
	}
	
	public int contadorAprobados() {
		int contador=0;
		for (Alumno alumno : arrayAlumnos) {
			if (alumno.getNota()>=notaAprobacion) {
				contador++;
			}
		}
		return contador;
		
	}

	private String pedirNombreApellido(String queVoyAPedir, int numeroAlumno, Scanner string) {
		String texto = "";
		System.out.println("Por favor ingrese el " + queVoyAPedir + " del " + (numeroAlumno + 1) + "º estudiante:");
		if (string.hasNextLine()) {
			texto = string.next();
		}
		return texto;
	}

	private int pedirNota(int numeroAlumno, Scanner inter) {
		int nota = -1;
		do {
			System.out.println("Por favor ingrese la nota del " + (numeroAlumno + 1) + "º estudiante:");

			nota = inter.nextInt();

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

	void cargarArrayNotaMax() {
		int notaMax = buscarNotaMax(); // para comparar
		int tamañoNuevoArray = cantNotaMaxRepetida(); // para definir tamaño
		int aux = 0;
		if (tamañoNuevoArray > 0) { // hay alumnos cargados
			arrayNotaMax = new Alumno[tamañoNuevoArray];
			for (Alumno alumno : arrayAlumnos) {
				if (alumno.getNota() == notaMax) {
					arrayNotaMax[aux] = alumno;
					aux++;
				}
			}
		} else {
			arrayNotaMax = new Alumno[0]; // lo creo vacio
		}
	}

	void cargarUnArrayConMinOMax(Alumno[]unarray, boolean MaxOMin) { //si es por el true bsuca el max biceversa
		if (arrayAlumnos.length > 0) {
			if (MaxOMin) {
				int nota = notaBuscar(MaxOMin); // para comparar
				int tamanioNuevoArray = contadorDeNotaRepetida(MaxOMin); // para definir tamaño
				int aux = 0;
				if (tamanioNuevoArray > 0) { // hay alumnos cargados
					unarray = new Alumno[tamanioNuevoArray];
					for (Alumno alumno : arrayAlumnos) {
						if (alumno.getNota() == nota) {
							unarray[aux] = alumno;
							aux++;
						}
					}
				}
			} else {
				int nota = notaBuscar(MaxOMin); // para comparar
				int tamanioNuevoArray = contadorDeNotaRepetida(MaxOMin); // para definir tamaño
				int aux = 0;
				if (tamanioNuevoArray > 0) { // hay alumnos cargados
					unarray = new Alumno[tamanioNuevoArray];
					for (Alumno alumno : arrayAlumnos) {
						if (alumno.getNota() == nota) {
							unarray[aux] = alumno;
							aux++;

						}
					}
				}
			}
		} else {
			unarray = new Alumno[0]; // lo creo vacio para que no explote
		}
	}

	// proximo paso hacer 1 solo metodo que segun el parametro que le mando bnsuca
	// la nota
	// tendria que pasarle a que array agregarlo y la notamin o max
	// FALTA HACER 3- alumnos que promocionan, aquellos que obtuvieron un promedio
	// >= 7
	// 4- alumnos que deben recursar la materia, aquellos que obtuvieron un promedio
	// < 7"

	void cargarArrayNotaMin() {
		int notaMin = buscarNotaMin(); // para comparar
		int tamañoNuevoArray = cantNotaMinRepetida(); // para definir tamaño
		int aux = 0;
		if (tamañoNuevoArray > 0) { // hay alumnos cargados
			arrayNotaMin = new Alumno[tamañoNuevoArray];
			for (Alumno alumno : arrayAlumnos) {
				if (alumno.getNota() == notaMin) {
					arrayNotaMin[aux] = alumno;
					aux++;
				}
			}
		} else {
			arrayNotaMin = new Alumno[0]; // lo creo vacio
		}
	}

	public void mostrarArray(Alumno[] mostrar, String mensajeTitulo) {
		if ((mostrar != null) && (mostrar.length > 0)) { // si pongo el null despeus caga todo
			System.out.println("La lista con alumnos que tienen la nota " + mensajeTitulo);
			for (Alumno alumno : mostrar) {
				System.out.println(alumno.toString());
			}
		} else {
			System.out.println("Nada para mostrar");
		}

	}

	public int notaBuscar(boolean MaxOMin) {// por true busca el mas alto y biceversa
		int notaDevolver = 0;
		if ((arrayAlumnos.length) > 0) {
			if (MaxOMin) { // true busca nota mas alta

				for (Alumno alumno : arrayAlumnos) {
					if (alumno.getNota() > notaDevolver) {
						notaDevolver = alumno.getNota();
					}
				}

			} else {// false busca la nota mas baja
				notaDevolver = 11;
				for (Alumno alumno : arrayAlumnos) {
					if (alumno.getNota() < notaDevolver) {
						notaDevolver = alumno.getNota();
					}
				}

			}
		}
		return notaDevolver;

	}

	public int buscarNotaMax() {
		int notaMax = 0;
		if ((arrayAlumnos.length) > 0) {
			for (Alumno alumno : arrayAlumnos) {
				if (alumno.getNota() > notaMax) {
					notaMax = alumno.getNota();
				}
			}

		}
		return notaMax;
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

	public int contadorDeNotaRepetida(boolean MaxOMin) {
		int notaRepetida = 0;
		if (MaxOMin) {// entra por el true
			int notaMAx = notaBuscar(MaxOMin);
			for (Alumno alumno : arrayAlumnos) {
				if (alumno.getNota() == notaMAx) {
					notaRepetida++;
				}
			}
		} else {
			int notaMin = notaBuscar(MaxOMin);
			for (Alumno alumno : arrayAlumnos) {
				if (alumno.getNota() == notaMin) {
					notaRepetida++;
				}
			}

		}

		return notaRepetida;
	}

	int cantNotaMaxRepetida() {
		int notaMaxRepe = 0; // pongo 1 por que una nota va a devolver.
		int notaMAx = buscarNotaMax();
		for (Alumno alumno : arrayAlumnos) {
			if (alumno.getNota() == notaMAx) {
				notaMaxRepe++;
			}
		}
		return notaMaxRepe;
	}

	int cantNotaMinRepetida() {
		int notaMinRepe = 0; // pongo 1 por que una nota va a devolver.
		int notaMin = buscarNotaMin();
		for (Alumno alumno : arrayAlumnos) {
			if (alumno.getNota() == notaMin) {
				notaMinRepe++;
			}
		}
		return notaMinRepe;
	}

}
