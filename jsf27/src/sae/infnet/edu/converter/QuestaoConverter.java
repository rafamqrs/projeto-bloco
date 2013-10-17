package sae.infnet.edu.converter;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import sae.infnet.edu.br.facade.QuestaoFacade;
import sae.infnet.edu.modelo.Questao;
@FacesConverter(value = "questaoConverter") 
public class QuestaoConverter implements Converter {
	
	public static List<Questao> listaQuestoes;
	@EJB
	private QuestaoFacade facade;
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
		if(submittedValue.trim().equals("")){
			return null;
		}else {
			try {
				int number = Integer.parseInt(submittedValue);
				if(listaQuestoes == null){
					listaQuestoes =facade.listarQuestoesAtivas();
					for (Questao q : listaQuestoes) {
						if(q.getIdQuestao() == number){
							return q;
						}
					}
				}
			} catch (NumberFormatException exception) {
                throw new ConverterException();
            }
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		if(value == null || value.equals("")){
			return "";
		}else {
			return String.valueOf(((Questao) value).getIdQuestao());
		}
	}

}
