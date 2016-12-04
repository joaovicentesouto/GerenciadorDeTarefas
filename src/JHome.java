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
	private JPrincipal principal;
	private JTreeUsuario tree;
	private ActionListener listener;
	
	public JHome(ActionListener listener, Usuario usuarioAtual) {
		this.usuarioAtual = usuarioAtual;
		criacao();
	}
	
	public void criacao() {

		//listener = new L
		
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
		
		tree = new JTreeUsuario(usuarioAtual);
		menu.setViewportView(tree);
		
		// -- Cabeçalho --
		JLabel identificador = new JLabel("Home");
		identificador.setName("ID");
		identificador.setBounds(205, 10, 150, 25);
		painel.add(identificador);
		Font fonte = identificador.getFont();
		fonte.getSize();
		identificador.setFont(new Font(fonte.getFontName(), fonte.getStyle(), 18));
		
		JTextFieldLimitado campoBusca = new JTextFieldLimitado(30);
		campoBusca.setBounds(1000, 12, 150, 20);
		painel.add(campoBusca);
		campoBusca.setName("CAMPO");
		
		JButton but = new JButton("Buscar");
		but.setBounds(1160, 12, 60, 20);
		painel.add(but);
		but.setName("BUSCAR");
		
		JScrollPane conteudo = new JScrollPane();
		conteudo.setViewportBorder(null);
		conteudo.setBounds(200, 45, 200, 200);
		conteudo.setName("CONTEUDO");
		painel.add(conteudo);
		
		principal = new JPrincipal(usuarioAtual);
		principal.setName("PRINCIPAL");
//		JLabel l = new JLabel("llllllllll");
//		conteudo.setViewportView(l);
		conteudo.setViewportView(principal);
		
	}
	
	public void atualizar() {
		tree.atualizar();
		principal.atualizar();
	}
}