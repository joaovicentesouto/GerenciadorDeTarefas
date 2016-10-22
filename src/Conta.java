import java.util.Date;

public abstract class Conta implements InterfaceProjeto {

	private String titulo, descricao;
	private int prioridade;
	private Date criacao, termino, vencimento;
	private int quantParcelas, valorParcela, parcelasPagas;
	
	public Conta(int quantParcelas, int valorParcela, Date vencimento){
		this.quantParcelas = quantParcelas;
		this.valorParcela = valorParcela;
		criacao = new Date();
		termino = new Date();
		this.vencimento = vencimento;
		parcelasPagas = 0;
	}
	
	public double avaliarPorcentagem(){
		return (parcelasPagas/quantParcelas)*100;
	}
	
	public void completarTudo(){
		parcelasPagas = quantParcelas;
	}
	
}
