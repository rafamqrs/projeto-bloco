package sae.infnet.edu.br.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import sae.infnet.edu.modelo.Modulo;

@Stateless
public class ModuloDAO {
	@PersistenceContext
	private EntityManager em;

	public List<Modulo> listarModulos(){
		TypedQuery<Modulo> createQuery = em.createQuery("select m from Modulo m", Modulo.class);
		return createQuery.getResultList();
	}
	
	public Modulo listarModuloPorId(int idModulo){
		Modulo modulo = em.find(Modulo.class, idModulo);
		return modulo;
	}
}
