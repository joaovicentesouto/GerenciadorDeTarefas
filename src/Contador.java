import java.util.Date;

public class Contador {

	private Dados dados;
	private int total, contado;

	public Contador(String titulo, String descricao, int prioridade, int total, int contado, Date meta) {
		dados = new Dados(titulo, descricao, prioridade, meta);
		this.total = total;
		this.contado = contado;
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

	public void completar() {
		contado = total;
	}

}
