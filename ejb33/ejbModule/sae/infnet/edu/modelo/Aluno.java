package sae.infnet.edu.modelo;

public class Aluno extends Usuario{

	private String email;
	private Turma turma;
	
	public Aluno() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
