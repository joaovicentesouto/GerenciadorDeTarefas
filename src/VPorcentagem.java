import java.util.ArrayList;
import java.util.List;

import javax.swing.JProgressBar;

public class VPorcentagem extends Visitor {

	private JProgressBar bar;
	
	public VPorcentagem(JProgressBar bar) {
		this.bar = bar;
	}
	
	public void visitar(List<InterfaceProjeto> projetos, double porcento, Dados dados) {
		bar.setValue((int)porcento);
	}
	
	public void visitar(double porcento, Dados dados) {
		bar.setValue((int)porcento);
	}
	
	public void visitar(double porcento, Dados dados, int total, int contado) {
		bar.setValue((int)porcento);
	}
	
}
