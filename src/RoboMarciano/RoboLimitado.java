package RoboMarciano;

public class RoboLimitado {

	public String responda(String mensagem) {
		if(mensagem.isEmpty() ) {
			return "Não me incomode";
		}else if (mensagem.toUpperCase().startsWith("EU")) {
			return "A responsabilidade é sua.";
		}else if(mensagem.equals(mensagem.toUpperCase())&&(mensagem.contains("?"))){
			return "Relaxa, eu sei o que estou fazendo!";
		}else if(mensagem.equals(mensagem.toUpperCase())){
			return "Opa! Calma aí!";
		}else if(mensagem.contains("?")){
			return "Certamente";
		}else {
			return "Tudo bem, como quiser";
		}
	}	
}