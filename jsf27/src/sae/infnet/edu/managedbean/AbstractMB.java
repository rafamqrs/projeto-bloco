package sae.infnet.edu.managedbean;

import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.context.RequestContext;

import sae.infnet.edu.util.JSFMessageUtil;


public class AbstractMB {
	private static final String KEEP_DIALOG_OPENED = "KEEP_DIALOG_OPENED";

	public AbstractMB() {
		super();
	}

	protected void displayErrorMessageToUser(String message) {
		JSFMessageUtil messageUtil = new JSFMessageUtil();
		messageUtil.sendErrorMessageToUser(message);
	}
	
	protected void displayInfoMessageToUser(String message) {
		JSFMessageUtil messageUtil = new JSFMessageUtil();
		messageUtil.sendInfoMessageToUser(message);
	}
	
	protected void closeDialog(){
		getRequestContext().addCallbackParam(KEEP_DIALOG_OPENED, false);
	}
	
	protected void keepDialogOpen(){
		getRequestContext().addCallbackParam(KEEP_DIALOG_OPENED, true);
	}
	
	protected RequestContext getRequestContext(){
		return RequestContext.getCurrentInstance();
	}
	
	public static ExternalContext getExternalContext() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		return facesContext.getExternalContext();
	}
	
	
	public static Object getSessionAttribute(String nomeSessao) {
		Map sessionMap = getExternalContext().getSessionMap();
		return sessionMap.get(nomeSessao);
	}
	
	@SuppressWarnings("unchecked")
	public static void putSessionAttribute(Object nomeAtributo, Object valor) {
		Map sessionMap = getExternalContext().getSessionMap();
		sessionMap.put(nomeAtributo, valor);

	}
	
	@SuppressWarnings("unused")
	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}
}