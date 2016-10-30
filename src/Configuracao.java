import javax.swing.*;
import java.awt.*;

public class Configuracao {
	
	private String state;
	private Construtor construtor;
	private boolean inicio;
	private JPanel tela;
	
	public Configuracao(JFrame f, JPanel tela) {
		this.tela = tela;
		construtor = new Construtor(f, tela, this);
		state = "LOGIN";
		inicio = true;
	}
	
	public void configGuia(JMenuBar menu) {
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
	
	public void configTela() {
		construtor.inicio();
		CardLayout cl = (CardLayout) tela.getLayout();
		cl.show(tela, "LOGIN");
	}
	
	public void fsm() {
		CardLayout cl = (CardLayout) tela.getLayout();
		
		switch (state) {
		
		case "LOGIN" :
			cl.show(tela, "LOGIN");
			break;
		
		case "HOME" : 
			cl.show(tela, "HOME");
			break;
		
		default : break;
		}
	}
	
	public void nextState(String nextState) {
		state = nextState;
	}
	
	public String state() {
		return state;
	}

}
