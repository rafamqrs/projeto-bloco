package sae.infnet.edu.br.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import sae.infnet.edu.br.dao.ModuloDAO;
import sae.infnet.edu.br.dao.QuestaoDAO;
import sae.infnet.edu.modelo.Questao;
import sae.infnet.edu.modelo.Modulo;

@Stateless
public class QuestaoFacade {

	@EJB
	private QuestaoDAO questaoDAO;
	@EJB
	private ModuloDAO moduloDAO;
	
	public void cadastrar(Questao questao){
		questaoDAO.cadastrar(questao);
	}
	
	public List<Modulo> listarModulos(){
		return moduloDAO.listarModulos();
	}
	
	public Modulo listaModulo(int idModulo){
		return moduloDAO.listarModuloPorId(idModulo);
	}
	
	public List<Questao> listarQuestoes(){
		return questaoDAO.listarQuestoes();
	}
	
}
