package sae.infnet.edu.managedbean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import sae.infnet.edu.br.facade.DogFacade;
import sae.infnet.edu.managedbean.AbstractMB;
import sae.infnet.edu.modelo.Dog;



@ManagedBean
public class DogsMB extends AbstractMB{
	private List<Dog> dogs;
	private Dog dog;
	
	@EJB
	private DogFacade dogFacade;
	
	public void resetDog(){
		dog = new Dog();
	}
	
	public void cadastrar(){	
		try {
			dogFacade.cadastrar(dog);
			getDogs().add(dog);
			closeDialog();
			resetDog();
			displayInfoMessageToUser("Created With Sucess");
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("Ops, we could not create. Try again later");
			e.printStackTrace();
		}		
	}
	
	public void alterar(){
		try {
			dogFacade.alterar(dog);
			closeDialog();
			resetDog();
			displayInfoMessageToUser("Updated With Sucess");
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("Ops, we could not create. Try again later");
			e.printStackTrace();
		}		
	}
	
	public void remover(){
		try {
			dogFacade.remover(dog);
			getDogs().remove(dog);
			resetDog();
			closeDialog();
			displayInfoMessageToUser("Removed With Sucess");
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("Ops, we could not create. Try again later");
			e.printStackTrace();
		}		
	}

	public List<Dog> getDogs() {
		if (dogs == null) {
			dogs = dogFacade.listAll();
		}

		return dogs;
	}

	public void setDogs(List<Dog> dogs) {
		this.dogs = dogs;
	}

	public Dog getDog() {
		if(dog == null){
			resetDog();
		}
		
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}
}