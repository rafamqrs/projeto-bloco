package sae.infnet.edu.br.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import sae.infnet.edu.br.dao.AvaliacaoDAO;
import sae.infnet.edu.modelo.Avaliacao;

@Stateless
public class AvaliacaoFacade {
	@EJB
	private AvaliacaoDAO dao;

	public void cadastrar(Avaliacao avaliacao)throws Exception{
		dao.cadastrar(avaliacao);
	}
	
	public void excluir(Avaliacao avaliacao) throws Exception{
		dao.excluir(avaliacao);
	}
	
	public List<Avaliacao> listarAvaliacoes() throws Exception{
		return null;
	}
}