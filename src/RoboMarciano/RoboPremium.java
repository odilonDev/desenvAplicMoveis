package RoboMarciano;

public class RoboPremium extends RoboPersonalizado{

	public String responda(String comando, String acao) {
		if(comando.equals("agir")) {
			return "É pra já!\n"+acao;
		}else {
			return "Não entendi o comando";
		}
	}	
}
