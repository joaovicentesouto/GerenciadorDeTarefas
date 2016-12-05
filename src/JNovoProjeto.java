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

public class JNovoProjeto extends JDialog{

	private JHome home;
	private InterfaceAdd topo;
	private JTextField titulo, dia, mes, ano, totalCont; // Espaco que vai ser escrito, que contém as informações do projeto.
	private JTextArea descricao;
	private ButtonGroup prioridades, seletores;
	private String estado;
	private JPanel principal;

	public JNovoProjeto(JHome home, InterfaceAdd topo, Dimension tamanho){
		this.home = home;
		this.topo = topo;

		setLocation((int)(tamanho.getWidth()/2)-250, (int)(tamanho.getHeight()/2)-150);
		setSize(500, 240);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setTitle("Novo");

		estado = "Projeto";
		totalCont = new JTextField("0");
		inicializacao();
		addComponentListener(new GestorTamanhoNovoProjeto(this));

		this.repaint();
	}

	private void inicializacao(){

		principal = new JPanel();
		principal.setBounds(8, 30, 482, 150);
		getContentPane().add(principal);
		principal.setLayout(null);
		principal.setName("principal");

		// -- Botoes topo --
		JPanel botoes = new JPanel(null);
		botoes.setBounds(8, 0, 500, 30);
		getContentPane().add(botoes);
		botoes.setName("botoes");
		
		LRadioButton listener = new LRadioButton(this);
		
		JRadioButton rdbProjeto = new JRadioButton("Projeto");
		rdbProjeto.setBounds(80, 5, 80, 20);
		rdbProjeto.addItemListener(listener);
		rdbProjeto.setSelected(true);
		botoes.add(rdbProjeto);
		rdbProjeto.setName("Projeto");
		rdbProjeto.setActionCommand("Projeto");

		JRadioButton rdbContador = new JRadioButton("Contador");
		rdbContador.setBounds(330, 5, 90, 20);
		rdbContador.addItemListener(listener);
		botoes.add(rdbContador);
		rdbContador.setName("Contador");
		//rdbContador.setSelected(true);
		rdbProjeto.setActionCommand("Contador");

		JRadioButton rdbTarefa = new JRadioButton("Tarefa");
		rdbTarefa.setBounds(205, 5, 80, 20);
		rdbTarefa.addItemListener(listener);
		botoes.add(rdbTarefa);
		rdbTarefa.setName("Tarefa");
		rdbProjeto.setActionCommand("Tarefa");

		// -- Principal --
		JPanel painel = painelConstrutor();
		principal.add(painel);

		// -- Botoes cancelar e adicionar --
		LBotoesNovoProjeto ba = new LBotoesNovoProjeto(home, this, topo);
		JButton but = new JButton("Cancelar");
		but.setBounds(158, 185, 80, 20);
		but.setName("Cancelar");
		but.addActionListener(ba);
		but.setActionCommand("CANCELAR");
		super.getContentPane().add(but);

		but = new JButton("Adicionar");
		but.setBounds(278, 185, 80, 20);
		but.setName("Adicionar");
		but.addActionListener(ba);
		but.setActionCommand("ADICIONAR");
		super.getContentPane().add(but);

		seletores = new ButtonGroup();
		seletores.add(rdbProjeto);
		seletores.add(rdbContador);
		seletores.add(rdbTarefa);
		
		this.repaint();
	}

	public void proximoEstado(String proximoEstado) {
		estado = proximoEstado;
	}

	public void maquinaDeEstados() {

		if(estado.equals("Contador")) {
			JPanel aux2 = panelContador();
			principal.add(aux2);
		} else {
			for(Component c : principal.getComponents()) {
				if(c.getName()!=null && c.getName().equals("auxContador")) {
					principal.remove(c);
				}
			}
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
		totalCont.setText("0");
		totalCont.setName("CONTADOR");
		totalCont.setBounds(198, 5, 117, 20);
		aux.add(totalCont);
		//aux.setBackground(Color.LIGHT_GRAY);

		return aux;
	}

	public void criacao(LBotoesNovoProjeto act) { // Usado para criar
		String titulo, descricao, dia, mes, ano;
		int prioridade = 0, d, m, a, total = 1;
		
		titulo = this.titulo.getText();
		descricao = this.descricao.getText();
		dia = this.dia.getText();
		mes = this.mes.getText();
		ano = this.ano.getText();
		d = Integer.parseInt(dia);
		m = Integer.parseInt(mes);
		a = Integer.parseInt(ano);
		prioridade = Integer.parseInt(prioridades.getSelection().getActionCommand());
		
		total = Integer.parseInt(totalCont.getText());
		
		Calendar c = Calendar.getInstance();
		c.set(a, m-1, d);
		DateFormat f = DateFormat.getDateInstance();

		Date meta = c.getTime();
		//System.out.println(data);
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//System.out.println("Data formatada: "+sdf.format(data));

		act.criar(estado, titulo, descricao, prioridade, total, meta);

	}

}
