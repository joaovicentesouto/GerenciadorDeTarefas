import javax.swing.*;
import java.awt.event.*;

public class Criador implements ActionListener {

	JButton b;
	InterfaceProjeto topo;
	
	public Criador(JButton b, InterfaceProjeto topo) {
		this.b = b;
		this.topo = topo;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// mesmo para este, criar outra interface pra ter metodo add?
		//topo.add(new InterfaceProjeto()????);
	}

}
