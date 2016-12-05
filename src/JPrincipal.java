import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.util.*;

public class JPrincipal extends JPanel{

	private Usuario usuario;
	private LAtualizarHome atualizarHome;
	private InterfaceProjeto projetoAtual;
	private String estado; // Panel que esta sendo mostrado
	//USUARIO = home do usuario / "PROJETO" = qualquer sub projeto

	public JPrincipal(Usuario usuario, LAtualizarHome atualizarHome) {
		this.usuario = usuario;
		this.atualizarHome = atualizarHome;
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
	
	public void atualizarProjeto(InterfaceProjeto projetoAtual) {
		this.projetoAtual = projetoAtual;
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
		usuario.aceitarVisita(new VProjetosDoUsuario(componentes, usuario, atualizarHome));
		
		super.setLayout(new BorderLayout());
		
		JPanel aux1 = new JPanel(null);
		aux1.setName("aux1");
		aux1.setBounds(0, 0, 300, componentes.size()*70);
		super.add(aux1, BorderLayout.CENTER);
		
		JPanel aux2 = new JPanel(new GridLayout(componentes.size(), 1));
		aux2.setName("aux2");
		aux1.add(aux2);
		aux2.setBounds(0, 0, 300, componentes.size()*70);
		
		Iterator<Component> it = componentes.iterator();
		while(it.hasNext()) {
			aux2.add(it.next());
		}
		
		super.setSize(new Dimension(300, componentes.size()*70));
		
		
		// -- Funcionou mais ou menos
//		super.setLayout(new GridLayout(componentes.size(), 1));
//		
//		Iterator<Component> it = componentes.iterator();
//		while(it.hasNext()) {
//			super.add(it.next());
//		}
		// --- teste 1

	}

	private void principalProjeto() {

		ArrayList<Component> componentes = new ArrayList<Component>();
		projetoAtual.aceitarVisita(new VProjetosDoProjeto(componentes, (Projeto)projetoAtual, atualizarHome));
		
		super.setLayout(new BorderLayout());
		
		if(componentes.isEmpty()) {
			JPanel aux1 = new JPanel(null);
			aux1.setName("aux1");
			aux1.setBounds(0, 0, 300, 70);
			super.add(aux1, BorderLayout.CENTER);
			
			JLabel aux2 = new JLabel("Está meio vazio por aqui...");
			aux2.setName("vazio");
			aux2.setBounds(25, 5, 300, 70);
			aux1.add(aux2);
		} else {
			JPanel aux1 = new JPanel(null);
			aux1.setName("aux1");
			aux1.setBounds(0, 0, 300, componentes.size()*70);
			super.add(aux1, BorderLayout.CENTER);
			
			JPanel aux2 = new JPanel(new GridLayout(componentes.size(), 1));
			aux2.setName("aux2");
			aux1.add(aux2);
			aux2.setBounds(0, 0, 300, componentes.size()*70);
			
			Iterator<Component> it = componentes.iterator();
			while(it.hasNext()) {
				aux2.add(it.next());
			}
			
			super.setSize(new Dimension(300, componentes.size()*70));
		}
	}

}
