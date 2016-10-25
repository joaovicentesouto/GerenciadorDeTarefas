import java.awt.event.*;
import javax.swing.*;

public class Excluidor implements ActionListener {
	
	JButton b;
	InterfaceRemove topo; // Componente que vai excluir um dos seus.
	InterfaceProjeto excluir; // o projeto/tarefa que será excluido.
	
	public Excluidor(JButton b, InterfaceRemove topo, InterfaceProjeto excluir) {
		this.b = b;
		this.topo = topo;
		this.excluir = excluir;
	}

	public void actionPerformed(ActionEvent e) {
		topo.remove(excluir);
	}
}
