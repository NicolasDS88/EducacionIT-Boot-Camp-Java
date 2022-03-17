import java.util.Scanner;

public class validacion_fecha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int anio = 0;
		int mes;
		//                                en  fe  ma  ab  ma  jn  jl  ag  se  oc  no  di
		int[] mesReferenciaNoBisiesto = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int dia;

		anio = ingresoAnio();
		mes = ingreseMes();
		boolean esBisiesto = esBisiesto(anio);
		esBisiesto(anio);
		// es bisiesto nose si conviene mandarlo como metodo o referencia
		dia = ingreseDia(mes, mesReferenciaNoBisiesto, esBisiesto(anio));

		System.out.println("La fecha ingresado es: " + dia + "/" + mes + "/" + anio);
		System.out.println("Es bisiesto?= " + esBisiesto(anio));
		// fechaValida(dia,mes,anio);

	}

	/*
	 * Es año bisiesto si es divisible entre 4 (por ejemplo, 1988, 1992, 1996
	 * etcétera.) y da un número exacto. No es año bisiesto si SOLO es divisible
	 * entre 100 (como 2100, 2200, etcétera.). En cambio si, además de divisible
	 * entre 100, también lo es entre 400 sí será bisiesto (por ejemplo, 2000 y 2400
	 * son bisiestos ya que son divisibles entre 100 y también entre 400. Si bien,
	 * los años 1900, 2100, 2200 y 2300 no lo son porque sólo son divisibles entre
	 * 100).
	 * 
	 */
	private static boolean esBisiesto(int anio) {
		boolean esOnoEs = false;
		if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 100 == 0 && anio % 400 == 0)) {
			esOnoEs = true;
		}

		return esOnoEs;
	}

	public static int ingresoAnio() {
		Scanner objeto = new Scanner(System.in); // Create a Scanner object
		int anio;
		do {
			System.out.println("Ingrese un año:");
			anio = objeto.nextInt(); // si es un string rompe todo, pero no vimos try catch
		} while (!((anio >= 1900) && (anio <= 2099)));
		//objeto.close();
		return anio;
	}

	private static int ingreseMes() {
		Scanner objetoMes = new Scanner(System.in); // Create a Scanner object
		int mes;
		do {
			System.out.println("Ingrese un mes:");
			mes = objetoMes.nextInt(); // si es un string rompe todo, pero no vimos try catch
		} while (!((mes >= 1) && (mes <= 12)));
		//objetoMes.close();
		return mes;

	}

	private static int ingreseDia(int mes, int[] mesReferencia, boolean biSiesto) {
		Scanner objetoDia = new Scanner(System.in); // Create a Scanner object
		int dia = 0;
		if ((mes == 2) && biSiesto) {
			do {
				System.out.println("Ingrese un dia:");
				dia = objetoDia.nextInt(); // si es un string rompe todo, pero no vimos try catch
			} while (!((dia >= 1) && (dia <= 29))); // resto 1 por la diferencia de la pos

		}

		else {
			do {
				System.out.println("Ingrese un dia:");
				dia = objetoDia.nextInt(); // si es un string rompe todo, pero no vimos try catch
			} while (!((dia >= 1) && (dia <= mesReferencia[mes - 1]))); // resto 1 por la diferencia de la pos

		}

		objetoDia.close();
		return dia;

	}

}
