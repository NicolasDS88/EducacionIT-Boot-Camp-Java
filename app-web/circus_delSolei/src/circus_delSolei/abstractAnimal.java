package circus_delSolei;

public abstract class abstractAnimal {
	
	String nombreAnimal;
	Long idCollar;
	String tipoAlimento;
	JaulaAnimal nombreAnimalEnLaJaula;
	
	
	
	public abstractAnimal(String nombreAnimal, Long idCollar, String tipoAlimento) {//despues agrego jaula JaulaAnimal nombreAnimalEnLaJaula
		super();
		this.nombreAnimal = nombreAnimal;
		this.idCollar = idCollar;
		this.tipoAlimento = tipoAlimento;
		this.nombreAnimalEnLaJaula = nombreAnimalEnLaJaula;
	}



	public abstract void hacerRuido(); //los metodos abstractos NO LLEVAN {}	
	//YA uqe la clase que lo implementa lo sobre escribe  
	
	public void decirNombre() {
		System.out.println("Nombre "+nombreAnimal);
		
	}

	

}
