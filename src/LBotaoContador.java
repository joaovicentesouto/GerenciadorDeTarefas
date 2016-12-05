import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LBotaoContador implements ActionListener{
	
	private Contador contador;
	private JTextFieldSomenteNumeros numero;
	private LAtualizarHome atHome;
	
	public LBotaoContador(Contador contador, JTextFieldSomenteNumeros numero, LAtualizarHome atHome) {
		this.contador = contador;
		this.numero = numero;
		this.atHome = atHome;
	}

	public void actionPerformed(ActionEvent e) {
		String cont = numero.getText();
		contador.contar(Integer.parseInt(cont));
		atHome.atualizarHome();
	}

}
