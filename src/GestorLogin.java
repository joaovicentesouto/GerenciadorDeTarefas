import java.awt.event.*;

public class GestorLogin implements ActionListener {

	private Configuracao config;
	
	public GestorLogin(Configuracao config) {
		this.config = config;
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd;
		cmd = e.getActionCommand();
		config.nextState(cmd);
		config.configTela();
	}

}
