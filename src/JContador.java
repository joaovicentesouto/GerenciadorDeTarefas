import java.awt.*;
import javax.swing.*;

public class JContador extends JPanel{

	private Contador contador;
	private JLabel titulo, descricao;
	private JProgressBar bar;
	private JButton excluir, completar;
	
	public JContador(Contador contador, InterfaceRemove topo){
		super();
		this.contador = contador;
		super.setName("CONTADOR");
		criacao(topo);
	}
	
	public void criacao(InterfaceRemove topo) {
		
		super.setLayout(new GridLayout(2,1));
		
		Dimension d = super.getSize();
		d.height = 50;
		super.setSize(d);
		
		titulo = new JLabel();
		contador.aceitarVisita(new VTitulo(titulo));
		
		descricao = new JLabel();
		contador.aceitarVisita(new VDescricao(descricao));
		
		bar = new JProgressBar();
		contador.aceitarVisita(new VPorcentagem(bar));
		
		excluir = new JButton("Excluir");
		excluir.addActionListener(new LExcluidor(topo, contador));
		
		completar = new JButton("Completar");
		completar.addActionListener(new LCompletador(contador));
		
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
		contador.aceitarVisita(new VTitulo(titulo));
		contador.aceitarVisita(new VDescricao(descricao));
		contador.aceitarVisita(new VPorcentagem(bar));
	}
	
}
