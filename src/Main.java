import java.awt.*;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		
		JFrame f = new JFrame("Gerenciador de Tarefas");
		JPanel tela = new JPanel();
		Configuracao config = new Configuracao(f, tela);
		
		f.setContentPane(tela);
		config.configTela();
		
		JMenuBar menu = new JMenuBar();
	    f.setJMenuBar(menu);
	    config.configGuia(menu);
		
		Toolkit kit = Toolkit.getDefaultToolkit();  
		Dimension tamanho = kit.getScreenSize();
		
		f.setSize(tamanho.width, tamanho.height);
		f.setMinimumSize(new Dimension(500, 200));
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.repaint();
		
		//Projeto p = new Projeto("Projeto 1", "Descricao 1", 0, null);
		//new JNovoProjeto(p, tamanho);
	}

}
