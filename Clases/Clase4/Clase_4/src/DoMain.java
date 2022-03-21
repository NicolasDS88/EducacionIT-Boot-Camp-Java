package clase4;

import java.util.Scanner;

public class DoMain {

	public static void main(String[] args) {
		
		/**
		 * Leer un dato hasta que el usuario ingrese 0
		 */
		
		// la variabla debe estar fuera del do-while
		int opcion;
		Scanner teclado = new Scanner(System.in);//f8
		do {
			mostrarMenu();
			opcion = teclado.nextInt();
		}while(opcion < 0 || opcion > 4); //salir si < 0 || >4
		teclado.close();
		System.out.println("Fin");
	}

	private static void mostrarMenu() {
		System.out.println("Ingrese opcion (0 para salir, 1=suma; 2=restar,3= multi, 4=div)");
	}

}
