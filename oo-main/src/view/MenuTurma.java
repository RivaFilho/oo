package view;

import javax.swing.JOptionPane;

import app.Aluno;
import app.Professor;
import app.Turma;
import cadastros.CadastroTurma;
import cadastros.CadastroDisciplina;
import cadastros.CadastroProfessor;
import cadastros.CadastroAluno;

public class MenuTurma {

    public static Turma dadosNovaTurma(CadastroDisciplina cadDisciplina, CadastroProfessor cadProfessor) {
        String codigo = JOptionPane.showInputDialog("Informe o código da turma: ");
        String codigoDisciplina = JOptionPane.showInputDialog("Informe o código da disciplina: ");
        String matriculaProfessor = JOptionPane.showInputDialog("Informe a matrícula do professor: ");

        app.Disciplina disciplina = cadDisciplina.pesquisarDisciplina(codigoDisciplina);
        Professor professor = cadProfessor.pesquisarProfessor(matriculaProfessor);

        if (disciplina != null && professor != null) {
            return new Turma(codigo, disciplina, professor);
        } else {
            JOptionPane.showMessageDialog(null, "Disciplina ou Professor não encontrados.");
            return null;
        }
    }

    public static void menuTurma(CadastroTurma cadTurma, CadastroDisciplina cadDisciplina, CadastroProfessor cadProfessor, CadastroAluno cadAluno) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar turma\n"
                + "2 - Pesquisar turma\n"
                + "3 - Atualizar turma\n"
                + "4 - Remover turma\n"
                + "5 - Matricular aluno\n"
                + "6 - Imprimir lista de presença\n"
                + "0 - Voltar para menu anterior";

        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    Turma novaTurma = dadosNovaTurma(cadDisciplina, cadProfessor);
                    if (novaTurma != null) {
                        cadTurma.cadastrarTurma(novaTurma);
                    }
                    break;

                case 2:
                    String codigo = JOptionPane.showInputDialog("Informe o código da turma: ");
                    Turma turma = cadTurma.pesquisarTurma(codigo);
                    if (turma != null) {
                        JOptionPane.showMessageDialog(null, turma.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Turma não encontrada.");
                    }
                    break;

                case 3:
                    codigo = JOptionPane.showInputDialog("Informe o código da turma que você mudar: ");
                    Turma novaTurmaAtualizada = dadosNovaTurma(cadDisciplina, cadProfessor);
                    if (novaTurmaAtualizada != null) {
                        boolean atualizado = cadTurma.atualizarTurma(codigo, novaTurmaAtualizada);
                        if (atualizado) {
                            JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar cadastro.");
                        }
                    }
                    break;

                case 4:
                    codigo = JOptionPane.showInputDialog("Informe o código da turma: ");
                    Turma turmaRemover = cadTurma.pesquisarTurma(codigo);
                    if (turmaRemover != null) {
                        boolean removido = cadTurma.removerTurma(turmaRemover);
                        if (removido) {
                            JOptionPane.showMessageDialog(null, "Turma removida do cadastro");
                        } else {
                            JOptionPane.showMessageDialog(null, "Falha ao remover turma.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Turma não encontrada.");
                    }
                    break;

                case 5:
                    String matriculaAluno = JOptionPane.showInputDialog("Informe a matrícula do aluno: ");
                    String codigoTurma = JOptionPane.showInputDialog("Informe o código da turma: ");
                    app.Aluno aluno = cadAluno.pesquisarAluno(matriculaAluno);
                    Turma turmaMatricular = cadTurma.pesquisarTurma(codigoTurma);
                    if (aluno != null && turmaMatricular != null) {
                        turmaMatricular.adicionarAluno(aluno);
                        JOptionPane.showMessageDialog(null, "Aluno matriculado com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Aluno ou turma não encontrados.");
                    }
                    break;

                case 6:
                    codigoTurma = JOptionPane.showInputDialog("Informe o código da turma: ");
                    Turma turmaImprimir = cadTurma.pesquisarTurma(codigoTurma);
                    if (turmaImprimir != null) {
                        JOptionPane.showMessageDialog(null, turmaImprimir.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Turma não encontrada.");
                    }
                    break;

                default:
                    break;
            }
        } while (opcao != 0);
    }
}
