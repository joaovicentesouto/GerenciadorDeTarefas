import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Lista implements InterfaceProjeto {

	private String titulo, descricao;
	private int prioridade;
	private Date criacao, termino, meta;
	private Map<String,Boolean> tarefas;

	public Lista(String titulo, String descricao, int prioridade, Date meta) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.prioridade = prioridade;
		criacao = new Date();
		termino = new Date();
		this.meta = meta;
		tarefas = new HashMap<String, Boolean>();
	}

	public void add(String tarefa) {
		tarefas.put(tarefa, false);
	}

	public void remove(String tarefa) {
		if(tarefas.containsKey(tarefa)) {
			tarefas.remove(tarefa);
		}
	}

	public double avaliarPorcentagem() {
		double porcento = 0;
		for (String key : tarefas.keySet()) {
			if(tarefas.get(key)) {
				porcento++;
			}
		}
		return (porcento/tarefas.size())*100;
	}

	public void completarTudo() {
		for (String key : tarefas.keySet()) {
			completar(key);
		}
	}

	public void completar(String tarefa) {
		tarefas.put(tarefa, true);
	}

}
