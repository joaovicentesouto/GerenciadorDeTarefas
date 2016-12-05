
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;

public class LModificador implements ActionListener {

	private InterfaceProjeto p; // o projeto/tarefa que será completado.
	private LAtualizarHome atualizarHome;
	
	public LModificador(InterfaceProjeto p, LAtualizarHome atualizarHome) {
		this.p = p;
		this.atualizarHome = atualizarHome;
	}

	public void actionPerformed(ActionEvent e) {
		Toolkit kit = Toolkit.getDefaultToolkit();  
		Dimension tamanho = kit.getScreenSize();
		new JModificaProjeto(p, tamanho, atualizarHome);
	}
}
