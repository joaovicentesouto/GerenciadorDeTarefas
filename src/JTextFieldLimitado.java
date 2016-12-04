
import java.awt.event.KeyEvent;

import javax.swing.*;

public class JTextFieldLimitado extends JTextField {

	private int maximoCaracteres=-1; 

	public JTextFieldLimitado() {
		super();
		addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
				jTextFieldKeyTyped(evt);
			}
		});
	}

	public JTextFieldLimitado(int maximo) {    
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
