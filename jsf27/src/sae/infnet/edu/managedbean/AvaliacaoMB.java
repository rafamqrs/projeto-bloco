package sae.infnet.edu.managedbean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import org.primefaces.model.DualListModel;

import sae.infnet.edu.br.facade.AvaliacaoFacade;
import sae.infnet.edu.br.facade.QuestaoFacade;
import sae.infnet.edu.modelo.Avaliacao;
import sae.infnet.edu.modelo.Modulo;
import sae.infnet.edu.modelo.Questao;
import sae.infnet.edu.util.DataHelper;

@ManagedBean
@RequestScoped
public class AvaliacaoMB extends AbstractMB{
	private List<Questao> questoes = new ArrayList<Questao>();
	private List<Questao> selecionadas;
	private String objetivo;
	private Avaliacao avaliacao;
	private boolean situacao;
	private List<SelectItem> listaModulos = new ArrayList<SelectItem>();
	private int idModulo;
	private String observacao;
	private Date dataHoraInicio;
	private Date dataHoraFim;
	@EJB
	private QuestaoFacade questaoFacade;
	@EJB
	private AvaliacaoFacade avaliacaoFacade;
	private DualListModel<Questao> cores;
	
	public AvaliacaoMB() {
		avaliacao = new Avaliacao();
	}

	public void listarQuestoes(){
		questoes = questaoFacade.listarQuestoesAtivas();
		selecionadas = new ArrayList<Questao>();
		cores = new DualListModel<Questao>(questoes, selecionadas);
		listaModulos.clear();
	}
	
	public String cadastrar(){
		try {
			avaliacao.setAtiva(situacao);
			avaliacao.setObjetivo(objetivo);
			avaliacao.setObservacao(observacao);
			avaliacao.setDataHoraInicio(DataHelper.dateToCalendar(dataHoraInicio));
			avaliacao.setDataHoraTermino(DataHelper.dateToCalendar(dataHoraFim));
			Modulo modulo = questaoFacade.listaModulo(idModulo);
			avaliacao.setCurso(modulo);
			avaliacao.setQuestoes(selecionadas);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "cadQuestao";
	}
	
	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

	public List<Questao> getSelecionadas() {
		return selecionadas;
	}

	public void setSelecionadas(List<Questao> selecionadas) {
		this.selecionadas = selecionadas;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public boolean isSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public QuestaoFacade getQuestaoFacade() {
		return questaoFacade;
	}

	public void setQuestaoFacade(QuestaoFacade questaoFacade) {
		this.questaoFacade = questaoFacade;
	}

	public DualListModel<Questao> getCores() {
		if(questoes.isEmpty()){
			listarQuestoes();
		}
		return cores;
	}

	public void setCores(DualListModel<Questao> cores) {
		this.cores = cores;
	}

	public List<SelectItem> getListaModulos() {
		if (listaModulos.isEmpty()) {
			List<Modulo> modulos = questaoFacade.listarModulos();
			for (Modulo modulo : modulos) {
				listaModulos.add(new SelectItem(String.valueOf(modulo
						.getIdModulo()), String.valueOf(modulo.getNome())));
			}
		}
		return listaModulos;
	}

	public void setListaModulos(List<SelectItem> listaModulos) {
		this.listaModulos = listaModulos;
	}

	public int getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(int idModulo) {
		this.idModulo = idModulo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(Date dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public Date getDataHoraFim() {
		return dataHoraFim;
	}

	public void setDataHoraFim(Date dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}
}
