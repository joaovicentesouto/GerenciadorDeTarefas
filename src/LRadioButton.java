import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LRadioButton implements ItemListener{

	private JNovoProjeto janela;
	
	public LRadioButton(JNovoProjeto janela){
		this.janela = janela;
	}
	
	public void itemStateChanged(ItemEvent e) {
		
		JRadioButton rb = (JRadioButton) e.getSource();
		if(e.getStateChange() == ItemEvent.SELECTED){
			janela.proximoEstado(rb.getText());
			janela.maquinaDeEstados();
		}
	}

}
