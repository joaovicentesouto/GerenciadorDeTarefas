import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Projeto implements InterfaceProjeto, InterfaceAdd, InterfaceRemove {

	private Dados dados;
	private List<InterfaceProjeto> projetos;

	public Projeto(String titulo, String descricao, int prioridade, Date meta) {
		dados = new Dados(titulo, descricao, prioridade, meta);
		projetos = new ArrayList<InterfaceProjeto>();
	}

	public void add(InterfaceProjeto projeto) {
		projetos.add(projeto);
	}

	public void remove(InterfaceProjeto projeto) {
		if(projetos.contains(projeto)) {
			projetos.remove(projeto);
			System.out.println("Projeto excluido com sucesso.");
		} else {
			System.out.println("Este projeto não existe.");
		}
	}

	public double avaliarPorcentagem() {
		int completado = 0;
		for(InterfaceProjeto p : projetos) {
			completado += p.avaliarPorcentagem();
		}
		return completado/projetos.size();
	}

	public void completar() {
		for(InterfaceProjeto p : projetos) {
			p.completar();
		}
	}
	
}
