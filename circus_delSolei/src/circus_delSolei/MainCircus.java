package circus_delSolei;

public class MainCircus {

	public static void main(String[] args) {
		
		Mono[] muchosMonos = new Mono[3];
		JaulaAnimal[] jaulaAnimales=new JaulaAnimal[5]; //unMono.nombre() //unMono.suJaula()
		
		
		
		Mono unMono = new Mono("Carlos", 00000001l, "Banana");
		Mono dosMono = new Mono("Juan", 00000002l, "Banana");
		Mono tresMono = new Mono("NoSePuedeDecir", 00000003l, "Manzana");
		
		muchosMonos[0]=unMono;
		muchosMonos[1]=dosMono;
		muchosMonos[2]=tresMono;
		
		//jaulaAnimales[0]=muchosMonos; //como hago?
		

	}

}
