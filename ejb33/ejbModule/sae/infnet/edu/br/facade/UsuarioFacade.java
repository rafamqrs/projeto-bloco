package sae.infnet.edu.br.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import sae.infnet.edu.br.dao.UsuarioDAO;
import sae.infnet.edu.modelo.Usuario;


@Stateless
@LocalBean
public class UsuarioFacade{

	@EJB 
	private UsuarioDAO userDAO;
	
	public Usuario procurarPorMatricula(String matricula) {
		return userDAO.procurarPorMatricula(matricula);
	}
}