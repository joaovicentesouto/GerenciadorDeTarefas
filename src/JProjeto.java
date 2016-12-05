import java.awt.*;
import javax.swing.*;

public class JProjeto extends JPanel {

	private Projeto projeto;
	private JLabel titulo, descricao;
	private JProgressBar bar;
	private JButton excluir, completar, modificar;
	private LAtualizarHome atualizarHome;
	
	public JProjeto(Projeto projeto, InterfaceRemove topo, LAtualizarHome atualizarHome) {
		this.projeto = projeto;
		super.setName("PROJETO");
		this.atualizarHome = atualizarHome;
		criacao(topo);
		super.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	}
	
	public void criacao(InterfaceRemove topo) {
		
		super.setLayout(new GridLayout(2,1));
		
		Dimension d = super.getSize();
		d.height = 50;
		super.setSize(d);
		
		titulo = new JLabel();
		projeto.aceitarVisita(new VTitulo(titulo));
		
		descricao = new JLabel();
		projeto.aceitarVisita(new VDescricao(descricao));
		
		bar = new JProgressBar();
		projeto.aceitarVisita(new VPorcentagem(bar));
		
		excluir = new JButton("Excluir");
		excluir.addActionListener(new LExcluidor(topo, projeto, atualizarHome));
		
		completar = new JButton("Completar");
		completar.addActionListener(new LCompletador(projeto, atualizarHome));
		
		modificar = new JButton("Modificar");
		modificar.addActionListener(new LModificador(projeto, atualizarHome));
		
		JPanel aux = new JPanel(new BorderLayout());
		aux.add(titulo, BorderLayout.WEST);
		aux.add(bar, BorderLayout.EAST);
		super.add(aux);
		
		projeto.aceitarVisita(new VCorJPanel(aux));
		
		aux = new JPanel(new BorderLayout());
		aux.add(descricao, BorderLayout.WEST);
		JPanel aux2 = new JPanel(new FlowLayout());
		aux2.add(excluir);
		aux2.add(completar);
		aux2.add(modificar);
		aux.add(aux2, BorderLayout.EAST);
		super.add(aux);
		
		projeto.aceitarVisita(new VCorJPanel(aux));
		projeto.aceitarVisita(new VCorJPanel(aux2));
		
		projeto.aceitarVisita(new VCorJPanel(this));
	}
	
	public void atualizar() {
		projeto.aceitarVisita(new VTitulo(titulo));
		projeto.aceitarVisita(new VDescricao(descricao));
		projeto.aceitarVisita(new VPorcentagem(bar));
	}
	
}
