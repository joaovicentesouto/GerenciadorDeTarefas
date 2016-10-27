import javax.swing.*;
import java.awt.*;

public class Configuracao {
	
	private JFrame f;
	private JPanel tela;
	private String state;
	
	public Configuracao(JFrame f, JPanel tela) {
		this.f = f;
		this.tela = tela;
		state = "LOGIN";
	}
	
	public void configGuia(JMenuBar menu) {
		JMenu guia;
	    guia = new JMenu("Arquivo");
	    JMenuItem item;
	    item = new JMenuItem("sair");
	    //item.addActionListener(new GestorGuia());
	    guia.add(item);
	    menu.add(guia);
	}
	
	public void configTela() {
		switch (state) {
		case "LOGIN" :
			telaLogin();
			break;
		case "HOME" : 
			telaHome();
		break;
		default : break;
		}
	}
	
	public void nextState(String nextState) {
		state = nextState;
	}
	
	private void telaLogin() {
		
		tela.removeAll();
		tela.setLayout(new GridLayout(3,3));
		
		JPanel log = new JPanel();
		log.setBackground(Color.blue);
		tela.add(log);
		
		log = new JPanel();
		log.setBackground(Color.cyan);
		tela.add(log);
		
		log = new JPanel();
		log.setBackground(Color.red);
		tela.add(log);
		
		log = new JPanel();
		log.setBackground(Color.GREEN);
		tela.add(log);
		
		//-------------------
		log = new JPanel();
		log.setLayout(new GridLayout(3,1));
		
		JPanel vazio = new JPanel();
		vazio.setBackground(Color.gray);
		log.add(vazio);
		
		vazio = new JPanel(new GridLayout(3,1));
		
		JPanel aux = new JPanel(new FlowLayout());
		JLabel r = new JLabel("Usuario");
		JTextField t = new JTextField(10);
		aux.add(r);
		aux.add(t);
		vazio.add(aux);
		
		aux = new JPanel(new FlowLayout());
		r = new JLabel("Senha");
		t = new JTextField(11);
		aux.add(r);
		aux.add(t);
		vazio.add(aux);
		
		aux = new JPanel(new FlowLayout());
		JButton b = new JButton("Cadastrar");
		aux.add(b);
		b = new JButton("Log In");
		b.addActionListener(new GestorLogin(this));
	    b.setActionCommand("HOME");
		aux.add(b);
		vazio.add(aux);
		log.add(vazio);
		
		vazio = new JPanel();
		vazio.setBackground(Color.gray);
		log.add(vazio);
		
		tela.add(log);
		//-------------------
		
		log = new JPanel();
		log.setBackground(Color.BLACK);
		tela.add(log);
		
		log = new JPanel();
		log.setBackground(Color.darkGray);
		tela.add(log);
		
		log = new JPanel();
		log.setBackground(Color.LIGHT_GRAY);
		tela.add(log);
		
		tela.repaint();
	}
	
	private void telaHome() {
		
		tela.removeAll();
		tela.setLayout(new BorderLayout());
		
		JPanel menu;
		menu = menuLateral();
		tela.add(menu, BorderLayout.WEST);
		
		JPanel home = new JPanel();
		home = home();
		tela.add(home, BorderLayout.CENTER);
		
		Dimension min = menu.getPreferredSize();
		min.width = 250;
		menu.setPreferredSize(min);
		
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
		b.addActionListener(new GestorLogin(this));
		b.setActionCommand("LOGIN");
		aux.add(b);
		home.add(aux, BorderLayout.SOUTH);
		
		return home;
	}

}
