import java.awt.*;
import javax.swing.*;

public class JTarefa extends JPanel{
	
	private Tarefa tarefa;
	private JLabel titulo, descricao;
	private JProgressBar bar;
	private JButton excluir, completar, modificar;
	private LAtualizarHome atualizarHome;
	
	public JTarefa(Tarefa tarefa, InterfaceRemove topo, LAtualizarHome atualizarHome) {
		this.tarefa = tarefa;
		super.setName("TAREFA");
		this.atualizarHome = atualizarHome;
		criacao(topo);
	}

	public void criacao(InterfaceRemove topo) {
		
		super.setLayout(new GridLayout(2,1));
		
		Dimension d = super.getSize();
		d.height = 50;
		super.setSize(d);
		
		titulo = new JLabel();
		tarefa.aceitarVisita(new VTitulo(titulo));
		
		descricao = new JLabel();
		tarefa.aceitarVisita(new VDescricao(descricao));
		
		bar = new JProgressBar();
		tarefa.aceitarVisita(new VPorcentagem(bar));
		
		excluir = new JButton("Excluir");
		excluir.addActionListener(new LExcluidor(topo, tarefa, atualizarHome));
		
		completar = new JButton("Completar");
		completar.addActionListener(new LCompletador(tarefa, atualizarHome));
		
		modificar = new JButton("Modificar");
		modificar.addActionListener(new LModificador(tarefa, atualizarHome));
		
		JPanel aux = new JPanel(new BorderLayout());
		aux.add(titulo, BorderLayout.WEST);
		aux.add(bar, BorderLayout.EAST);
		super.add(aux);
		
		tarefa.aceitarVisita(new VCorJPanel(aux));
		
		aux = new JPanel(new BorderLayout());
		aux.add(descricao, BorderLayout.WEST);
		JPanel aux2 = new JPanel(new FlowLayout());
		aux2.add(excluir);
		aux2.add(completar);
		aux2.add(modificar);
		aux.add(aux2, BorderLayout.EAST);
		super.add(aux);
		
		tarefa.aceitarVisita(new VCorJPanel(aux));
		tarefa.aceitarVisita(new VCorJPanel(aux2));
		
		tarefa.aceitarVisita(new VCorJPanel(this));
	}
	
	public void atualizar() {
		tarefa.aceitarVisita(new VTitulo(titulo));
		tarefa.aceitarVisita(new VDescricao(descricao));
		tarefa.aceitarVisita(new VPorcentagem(bar));
	}
}
