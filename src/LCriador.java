import javax.swing.*;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;

public class LCriador implements ActionListener {

	private InterfaceAdd topo;
	private JHome home;
	
	public LCriador(JHome home, InterfaceAdd topo) {
		this.home = home;
		this.topo = topo;
	}
	
	public void novoTopo(InterfaceAdd topo) {
		this.topo = topo;
	}
	
	public void actionPerformed(ActionEvent e) {
		Toolkit kit = Toolkit.getDefaultToolkit();  
		Dimension tamanho = kit.getScreenSize();
		new JNovoProjeto(home, topo, tamanho);
	}

}
