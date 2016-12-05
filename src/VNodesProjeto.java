
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class VNodesProjeto extends Visitor {
	
	private NossoTreeNode node;
	private InterfaceProjeto projeto;
	
	public VNodesProjeto(NossoTreeNode node, InterfaceProjeto projeto) {
		this.node = node;
		this.projeto = projeto;
	}
	
	public void visitar(List<InterfaceProjeto> projetos, double porcento, Dados dados) {
		NossoTreeNode nodeAux = new NossoTreeNode(projeto);
		dados.aceitarVisita(new VNodesProjeto(nodeAux, null));
		Iterator<InterfaceProjeto> it = projetos.iterator();
		while(it.hasNext()) {
			InterfaceProjeto p = it.next();
			p.aceitarVisita(new VNodesProjeto(nodeAux, p));
		}
		node.add(nodeAux);
	}
	
	public void visitar(double porcento, Dados dados) {
		NossoTreeNode nodeAux = new NossoTreeNode(projeto);
		dados.aceitarVisita(new VNodesProjeto(nodeAux, null));
		node.add(nodeAux);
	}
	
	public void visitar(double porcento, Dados dados, int total, int contado) {
		NossoTreeNode nodeAux = new NossoTreeNode(projeto);
		dados.aceitarVisita(new VNodesProjeto(nodeAux, null));
		node.add(nodeAux);
	}
	
	public void visitar(String titulo, String descricao, int prioridade, Date[] datas) {
		node.setUserObject(titulo);
	}

}
