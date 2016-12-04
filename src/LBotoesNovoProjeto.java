import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.util.Date;

import javax.swing.*;

public class LBotoesNovoProjeto implements ActionListener{

	private JNovoProjeto janela;
	private InterfaceAdd topo;

	public LBotoesNovoProjeto(JNovoProjeto janela, InterfaceAdd topo){
		this.janela = janela;
		this.topo = topo;
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("ADICIONAR")) {
			try {
				janela.criacao(this);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
				p = new Contador(titulo, descricao, prioridade, 1, d);
			} else {
				p = new Tarefa(titulo, descricao, prioridade, d);
			}
		}
		topo.add(p);
		janela.dispose();
	}

}
