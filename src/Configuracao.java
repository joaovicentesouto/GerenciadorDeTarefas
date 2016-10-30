import javax.swing.*;
import java.awt.*;

public class Configuracao {
	
	private String state;
	private Construtor construtor;
	private boolean inicio;
	
	public Configuracao(JFrame f, JPanel tela) {
		construtor = new Construtor(f, tela, this);
		state = "LOGIN";
		inicio = true;
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
		if(inicio) {
			// constroi todas as telas e coloca como cards na tela
			// e ja show(cards, "login");
		} else {
			fsm(); // muda os cards.
		}
	}
	
	public void fsm() {
		switch (state) {
		
		case "LOGIN" :
			// show(cards, "login")
			//construtor.telaLogin();
			break;
		
		case "HOME" : 
			// show(cards, "home")
			//construtor.telaHome();
			break;
		
		default : break;
		}
	}
	
	public void nextState(String nextState) {
		state = nextState;
	}
	
	public String ajuste() {
		return state;
	}

}
