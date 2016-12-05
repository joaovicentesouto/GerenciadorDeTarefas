import java.awt.event.*;
import javax.swing.*;

public class LExcluidor implements ActionListener {
	
	private InterfaceRemove topo; // Componente que vai excluir um dos seus.
	private InterfaceProjeto excluir; // o projeto/tarefa que será excluido.
	private LAtualizarHome atualizarHome;
	
	public LExcluidor(InterfaceRemove topo, InterfaceProjeto excluir, LAtualizarHome atualizarHome) {
		this.topo = topo;
		this.excluir = excluir;
		this.atualizarHome = atualizarHome;
	}

	public void actionPerformed(ActionEvent e) {
		topo.remove(excluir);
		atualizarHome.atualizarHome();
	}
}
