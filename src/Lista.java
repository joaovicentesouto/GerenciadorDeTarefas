import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Lista implements InterfaceProjeto {

	private String titulo, descricao;
	private int prioridade;
	private Date criacao, termino, meta;
	private List<InterfaceProjeto> tarefas;

	public Lista(String titulo, String descricao, int prioridade, Date meta) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.prioridade = prioridade;
		criacao = new Date();
		termino = new Date();
		this.meta = meta;
		tarefas = new ArrayList<InterfaceProjeto>();
	}

	public void add(String tarefa, int prioridade) {
		tarefas.add(new Tarefa(tarefa, prioridade));
	}
	
	// ou
	public void add(InterfaceProjeto tarefa) {
		tarefas.add(tarefa);
	}

	public void remove(InterfaceProjeto tarefa) {
		if(tarefas.contains(tarefa)) {
			tarefas.remove(tarefa);
			System.out.println("Tarefa excluida com sucesso.");
		} else {
			System.out.println("Tarefa não encontrada.");
		}
	}

	public double avaliarPorcentagem() {
		double completado = 0;
		for(InterfaceProjeto t : tarefas) {
			completado += t.avaliarPorcentagem();
		}
		return (completado/tarefas.size())*100;
	}

	public void completar() {
		for(InterfaceProjeto t : tarefas) {
			t.completar();
		}
	}

}
