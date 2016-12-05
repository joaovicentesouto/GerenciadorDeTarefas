import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class LComportamento implements ActionListener{
	private Configuracao config;
	private JPanel tela;
	private BancoDeDados bd;
	
	public LComportamento(Configuracao config, JPanel tela, BancoDeDados bd) {
		this.config = config;
		this.tela = tela;
		this.bd = bd;
	}
	
	public boolean valida_Usuario(JTextField us, JTextField se, JLabel erro){
		erro.setVisible(false);
		if(bd.validar(new Usuario(us.getText(), se.getText()))){
			Usuario usuarioAprovado = null;
			bd.aceitarVisita(new VPegaUsuario(usuarioAprovado));
			config.maquinaDeEstados("HOME");
			return true;
		}else
			erro.setVisible(true);
		return false;
	}
	
	public boolean cadastra_Usuario(String senha, String confirma_Senha, String usuario, JLabel erro1, JLabel erro2, JLabel erro3, JLabel erro4, JLabel cadastro){
		
		erro1.setVisible(false); // Senha invalida
		erro2.setVisible(false); // Usuario invalido
		erro3.setVisible(false); // Usuario e senha invalidos
		erro4.setVisible(false); // Usuario ja cadastrado
		cadastro.setVisible(false); //Usuario cadastrado com sucesso
		
		
		if(!senha.equals("") && confirma_Senha.equals(senha) && !usuario.equals("")){
			if(bd.cadastrar(new Usuario(usuario, senha))){
				cadastro.setVisible(true);
				return true;
			}else
				erro4.setVisible(true);
		}else
			if((!confirma_Senha.equals(senha) || senha.equals("") || confirma_Senha.equals("")) && !usuario.equals(""))
				erro1.setVisible(true);
			else
				if(!senha.equals("") && confirma_Senha.equals(senha) && usuario.equals(""))
					erro2.setVisible(true);
				else
					erro3.setVisible(true);
		
		return false;
			
	}
		
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		JPanel card = null;
		
		switch(cmd){
		
		case "ENTRAR":
			
			for (Component comp : tela.getComponents()) {
			    if (comp.getName().equals("LOGIN")) {
			        card = (JPanel) comp;
			    }
			}
			
			BorderLayout layout = (BorderLayout) card.getLayout();
			
			JTextField us = null, se = null;
			JLabel erro = null;
			JPanel login;
			
			login = (JPanel) layout.getLayoutComponent(BorderLayout.CENTER);
			login = (JPanel) login.getComponent(0);
			login = (JPanel) login.getComponent(0);
			
			for(Component c : login.getComponents()){
				if(c.getName() != null){
					switch (c.getName()) {
					case "SENHA":
						se = (JTextField)c;
						break;
					case "USUARIO":
						us = (JTextField)c;
						break;
					case "ERRO_LOGIN":
						erro = (JLabel)c;
						break;
					}				
				}
			}
			
			if(valida_Usuario(us, se, erro)){
				
				for (Component comp : tela.getComponents()) {
				    if (comp.getName().equals("HOME")) {
				        card = (JPanel) comp;
				    }
				}
				
				layout = (BorderLayout) card.getLayout();
				
				JLabel msg = null;
				JPanel home, bem_Vindo;
				
				home = (JPanel) layout.getLayoutComponent(BorderLayout.CENTER);
				home = (JPanel) home.getComponent(0);
				
				for(Component c : home.getComponents()){
					if(c.getName() != null){
						switch (c.getName()) {
						case "BEM_VINDO":
							bem_Vindo = (JPanel)c;
							for(Component co : bem_Vindo.getComponents()){
								if(co.getName() != null){
									switch (co.getName()) {
									case "MSG_ENTRADA":
										msg = (JLabel)co;
										msg.setText("Bem Vindo " + us.getText());
										break;
									}				
								}
							}
							break;
						}				
					}
				}
				us.setText(null);
				se.setText(null);
			}
		break;
		
		case "CADASTRAR":
			for (Component comp : tela.getComponents()) {
			    if (comp.getName().equals("LOGIN")) {
			        card = (JPanel) comp;
			    }
			}
			
			layout = (BorderLayout) card.getLayout();
			
			us = null; se = null;
			erro = null;
			
			login = (JPanel) layout.getLayoutComponent(BorderLayout.CENTER);
			login = (JPanel) login.getComponent(0);
			login = (JPanel) login.getComponent(0);
			
			for(Component c : login.getComponents()){
				if(c.getName() != null){
					switch (c.getName()) {
					case "SENHA":
						se = (JTextField)c;
						se.setText(null);
						break;
					case "USUARIO":
						us = (JTextField)c;
						us.setText(null);
						break;
					case "ERRO_LOGIN":
						erro = (JLabel)c;
						erro.setVisible(false);
						break;
					}				
				}
			}
			config.maquinaDeEstados("LOGIN");
			break;
			
		case "VOLTAR":
			for (Component comp : tela.getComponents()) {
			    if (comp.getName().equals("CADASTRO")) {
			        card = (JPanel) comp;
			    }
			}
			BorderLayout lay = (BorderLayout) card.getLayout();
			JLabel erro1 = null, erro2 = null, erro3 = null, erro4 = null, msg_Cadastro = null;
			JPanel cadastro;
			
			cadastro = (JPanel) lay.getLayoutComponent(BorderLayout.CENTER);
			cadastro = (JPanel) cadastro.getComponent(0);
			cadastro = (JPanel) cadastro.getComponent(0);
			
			for(Component c : cadastro.getComponents()){
				if(c.getName() != null){
					switch (c.getName()) {
					case "ERRO1_LOGIN":
						erro1 = (JLabel)c;
						erro1.setVisible(false);
						break;
					case "ERRO2_LOGIN":
						erro2 = (JLabel)c;
						erro2.setVisible(false);
						break;
					case "ERRO3_LOGIN":
						erro3 = (JLabel)c;
						erro3.setVisible(false);
						break;
					case "ERRO4_LOGIN":
						erro4 = (JLabel)c;
						erro4.setVisible(false);
						break;
					case "CADASTRO_EFETUADO":
						msg_Cadastro = (JLabel)c;
						msg_Cadastro.setVisible(false);
						break;
					}				
				}
			}
			config.maquinaDeEstados("LOGIN");
			break;
		
		case "CADASTRAR_USUARIO":
			
			for (Component comp : tela.getComponents()) {
			    if (comp.getName().equals("CADASTRO")) {
			        card = (JPanel) comp;
			    }
			}
			
			lay = (BorderLayout) card.getLayout();
			
			JTextField usuario = null, senha = null, confirma_Senha = null;
			erro1 = null; erro2 = null; erro3 = null; erro4 = null; msg_Cadastro = null;
			
			cadastro = (JPanel) lay.getLayoutComponent(BorderLayout.CENTER);
			cadastro = (JPanel) cadastro.getComponent(0);
			cadastro = (JPanel) cadastro.getComponent(0);
			
			for(Component c : cadastro.getComponents()){
				if(c.getName() != null){
					switch (c.getName()) {
					case "SENHA":
						senha = (JTextField)c;					
						break;
					case "CONFIRMA_SENHA":
						confirma_Senha = (JTextField)c;					
						break;
					case "USUARIO":
						usuario = (JTextField)c;
						break;
					case "ERRO1_LOGIN":
						erro1 = (JLabel)c;
						break;
					case "ERRO2_LOGIN":
						erro2 = (JLabel)c;
						break;
					case "ERRO3_LOGIN":
						erro3 = (JLabel)c;
						break;
					case "ERRO4_LOGIN":
						erro4 = (JLabel)c;
						break;
					case "CADASTRO_EFETUADO":
						msg_Cadastro = (JLabel)c;
						break;
					}				
				}
			}
			if(cadastra_Usuario(senha.getText(), confirma_Senha.getText(), usuario.getText(), erro1, erro2, erro3, erro4, msg_Cadastro)){
				senha.setText(null);
				usuario.setText(null);
				confirma_Senha.setText(null);
			}
			break;
			
		default:
			break;
		}
	}
}