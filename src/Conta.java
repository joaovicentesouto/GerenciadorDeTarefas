import java.util.Date;
import java.util.Timer; //????

public class Conta implements InterfaceProjeto {

	private String titulo, descricao;
	private int prioridade, jurosAoMes;;
	private Date criacao, termino, vencimento;
	private int quantParcelas, valorParcela, parcelasPagas;
	
	public Conta(int quantParcelas, int valorParcela, Date vencimento, int jurosAoMes){
		this.quantParcelas = quantParcelas;
		this.valorParcela = valorParcela;
		criacao = new Date();
		termino = new Date();
		this.vencimento = vencimento;
		parcelasPagas = 0;
		this.jurosAoMes = jurosAoMes;
	}
	
	public double avaliarPorcentagem(){
		return (parcelasPagas/quantParcelas)*100;
	}
	
	public void completar(){
		parcelasPagas = quantParcelas;
	}
	
}
