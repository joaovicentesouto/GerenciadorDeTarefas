
import javax.swing.*;

import java.awt.Color;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;

public class VCorJPanel extends Visitor {
	
	private JPanel p;
	
	public VCorJPanel(JPanel p) {
		this.p = p;
	}
	
	public void visitar(double porcento, Dados dados) {
		dados.aceitarVisita(this);
	}
	
	public void visitar(List<InterfaceProjeto> projetos, double porcento, Dados dados) {
		dados.aceitarVisita(this);
	}
	
	public void visitar(String titulo, String descricao, int prioridade, Date[] datas) {
		switch(prioridade) {
		case 0 :
			break;
		case 1 :
			p.setBackground(Color.LIGHT_GRAY);
			break;
		case 2 : 
			p.setBackground(Color.GRAY);
			break;
		default: break;
		}
	}
	
	public void visitar(double porcento, Dados dados, int total, int contado) {
		dados.aceitarVisita(this);
	}

}
