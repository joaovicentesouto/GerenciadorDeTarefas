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
	
	public void inicio() {
		tela.setLayout(new CardLayout());
		
		tela.add(telaLogin(), "LOGIN");
		tela.add(telaHome(), "HOME");
	}

	private JPanel telaLogin() {
		
		JPanel principal = new JPanel(new BorderLayout());
		
		//-- NORTH
		JPanel log = new JPanel();
		log.setBackground(Color.blue);
		principal.add(log, BorderLayout.NORTH);

		Dimension min = log.getPreferredSize();
		min.height = (500/2)-75;
		log.setPreferredSize(min);
		//-- Fim NORTH

		//--- CENTER Login
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
		JPasswordField p = new JPasswordField(11);
		aux.add(r);
		aux.add(p);
		log.add(aux);

		aux = new JPanel(new FlowLayout());
		JButton b = new JButton("Cadastrar");
		aux.add(b);
		b = new JButton("Log In");
		b.addActionListener(new GestorMudaTela(config));
		b.setActionCommand("HOME");
		aux.add(b);
		log.add(aux);
		
		principal.add(log, BorderLayout.CENTER);
		//--- Fim CENTER
		
		//-- SOUTH
		log = new JPanel();
		log.setBackground(Color.cyan);
		principal.add(log, BorderLayout.SOUTH);
		
		min = log.getPreferredSize();
		min.height = (500/2)-75;
		log.setPreferredSize(min);
		//-- Fim SOUTH

		principal.setName("LOGIN");
		
		return principal;
	}
	
	public void ajusteTamanhoLogin() {
		
		JPanel card = null;
		for (Component comp : tela.getComponents()) {
		    if (comp.getName().equals("LOGIN")) {
		        card = (JPanel) comp;
		    }
		}
		
		BorderLayout layout = (BorderLayout) card.getLayout();
		
		JPanel aux = (JPanel) layout.getLayoutComponent(BorderLayout.NORTH);
		Dimension min = aux.getPreferredSize();
		min.height = (f.getHeight()/2)-75;
		aux.setPreferredSize(min);
		
		aux = (JPanel) layout.getLayoutComponent(BorderLayout.SOUTH);
		min = aux.getPreferredSize();
		min.height = (f.getHeight()/2)-75;
		aux.setPreferredSize(min);
		
		tela.repaint();
	}

	private JPanel telaHome() {

		JPanel principal = new JPanel(new BorderLayout());
		
		//-- WEST
		JPanel aux = menuLateral();
		principal.add(aux, BorderLayout.WEST);
		
		//-- CENTER
		aux = home();
		principal.add(aux, BorderLayout.CENTER);
		
		principal.setName("HOME");
		
		return principal;

	}

	private JPanel menuLateral() {
		JPanel menu = new JPanel();
		menu.setLayout(new GridLayout(5,1));

		JLabel l = new JLabel("Menu lateral");
		JButton b = new JButton("Meu projeto");
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

		JPanel aux = new JPanel(new BorderLayout());
		JLabel msg = new JLabel("Home");
		
		Dimension t = msg.getPreferredSize();
		t.width = 50;
		msg.setPreferredSize(t);
		
		aux.setBackground(Color.gray);
		aux.add(msg, BorderLayout.WEST);
		
		JButton b = new JButton("Volta log in");
		b.addActionListener(new GestorMudaTela(config));
		b.setActionCommand("LOGIN");
		t = b.getPreferredSize();
		t.width = 100;
		b.setPreferredSize(t);
		
		aux.add(b, BorderLayout.EAST);
		
		t = aux.getPreferredSize();
		t.height = 75;
		aux.setPreferredSize(t);
		
		home.add(aux, BorderLayout.NORTH);
		
		//-- Centro
		aux = new JPanel(new GridLayout(5,1));

		JLabel l = new JLabel("Meu projeto");
		aux.add(l);
		b = new JButton("a");
		aux.add(b);
		b = new JButton("b");
		aux.add(b);
		b = new JButton("c");
		aux.add(b);
		b = new JButton("d");
		aux.add(b);
		
		aux.setBackground(Color.LIGHT_GRAY);
		home.add(aux, BorderLayout.SOUTH);
		
		t = aux.getPreferredSize();
		t.height = f.getHeight()-75;
		aux.setPreferredSize(t);
		//-- Fim Centro
		
		return home;
	}
	
	public void ajusteTamanhoHome() {
		BorderLayout layout = (BorderLayout) tela.getLayout();
		
		JPanel aux = (JPanel) layout.getLayoutComponent(BorderLayout.CENTER);
		
		BorderLayout lay = (BorderLayout) aux.getLayout();
		
		JPanel aux2 = (JPanel) lay.getLayoutComponent(BorderLayout.SOUTH);
		
		Dimension min = aux2.getPreferredSize();
		min.height = f.getHeight()-75;
		aux2.setPreferredSize(min);
		
		tela.repaint();
	}

}
