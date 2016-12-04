import javax.swing.JTree;
import javax.swing.tree.*;

public class JTreeUsuario extends JTree{

	private Usuario usuarioAtual;
	
	public JTreeUsuario(Usuario usuarioAtual) {
		this.usuarioAtual = usuarioAtual;
		criacao();
	}
	
	private void criacao() {
		
		DefaultMutableTreeNode nodePrincipal = new DefaultMutableTreeNode("Meus Projetos");
		super.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

		//Listen for when the selection changes.
		super.addTreeSelectionListener(new LNodeTree(this));

		usuarioAtual.aceitarVisita(new VNodesUsuario(nodePrincipal));
		setModel(new DefaultTreeModel(nodePrincipal));
		
	}
	
}
