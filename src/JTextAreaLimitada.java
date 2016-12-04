

import java.awt.event.KeyEvent;

import javax.swing.*;

public class JTextAreaLimitada extends JTextArea {

	private int maximoCaracteres=-1; 

	public JTextAreaLimitada() {
		super();
		addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
				jTextFieldKeyTyped(evt);
			}
		});
	}

	public JTextAreaLimitada(int maximo) {    
		super();
		setMaximoCaracteres(maximo);

		addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
				jTextFieldKeyTyped(evt);
			}
		});
	}

	private void jTextFieldKeyTyped(KeyEvent evt) {

		if((getText().length()>=getMaximoCaracteres())&&(getMaximoCaracteres()!=-1)){
			evt.consume();
			setText(getText().substring(0,getMaximoCaracteres()));
		}
	}

	public int getMaximoCaracteres() {
		return maximoCaracteres;
	}
	public void setMaximoCaracteres(int maximoCaracteres) {
		this.maximoCaracteres = maximoCaracteres;
	}
}