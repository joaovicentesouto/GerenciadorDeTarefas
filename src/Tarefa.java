
public class Tarefa implements InterfaceProjeto {
	
	private String descricao;
	private int prioridade;
	boolean status;
	
	public Tarefa(String descricao, int prioridade) {
		this.descricao = descricao;
		this.prioridade = prioridade;
		status = false;
	}
	
	public double avaliarPorcentagem() {
		if(status) {
			return 1;
		} else {
			return 0;
		}
	}

	public void completar() {
		status = true;
	}

}
