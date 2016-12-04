import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Visitor{

	// Esses que só recebem e visitam funcionam para acessar dados mais profundos, efeito cascata.
	// Pode criar outros aqui para visitar novas classes
	public void visitar(Projeto projeto) {
		projeto.aceitarVisita(this);
	}
	
	public void visitar(Tarefa tarefa) {
		tarefa.aceitarVisita(this);
	}
	
	public void visitar(Contador contador){
		contador.aceitarVisita(this);
	}
	
	public void visitar(Usuario usuario) {
		usuario.aceitarVisita(this);
	}
	// Fim efeito cascata --
	
	
	// Estes para baixo são os particulares:
	// Cria-se uma classe que extends Visitor e sobrescreve esses métodos para que
	// tenham comportamentos especificos.
	// Vale lembrar que no construtor desses extends pode se salvar o que deseja modificar.
	// De uma olhada no VDescricao e VTitulo
	
	//Projeto e Lista
	public void visitar(List<InterfaceProjeto> projetos, double porcento, Dados dados) {
		//sobrescrever
	}
	
	//InterfaceProjeto
	public void visitar(double porcento, Dados dados) {
		//sobrescrever
	}
	
	//Usuario
	public void visitar(String usuario, String senha, List<InterfaceProjeto> projetos) {
		//sobrescrever
	}
	
	//Dados
	public void visitar(String titulo, String descricao, int prioridade, Date[] datas) {
		//sobrescrever
	}
	
	//Banco de dados
	public void visitar(List<Usuario> usuarios, Usuario usuarioAtual) {
		//sobrescrever
	}
	
}
