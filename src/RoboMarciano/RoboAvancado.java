package RoboMarciano;

public class RoboAvancado extends RoboLimitado {
	
	public String responda(String mensagem, String operando1, String operando2) {
		Integer operandoA;
		Integer operandoB;
		if(operando1.isEmpty()){
			operandoA = 0;
		}else{
			try {
				operandoA=Integer.valueOf(operando1);
			}catch (Exception ex){
				operandoA = 0;
			}
		}
		if(operando2.isEmpty()) {
			operandoB = 0;
		}else{
			try {
				operandoB=Integer.valueOf(operando2);
			}catch (Exception ex){
				operandoB = 0;
			}
		}
		if(mensagem.equals("some")) {
			return "Essa eu sei: "+(operandoA+operandoB);
		}else if(mensagem.equals("subtraia")){
			return "Essa eu sei: "+(operandoA-operandoB);
		}else if(mensagem.equals("multiplique")){
			return "Essa eu sei: "+(operandoA*operandoB);
		}else if(mensagem.equals("divida")){
			try {
				return "Essa eu sei: "+(operandoA/operandoB);
			}catch (Exception ex){
				return "Um número não pode ser divido por ZERO,\nOperando 2 necessita diferente de ZERO";
			}
		}else{
			return " Não entendi, informe a operação desejada: \nsome, subtraia, multiplica ou divida";
		}
		
	}	

}
