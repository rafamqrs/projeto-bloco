package sae.infnet.edu.br.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import sae.infnet.edu.modelo.Dog;


@Singleton
@LocalBean
public class DogDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Dog> listAll() {
		TypedQuery<Dog> createQuery = entityManager.createQuery("select d from Dog d", Dog.class);

		return createQuery.getResultList();
	}

	public void cadastrar(Dog dog) {
		entityManager.persist(dog);
	}

	public void alterar(Dog dog) {
		entityManager.merge(dog);
	}

	public void remover(Dog dog) {
		Dog reference = entityManager.getReference(Dog.class, dog.getId());
		entityManager.remove(reference);
	}

}
