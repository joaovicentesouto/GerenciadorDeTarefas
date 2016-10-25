import java.awt.event.*;
import javax.swing.*;

public class Apagador implements ActionListener {
	
	JButton b;
	InterfaceProjeto topo, excluir; // o projeto/tarefa que será completado.
	
	public Apagador(JButton b, InterfaceProjeto topo, InterfaceProjeto excluir) {
		this.b = b;
		this.topo = topo;
		this.excluir = excluir;
	}

	public void actionPerformed(ActionEvent e) {
		// para remover preciso criar outra interface que contenha o metodo remover..
		//topo.remove(excluir);
	}
}
