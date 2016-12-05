import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GestorTamanhoNovoProjeto implements ComponentListener {
	
	private JNovoProjeto janela;

	public GestorTamanhoNovoProjeto(JNovoProjeto janela) {
		this.janela = janela;
	}

	public void componentResized(ComponentEvent e) {
		ajusteTamanhoTela();
	}
	
	public void componentMoved(ComponentEvent e) {

	}

	public void componentShown(ComponentEvent e) {
		//ajusteTamanhoTela();
	}

	public void componentHidden(ComponentEvent e) {
		
	}
	
	public void ajusteTamanhoTela() {
		
		JPanel pane = (JPanel)janela.getContentPane();
		Component[] c = pane.getComponents();
		
		for(Component comp : c) {
			if(comp.getName().equals("principal")) {
				Point po = comp.getLocation();
				po.x = (janela.getWidth()/2)-242;
				po.y = (janela.getHeight()/2)-90;
				comp.setLocation(po);
			}
			if(comp.getName().equals("Cancelar")) {
				Point po = comp.getLocation();
				po.x = (janela.getWidth()/2)-92;
				po.y = (janela.getHeight()/2)+65;
				comp.setLocation(po);
			}
			if(comp.getName().equals("Adicionar")) {
				Point po = comp.getLocation();
				po.x = (janela.getWidth()/2)+28;
				po.y = (janela.getHeight()/2)+65;
				comp.setLocation(po);
			}
		}
		
		janela.repaint();
	}
	
}
