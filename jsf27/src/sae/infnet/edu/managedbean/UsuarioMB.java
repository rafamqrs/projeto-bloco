/*package sae.infnet.edu.managedbean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import sae.infnet.edu.br.facade.UsuarioFacade;
import sae.infnet.edu.modelo.Usuario;



@SessionScoped
@ManagedBean
public class UsuarioMB {
	private Usuario usuario;
	@EJB
	private UsuarioFacade usuarioFacade;

	public Usuario getUsuario() {
		if(usuario == null){
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
			String userEmail = context.getUserPrincipal().getName();
			
		//	usuario = usuarioFacade.procurarPorEmail(userEmail);
		}
		
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String logout(){
		getRequest().getSession().invalidate();
		return "/index.xhtml";
	}

	private HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	public boolean isAdmin() {
		return getRequest().isUserInRole("ADMIN");
	}
}
*/