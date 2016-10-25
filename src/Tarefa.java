import java.util.Date;

public class Tarefa implements InterfaceProjeto {
	
	private Dados dados;
	boolean status;
	
	public Tarefa(String titulo, String descricao, int prioridade, Date meta) {
		dados = new Dados(titulo, descricao, prioridade, meta);
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
