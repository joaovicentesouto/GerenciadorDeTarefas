import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Construtor {

	private JFrame f;
	private JPanel tela;
	private Configuracao config;
	private ActionListener listener;

	public Construtor(JFrame f, JPanel tela, Configuracao config) {
		this.f = f;
		this.tela = tela;
		this.config = config;
		this.listener = new LComportamento(config, tela, new BancoDeDados());
		f.addComponentListener(new GestorTamanhoTela(this, config, f, tela));
	}
	
	public void inicio() {
		// TESTE -- criando usuario e projetos para testar a tree
		Usuario us = new Usuario("Bruno", "123");
		Projeto p = new Projeto("Projeto 1", "Descricao 1", 2, null);
		p.add(new Projeto("Projeto Dentro 1", "Desc dentro 1", 0, null));
		us.add(p);
		us.add(new Projeto("Projeto 2", "Desc 2", 1, null));
		us.add(new Projeto("Projeto 3", "Descr 3", 2, null));
		us.add(new Projeto("Projeto 4", "Desc 2", 0, null));
		us.add(new Projeto("Projeto 5", "Descr 3", 1, null));
		tela.setLayout(new CardLayout());
		telaLogin();
		telaCadastro();
		telaHome(us);
	}

	public void telaLogin() {
		
		JPanel principal = new JPanel(new BorderLayout());
		
		JPanel log;
		
		log = new JPanel();
		principal.add(log, BorderLayout.NORTH);
		
		JPanel login = new JLogin(f, listener);
		principal.add(login, BorderLayout.CENTER);

		log = new JPanel();
		principal.add(log, BorderLayout.SOUTH);
		
		principal.repaint();
		principal.setName("LOGIN");
		
		tela.add(principal, "LOGIN");
	}
	
	public void telaCadastro(){		
			
		JPanel principal = new JPanel(new BorderLayout());
		
		JPanel log;
		
		log = new JPanel();
		principal.add(log, BorderLayout.NORTH);
		
		JPanel cadastro = new JCadastro(f, listener);
		principal.add(cadastro, BorderLayout.CENTER);

		log = new JPanel();
		principal.add(log, BorderLayout.SOUTH);
		
		principal.repaint();
		principal.setName("CADASTRO");
		
		tela.add(principal, "CADASTRO");
	}

	public void telaHome(Usuario usuario) {
		
		JPanel principal, home;
		principal = new JPanel(new BorderLayout());
		home = new JHome(listener, usuario);
		
		principal.add(home, BorderLayout.CENTER);
		principal.repaint();
		principal.setName("HOME");
		
		tela.add(principal, "HOME");
	}
	
	public void guia(JMenuBar menu) {
		JMenu guia;
		
	    guia = new JMenu("Arquivo");
	    
	    JMenuItem item;
	    item = new JMenuItem("Novo projeto");
	    item.addActionListener(new GestorGuia());
	    item.setActionCommand("NOVO");
	    guia.add(item);
	    
	    item = new JMenuItem("Sair");
	    item.addActionListener(new GestorGuia());
	    item.setActionCommand("SAIR");
	    guia.add(item);
	    
	    menu.add(guia);
	    
	    guia = new JMenu("Ajuda");
	    
	    item = new JMenuItem("Ajuda");
	    item.addActionListener(new GestorGuia());
	    item.setActionCommand("AJUDA");
	    guia.add(item);
	    
	    item = new JMenuItem("Sobre");
	    item.addActionListener(new GestorGuia());
	    item.setActionCommand("SOBRE");
	    guia.add(item);
	    
	    menu.add(guia);
	}

}
