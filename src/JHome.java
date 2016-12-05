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
	private JLabel identificador;
	private JButton novo;
	private ActionListener listener;
	private GestorTamanhoTela gestorTela;
	
	public JHome(Usuario usuarioAtual, GestorTamanhoTela gestorTela) {
		this.usuarioAtual = usuarioAtual;
		criacao();
		this.gestorTela = gestorTela;
	}
	
	public void criacao() {

		LAtualizarHome atualizarHome = new LAtualizarHome(this);
		
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
		
		tree = new JTreeUsuario(usuarioAtual, atualizarHome);
		menu.add(tree);
		menu.setViewportView(tree);
		
		
		// -- Cabeçalho --
		identificador = new JLabel("Home");
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
		
		novo = new JButton("Novo");
		novo.setBounds(950, 12, 50, 20);
		painel.add(novo);
		novo.setName("NOVO");
		novo.addActionListener(new LCriador(this, usuarioAtual));
		
		JScrollPane conteudo = new JScrollPane();
		conteudo.setViewportBorder(null);
		conteudo.setBounds(200, 45, 200, 200);
		conteudo.setName("CONTEUDO");
		painel.add(conteudo);
		
		principal = new JPrincipal(usuarioAtual, atualizarHome);
		principal.setName("PRINCIPAL");
		conteudo.add(principal);
		conteudo.setViewportView(principal);
		
	}
	
	public void atualizar() {
		tree.atualizar();
		principal.atualizar();
		gestorTela.ajusteTamanhoHome();
	}
	
	public void atualizar(String cmd) {
		principal.proximoEstado("USUARIO");
		identificador.setText("Home");
		((LCriador)novo.getActionListeners()[0]).novoTopo(usuarioAtual);
		principal.atualizar();
		gestorTela.ajusteTamanhoHome();
	}
	
	public void atualizar(InterfaceProjeto p) {
		principal.proximoEstado("PROJETO");
		p.aceitarVisita(new VTitulo(identificador));
		((LCriador)novo.getActionListeners()[0]).novoTopo((Projeto)p);
		principal.atualizarProjeto(p);
		principal.atualizar();
		gestorTela.ajusteTamanhoHome();
	}
}