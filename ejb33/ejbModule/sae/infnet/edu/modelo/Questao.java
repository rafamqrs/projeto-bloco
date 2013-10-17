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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((idQuestao == null) ? 0 : idQuestao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Questao other = (Questao) obj;
		if (ativo != other.ativo)
			return false;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idQuestao == null) {
			if (other.idQuestao != null)
				return false;
		} else if (!idQuestao.equals(other.idQuestao))
			return false;
		return true;
	}
}
