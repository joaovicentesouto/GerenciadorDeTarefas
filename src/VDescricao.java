import javax.swing.*;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;

public class VDescricao extends Visitor {
	
	private JLabel descricao;
	
	public VDescricao(JLabel descricao) {
		this.descricao = descricao;
	}
	
	public void visitar(double porcento, Dados dados) {
		dados.aceitarVisita(this);
	}
	
	public void visitar(List<InterfaceProjeto> projetos, double porcento, Dados dados) {
		dados.aceitarVisita(this);
	}
	
	public void visitar(String titulo, String descricao, int prioridade, Date[] datas) {
		this.descricao.setText(descricao);
	}

}
