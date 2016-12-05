import java.util.List;

public class VPegaUsuario extends Visitor {

	private Usuario[] usuario;
	
	public VPegaUsuario(Usuario[] usuario) {
		this.usuario = usuario;
	}
	
	public void visitar(List<Usuario> usuarios, Usuario usuario) {
		this.usuario[0] = usuario;
	}
}
