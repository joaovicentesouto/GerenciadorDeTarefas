import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GestorTamanhoTela implements ComponentListener {
	
	private Construtor construtor;
	private Configuracao config;
	private JFrame f;
	private JPanel tela;

	public GestorTamanhoTela(Construtor construtor, Configuracao config, JFrame f, JPanel tela) {
		this.construtor = construtor;
		this.config = config;
		this.f = f;
		this.tela = tela;
	}

	public void componentResized(ComponentEvent e) {
		switch (config.estadoAtual()) {
		case "LOGIN" : 
			ajusteTamanhoLogin();
			break;
		case "HOME" : 
			ajusteTamanhoHome();
			break;
		case "CADASTRO" : 
			ajusteTamanhoCadastro();
			break;
		default : break;
		}
	}
	
	
	
	public void componentMoved(ComponentEvent e) {

	}

	public void componentShown(ComponentEvent e) {
		switch (config.estadoAtual()) {
		case "LOGIN" : 
			ajusteTamanhoLogin();
			break;
		case "HOME" : 
			ajusteTamanhoHome();
			break;
		default : break;
		}
	}

	public void componentHidden(ComponentEvent e) {
		
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
		
		aux = (JPanel) layout.getLayoutComponent(BorderLayout.CENTER);
		aux = (JPanel) aux.getComponent(0);
		aux = (JPanel) aux.getComponent(0);
		Point po = aux.getLocation();
		po.x = (f.getWidth()/2)-127;
		aux.setLocation(po);
		
		tela.repaint();
	}
	
	public void ajusteTamanhoCadastro() {
		
		JPanel card = null;
		for (Component comp : tela.getComponents()) {
		    if (comp.getName().equals("CADASTRO")) {
		        card = (JPanel) comp;
		    }
		}
		
		BorderLayout layout = (BorderLayout) card.getLayout();
		
		JPanel aux;
		
		aux = (JPanel) layout.getLayoutComponent(BorderLayout.NORTH);
		Dimension min = aux.getPreferredSize();
		min.height = (f.getHeight()/2)-100;
		aux.setPreferredSize(min);
		
		aux = (JPanel) layout.getLayoutComponent(BorderLayout.SOUTH);
		min = aux.getPreferredSize();
		min.height = (f.getHeight()/2)-100;
		aux.setPreferredSize(min);
		
		aux = (JPanel) layout.getLayoutComponent(BorderLayout.CENTER);
		aux = (JPanel) aux.getComponent(0);
		aux = (JPanel) aux.getComponent(0);
		Point po = aux.getLocation();
		po.x = (f.getWidth()/2)-127;
		aux.setLocation(po);
		
	}

	public void ajusteTamanhoHome() {
		
		JPanel card = null;
		for (Component comp : tela.getComponents()) {
		    if (comp.getName().equals("HOME")) {
		        card = (JPanel) comp;
		    }
		}
		
		BorderLayout layout = (BorderLayout) card.getLayout();
		
		JPanel aux;
		JScrollPane menu = null, conteudo = null;
		
		aux = (JPanel) layout.getLayoutComponent(BorderLayout.CENTER);
		aux = (JPanel) aux.getComponent(0);

		for (Component comp : aux.getComponents()) {
			if(comp != null && comp.getName() != null){
			    if(comp.getName().equals("MENU_LATERAL"))
			        menu = (JScrollPane) comp;
			    if(comp.getName().equals("CONTEUDO"))
			    	conteudo = (JScrollPane) comp;
			}
		}
		
		Rectangle rec = menu.getBounds();
		rec.height = f.getHeight()-105;
		menu.setBounds(rec);
		
		rec = conteudo.getBounds();
		rec.height = f.getHeight()-60;
		rec.width = f.getWidth()-200;
		conteudo.setBounds(rec);
	}
	
}
