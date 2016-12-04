import java.awt.*;
import javax.swing.*;

public class JTarefa extends JPanel{
	
	private Tarefa tarefa;
	private JLabel titulo, descricao;
	private JProgressBar bar;
	private JButton excluir, completar;
	
	public JTarefa(Tarefa tarefa, InterfaceRemove topo) {
		super();
		this.tarefa = tarefa;
		super.setName("TAREFA");
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
		excluir.addActionListener(new LExcluidor(topo, tarefa));
		
		completar = new JButton("Completar");
		completar.addActionListener(new LCompletador(tarefa));
		
		JPanel aux = new JPanel(new BorderLayout());
		aux.add(titulo, BorderLayout.WEST);
		aux.add(bar, BorderLayout.EAST);
		super.add(aux);
		
		aux = new JPanel(new BorderLayout());
		aux.add(descricao, BorderLayout.WEST);
		JPanel aux2 = new JPanel(new FlowLayout());
		aux2.add(excluir);
		aux2.add(completar);
		aux.add(aux2, BorderLayout.EAST);
		super.add(aux);
	}
	
	public void atualizar() {
		tarefa.aceitarVisita(new VTitulo(titulo));
		tarefa.aceitarVisita(new VDescricao(descricao));
		tarefa.aceitarVisita(new VPorcentagem(bar));
	}
}
