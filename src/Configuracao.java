import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Configuracao {
	
	private String estado;
	private Construtor construtor;
	private JFrame f;
	private JPanel tela;
	
	public Configuracao(JFrame f, JPanel tela) {
		this.f = f;
		this.tela = tela;
		construtor = new Construtor(f, tela, this);
		estado = "LOGIN";
	}
	
	public void configGuia(JMenuBar menu) {
		construtor.guia(menu);
	}
	
	public void configTela() {
		construtor.inicio();
		CardLayout cl = (CardLayout) tela.getLayout();
		cl.show(tela, "LOGIN");
	}
	
	public void ativaHomeUsuarioA(Usuario usuario) {
		construtor.telaHome(usuario);
	}
	
	public void maquinaDeEstados(String estado) {
		this.estado = estado;
		CardLayout cl = (CardLayout) tela.getLayout();
		Object[] listeners =  f.getComponentListeners();
		GestorTamanhoTela gestor = (GestorTamanhoTela) listeners[0];
		
		switch (estado) {
		
		case "LOGIN" :
			cl.show(tela, "LOGIN");
			gestor.ajusteTamanhoLogin();
			break;
		
		case "HOME" : 
			cl.show(tela, "HOME");
			gestor.ajusteTamanhoHome();
			break;
			
		case "CADASTRO" :
			cl.show(tela, "CADASTRO");
			gestor.ajusteTamanhoCadastro();
			break;
		
		default : break;
		}
		
	}
	
	public String estadoAtual() {
		return estado;
	}
	
	public void atualizar() {
		for (Component comp : tela.getComponents()) {
		    if (comp.getName().equals("HOME")) {
		    	((JHome) comp).criacao();
		    }
		}
	}

}
