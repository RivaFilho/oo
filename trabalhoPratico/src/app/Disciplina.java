package app;

public class Disciplina {
    private String codigo;
    private String nome;
    private String professor;

    public Disciplina(String codigo, String nome, String professor) {
        this.codigo = codigo;
        this.nome = nome;
        this.professor = professor;
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
        return "Disciplina{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", professor='" + professor + '\'' +
                '}';
    }
}
