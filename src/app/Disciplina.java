package app;

public class Disciplina {
    private String codigo;
    private String nome;
    private String professor;
    Professor professore;

    public Disciplina(String codigo, String nome, String professor) throws CampoEmBrancoException, ProfessorNaoAtribuidoException, DisciplinaNaoAtribuidaException {
        this.codigo = codigo;
        this.nome = nome;
        this.professor = professor;
        if (nome == null || nome.trim().isEmpty()) {
            throw new CampoEmBrancoException("Nome da disciplina");
        }
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new DisciplinaNaoAtribuidaException();
        }if (professor == null || professor.trim().isEmpty()) {
            throw new ProfessorNaoAtribuidoException();
        }


    }

    public Professor getProfessore() {
        return professore;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getProfessor() {
        return professor;
    }

    @Override
    public String toString() {
        String resposta = "NOME: "+nome+ '\n';
        resposta += "CODIGO: "+codigo+ '\n';
        resposta += "PROFESSOR: "+professore+ '\n';
        return resposta;
    }
}
