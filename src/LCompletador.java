import java.awt.event.*;
import javax.swing.*;

public class LCompletador implements ActionListener {

	InterfaceProjeto p; // o projeto/tarefa que será completado.
	
	public LCompletador(InterfaceProjeto p) {
		this.p = p;
	}

	public void actionPerformed(ActionEvent e) {
		p.completar();
	}
}
