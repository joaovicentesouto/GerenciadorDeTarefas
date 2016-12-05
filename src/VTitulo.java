import javax.swing.*;

import java.awt.Font;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class VTitulo extends Visitor {

	private JLabel titulo;
	
	public VTitulo(JLabel titulo) {
		this.titulo = titulo;
	}
	
	public void visitar(double porcento, Dados dados) {
		dados.aceitarVisita(this);
	}
	
	public void visitar(List<InterfaceProjeto> projetos, double porcento, Dados dados) {
		dados.aceitarVisita(this);
	}
	
	public void visitar(double porcento, Dados dados, int total, int contado) {
		dados.aceitarVisita(this);
	}
	

	public void visitar(String titulo, String descricao, int prioridade, Date[] datas) {
		this.titulo.setText(" "+titulo);
		Font fonte = this.titulo.getFont();
		fonte.getSize();
		this.titulo.setFont(new Font(fonte.getFontName(), fonte.getStyle(), 15));
	}

}
