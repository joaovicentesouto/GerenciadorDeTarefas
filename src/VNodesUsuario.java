import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class VNodesUsuario extends Visitor {
	
	private NossoTreeNode node;
	
	public VNodesUsuario(NossoTreeNode node) {
		this.node = node;
	}
	
	public void visitar(String usuario, String senha, List<InterfaceProjeto> projetos) {
		Iterator<InterfaceProjeto> it = projetos.iterator();
		while(it.hasNext()) {
			InterfaceProjeto p = it.next();
			p.aceitarVisita(new VNodesProjeto(node, p));
		}
	}
//	
//	public void visitar(List<InterfaceProjeto> projetos, double porcento, Dados dados) {
//		DefaultMutableTreeNode nodeAux = new DefaultMutableTreeNode();
//		dados.aceitarVisita(new VNodesUsuario(nodeAux));
//		Iterator<InterfaceProjeto> it = projetos.iterator();
//		while(it.hasNext()) {
//			it.next().aceitarVisita(new VNodesUsuario(nodeAux));
//		}
//		node.add(nodeAux);
//	}
//	
//	public void visitar(double porcento, Dados dados) {
//		DefaultMutableTreeNode nodeAux = new DefaultMutableTreeNode();
//		dados.aceitarVisita(new VNodesUsuario(nodeAux));
//		node.add(nodeAux);
//	}
//	
//	public void visitar(String titulo, String descricao, int prioridade, Date[] datas) {
//		node.setUserObject(titulo);
//	}

}
