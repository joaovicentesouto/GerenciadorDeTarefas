import javax.swing.JTree;
import javax.swing.tree.*;

public class JTreeUsuario extends JTree{

	private Usuario usuarioAtual;
	private LAtualizarHome atualizarHome;
	public JTreeUsuario(Usuario usuarioAtual, LAtualizarHome atualizarHome) {
		this.usuarioAtual = usuarioAtual;
		this.atualizarHome = atualizarHome;
		criacao();
	}
	
	private void criacao() {
		
		NossoTreeNode nodePrincipal = new NossoTreeNode("Meus Projetos");
		super.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

		//Listen for when the selection changes.
		super.addTreeSelectionListener(new LNodeTree(this, atualizarHome));

		usuarioAtual.aceitarVisita(new VNodesUsuario(nodePrincipal));
		setModel(new DefaultTreeModel(nodePrincipal));
	}
	
	public void atualizar() {
		super.removeAll();
		criacao();
	}
	
}
