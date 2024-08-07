package cadastros;

import app.Aluno;
import app.Disciplina;
import app.Professor;
import app.Turmas;

import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class CadastroTurmas {

    private List<Turmas> turmas;

    private Disciplina disciplina;
    private CadastroDisciplina dd;
    private Professor p;
    private List<Aluno> alunos;


    public CadastroTurmas() {

        turmas = new ArrayList<>();
    }

    public void imprimirListaPresenca(){
        for (Turmas turma : turmas) {
            JOptionPane.showMessageDialog(null,"Nome da disciplina:" + disciplina.getNome() + "\nProfessor: " + p.getNome() + "Código da turma: " + turma.getCodTurma() );
        }

        for (Aluno aluno : alunos) {
            JOptionPane.showMessageDialog(null,"Matrícula: " +aluno.getMatricula() + "\nNome: " + aluno.getNome());
        }


    }
    public boolean cadastrarTurmas(Turmas t) {



        //implementar tratamento de erro pra verificar se é nulo a disciplina ou as turmas
//        Turmas x = new Turmas(t.getNome(), t.getCodTurma(), p.getNome(), alunos);
        return turmas.add(t);


    }

    public Turmas pesquisarTurma(String codigo){
        for(Turmas t: turmas){
            if(t.getCodTurma().equalsIgnoreCase(codigo)){
                return t;
            }
        }
        return null;
    }

    public boolean removerTurma(Turmas t){
        return turmas.remove(t);
    }
    public boolean atualizarTurma(String codigo, Turmas novaTurma){
        Turmas turma = pesquisarTurma(codigo);
        if(turma != null){
            turmas.remove(turma);
            return turmas.add(novaTurma);
        }
        return false;
    }



}





