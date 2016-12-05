import java.awt.event.*;
import javax.swing.*;

public class LCompletador implements ActionListener {

	private InterfaceProjeto p; // o projeto/tarefa que será completado.
	private LAtualizarHome atualizarHome;
	
	public LCompletador(InterfaceProjeto p, LAtualizarHome atualizarHome) {
		this.p = p;
		this.atualizarHome = atualizarHome;
	}

	public void actionPerformed(ActionEvent e) {
		p.completar();
		atualizarHome.atualizarHome();
	}
}
