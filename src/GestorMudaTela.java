import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorMudaTela implements ActionListener {

	private Configuracao config;
	
	public GestorMudaTela(Configuracao config) {
		this.config = config;
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd;
		cmd = e.getActionCommand();
		config.maquinaDeEstados(cmd);
	}

}
