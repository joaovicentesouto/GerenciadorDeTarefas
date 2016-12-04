import java.util.Date;

public class Contador implements InterfaceProjeto {

	private Dados dados;
	private int total, contado;

	public Contador(String titulo, String descricao, int prioridade, int total, Date meta) {
		dados = new Dados(titulo, descricao, prioridade, meta);
		this.total = total;
		this.contado = 0;
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
	
	public String tipo() {
		return "CONTADOR";
	}

	public void aceitarVisita(Visitor v) {
		v.visitar(avaliarPorcentagem(), dados);
	}

}
