import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.util.Date;

import javax.swing.*;

public class LBotoesNovoProjeto implements ActionListener{

	private JHome home;
	private JNovoProjeto janela;
	private InterfaceAdd topo;

	public LBotoesNovoProjeto(JHome home, JNovoProjeto janela, InterfaceAdd topo){
		this.home = home;
		this.janela = janela;
		this.topo = topo;
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("ADICIONAR")) {
				janela.criacao(this);
		} else {
			if(e.getActionCommand().equals("CANCELAR"))
				janela.dispose();
		}
	}
	
	public void criar(String tipo, String titulo, String descricao, int prioridade, int total, Date d) {
		InterfaceProjeto p;
		if(tipo.equals("Projeto")) {
			p = new Projeto(titulo, descricao, prioridade, d);
		} else {
			if(tipo.equals("Contador")) {
				p = new Contador(titulo, descricao, prioridade, total, d);
			} else {
				p = new Tarefa(titulo, descricao, prioridade, d);
			}
		}
		topo.add(p);
		home.atualizar();
		janela.dispose();
	}

}
