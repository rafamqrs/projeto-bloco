package sae.infnet.edu.br.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import sae.infnet.edu.modelo.Usuario;


@Stateless
@LocalBean
public class UsuarioDAO {
	@PersistenceContext
	private EntityManager em;
	
	public Usuario procurarPorMatricula(String matricula) {
		  TypedQuery<Usuario> query = em.createQuery(
			      "SELECT u FROM Usuario u WHERE u.matricula = :matricula", Usuario.class);
		return query.setParameter("matricula", matricula).getSingleResult();
	}

}
