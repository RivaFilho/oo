package view;

import javax.swing.JOptionPane;

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
    }

    private static String lerNome() {
        return JOptionPane.showInputDialog("Informe o nome da turma: ");
    }

    private static String lerCodigoTurma() {
        return JOptionPane.showInputDialog("Informe o código da turma: ");
    }

    private static String lerMatriculaProfessor() {
        return JOptionPane.showInputDialog("Informe a matrícula FUB do professor: ");
    }

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
                    Turma novaTurma = dadosNovaTurma(cadProfessor);
                    if (novaTurma != null) {
                        cadTurma.cadastrarTurma(novaTurma);
                    }
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
                    codigoTurma = lerCodigoTurma();
                    Turma novaCadastro = dadosNovaTurma(cadProfessor);
                    if (novaCadastro != null) {
                        boolean atualizado = cadTurma.atualizarTurma(codigoTurma, novaCadastro);
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

                case 5:
                    cadTurma.listarTurmas();
                    break;

                default:
                    break;
            }
        } while (opcao != 0);
    }
}
