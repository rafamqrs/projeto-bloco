package sae.infnet.edu.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class MenuMB {

	private int activeIndex = 0;
	
	public MenuMB() {
	}
	
	public String cadQuestao(){
		return "cadQuestao";
	}

	public String cadModulo(){
		return "cadModulo";
	}
	
	public String cadAvaliacao(){
		return "cadAvaliacao";
	}
	
	public String respAvaliacao(){
		return "respAvaliacao";
	}
	
	public String paginaInicial(){
		setActiveIndex(0);
		return "home";
	}
	
	public String paginaAdmin(){
		setActiveIndex(1);
		return "admin";
	}

	public String paginaAluno(){
		setActiveIndex(2);
		return "aluno";
	}
	
	public int getActiveIndex() {
		return activeIndex;
	}

	public void setActiveIndex(int activeIndex) {
		this.activeIndex = activeIndex;
	}
}
