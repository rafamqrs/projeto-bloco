package sae.infnet.edu.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Questao {
	@Id
	@GeneratedValue
	@Column(name="idQuestao")
	private Integer idQuestao;
	private String descricao;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idModulo", nullable=false)
	private Modulo curso;
	private boolean ativo;
	
	public Questao() {
		// TODO Auto-generated constructor stub
	}
	
	public Questao(Integer idQuestao, String descricao, Modulo curso,
			boolean ativo) {
		super();
		this.idQuestao = idQuestao;
		this.descricao = descricao;
		this.curso = curso;
		this.ativo = ativo;
	}




	public Integer getIdQuestao() {
		return idQuestao;
	}
	public void setIdQuestao(Integer idQuestao) {
		this.idQuestao = idQuestao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Modulo getCurso() {
		return curso;
	}
	public void setCurso(Modulo curso) {
		this.curso = curso;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}
