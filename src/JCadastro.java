import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class JCadastro extends JPanel {
	private JTextField confirma_senha, usuario;
	private JTextField senha;

	public JCadastro(JFrame f, ActionListener listener) {
		
		setForeground(Color.BLACK);
		setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		
		panel.setLayout(null);
		
		JPanel PainelFixo = new JPanel();
		PainelFixo.setBounds(0, 0, 255, 100);		
		panel.add(PainelFixo);
		PainelFixo.setLayout(null);
		
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.setFont(new Font("Arial", Font.PLAIN, 12));
		cadastrar.setBorderPainted(false);
		cadastrar.setBorder(new LineBorder(new Color(192, 192, 192), 8));
		cadastrar.setBackground(Color.LIGHT_GRAY);
		cadastrar.setBounds(0, 60, 125, 15);
	    cadastrar.addActionListener(listener);
	    cadastrar.setActionCommand("CADASTRAR_USUARIO");
		PainelFixo.add(cadastrar);
		
		JButton voltar = new JButton("Voltar");
		voltar.setFont(new Font("Arial", Font.PLAIN, 12));
		voltar.setBorderPainted(false);
		voltar.setBorder(new LineBorder(new Color(192, 192, 192), 8));
		voltar.setBackground(Color.LIGHT_GRAY);
		voltar.setBounds(130, 60, 125, 15);
	    voltar.addActionListener(listener);
	    voltar.setActionCommand("VOLTAR");
		PainelFixo.add(voltar);
		
		confirma_senha = new JTextField();
		confirma_senha.setHorizontalAlignment(SwingConstants.LEFT);
		confirma_senha.setFont(new Font("Arial", Font.PLAIN, 12));
		confirma_senha.setEditable(true);
		confirma_senha.setColumns(1);
		confirma_senha.setBorder(null);
		confirma_senha.setBackground(Color.LIGHT_GRAY);
		confirma_senha.setBounds(100, 40, 155, 15);
		confirma_senha.setName("CONFIRMA_SENHA");
		PainelFixo.add(confirma_senha);
		
		usuario = new JTextField();
		usuario.setHorizontalAlignment(SwingConstants.LEFT);
		usuario.setFont(new Font("Arial", Font.PLAIN, 12));
		usuario.setEditable(true);
		usuario.setColumns(1);
		usuario.setBorder(null);
		usuario.setBackground(Color.LIGHT_GRAY);
		usuario.setBounds(55, 0, 200, 15);
		usuario.setName("USUARIO");
		PainelFixo.add(usuario);
		
		JLabel label = new JLabel("Usuário:");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Arial", Font.PLAIN, 12));
		label.setAlignmentX(0.5f);
		label.setBounds(0, 0, 55, 15);
		PainelFixo.add(label);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar Senha:");
		lblConfirmarSenha.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmarSenha.setFont(new Font("Arial", Font.PLAIN, 12));
		lblConfirmarSenha.setAlignmentX(0.5f);
		lblConfirmarSenha.setBounds(0, 40, 100, 15);
		PainelFixo.add(lblConfirmarSenha);
		
		senha = new JTextField();
		senha.setName("SENHA");
		senha.setHorizontalAlignment(SwingConstants.LEFT);
		senha.setFont(new Font("Arial", Font.PLAIN, 12));
		senha.setEditable(true);
		senha.setColumns(1);
		senha.setBorder(null);
		senha.setBackground(Color.LIGHT_GRAY);
		senha.setBounds(55, 20, 200, 15);
		senha.setName("SENHA");
		PainelFixo.add(senha);
		
		JLabel label_2 = new JLabel("Senha:");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Arial", Font.PLAIN, 12));
		label_2.setAlignmentX(0.5f);
		label_2.setBounds(0, 20, 55, 15);
		PainelFixo.add(label_2);
		
		JLabel lblErro1 = new JLabel("Senha inválida. Tente novamente.");
		lblErro1.setForeground(Color.RED);
		lblErro1.setVisible(false);
		lblErro1.setHorizontalAlignment(SwingConstants.CENTER);
		lblErro1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblErro1.setAlignmentX(0.5f);
		lblErro1.setBounds(0, 80, 255, 15);
		lblErro1.setName("ERRO1_LOGIN");
		PainelFixo.add(lblErro1);
		
		JLabel lblErro2 = new JLabel("Usuário inválido. Tente novamente.");
		lblErro2.setForeground(Color.RED);
		lblErro2.setVisible(false);
		lblErro2.setHorizontalAlignment(SwingConstants.CENTER);
		lblErro2.setFont(new Font("Arial", Font.PLAIN, 11));
		lblErro2.setAlignmentX(0.5f);
		lblErro2.setBounds(0, 80, 255, 15);
		lblErro2.setName("ERRO2_LOGIN");
		PainelFixo.add(lblErro2);
		
		JLabel lblErro3 = new JLabel("Usuário e senha inválidos. Tente novamente.");
		lblErro3.setForeground(Color.RED);
		lblErro3.setVisible(false);
		lblErro3.setHorizontalAlignment(SwingConstants.CENTER);
		lblErro3.setFont(new Font("Arial", Font.PLAIN, 11));
		lblErro3.setAlignmentX(0.5f);
		lblErro3.setBounds(0, 80, 255, 15);
		lblErro3.setName("ERRO3_LOGIN");
		PainelFixo.add(lblErro3);
		
		JLabel lblErro4 = new JLabel("Usuário já cadastrado. Tente novamente.");
		lblErro4.setForeground(Color.RED);
		lblErro4.setVisible(false);
		lblErro4.setHorizontalAlignment(SwingConstants.CENTER);
		lblErro4.setFont(new Font("Arial", Font.PLAIN, 11));
		lblErro4.setAlignmentX(0.5f);
		lblErro4.setBounds(0, 80, 255, 15);
		lblErro4.setName("ERRO4_LOGIN");
		PainelFixo.add(lblErro4);
		
		JLabel lblCadastrado = new JLabel("Usuário cadastrado com sucesso!.");
		lblCadastrado.setForeground(Color.GREEN);
		lblCadastrado.setVisible(false);
		lblCadastrado.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrado.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCadastrado.setAlignmentX(0.5f);
		lblCadastrado.setBounds(0, 80, 255, 15);
		lblCadastrado.setName("CADASTRO_EFETUADO");
		PainelFixo.add(lblCadastrado);
	}
}