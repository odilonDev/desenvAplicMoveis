package RoboMarciano;

import java.util.Random;

public class RoboPersonalizado extends RoboAvancado {
	public String responda(Integer numero) {
		Random random = new Random();
		Integer pensamento = random.nextInt(4)+1;
		
		if(pensamento==numero){
			return "Acertou!";
		}else{
			return "Errou, eu pensei o número "+pensamento;
		}
	}	
}
