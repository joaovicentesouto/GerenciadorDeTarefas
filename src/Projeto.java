import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Projeto implements InterfaceProjeto {

	private String titulo, descricao;
	private int prioridade;
	private Date criacao, termino, meta;
	private List<InterfaceProjeto> projetos;
	
	public Projeto(String titulo, String descricao, int prioridade, Date meta) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.prioridade = prioridade;
		criacao = new Date();
		termino = new Date();
		this.meta = meta;
		projetos = new ArrayList<InterfaceProjeto>();
	}
	
	public void add(InterfaceProjeto projeto) {
		projetos.add(projeto);
	}
	
	public void remove(InterfaceProjeto projeto) {
		boolean removido = false;
		for(InterfaceProjeto p : projetos) {
			if(projeto.equals(p)) {
				projetos.remove(p);
				removido = true;
			}
		}
		if(removido) {
			System.out.println("Removido com sucesso.");
		} else {
			System.out.println("Projeto não encontrado.");
		}
	}
	
	public double avaliarPorcentagem() {
		int completado = 0;
		for(InterfaceProjeto p : projetos) {
			completado += p.avaliarPorcentagem();
		}
		return completado/projetos.size();
	}

	public void completarTudo() {
		for(InterfaceProjeto p : projetos) {
			p.completarTudo();
		}
	}

}
