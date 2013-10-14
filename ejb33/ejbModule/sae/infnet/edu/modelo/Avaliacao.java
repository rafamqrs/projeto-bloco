package sae.infnet.edu.modelo;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Avaliacao {
	@Id
	@GeneratedValue
	private Integer idAvaliacao;
	private String objetivo;
	private String observacao;
	private boolean ativa;
	private boolean enviada;
	private Calendar dataHoraInicio;
	private Calendar dataHoraTermino;
	@OneToOne
	@JoinColumn(name="idModulo")
	private Modulo curso;
    @ManyToMany
    @JoinTable(name = "avaliacao_questao", joinColumns = @JoinColumn(name = "idAvaliacao"), inverseJoinColumns = @JoinColumn(name = "idQuestao"))
	private List<Questao> questoes;
	
	public Avaliacao() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(Integer idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public boolean isEnviada() {
		return enviada;
	}

	public void setEnviada(boolean enviada) {
		this.enviada = enviada;
	}

	public Calendar getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(Calendar dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public Calendar getDataHoraTermino() {
		return dataHoraTermino;
	}

	public void setDataHoraTermino(Calendar dataHoraTermino) {
		this.dataHoraTermino = dataHoraTermino;
	}

	public Modulo getCurso() {
		return curso;
	}

	public void setCurso(Modulo curso) {
		this.curso = curso;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}
}
