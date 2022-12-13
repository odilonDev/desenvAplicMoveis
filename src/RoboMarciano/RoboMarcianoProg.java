package RoboMarciano;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPanel;
import java.awt.Font;

public class RoboMarcianoProg {

	private JFrame frame;
	private JTextField tfComando;
	private JTextField tfOperando1;
	private JTextField tfOperando2;
	private JTextField tfMensagem;
	private JTextField tfSorteio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoboMarcianoProg window = new RoboMarcianoProg();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RoboMarcianoProg() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 516, 341);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		RoboPremium robo1 = new RoboPremium();

		JTextArea taResultado = new JTextArea();
		taResultado.setBounds(10, 252, 465, 39);
		frame.getContentPane().add(taResultado);

		JLabel lbOperando1 = new JLabel("Operando 1:");
		lbOperando1.setBounds(10, 103, 73, 14);
		frame.getContentPane().add(lbOperando1);
		JLabel lbOperando2 = new JLabel("Operando 2:");
		lbOperando2.setBounds(127, 103, 79, 14);
		frame.getContentPane().add(lbOperando2);
		JLabel lbMensagem = new JLabel("Ação:");
		lbMensagem.setBounds(10, 137, 73, 14);
		frame.getContentPane().add(lbMensagem);
		JLabel lbSorteio = new JLabel("Número entre 1 e 5:");
		lbSorteio.setBounds(10, 162, 119, 14);
		frame.getContentPane().add(lbSorteio);	
		
		tfOperando1 = new JTextField();
		tfOperando1.setBounds(85, 100, 32, 20);
		frame.getContentPane().add(tfOperando1);
		tfOperando1.setColumns(10);
		tfOperando2 = new JTextField();
		tfOperando2.setBounds(203, 100, 32, 20);
		frame.getContentPane().add(tfOperando2);
		tfOperando2.setColumns(10);
		tfMensagem = new JTextField();
		tfMensagem.setBounds(85, 131, 239, 20);
		frame.getContentPane().add(tfMensagem);
		tfMensagem.setColumns(10);
		tfSorteio = new JTextField();
		tfSorteio.setBounds(130, 159, 32, 20);
		frame.getContentPane().add(tfSorteio);
		tfSorteio.setColumns(10);
		JButton btnConfirmar1 = new JButton("Confirmar");
		btnConfirmar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String comando = tfComando.getText();
				
				if ((comando.equals("some"))||(comando.equals("subtraia"))||(comando.equals("multiplique"))||(comando.equals("divida"))){
					String operando1 = tfOperando1.getText();
					String operando2 = tfOperando2.getText();
					taResultado.setText(robo1.responda(comando, operando1, operando2));
				}else if (comando.equals("adivinhe")){
					try {
						Integer numero = Integer.valueOf(tfSorteio.getText());
						taResultado.setText(robo1.responda(numero));
					}catch (Exception ex){
						taResultado.setText("Necesita ser digitado um número");
					}
				}else if (comando.equals("agir")){
			        String acao = tfMensagem.getText(); 
			        taResultado.setText(robo1.responda(comando, acao));
				}
			}
		});
		btnConfirmar1.setBounds(85, 190, 239, 23);
		frame.getContentPane().add(btnConfirmar1);

		tfComando = new JTextField();
		tfComando.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				taResultado.setText("");
				tfOperando1.setVisible(false);
				tfOperando2.setVisible(false);
				tfMensagem.setVisible(false);
				lbMensagem.setVisible(false);
				lbOperando1.setVisible(false);
				lbOperando2.setVisible(false);
				lbSorteio.setVisible(false);
				tfSorteio.setVisible(false);
				btnConfirmar1.setVisible(false);			
			}
		});
		tfComando.setBounds(85, 72, 239, 20);
		frame.getContentPane().add(tfComando);
		tfComando.setColumns(10);
		
		JButton btnConfirmar = new JButton("Enviar Comando");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String comando = tfComando.getText();
				if (comando.equals("FIM")) {
					System.exit(0);
				}else if ((comando.equals("some"))||(comando.equals("subtraia"))||(comando.equals("multiplique"))||(comando.equals("divida"))){
					tfOperando1.setVisible(true);
					tfOperando2.setVisible(true);
					lbOperando1.setVisible(true);
					lbOperando2.setVisible(true);
					btnConfirmar1.setVisible(true);
				}else if (comando.equals("adivinhe")){
					lbSorteio.setVisible(true);
					tfSorteio.setVisible(true);
					btnConfirmar1.setVisible(true);
				}else if (comando.equals("agir")){
					lbMensagem.setVisible(true);
					tfMensagem.setVisible(true);
					btnConfirmar1.setVisible(true);
				}else {
					taResultado.setText(robo1.responda(tfComando.getText()));
				}
			}
		});
		btnConfirmar.setBounds(334, 72, 141, 21);
		frame.getContentPane().add(btnConfirmar);
		
		JLabel lblNewLabel = new JLabel("Comando:");
		lblNewLabel.setBounds(10, 75, 73, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Resultado:");
		lblNewLabel_1.setBounds(10, 227, 73, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Digite um comando (some, subtraia, multiplica, divida, adivinhe , agir),");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 11, 480, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Faça uma pergunta, digite qualquer coisa ou FIM (para finalizar o programa)");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 26, 480, 14);
		frame.getContentPane().add(lblNewLabel_3);
			
				
	}
}
