import java.util.Date;
import java.util.Timer; //????

public class Conta implements InterfaceProjeto {

	private Dados dados;
	private int juros;
	private int quantParcelas, valorParcela, parcelasPagas;
	
	public Conta(String titulo, String descricao, int prioridade, Date meta, int quantParcelas, int valorParcela, Date vencimento, int juros){
		dados = new Dados(titulo, descricao, prioridade, meta);
		this.quantParcelas = quantParcelas;
		this.valorParcela = valorParcela;
		parcelasPagas = 0;
		this.juros = juros;
	}
	
	public double avaliarPorcentagem(){
		return (parcelasPagas/quantParcelas)*100;
	}
	
	public void completar(){
		parcelasPagas = quantParcelas;
	}
	
}
