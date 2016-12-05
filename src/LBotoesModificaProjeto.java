
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.util.Date;

import javax.swing.*;

public class LBotoesModificaProjeto implements ActionListener{

	private JHome home;
	private JModificaProjeto janela;
	private InterfaceProjeto projeto;
	private LAtualizarHome atualizarHome;

	public LBotoesModificaProjeto(JModificaProjeto janela, InterfaceProjeto projeto, LAtualizarHome atualizarHome){
		this.home = home;
		this.janela = janela;
		this.projeto = projeto;
		this.atualizarHome = atualizarHome;
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("MODIFICAR")) {
				janela.criacao(this);
		} else {
			if(e.getActionCommand().equals("CANCELAR"))
				janela.dispose();
		}
	}
	
	public void modificar(Dados d) {
		projeto.modifica(d);
		atualizarHome.atualizarHome();
		janela.dispose();
	}

}

