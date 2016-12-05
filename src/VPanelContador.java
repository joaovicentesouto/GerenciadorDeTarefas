import javax.swing.JLabel;

public class VPanelContador extends Visitor{

	private JLabel total;
	private JTextFieldSomenteNumeros numero;
	
	public VPanelContador(JLabel total) {
		this.total = total;
		numero = null;
	}
	
	public VPanelContador(JTextFieldSomenteNumeros numero) {
		this.numero = numero;
		total = null;
	}
	
	public void visitar(double porcento, Dados dados, int total, int contado) {
		if(this.total!=null){
			this.total.setText("Total: " + total + " / Contado:");
		} else {
			String cont = contado+"";
			int diferenca = (""+total).length()-cont.length();
			if(diferenca > 0) {
				String complemento = "";
				for(int i = 0; i < diferenca; i++) {
					complemento += "0";
				}
				numero.setText(complemento+cont);
			} else {
				numero.setText(contado+"");
			}
			
		}
		
//		if(comando.equals("TOTAL")) {
//			label.setText("Total: "+total);
//		} else {
//			String cont = contado+"";
//			String s = "0000000000000";
//			s.
//			for(int i = 0; i < 13; i++) {
//				if(i < cont.length()) {
//					s += "";
//				}
//			}
//		}
	}
	
}
