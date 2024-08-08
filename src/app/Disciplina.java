package app;

public class Disciplina {
    private String codigo;
    private String nome;
    private String professor;
    Professor professore;

    public Disciplina(String codigo, String nome, String professor) {
        this.codigo = codigo;
        this.nome = nome;
        this.professor = professor;
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
        resposta += "PROFESSOR: "+professor+ '\n';
        return resposta;
    }
}
