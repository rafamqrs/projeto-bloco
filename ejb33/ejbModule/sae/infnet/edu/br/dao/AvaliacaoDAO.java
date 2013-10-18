package sae.infnet.edu.br.dao;

import java.sql.Connection;
import java.sql.DriverManager;
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
	
	public void cadastrar2(Avaliacao avaliacao) throws Exception{
		Class.forName("org.postgresql.Driver");
		Connection connection = null;
		connection = DriverManager.getConnection(
		   "jdbc:postgresql://localhost:5432/CrudDB","postgres", "postgres");
		String sql = "INSERT INTO (null, t, null, 2013-10-18 10:00:00, f, TESTE, TESTE, 2, 57, null, 2013-10-30 11:00:00)";
		connection.close();
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
