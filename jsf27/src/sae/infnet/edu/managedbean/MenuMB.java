package sae.infnet.edu.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class MenuMB {

	private int activeIndex = 0;
	
	public MenuMB() {
		// TODO Auto-generated constructor stub
	}
	
	public String cadQuestao(){
		return "cadQuestao";
	}

	public String cadAvaliacao(){
		return "cadAvaliacao";
	}
	
	public String paginaInicial(){
		this.activeIndex = 0;
		return "permitido";
	}
	
	public String paginaAdmin(){
		this.activeIndex = 1;
		return "admin";
	}

	public String paginaAluno(){
		this.activeIndex = 2;
		return "aluno";
	}
	
	public int getActiveIndex() {
		return activeIndex;
	}

	public void setActiveIndex(int activeIndex) {
		this.activeIndex = activeIndex;
	}
}
