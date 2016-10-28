import java.awt.*;
import javax.swing.*;

public class Construtor {

	private JFrame f;
	private JPanel tela;
	private Configuracao config;

	public Construtor(JFrame f, JPanel tela, Configuracao config) {
		this.f = f;
		this.tela = tela;
		this.config = config;
		
		f.addComponentListener(new GestorTamanhoTela(this, config));
	}

	public void telaLogin() {

		tela.removeAll();
		
		tela.setLayout(new BorderLayout());

		JPanel log = new JPanel();
		log.setBackground(Color.blue);
		tela.add(log, BorderLayout.NORTH);
		
		Dimension min = log.getPreferredSize();
		Dimension frame = f.getSize();
		min.height = frame.height/2-100;
		log.setPreferredSize(min);

		//--- Centro Login
		log = new JPanel();
		log.setLayout(new GridLayout(3,1));

		JPanel aux = new JPanel(new FlowLayout());
		JLabel r = new JLabel("Usuario");
		JTextField t = new JTextField(10);
		aux.add(r);
		aux.add(t);
		log.add(aux);

		aux = new JPanel(new FlowLayout());
		r = new JLabel("Senha");
		t = new JTextField(11);
		aux.add(r);
		aux.add(t);
		log.add(aux);

		aux = new JPanel(new FlowLayout());
		JButton b = new JButton("Cadastrar");
		aux.add(b);
		b = new JButton("Log In");
		b.addActionListener(new GestorLogin(config));
		b.setActionCommand("HOME");
		aux.add(b);
		log.add(aux);
		
		tela.add(log, BorderLayout.CENTER);
		//---
		
		log = new JPanel();
		log.setBackground(Color.cyan);
		tela.add(log, BorderLayout.SOUTH);
		
		min = log.getPreferredSize();
		frame = f.getSize();
		min.height = frame.height/2-100;
		log.setPreferredSize(min);
		
		tela.repaint();
	}
	
	public void ajusteTamanhoLogin() {
		BorderLayout layout = (BorderLayout) tela.getLayout();
		
		JPanel aux = (JPanel) layout.getLayoutComponent(BorderLayout.NORTH);
		Dimension min = aux.getPreferredSize();
		min.height = (f.getHeight()/2)-75;
		aux.setPreferredSize(min);
		
		aux = (JPanel) layout.getLayoutComponent(BorderLayout.SOUTH);
		min = aux.getPreferredSize();
		min.height = (f.getHeight()/2)-75;
		aux.setPreferredSize(min);
		
		f.repaint();
	}

	public void telaHome() {

		tela.removeAll();
		tela.setLayout(new BorderLayout());

		JPanel menu;
		menu = menuLateral();
		tela.add(menu, BorderLayout.WEST);

		JPanel home = new JPanel();
		home = home();
		tela.add(home, BorderLayout.CENTER);

		tela.repaint();

	}

	private JPanel menuLateral() {
		JPanel menu = new JPanel();
		menu.setLayout(new GridLayout(5,1));

		JLabel l = new JLabel("Menu lateral");
		JButton b = new JButton("Projeto 1");
		menu.add(l);
		menu.add(b);
		b = new JButton("Projeto 2");
		menu.add(b);
		b = new JButton("Projeto 3");
		menu.add(b);
		b = new JButton("Projeto 4");
		menu.add(b);

		Dimension min = menu.getPreferredSize();
		min.width = 250;
		menu.setPreferredSize(min);

		return menu;
	}

	private JPanel home() {
		JPanel home = new JPanel();
		home.setLayout(new BorderLayout());

		JPanel aux = new JPanel();
		JLabel msg = new JLabel("Home");
		aux.setBackground(Color.BLUE);
		aux.add(msg);
		home.add(aux, BorderLayout.NORTH);

		Dimension t = aux.getPreferredSize();
		t.height = 100;
		aux.setPreferredSize(t);

		aux = new JPanel();
		JButton b = new JButton("Volta log in");
		b.addActionListener(new GestorLogin(config));
		b.setActionCommand("LOGIN");
		aux.add(b);
		home.add(aux, BorderLayout.SOUTH);

		return home;
	}

}
