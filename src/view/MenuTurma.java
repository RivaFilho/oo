package view;

import javax.swing.JOptionPane;

<<<<<<< HEAD
import app.Aluno;
import app.Disciplina;
import app.Professor;
import app.Turmas;
import cadastros.CadastroAluno;
import cadastros.CadastroDisciplina;
import cadastros.CadastroProfessor;
import cadastros.CadastroTurmas;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MenuTurma {





    static Professor p;
    static List<Aluno> alunos = new ArrayList<>();

    public static Turmas dadosNovaTurma(CadastroProfessor cadProfessor, CadastroDisciplina cadDisciplina,CadastroAluno cadAluno) {
        String nome = lerNome();
        String codTurma = lerCodigoTurma();
        String matriculaProfessor = lerMatriculaProfessor();
        alunos = lerMatriculaAluno(cadAluno);
        Professor professor = cadProfessor.pesquisarProfessor(matriculaProfessor);
        Disciplina disciplina = cadDisciplina.pesquisarDisciplina(lerDisciplina());
        if (professor == null) {
            JOptionPane.showMessageDialog(null, "Professor não encontrado.");
            return null;
        }if (disciplina == null) {
            JOptionPane.showMessageDialog(null, "Disciplina não encontrada.");
            return null;
        }
        return new Turmas(nome, codTurma, professor,disciplina,alunos);
    }

    private static String lerCodigo() {
        return JOptionPane.showInputDialog("Informe o código da Turma: ");
=======
import app.Professor;
import app.Turma;
import cadastros.CadastroTurma;
import cadastros.CadastroProfessor;

public class MenuTurma {

    public static Turma dadosNovaTurma(CadastroProfessor cadProfessor) {
        String nome = lerNome();
        String codTurma = lerCodigoTurma();
        String matriculaProfessor = lerMatriculaProfessor();
        Professor professor = cadProfessor.pesquisarProfessor(matriculaProfessor);
        if (professor == null) {
            JOptionPane.showMessageDialog(null, "Professor não encontrado.");
            return null;
        }
        return new Turma(nome, codTurma, professor);
>>>>>>> 63cf5b4f6e6f6b05872c12e8bbecbfbc672b76f1
    }


    private static String lerNome() {
        return JOptionPane.showInputDialog("Informe o nome da turma: ");
    }

    private static String lerCodigoTurma() {
        return JOptionPane.showInputDialog("Informe o código da turma: ");
<<<<<<< HEAD
    }

    private static String lerMatriculaProfessor() {
        return JOptionPane.showInputDialog("Informe a matrícula FUB do professor: ");
    } private static String lerDisciplina() {
        return JOptionPane.showInputDialog("Informe o código da disciplina que o professor ministra: ");
    }



    private static List<Aluno> lerMatriculaAluno(CadastroAluno cadAluno) {
        int op = -1;
        List<Aluno> alunos1 = new ArrayList<>();
        do{
            String txt = "Informe a opção desejada \n"
                    + "1 - Cadastrar Aluno na turma\n"
                    + "2 - Remover aluno da turma\n"
                    + "0 - Voltar para menu anterior";
            String stropc = JOptionPane.showInputDialog(txt);
            op = Integer.parseInt(stropc);
            switch(op)  {

                case 1:
                    String matricula = JOptionPane.showInputDialog("Informe a matrícula do aluno: ");
                    Aluno aluno = cadAluno.pesquisarAluno(matricula);
                    if (aluno == null) {
                        JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
                    } else {
                        alunos1.add(aluno);
                    }


                    break;
                case 2:
                    matricula = JOptionPane.showInputDialog("Informe a matrícula do aluno: ");
                    alunos1.removeIf(aluno1 -> aluno1.getMatricula().equalsIgnoreCase(matricula));

                default:
                    break;


            }

        }
        while(op != 0);
        return alunos1;
    }


    public static void menuTurma(CadastroTurmas cadTurma, CadastroProfessor cadProfessor, CadastroDisciplina cadDisciplina, CadastroAluno cadAluno) {
        if (cadTurma == null) {
            JOptionPane.showMessageDialog(null, "Erro: CadastroTurma não foi inicializado.");
            return;
        }
=======
    }

    private static String lerMatriculaProfessor() {
        return JOptionPane.showInputDialog("Informe a matrícula FUB do professor: ");
    }
>>>>>>> 63cf5b4f6e6f6b05872c12e8bbecbfbc672b76f1

    public static void menuTurma(CadastroTurma cadTurma, CadastroProfessor cadProfessor) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar turma\n"
                + "2 - Pesquisar turma\n"
                + "3 - Atualizar turma\n"
                + "4 - Remover turma\n"
                + "5 - Listar turmas\n"
                + "0 - Voltar para menu anterior";

        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
<<<<<<< HEAD
                    Turmas novaTurma = dadosNovaTurma(cadProfessor,cadDisciplina,cadAluno);
                   cadTurma.cadastrarTurma(novaTurma);
=======
                    Turma novaTurma = dadosNovaTurma(cadProfessor);
                    if (novaTurma != null) {
                        cadTurma.cadastrarTurma(novaTurma);
                    }
>>>>>>> 63cf5b4f6e6f6b05872c12e8bbecbfbc672b76f1
                    break;

                case 2:
                    String codigoTurma = lerCodigoTurma();
                    Turma t = cadTurma.pesquisarTurma(codigoTurma);
                    if (t != null) {
                        JOptionPane.showMessageDialog(null, t.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Turma não encontrada.");
                    }
                    break;

                case 3:
<<<<<<< HEAD
                    codigo = lerCodigo();
                    if (codigo != null && !codigo.isEmpty()) {
                        Turmas novaCadastro = dadosNovaTurma(cadProfessor,cadDisciplina,cadAluno);
                        boolean atualizado = cadTurma.atualizarTurma(codigo, novaCadastro);
=======
                    codigoTurma = lerCodigoTurma();
                    Turma novaCadastro = dadosNovaTurma(cadProfessor);
                    if (novaCadastro != null) {
                        boolean atualizado = cadTurma.atualizarTurma(codigoTurma, novaCadastro);
>>>>>>> 63cf5b4f6e6f6b05872c12e8bbecbfbc672b76f1
                        if (atualizado) {
                            JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar cadastro.");
                        }
                    }
                    break;

                case 4:
                    codigoTurma = lerCodigoTurma();
                    Turma remover = cadTurma.pesquisarTurma(codigoTurma);
                    if (remover != null) {
                        boolean removido = cadTurma.removerTurma(remover);
                        if (removido) {
                            JOptionPane.showMessageDialog(null, "Turma removida do cadastro");
                        } else {
                            JOptionPane.showMessageDialog(null, "Falha ao remover turma.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Turma não encontrada.");
                    }
                    break;
<<<<<<< HEAD
                case 5:
                    cadTurma.listarTurmas();



=======
>>>>>>> 63cf5b4f6e6f6b05872c12e8bbecbfbc672b76f1

                case 5:
                    cadTurma.listarTurmas();
                    break;

                default:
                    break;
            }
        } while (opcao != 0);
    }
}
