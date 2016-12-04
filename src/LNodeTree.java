import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class LNodeTree implements TreeSelectionListener {

	private JTreeUsuario tree;
	
	public LNodeTree(JTreeUsuario tree) {
		this.tree = tree;
	}
	@Override
	public void valueChanged(TreeSelectionEvent arg0) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		System.out.println(node.toString());
		
	}
	
}
