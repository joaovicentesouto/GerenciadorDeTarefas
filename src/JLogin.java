import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JLogin extends JPanel {

	private JTextField senha, usuario;

	public JLogin(JFrame f, ActionListener listener) {

		setForeground(Color.BLACK);
		setLayout(new BorderLayout());

		criacao(listener);
	}

	public void criacao(ActionListener listener) {

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);

		panel.setLayout(null);

		JPanel PainelFixo = new JPanel();
		PainelFixo.setBounds(0, 0, 255, 80);
		panel.add(PainelFixo);
		PainelFixo.setLayout(null);

		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.setFont(new Font("Arial", Font.PLAIN, 12));
		cadastrar.setBorderPainted(false);
		cadastrar.setBorder(new LineBorder(new Color(192, 192, 192), 8));
		cadastrar.setBackground(Color.LIGHT_GRAY);
		cadastrar.setActionCommand("CADASTRAR");
		cadastrar.setBounds(55, 40, 98, 15);
		cadastrar.addActionListener(listener);
		PainelFixo.add(cadastrar);

		JButton entrar = new JButton("Entrar");
		entrar.setFont(new Font("Arial", Font.PLAIN, 12));
		entrar.setBorderPainted(false);
		entrar.setBorder(new LineBorder(new Color(192, 192, 192), 8));
		entrar.setBackground(Color.LIGHT_GRAY);
		entrar.setActionCommand("ENTRAR");
		entrar.setBounds(157, 40, 98, 15);
		entrar.addActionListener(listener);
		PainelFixo.add(entrar);

		senha = new JTextField();
		senha.setFont(new Font("Arial", Font.PLAIN, 12));
		senha.setHorizontalAlignment(SwingConstants.LEFT);
		senha.setEditable(true);
		senha.setColumns(1);
		senha.setBorder(null);
		senha.setBackground(Color.LIGHT_GRAY);
		senha.setBounds(55, 20, 200, 15);
		senha.setName("SENHA");
		PainelFixo.add(senha);

		usuario = new JTextField();
		usuario.setFont(new Font("Arial", Font.PLAIN, 12));
		usuario.setHorizontalAlignment(SwingConstants.LEFT);
		usuario.setEditable(true);
		usuario.setColumns(1);
		usuario.setBorder(null);
		usuario.setBackground(Color.LIGHT_GRAY);
		usuario.setBounds(55, 0, 200, 15);
		usuario.setName("USUARIO");
		PainelFixo.add(usuario);

		JLabel label = new JLabel("Usuario:");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Arial", Font.PLAIN, 12));
		label.setAlignmentX(0.5f);
		label.setBounds(0, 0, 55, 15);
		PainelFixo.add(label);

		label = new JLabel("Senha:");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Arial", Font.PLAIN, 12));
		label.setAlignmentX(0.5f);
		label.setBounds(0, 20, 55, 15);
		PainelFixo.add(label);

		JLabel lblUsurioOuSenha = new JLabel("Usuario ou senha incorretos. Tente novamente.");
		lblUsurioOuSenha.setForeground(Color.RED);
		lblUsurioOuSenha.setVisible(false);
		lblUsurioOuSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsurioOuSenha.setFont(new Font("Arial", Font.PLAIN, 11));
		lblUsurioOuSenha.setAlignmentX(0.5f);
		lblUsurioOuSenha.setBounds(0, 60, 255, 15);
		lblUsurioOuSenha.setName("ERRO_LOGIN");
		PainelFixo.add(lblUsurioOuSenha);
	}
}
