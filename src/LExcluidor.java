import java.awt.event.*;
import javax.swing.*;

public class LExcluidor implements ActionListener {
	
	InterfaceRemove topo; // Componente que vai excluir um dos seus.
	InterfaceProjeto excluir; // o projeto/tarefa que será excluido.
	
	public LExcluidor(InterfaceRemove topo, InterfaceProjeto excluir) {
		this.topo = topo;
		this.excluir = excluir;
	}

	public void actionPerformed(ActionEvent e) {
		topo.remove(excluir);
	}
}
