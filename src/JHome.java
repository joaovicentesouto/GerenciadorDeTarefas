import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class JHome extends JPanel {

	private Usuario usuarioAtual;
	ActionListener listener;
	
	public JHome(ActionListener listener, Usuario usuarioAtual) {
		this.usuarioAtual = usuarioAtual;
		criacao();
	}
	
	public void criacao() {
		
		setForeground(Color.BLACK);
		setLayout(new BorderLayout());
		setName("HOME");
		
		JPanel painel = new JPanel();
		painel.setLayout(null);
		
		add(painel, BorderLayout.CENTER);
		painel.setName("PAINEL");
		
		JPanel BemVindo = new JPanel();
		BemVindo.setBounds(0, 0, 200, 45);		
		painel.add(BemVindo);
		BemVindo.setLayout(null);
		BemVindo.setName("BEM_VINDO");
		
		JButton voltar = new JButton("Voltar");
		voltar.setFont(new Font("Arial", Font.PLAIN, 12));
		voltar.setBorderPainted(false);
		voltar.setBorder(new LineBorder(new Color(192, 192, 192), 8));
		voltar.setBackground(Color.LIGHT_GRAY);
		voltar.setActionCommand("VOLTAR");
		voltar.setBounds(30, 25, 140, 15);
	    voltar.addActionListener(listener);
		BemVindo.add(voltar);
		
		JLabel lblBemVindo = new JLabel("Bem Vindo ");
		lblBemVindo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemVindo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblBemVindo.setAlignmentX(0.5f);
		lblBemVindo.setBounds(5, 5, 190, 15);
		BemVindo.add(lblBemVindo);
		lblBemVindo.setName("MSG_ENTRADA");
		
		JScrollPane menu = new JScrollPane();
		menu.setViewportBorder(null);
		menu.setBounds(0, 45, 200, 200);
		menu.setName("MENU_LATERAL");
		painel.add(menu);
		
		JTree tree = new JTreeUsuario(usuarioAtual);
		menu.setViewportView(tree);
		
		JScrollPane conteudo = new JScrollPane();
		conteudo.setViewportBorder(null);
		conteudo.setBounds(200, 0, 300, 300);
		conteudo.setName("CONTEUDO");
		painel.add(conteudo);
		
		JPrincipal principal = new JPrincipal(usuarioAtual);
		conteudo.setViewportView(principal);
		
	}
}