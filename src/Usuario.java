import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Usuario implements InterfaceAdd, InterfaceRemove {
	
	private String usuario, senha;
	private List<InterfaceProjeto> projetos;
	
	public Usuario(String usuario, String senha){
		this.usuario = usuario;
		this.senha = senha;
		projetos = new ArrayList<InterfaceProjeto>();
	}
	
	public void completar(InterfaceProjeto projeto) {
		projeto.completar();
	}

	public void add(InterfaceProjeto p) {
		projetos.add(p);
	}
	
	public void remove(InterfaceProjeto p) {
		projetos.remove(p);
	}
	
	public boolean equals_Cadastro(Usuario usuario){
		if(usuario.equals(usuario.usuario))
			return true;
		return false;
	}
	
	public boolean equals_Validacao(Usuario usuario){
		if(this.usuario.equals(usuario.usuario) && this.senha.equals(usuario.senha))
			return true;
		return false;
	}
	
	public void aceitarVisita(Visitor v) {
		v.visitar(usuario, senha, projetos);
	}

}
