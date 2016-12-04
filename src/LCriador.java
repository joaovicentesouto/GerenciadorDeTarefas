import javax.swing.*;
import java.awt.event.*;

public class LCriador implements ActionListener {

	JButton b;
	InterfaceAdd topo;
	
	public LCriador(JButton b, InterfaceAdd topo) {
		this.b = b;
		this.topo = topo;
	}
	
	public void actionPerformed(ActionEvent e) {
		//Controle controle = new Controle();
		//InterfaceProjeto = controle.recebeComponenete(); --> Tem que chamar o controle que vai criar os componentes e passar para add.
		InterfaceProjeto p = new Projeto(null, null, 0, null);
		topo.add(p);
	}

}
