package RoboMarciano;

import java.util.Scanner;

public class RoboImplementado {

	public static void main(String[] args) {

		RoboPremium robo1 = new RoboPremium();

		while (true) {
			System.out.println("\nDigite um comando (some, subtraia, multiplica, divida, adivinhe , agir),");
			System.out.println("Faça uma pergunta, digite qualquer coisa ou FIM (para finalizar o programa).");
			System.out.println("Comando:");
	        Scanner teclado = new Scanner( System.in );
			String comando = teclado.nextLine();
			if (comando.equals("FIM")){break;}
			//Robô Avançado - Calculos matemáticos
			if ((comando.equals("some"))||(comando.equals("subtraia"))||(comando.equals("multiplique"))||(comando.equals("divida"))){
		        System.out.println("Digite o operando 1:");
		        String operando1 = teclado.nextLine(); 
		        System.out.println("Digite o operando 2:");
		        String operando2 = teclado.nextLine(); 
		        System.out.println(robo1.responda(comando, operando1, operando2));
			//Robô Personalizado - O robô pede para o usuário adivinhar um número entre 1 e 5
			}else if (comando.equals("adivinhe")){
				System.out.println("Terráqueo, adivinhe o número que estou pensando,");
				System.out.println("entre 1 e 5:");
				try {
		          Integer numero = Integer.valueOf(teclado.nextLine());
		          System.out.println(robo1.responda(numero));
				}catch (Exception ex){
			        System.out.println("Necesita ser digitado um número");
				}
			//Robô Premium - executa ação solicitada pelo usuário
			}else if (comando.equals("agir")){
		        System.out.println("Ação:");
		        String acao = teclado.nextLine(); 
		        System.out.println(robo1.responda(comando, acao));
			//robô Limitado    
			}else {
		        System.out.println(robo1.responda(comando));
			}
		}
		System.out.println("Programa foi finalizado!");	
	}
}
