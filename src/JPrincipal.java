import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.util.*;

public class JPrincipal extends JPanel{

	private Usuario usuario;
	private InterfaceProjeto projetoAtual;
	private String estado; // Panel que esta sendo mostrado
	//USUARIO = home do usuario / "PROJETO" = qualquer sub projeto

	public JPrincipal(Usuario usuario) {
		super();
		this.usuario = usuario;
		setName("PRINCIPAL");
		estado = "USUARIO";
		principalUsuario();
		super.setMinimumSize(new Dimension(400,400));
	}

	public void proximoEstado(String proximoEstado) {
		estado = proximoEstado;
	}

	public String estadoAtual() {
		return estado;
	}
	
	public void atualizar() {
		
		super.removeAll();
		
		if(estado.equals("USUARIO")) {
			principalUsuario();
		} else {
			principalProjeto();
		}
	}

	private void principalUsuario() {

		ArrayList<Component> componentes = new ArrayList<Component>();
		usuario.aceitarVisita(new VProjetosDoUsuario(componentes, usuario));
		
		// -- Funcionou mais ou menos
		super.setLayout(new GridLayout(componentes.size(), 1));
		
		Iterator<Component> it = componentes.iterator();
		while(it.hasNext()) {
			super.add(it.next());
		}
		// --- teste 1

//		JPanel auxPrimeiro = new JPanel(null);
//		JPanel auxSegundo = new JPanel(new GridLayout(componentes.size(), 1));
//		
//		Rectangle r = new Rectangle(0, 0, 1000, componentes.size()*100);
//		auxPrimeiro.setBounds(r);
//		auxSegundo.setBounds(r);
//		
//		Iterator<Component> it = componentes.iterator();
//		while(it.hasNext()) {
//			auxSegundo.add(it.next());
//		}
//		auxPrimeiro.add(auxSegundo);
//		auxPrimeiro.setName("auxPrimeiro");
//		auxSegundo.setName("auxSegundo");
//		add(auxPrimeiro);
//		auxPrimeiro.setBackground(Color.red);
//		auxSegundo.setBackground(Color.cyan);
	}

	private void principalProjeto() {

		ArrayList<Component> componentes = new ArrayList<Component>();
		projetoAtual.aceitarVisita(new VProjetosDoUsuario(componentes, usuario));

		JScrollPane sp = new JScrollPane();
		sp.setViewportBorder(null);
		JPanel principal = new JPanel(null);
		JPanel auxiliar = new JPanel(new GridLayout(componentes.size(), 1));
		auxiliar.setBounds(0, 0, 500, componentes.size()*100);
		
		Iterator<Component> it = componentes.iterator();
		while(it.hasNext()) {
			auxiliar.add(it.next());
		}
		principal.add(auxiliar);
		sp.setViewportView(principal);
		add(sp, "PROJETO");
	}

}
