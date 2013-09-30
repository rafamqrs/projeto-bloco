package sae.infnet.edu.br.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import sae.infnet.edu.modelo.Dog;
import sae.infnet.edu.modelo.Questao;

@Stateless
public class QuestaoDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void cadastrar(Questao questao){
		em.persist(questao);
	}
	
	public List<Questao> listarQuestoes(){
		TypedQuery<Questao> createQuery = em.createQuery("SELECT q FROM Questao q", Questao.class);
		List<Questao> results = createQuery.getResultList();
		return results;
	}
	
	public void alterar(Questao questao){
		em.merge(questao);
	}

	public void excluir(Questao questaoSelecionada) {
		Questao reference = em.getReference(Questao.class, questaoSelecionada.getIdQuestao());
		em.remove(reference);
	}
}
