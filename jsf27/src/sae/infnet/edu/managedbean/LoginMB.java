package sae.infnet.edu.managedbean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import sae.infnet.edu.br.facade.UsuarioFacade;
import sae.infnet.edu.managedbean.AbstractMB;
import sae.infnet.edu.modelo.Usuario;

@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginMB extends AbstractMB {

	private String username;
	private String password;
	private boolean isAdmin;
	@EJB
	private UsuarioFacade userFacade;
	private Usuario usuario;

	HttpServletRequest request = (HttpServletRequest) getExternalContext().getRequest();
	
	public LoginMB() {
 	}
	@SuppressWarnings("unused")
	public String login() {
		String message = "";
		String navigation = "";

		try {
			request.login(username, password);
			if (request.isUserInRole("ADMIN")) {
				usuario = userFacade.procurarPorMatricula(request
						.getUserPrincipal().getName());
				putSessionAttribute("usuario", usuario);
				message = request.getUserPrincipal().getName()
						+ " Bem vindo Administrador";
				displayInfoMessageToUser(message);
				return navigation = "permitido";
			} else if (request.isUserInRole("USER")) {
				usuario = userFacade.procurarPorMatricula(request
						.getUserPrincipal().getName());
				putSessionAttribute("usuario", usuario);
				message = "Usuário : " + request.getUserPrincipal().getName()
						+ " Bem vindo Aluno";
				return navigation = "permitido";
			}
			return null;

		} catch (ServletException e) {
			System.out.println(e.getMessage());
			logout();
			return "failure";
		}
	}

	public String logout() {
		try {
			getRequest().getSession().invalidate();
			request.logout();
		} catch (ServletException e) {
			e.printStackTrace();
		}
		return "logout";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		if(request.isUserInRole("ADMIN")){
			return true;
		}
		return false;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
