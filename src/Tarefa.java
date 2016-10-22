
public class Tarefa implements InterfaceProjeto {
	
	private String descricao;
	boolean status;
	
	public Tarefa(String descricao) {
		this.descricao = descricao;
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
