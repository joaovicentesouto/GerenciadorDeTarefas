
public class VNodeParaModHome extends Visitor {
	
	private LAtualizarHome atualizarHome;
	
	public VNodeParaModHome(LAtualizarHome atualizarHome) {
		this.atualizarHome = atualizarHome;
	}
	
	public void visitar(InterfaceProjeto projeto) {
		atualizarHome.atualizarHome(projeto);
	}

}
