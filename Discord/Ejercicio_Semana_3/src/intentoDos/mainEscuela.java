package intentoDos;

public class mainEscuela {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EscuelaXYZ escuelita=new EscuelaXYZ();
		
		System.out.println("-------------------------------------");
		escuelita.mostrarArray(escuelita.arrayAlumnos, "de todos es:");		
		System.out.println("-------------------------------------");		
		escuelita.mostrarArray(escuelita.arrayNotaMax,"Nota Max");
		System.out.println("-------------------------------------");
		escuelita.mostrarArray(escuelita.arrayNotaMin,"Nota Min");
		
	}

}
