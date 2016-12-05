import java.awt.*;
import javax.swing.*;

public class JContador extends JPanel{

	private Contador contador;
	private JLabel titulo, descricao, total;
	private JProgressBar bar;
	private JButton excluir, completar, modificar, BContar;
	private JTextFieldSomenteNumeros contar;
	private LAtualizarHome atualizarHome;
	
	public JContador(Contador contador, InterfaceRemove topo, LAtualizarHome atualizarHome){
		this.contador = contador;
		super.setName("CONTADOR");
		this.atualizarHome = atualizarHome;
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
		excluir.addActionListener(new LExcluidor(topo, contador, atualizarHome));
		
		completar = new JButton("Completar");
		completar.addActionListener(new LCompletador(contador, atualizarHome));
		
		modificar = new JButton("Modificar");
		modificar.addActionListener(new LModificador(contador, atualizarHome));
		
		contar = new JTextFieldSomenteNumeros(13);
		contar.setSize(new Dimension(50, 20));
		contador.aceitarVisita(new VTotalContador(contar));
		BContar = new JButton("Contar");
		BContar.addActionListener(new LBotaoContador(contador, contar, atualizarHome));
		
		total = new JLabel();
		contador.aceitarVisita(new VTotalContador(total));
		
		JPanel aux = new JPanel(new BorderLayout());
		aux.add(titulo, BorderLayout.WEST);
		JPanel flowBarra = new JPanel(new FlowLayout());
		flowBarra.add(total);
		flowBarra.add(contar);
		flowBarra.add(BContar);
		flowBarra.add(bar);
		
		aux.add(flowBarra, BorderLayout.EAST);
		super.add(aux);
		
		contador.aceitarVisita(new VCorJPanel(aux));
		
		aux = new JPanel(new BorderLayout());
		aux.add(descricao, BorderLayout.WEST);
		JPanel aux2 = new JPanel(new FlowLayout());
		aux2.add(excluir);
		aux2.add(completar);
		aux2.add(modificar);
		aux.add(aux2, BorderLayout.EAST);
		super.add(aux);
		
		contador.aceitarVisita(new VCorJPanel(aux));
		contador.aceitarVisita(new VCorJPanel(aux2));
		contador.aceitarVisita(new VCorJPanel(flowBarra));
		contador.aceitarVisita(new VCorJPanel(this));
	}
	
	public void atualizar() {
		contador.aceitarVisita(new VTitulo(titulo));
		contador.aceitarVisita(new VDescricao(descricao));
		contador.aceitarVisita(new VPorcentagem(bar));
	}
	
}
