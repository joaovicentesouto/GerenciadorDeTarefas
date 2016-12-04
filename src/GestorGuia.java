import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorGuia implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		
		String cmd = e.getActionCommand();
		
		switch (cmd) {
		
		// -- Arquivo
		case "NOVO" : 
			break;
		case "SAIR" : 
			System.exit(0);
			break;
			
		// -- Ajuda
		case "AJUDA" : 
			break;
		case "SOBRE" : 
			break;
			
		default : break;
		}
	}

}
