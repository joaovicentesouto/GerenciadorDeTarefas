import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class GestorTamanhoTela implements ComponentListener {
	
	private Construtor construtor;
	private Configuracao config;

	public GestorTamanhoTela(Construtor construtor, Configuracao config) {
		this.construtor = construtor;
		this.config = config;
	}

	public void componentResized(ComponentEvent e) {
		switch (config.ajuste()) {
		case "LOGIN" : 
			construtor.ajusteTamanhoLogin();
			break;
		case "HOME" : 
			//construtor.ajusteTamanhoHome();
			break;
		default : break;
		}
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	public void componentShown(ComponentEvent e) {
		switch (config.ajuste()) {
		case "LOGIN" : 
			construtor.ajusteTamanhoLogin();
			break;
		case "HOME" : 
			//construtor.ajusteTamanhoHome();
			break;
		default : break;
		}
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
