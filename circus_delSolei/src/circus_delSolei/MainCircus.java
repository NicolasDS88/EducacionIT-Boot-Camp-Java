package circus_delSolei;

public class MainCircus {

	public static void main(String[] args) {
		
		Mono[] muchosMonos = new Mono[3];
		JaulaAnimal[] jaulaAnimales=new JaulaAnimal[5]; //unMono.nombre() //unMono.suJaula()
		abstractAnimal[] abstractAnimal = new Mono[3];
		abstractAnimal[] abstractAnimal2 = new abstractAnimal[3];
		
		JaulaAnimal[] jaulaAnimales2=new abstractAnimal[5]; //unMono.nombre() //unMono.suJaula()
		
		
		
		
		
		Mono unMono = new Mono("Carlos", 00000001l, "Banana");
		Mono dosMono = new Mono("Juan", 00000002l, "Banana");
		Mono tresMono = new Mono("NoSePuedeDecir", 00000003l, "Manzana");
		
		muchosMonos[0]=unMono;
		muchosMonos[1]=dosMono;
		muchosMonos[2]=tresMono;
		
		abstractAnimal[0]=muchosMonos[0];
		jaulaAnimales[0]=abstractAnimal[0];
		
		//jaulaAnimales[0]=muchosMonos; //como hago?
		//jaulaAnimales[0]= {unMono};

		
		
		
		
	}

}
