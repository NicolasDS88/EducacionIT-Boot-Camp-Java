package clase12;

public class ServiceS2 implements IService {

	@Override
	public Dato consultar() {
		
		//id pos 0 al 5 lenght 6
		//nombre del 6 al 21
		//saldo 
		            //01234567890123456789012345678901
		String res = "id0001nombrecarlos    saldo01550";
		//return new Dato(null,null);		
		
		String id = res.substring(2,5);
		String description = res.substring(12,21);
		
	}

	
	return new Dato(id, description);
}
