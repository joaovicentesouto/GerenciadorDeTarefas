import java.util.*;
import java.util.List;
import java.awt.*;
import javax.swing.*;

public class VProjetosDoUsuario extends Visitor{

	private ArrayList<Component> componentes;
	private InterfaceRemove topo;
	
	public VProjetosDoUsuario(ArrayList<Component> componentes, InterfaceRemove topo) {
		super();
		this.componentes = componentes;
		this.topo = topo;
	}
	
	public void visitar(String usuario, String senha, List<InterfaceProjeto> projetos) {
		
		if(!projetos.isEmpty()) {
			Component c;
			Iterator<InterfaceProjeto> it = projetos.iterator();
			
			while(it.hasNext()) {
				InterfaceProjeto p = it.next();
				switch (p.tipo()) {
				
				case "PROJETO" :
					c = new JProjeto((Projeto)p, topo);
					//c.setName("PROJETO");
					componentes.add(c);
					break;
				
				case "TAREFA" :
					c = new JTarefa((Tarefa)p, topo);
					//c.setName("TAREFA");
					componentes.add(c);
					break;
				
				case "CONTADOR" :
					c = new JContador((Contador)p, topo);
					//c.setName("CONTADOR");
					componentes.add(c);
					break;
				
				default : break;
				}
			}
		}
	}
	
	
}