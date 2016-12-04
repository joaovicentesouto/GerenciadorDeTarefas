import java.awt.Component;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VProjetosDoProjeto extends Visitor {

	private ArrayList<Component> componentes;
	private InterfaceRemove topo;
	
	public VProjetosDoProjeto(ArrayList<Component> componentes, InterfaceRemove topo) {
		super();
		this.componentes = componentes;
		this.topo = topo;
	}
	
	public void visitar(List<InterfaceProjeto> projetos, double porcento, Dados dados) {
		
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
