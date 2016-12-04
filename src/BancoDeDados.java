import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
	
	private List<Usuario> usuarios;
	private Usuario usuarioAtual;
	
	public BancoDeDados(){
		usuarios = new ArrayList<Usuario>();
		usuarioAtual = null;
	}
	
	public boolean validar(Usuario usuario){
		for(Usuario u: usuarios){
			if(u.equals_Validacao(usuario)){
				usuarioAtual = u;
				return true;
			}
		}
		return true;
	}
	
	public boolean cadastrar(Usuario usuario){
		for(Usuario u: usuarios){
			if(u.equals_Cadastro(usuario))
				return false;
		}
		usuarios.add(usuario);
		return true;
	}
	
	public void aceitarVisita(Visitor v) {
		v.visitar(usuarios, usuarioAtual);
	}

}
