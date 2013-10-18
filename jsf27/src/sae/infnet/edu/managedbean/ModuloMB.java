package sae.infnet.edu.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import sae.infnet.edu.br.facade.ModuloFacade;
import sae.infnet.edu.modelo.Modulo;

@ManagedBean
public class ModuloMB extends AbstractMB{
	
	@EJB
	private ModuloFacade moduloFacade;
	private Modulo modulo;
	private List<Modulo> listaModulos = new ArrayList<Modulo>();
		
	public ModuloMB() {
		modulo = new Modulo();
		listaModulos.clear();
	}
	/*
	public String cadastrarQuestao(){
		try {
			if (!validarCampos()) {
				Modulo modulo = questaoDAO.listaModulo(idModulo);
				questao.setCurso(modulo);
				questao.setDescricao(descricao);
				questao.setAtivo(ativo);
				questaoDAO.cadastrar(questao);
				message = "Questão Cadastrada com Sucesso!";
				displayInfoMessageToUser(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return "cadQuestao";
	}*/
	
	public String cadastrarModulo(){
		try {
			moduloFacade.cadastrarModulo(modulo);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return "cadModulo";
	}
	
	public Modulo getModulo() {
		return modulo;
	}
	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}
	public List<Modulo> getListaModulos() {
		if(listaModulos.isEmpty()){
			return moduloFacade.listarModulos();
		}
		return listaModulos;
	}
	public void setListaModulos(List<Modulo> listaModulos) {
		this.listaModulos = listaModulos;
	}
	
}
