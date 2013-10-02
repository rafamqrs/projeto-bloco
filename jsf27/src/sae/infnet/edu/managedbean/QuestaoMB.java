package sae.infnet.edu.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import sae.infnet.edu.br.facade.QuestaoFacade;
import sae.infnet.edu.modelo.Modulo;
import sae.infnet.edu.modelo.Questao;

@ManagedBean
public class QuestaoMB extends AbstractMB{

	private String descricao;
	private boolean ativo;
	private List<SelectItem> listaModulos = new ArrayList<SelectItem>();
	private List<Questao> listaQuestoes = new ArrayList<Questao>();
	private int idModulo;
	private Questao questao;
	@EJB
	private QuestaoFacade questaoDAO;
	private String message;
	private Questao questaoSelecionada;
	
	public QuestaoMB() {
		questao = new Questao();
		listaQuestoes.clear();
		listaModulos.clear();
		questaoSelecionada = new Questao();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public List<SelectItem> getListaModulos() {
		if (listaModulos.isEmpty()) {
			List<Modulo> modulos = questaoDAO.listarModulos();
			for (Modulo modulo : modulos) {
				listaModulos.add(new SelectItem(String.valueOf(modulo
						.getIdModulo()), String.valueOf(modulo.getNome())));
			}
		}
		return listaModulos;
	}

	public void setListaModulos(List<SelectItem> listaModulos) {
		this.listaModulos = listaModulos;
	}

	public int getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(int idModulo) {
		this.idModulo = idModulo;
	}
	
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
	}
	
	public void alterar(){
		try {
			System.out.println(questaoSelecionada.getIdQuestao());
			Modulo modulo = questaoDAO.listaModulo(idModulo);
			questaoSelecionada.setCurso(modulo);
			questaoDAO.alterar(questaoSelecionada);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void remover(){
		try {
			questaoDAO.excluir(questaoSelecionada);
		} catch (Exception e) {
			displayErrorMessageToUser("Ocorreu um erro favor entrar em contato com o suporte!");
			e.printStackTrace();
		}
	}
	
	public boolean validarCampos(){
		boolean erro = false;
		if (descricao.trim().isEmpty() || idModulo < -1) {
			erro = true;
			displayErrorMessageToUser("Os campos são obrigatórios!");
		}
		return erro;
	}
	
	public void limparQuestao(){
		if(questaoSelecionada != null){
			questaoSelecionada = new Questao();
		}
	}
	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	public List<Questao> getListaQuestoes() {
		if(listaQuestoes.isEmpty()){
			return questaoDAO.listarQuestoes();
		}
		return listaQuestoes;
	}

	public void setListaQuestoes(List<Questao> listaQuestoes) {
		this.listaQuestoes = listaQuestoes;
	}

	public Questao getQuestaoSelecionada() {
		return questaoSelecionada;
	}

	public void setQuestaoSelecionada(Questao questaoSelecionada) {
		this.questaoSelecionada = questaoSelecionada;
	}
}
