package sae.infnet.edu.br.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import sae.infnet.edu.br.dao.DogDAO;
import sae.infnet.edu.modelo.Dog;


@Stateless
@LocalBean
public class DogFacade {
	@EJB
	private DogDAO dogDAO;
	
	public List<Dog> listAll() {
		return dogDAO.listAll();
	}

	public void cadastrar(Dog dog) {
		dogDAO.cadastrar(dog);
	}

	public void alterar(Dog dog) {
		dogDAO.alterar(dog);
	}

	public void remover(Dog dog) {
		dogDAO.remover(dog);
	}
}
