
public class LAtualizarHome {

	private JHome home; 
	
	public LAtualizarHome(JHome home) {
		this.home = home;
	}
	
	public void atualizarHome(){
		home.atualizar();
	}
	
	public void atualizarHome(String cmd){
		home.atualizar(cmd);
	}
	
	public void atualizarHome(InterfaceProjeto projeto) {
		home.atualizar(projeto);
	}
}
