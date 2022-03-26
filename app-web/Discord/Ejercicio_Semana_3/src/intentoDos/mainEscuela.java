package intentoDos;

public class mainEscuela {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EscuelaXYZ escuelita=new EscuelaXYZ();
		
		if (escuelita.arrayAlumnos.length>0) {
			System.out.println("----------------------------------------------");
			escuelita.mostrarArray(escuelita.arrayAlumnos, "de todos es:");		
			System.out.println("----------------------------------------------");		
			escuelita.mostrarArray(escuelita.arrayNotaMax,"del cuadro de honor");
			System.out.println("----------------------------------------------");
			escuelita.mostrarArray(escuelita.arrayNotaMin,"los burros");
			System.out.println("----------------------------------------------");
			escuelita.mostrarArray(escuelita.arrayAprobados,"Aprobados");
			System.out.println("----------------------------------------------");
			escuelita.mostrarArray(escuelita.arrayDesaprobados,"Desaprobados");
			
		}
		
	}

}
