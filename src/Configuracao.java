import javax.swing.*;
import java.awt.*;

public class Configuracao {
	
	private String state;
	private Construtor construtor; 
	
	public Configuracao(JFrame f, JPanel tela) {
		construtor = new Construtor(f, tela, this);
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
			construtor.telaLogin();
			break;
		
		case "HOME" : 
			construtor.telaHome();
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
