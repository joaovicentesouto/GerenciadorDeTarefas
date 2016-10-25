import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Pessoa implements InterfaceAdd, InterfaceRemove {
	
	private String nome, usuario, senha;
	private List<InterfaceProjeto> projetos;
	
	public Pessoa(String nome, String usuario, String senha){
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		projetos = new ArrayList<InterfaceProjeto>();
	}
	
	public void completar(InterfaceProjeto projeto) {
		projeto.completar();
	}
	
	public boolean logIn(String senha) {
		if(this.senha.equals(senha)) {
			return true;
		} else {
			return false;
		}
	}

	public void add(InterfaceProjeto p) {
		projetos.add(p);
	}
	
	public void remove(InterfaceProjeto p) {
		projetos.remove(p);
	}

}
