import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		
		JFrame f = new JFrame();
		JPanel tela = new JPanel();
		Configuracao config = new Configuracao(f, tela);
		
		f.setContentPane(tela);
		config.configTela();
		
		/*JMenuBar menu = new JMenuBar();
	    f.setJMenuBar(menu);
	    config.configGuia(menu);*/
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400,500);
		//f.pack();
		f.setVisible(true);

	}

}
