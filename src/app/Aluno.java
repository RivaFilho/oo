package app;

public class Aluno extends PessoaFisica{

	String matricula, 
	       curso;
	
	public Aluno(String nome, String cpf, String email, String matricula, String curso) throws CampoEmBrancoException  {
		super(nome, cpf, email);
		if (matricula == null || matricula.trim().isEmpty()) {
			throw new CampoEmBrancoException("Matrícula");

		}


		this.matricula = matricula;
		this.curso = curso;
	}

	public final String getMatricula() {
		return matricula;
	}

	public final String getCurso() {
		return curso;
	}
	
	
	protected void finalize() throws Throwable {
		System.out.println("Destruindo objeto: " + this);
	}
	
	public String toString() {
		String resposta = super.toString();
		resposta += "MATRICULA: " + matricula + '\n';
		resposta += "CURSO: " + curso + '\n';
		return resposta;
	}

}