import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
	
	private List<Usuario> usuarios;
	private Usuario usuarioAtual;
	
	public BancoDeDados(){
		usuarios = new ArrayList<Usuario>();
		usuarioAtual = null;
		
		// Usuario Admin para teste, pré-configurado
		Usuario admin = new Usuario("admin", "123");
		usuarios.add(admin);
		
		Projeto p = new Projeto("Projeto 1", "Descricao 1", 2, null);
		Projeto dentro = new Projeto("Projeto Dentro", "Desc dentro 1", 0, null);
		dentro.add(new Tarefa("Tarefa A", "Descricao tarefa A", 0, null));
		dentro.add(new Tarefa("Tarefa B", "Descricao tarefa B", 1, null));
		dentro.add(new Tarefa("Tarefa A", "Descricao tarefa A", 2, null));
		p.add(dentro);
		p.add(new Contador("Contador 1", "Descricao dentro do P1", 0, 500, null));
		admin.add(p);
		
		p = new Projeto("Projeto 2", "Desc 2", 1, null);
		p.add(new Tarefa("Tarefa 2A", "Descricao 2A", 0, null));
		p.add(new Contador("Contador 2", "Descricao dentro do P2", 0, 10000, null));
		admin.add(p);
		
		admin.add(new Projeto("Projeto 3 - VAZIO", "Descr 3", 2, null));
		admin.add(new Tarefa("Tarefa na Home", "Descricao tarefa na home", 0, null));
		admin.add(new Contador("Contador na Home", "Descricao na home", 0, 1000, null));
	}
	
	public boolean validar(Usuario usuario){
		for(Usuario us: usuarios){
			if(us.equals_Validacao(usuario)){
				usuarioAtual = us;
				return true;
			}
		}
		return false;
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
