
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.text.MaskFormatter;

public class JModificaProjeto extends JDialog{

	private InterfaceProjeto projeto;
	private JTextField titulo, dia, mes, ano, totalCont; // Espaco que vai ser escrito, que contém as informações do projeto.
	private JTextArea descricao;
	private ButtonGroup prioridades, seletores;
	private JPanel principal;
	private LAtualizarHome atualizarHome;

	public JModificaProjeto(InterfaceProjeto projeto, Dimension tamanho,LAtualizarHome atualizarHome){
		this.projeto = projeto;
		this.atualizarHome = atualizarHome;

		setLocation((int)(tamanho.getWidth()/2)-250, (int)(tamanho.getHeight()/2)-150);
		setSize(500, 240);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setTitle("Novo");

		maquinaDeEstados();
		addComponentListener(new GestorTamanhoModificaProjeto(this));

		this.repaint();
	}

	private void inicializacao(){

		principal = new JPanel();
		principal.setBounds(8, 30, 482, 150);
		getContentPane().add(principal);
		principal.setLayout(null);
		principal.setName("principal");

		// -- Principal --
		JPanel painel = painelConstrutor();
		principal.add(painel);

		// -- Botoes cancelar e adicionar --
		LBotoesModificaProjeto ba = new LBotoesModificaProjeto(this, projeto, atualizarHome);
		
		JButton but = new JButton("Cancelar");
		but.setBounds(158, 185, 80, 20);
		but.setName("Cancelar");
		but.addActionListener(ba);
		but.setActionCommand("CANCELAR");
		super.getContentPane().add(but);

		but = new JButton("Modificar");
		but.setBounds(278, 185, 80, 20);
		but.setName("MODIFICAR");
		but.addActionListener(ba);
		but.setActionCommand("MODIFICAR");
		super.getContentPane().add(but);
		
		this.repaint();
	}

	public void maquinaDeEstados() {

		if(projeto.tipo().equals("CONTADOR")) {
			inicializacao();
			JPanel aux2 = panelContador();
			principal.add(aux2);
		} else {
			inicializacao();
		}

		this.repaint();
	}

	private JPanel painelConstrutor() {

		JPanel auxiliar = new JPanel();
		auxiliar.setBounds(0, 0, 482, 110);
		//auxiliar.setBackground(Color.LIGHT_GRAY);
		auxiliar.setLayout(null);

		// -- Titulo --
		JLabel lblTtulo = new JLabel("Titulo:");
		lblTtulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTtulo.setBounds(0, 8, 50, 15);
		auxiliar.add(lblTtulo);

		titulo = new JTextFieldLimitado(35);
		titulo.setBounds(77, 5, 235, 20);
		titulo.setName("TITULO");
		auxiliar.add(titulo);
		titulo.setColumns(10);

		// -- Descricao --
		JLabel lblDescrio = new JLabel("Descricao:");
		lblDescrio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescrio.setBounds(5, 30, 70, 14);
		auxiliar.add(lblDescrio);

		descricao = new JTextAreaLimitada(150);
		descricao.setName("DESCRICAO");
		descricao.setWrapStyleWord(true);
		descricao.setLineWrap(true);
		descricao.setColumns(10);
		descricao.setRows(5);
		descricao.setBounds(80, 30, 230, 75);
		auxiliar.add(descricao);

		// -- Botoes Prioridade --
		JLabel lblPrioridade = new JLabel("Prioridade:");
		lblPrioridade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrioridade.setBounds(315, 5, 70, 15);
		auxiliar.add(lblPrioridade);

		prioridades = new ButtonGroup();
		//LRadioPrioridade rp = new LRadioPrioridade(this);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Alta");
		rdbtnNewRadioButton.setBounds(382, 5, 70, 15);
		rdbtnNewRadioButton.setActionCommand("2");
		//rdbtnNewRadioButton.addItemListener(rp);
		auxiliar.add(rdbtnNewRadioButton);
		prioridades.add(rdbtnNewRadioButton);

		JRadioButton rdbtnMdia = new JRadioButton("Media");
		rdbtnMdia.setBounds(382, 25, 70, 15);
		rdbtnMdia.setActionCommand("1");
		//rdbtnMdia.addItemListener(rp);
		auxiliar.add(rdbtnMdia);
		prioridades.add(rdbtnMdia);

		JRadioButton rdbtnBaixa = new JRadioButton("Baixa");
		rdbtnBaixa.setBounds(382, 45, 70, 15);
		rdbtnBaixa.setActionCommand("0");
		//rdbtnBaixa.addItemListener(rp);
		auxiliar.add(rdbtnBaixa);
		prioridades.add(rdbtnBaixa);

		// -- Data --
		JLabel lblDataFinal = new JLabel("Data para Finalizacao:");
		lblDataFinal.setBounds(320, 65, 170, 14);
		auxiliar.add(lblDataFinal);

		dia = new JTextFieldSomenteNumeros(2);
		dia.setName("DIA");
		dia.setBounds(320, 85, 30, 20);
		auxiliar.add(dia);

		JLabel labelAux = new JLabel("/");
		labelAux.setBounds(350, 85, 40, 20);
		auxiliar.add(labelAux);
		mes = new JTextFieldSomenteNumeros(2);
		mes.setName("MES");
		mes.setBounds(357, 85, 30, 20);
		auxiliar.add(mes);

		labelAux = new JLabel("/");
		labelAux.setBounds(387, 85, 30, 20);
		auxiliar.add(labelAux);
		ano = new JTextFieldSomenteNumeros(4);
		ano.setName("ANO");
		ano.setBounds(394, 85, 50, 20);
		auxiliar.add(ano);

		return auxiliar;
	}

	private JPanel panelContador() {

		JPanel aux = new JPanel(null);
		aux.setBounds(0, 115, 483, 30);
		aux.setName("auxContador");

		JLabel label = new JLabel("Quantidade total do contador:");
		label.setName("labelTotal");
		label.setBounds(5, 5, 190, 20);
		aux.add(label);

		totalCont = new JTextFieldSomenteNumeros(13);
		totalCont.setName("CONTADOR");
		totalCont.setBounds(198, 5, 117, 20);
		aux.add(totalCont);
		//aux.setBackground(Color.LIGHT_GRAY);

		return aux;
	}

	public void criacao(LBotoesModificaProjeto act) { // Usado para criar
		String titulo, descricao, dia, mes, ano, conta;
		int prioridade = 0, d, m, a, total = 0;
		
		titulo = this.titulo.getText();
		descricao = this.descricao.getText();
		dia = this.dia.getText();
		mes = this.mes.getText();
		ano = this.ano.getText();
		d = Integer.parseInt(dia);
		m = Integer.parseInt(mes);
		a = Integer.parseInt(ano);
		prioridade = Integer.parseInt(prioridades.getSelection().getActionCommand());
		
		Calendar c = Calendar.getInstance();
		c.set(a, m-1, d);
		DateFormat f = DateFormat.getDateInstance();

		Date meta = c.getTime();
		//System.out.println(data);
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//System.out.println("Data formatada: "+sdf.format(data));
		
		Dados dado = new Dados(titulo, descricao, prioridade, meta);

		act.modificar(dado);

	}

}
