import javax.swing.tree.DefaultMutableTreeNode;

public class NossoTreeNode extends DefaultMutableTreeNode{
	
	private InterfaceProjeto projeto;
	
	public NossoTreeNode() {
	}
	
	public NossoTreeNode(String name) {
		super(name);
	}
	
	public String tipoProjeto() {
		return projeto.tipo();
	}
	
	public NossoTreeNode(InterfaceProjeto projeto) {
		this.projeto = projeto;
	}
	
	public void addProjeto(InterfaceProjeto projeto) {
		this.projeto = projeto;
	}
	
	public void aceitarVisita(Visitor v) {
		v.visitar(projeto);
	}

}
