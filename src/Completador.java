import java.awt.event.*;
import javax.swing.*;

public class Completador implements ActionListener {

	JButton b;
	InterfaceProjeto p; // o projeto/tarefa que será completado.
	
	public Completador(JButton b, InterfaceProjeto p) {
		this.b = b;
		this.p = p;
	}

	public void actionPerformed(ActionEvent e) {
		p.completar();
	}
}
