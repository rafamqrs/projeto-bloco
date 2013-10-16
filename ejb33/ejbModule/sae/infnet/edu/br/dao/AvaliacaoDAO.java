package sae.infnet.edu.br.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import sae.infnet.edu.modelo.Avaliacao;

@Stateless
public class AvaliacaoDAO {
	@PersistenceContext
	private EntityManager em;

	public void cadastrar(Avaliacao avaliacao){
		em.persist(avaliacao);
	}

	public void alterar(Avaliacao avaliacao){
		em.merge(avaliacao);
	}

	public void excluir(Avaliacao avaliacao){
		Avaliacao referencia = em.getReference(Avaliacao.class, avaliacao.getIdAvaliacao());
		em.remove(referencia);
	}

	public List<Avaliacao> listarAvaliacoes(){
		TypedQuery<Avaliacao> createQuery = em.createQuery("SELECT a FROM Avaliacao a", Avaliacao.class);
		List<Avaliacao> avaliacoes = createQuery.getResultList();
		return avaliacoes;
	}
}
