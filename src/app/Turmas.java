package app;

import javax.swing.*;
import java.util.List;

public class Turmas {

    private String nome;
    private String codTurma;

    private Disciplina disciplina;
    private Professor p;
    private String professor;
    private String mat_aluno;



    private List <Aluno> alunos;

    public Turmas(String nome, String codTurma, String professor,  List <Aluno> alunos) {
        this.nome = nome;
        this.codTurma = codTurma;
        this.professor = professor;
        this.alunos = alunos;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Professor getP() {
        return p;
    }

    public String getProfessor() {
        return professor;
    }

    public Turmas(String nome, String codTurma) {

        this.nome = nome;
        this.codTurma = codTurma;
    }

    public String getNome() {
        return nome;
    }



    public void imprimirListaPresenca(){
        JOptionPane.showMessageDialog(null,"Nome da disciplina:" + disciplina.getNome() + "\nProfessor: " + p.getNome() + "Código da turma: " + codTurma + '\n');
        for (Aluno aluno : alunos) {
           JOptionPane.showMessageDialog(null,"Matrícula: " +aluno.getMatricula() + "\nNome: " + aluno.getNome());
        }


    }

    public String getCodTurma() {
        return codTurma;
    }

    @Override
    public String toString() {
        return "Turmas{" +
                "nome='" + nome + '\'' +
                ", codTurma='" + codTurma + '\'' +
                '}';
    }
}
