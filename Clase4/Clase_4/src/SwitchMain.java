package clase4;

import java.util.Scanner;

public class SwitchMain {

	public static void main(String[] args) {
		/**
		 * Realizar una mini calculadora
		 * operaciones:
		 * +,-,/,*
		 * 
		 * El usuario ingrear la operacion(+,/,*,- 0 PARA SALIR)
		 * 0,1,2,3,4 (0=salir; 1=resta; 2=mult; 3=divi; 4 =suma)
		 */
		//switch
		//ascci ?
		//if
		//do;while
		
		int opcion;
		double res;
		double a;
		double b;
		
		Scanner teclado = new Scanner(System.in);
		
		//alt+shit+m
		mostrarMenu();
		opcion = teclado.nextInt();
		
		if(opcion ==0) {
			System.exit(0);
		}

		System.out.println("Ingrese a");
		a = teclado.nextDouble();
		
		System.out.println("Ingrese b");
		b = teclado.nextDouble();
		
		switch(opcion) {
			case 1:
				res = a + b;			
				mostrarResultado(res, "+");
				break;
			case 2:			
				res = a - b;			
				mostrarResultado(res, "-");//f5
				break;
			case 3:			
				res = a * b;			
				mostrarResultado(res, "*");
				break;
			case 4:			
				if(b != 0) {
					res = a / b;
					mostrarResultado(res, "/");
				}else {
					System.out.println("No se puede divir por 0");
				}
				break;
		}
		teclado.close();
		
		System.out.println("Salida exitosa");
	}

	static void mostrarMenu() {
		System.out.println("Ingrese operacion: ");
		System.out.println("0=salir, 1=suma, 2=resta; 3=multi, 4=div");
	}

	static void mostrarResultado(double res, String operacion) {
		System.out.println(" La operacion " + operacion + " = " + res);//f6
	}//f7
}
