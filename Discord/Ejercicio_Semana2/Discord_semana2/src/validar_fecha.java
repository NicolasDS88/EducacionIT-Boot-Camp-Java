import java.util.Scanner;

public class validar_fecha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int anio;
		int mes;
		//------------------------------- en- fe- ma- ab- ma- jn- jl- ag- se- oc- no- di-
		int[] mesReferenciaNoBisiesto = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int dia;
		anio = ingresarFecha("Año");
		mes = ingresarFecha("Mes");
		dia = ingresarFecha("Dia");
		mensajeValidarFecha(dia, mes, anio, mesReferenciaNoBisiesto);
	}

	public static int ingresarFecha(String ddmmyy) {
		Scanner objeto = new Scanner(System.in); // Create a Scanner object
		System.out.println("Ingrese un " + ddmmyy);
		int valor = objeto.nextInt();
		// objeto.close(); //ACA si habilito el close me tira ERROR
		return valor;
	}

	public static void mensajeValidarFecha(int dia, int mes, int anio, int[] mesReferenciaNoBisiesto) {
		if (validarFecha(dia, mes, anio, mesReferenciaNoBisiesto)) {
			System.out.println("La fecha " + dia + "/" + mes + "/" + anio + " es correcta");
			if (esBisiesto(anio)) {
				System.out.println("Ademas 'dato de color', ese año fue bisiesto");
			}
		} else {
			System.out.println("La fecha " + dia + "/" + mes + "/" + anio + " es INCORRECTA");
		}

	}

	public static boolean validarFecha(int dia, int mes, int anio, int[] mesReferenciaNoBisiesto) {
		boolean valor = false;
		if (validarAnio(anio) && validaMes(mes) && validaDia(dia, mesReferenciaNoBisiesto, anio, mes)) {
			valor = true;
		}
		return valor;
	}

	private static boolean validarAnio(int anio) {
		// TODO Auto-generated method stub
		boolean valor = false;
		if (((anio >= 1900) && (anio <= 2099))) {
			valor = true;
		}
		return valor;
	}

	private static boolean esBisiesto(int anio) {
		boolean esOnoEs = false;
		if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 100 == 0 && anio % 400 == 0)) {
			esOnoEs = true;
		}
		return esOnoEs;
	}

	private static boolean validaMes(int mes) {
		// TODO Auto-generated method stub
		boolean valor = false;
		if (((mes >= 1) && (mes <= 12))) {
			valor = true;
		}
		return valor;
	}

	private static boolean validaDia(int dia, int[] mesReferenciaNoBisiesto, int anio, int mes) {
		// TODO Auto-generated method stub
		boolean valor = false;
		if ((mes == 2) && (esBisiesto(anio)) && ((dia >= 1) && (dia <= 29))) {
			valor = true;
		} else if (((dia >= 1) && (dia <= mesReferenciaNoBisiesto[mes - 1]))) {
			valor = true;
		}
		return valor;
	}

}
