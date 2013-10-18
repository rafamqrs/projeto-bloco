package sae.infnet.edu.br.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import sae.infnet.edu.br.dao.ModuloDAO;
import sae.infnet.edu.modelo.Modulo;
import sae.infnet.edu.modelo.Questao;

@Stateless
public class ModuloFacade {
	
	@EJB
	private ModuloDAO moduloDAO;
	
	public void cadastrarModulo(Modulo modulo){
		moduloDAO.cadastar(modulo);
	}
	
	public List<Modulo> listarModulos(){
		return moduloDAO.listarModulos();
	}
	
}
