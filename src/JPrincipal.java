import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.util.*;

public class JPrincipal extends JPanel{

	private Usuario usuario;
	private String estado; // Panel que esta sendo mostrado
	//RAIZ = home do usuario / "PROJETO" = qualquer sub projeto

	public JPrincipal(Usuario usuario) {
		super();
		this.usuario = usuario;
		setName("PRINCIPAL");
		setLayout(new CardLayout());
		estado = "RAIZ";
		principalUsuario();
	}

	public void maquinaDeEstados() {
		CardLayout cl = (CardLayout) getLayout();

		switch (estado) {
		case "RAIZ":
			cl.show(this, "RAIZ");
			break;

		case "PROJETO":
			cl.show(this, "PROJETO");
			break;

			default : break;
		}
	}

	public void proximoEstado(String proximoEstado) {
		estado = proximoEstado;
	}

	public String estadoAtual() {
		return estado;
	}

	private void principalUsuario() {

		ArrayList<Component> componentes = new ArrayList<Component>();
		usuario.aceitarVisita(new VProjetosDoUsuario(componentes, usuario));

		JScrollPane sp = new JScrollPane();
		sp.setViewportBorder(null);
		JPanel principal = new JPanel(null);
		JPanel auxiliar = new JPanel(new GridLayout(componentes.size(), 1));
		auxiliar.setBounds(0, 0, 1000, componentes.size()*100);
		
		Iterator<Component> it = componentes.iterator();
		while(it.hasNext()) {
			auxiliar.add(it.next());
		}
		principal.add(auxiliar);
		sp.setViewportView(principal);
		add(sp, "RAIZ");
	}

	private void principalProjeto(InterfaceProjeto projeto) {

		ArrayList<Component> componentes = new ArrayList<Component>();
		projeto.aceitarVisita(new VProjetosDoUsuario(componentes, usuario));

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
