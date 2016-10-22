import java.util.Date;

public class Contador {

	private String titulo, descricao;
	private int prioridade, total, contado;
	private Date criacao, termino, meta;

	public Contador(String titulo, String descricao, int prioridade, int total, int contado, Date meta) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.prioridade = prioridade;
		this.total = total;
		this.contado = contado;
		criacao = new Date();
		termino = new Date();
		this.meta = meta;
	}

	public void modificarTotal(int total) {
		this.total = total;
	}
	
	public void contar(int contado) {
		this.contado = contado;
	}

	public double avaliarPorcentagem() {
		return (contado/total)*100;
	}

	public void completarTudo() {
		contado = total;
	}

}
