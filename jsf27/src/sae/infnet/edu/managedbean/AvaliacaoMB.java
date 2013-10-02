package sae.infnet.edu.managedbean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import sae.infnet.edu.br.facade.QuestaoFacade;
import sae.infnet.edu.modelo.Questao;

@ManagedBean
public class AvaliacaoMB {
	
	private List<Questao> listaQuestoes = new ArrayList<Questao>();
	private HashMap<String, Integer> questoes; 
	@EJB
	private QuestaoFacade facade;
	
	public AvaliacaoMB() {
		questoes = new HashMap<String, Integer>();
		lista();
	}

	public HashMap<String, Integer> lista(){
		for(Questao q : getListaQuestoes()){
			questoes.put(q.getDescricao(), q.getIdQuestao());
		}
		return questoes;
	}
	
	public List<Questao> getListaQuestoes() {
		if(listaQuestoes.isEmpty()){
			listaQuestoes = facade.listarQuestoes();
		}
		return listaQuestoes;
	}

	public void setListaQuestoes(List<Questao> listaQuestoes) {
		this.listaQuestoes = listaQuestoes;
	}

	public HashMap<String, Integer> getQuestoes() {
		return questoes;
	}
}
