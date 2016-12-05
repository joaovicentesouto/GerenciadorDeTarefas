import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class LNodeTree implements TreeSelectionListener {

	private JTreeUsuario tree;
	private LAtualizarHome atualizarHome;
	private String pressionado = "a";

	public LNodeTree(JTreeUsuario tree, LAtualizarHome atualizarHome) {
		this.tree = tree;
		this.atualizarHome = atualizarHome;
	}

	public void valueChanged(TreeSelectionEvent arg0) {
		NossoTreeNode node = (NossoTreeNode) tree.getLastSelectedPathComponent();
		if(node!=null) {
			String teste = (String)node.getUserObject();
			if(pressionado.equals(teste)) {
			} else {
				pressionado = (String) node.getUserObject();
				if(node.getUserObject().equals("Meus Projetos")) {
					atualizarHome.atualizarHome("USUARIO");
				} else {
					NossoTreeNode nosso = (NossoTreeNode) node;
					if(nosso.tipoProjeto().equals("PROJETO")) {
						nosso.aceitarVisita(new VNodeParaModHome(atualizarHome));
					}
				}
				
			}

		}
	}

}
