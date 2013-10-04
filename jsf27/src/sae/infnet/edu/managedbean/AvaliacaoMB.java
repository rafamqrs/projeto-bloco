package sae.infnet.edu.managedbean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DualListModel;

import sae.infnet.edu.br.facade.QuestaoFacade;
import sae.infnet.edu.modelo.Questao;

@ManagedBean
@ViewScoped
public class AvaliacaoMB {
	private String objetivo;
	private Date dataInicio;
	private Date dataTermino;
	private List<Questao> listaQuestoes;
	private List<Questao> listasQuestoesSeleconadas;
	@EJB
	private QuestaoFacade facade;
	private boolean ativo;
	private DualListModel<Questao> questoes;  

	public AvaliacaoMB() {
		listaQuestoes = new ArrayList<Questao>();
		listasQuestoesSeleconadas = new ArrayList<Questao>();
		listaQuestoes = facade.listarQuestoes();
		questoes = new DualListModel<Questao>( listaQuestoes, listasQuestoesSeleconadas);

	}

	public List<Questao> getListaQuestoes() {
		return listaQuestoes;
	}

	public void setListaQuestoes(List<Questao> listaQuestoes) {
		this.listaQuestoes = listaQuestoes;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public DualListModel<Questao> getPlayers() {
		return questoes;
	}

	public void setPlayers(DualListModel<Questao> players) {
		this.questoes = players;
	}

	public List<Questao> getListas() {
		return listasQuestoesSeleconadas;
	}

	public void setListas(List<Questao> listas) {
		this.listasQuestoesSeleconadas = listas;
	}
}
