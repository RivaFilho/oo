package view;


import app.Aluno;
import app.Professor;
import app.Turmas;
import cadastros.CadastroAluno;
import cadastros.CadastroDisciplina;
import cadastros.CadastroTurmas;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MenuTurma {
    

    static CadastroDisciplina cadDisciplina;


    static Professor p;
    static List<Aluno> alunos = new ArrayList<>();

    public static Turmas dadosNovaTurma() {
        String codigo = lerCodigo();
        String nome = lerNome();
        String professor = lerProfessor();

        return new Turmas(nome, codigo, professor, lerMatriculaAluno());
    }

    private static String lerCodigo() {
        return JOptionPane.showInputDialog("Informe o código da Turma: ");
    }

    private static String lerNome() {
        return JOptionPane.showInputDialog("Informe o nome da turma: ");
    }

    private static String lerProfessor() {
        return JOptionPane.showInputDialog("Informe o professor da turma: ");
    }
    private static String lerMatricula(){return JOptionPane.showInputDialog("Informe a matricula do aluno:  ");}

    private static List<Aluno> lerMatriculaAluno() {
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
                        lerMatricula();
                    for (Aluno aluno : alunos) {
                        if(aluno.getMatricula().equalsIgnoreCase(lerMatricula())){alunos1.add(aluno);}

                    }

                    break;
                case 2:
                    String str = lerMatricula();
                    for (Aluno aluno : alunos) {
                        if(aluno.getMatricula().equalsIgnoreCase(str)){alunos1.remove(aluno);}
                    }

                default:
                    break;


            }

        }
        while(op != 0);
        return alunos1;
    }

    public static void menuTurma(CadastroTurmas cadTurma) {
        if (cadTurma == null) {
            JOptionPane.showMessageDialog(null, "Erro: CadastroTurma não foi inicializado.");
            return;
        }

        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar Turma\n"
                + "2 - Pesquisar Turma\n"
                + "3 - Atualizar Turma\n"
                + "4 - Remover Turma\n"
                + "5 - Imprimir Lista de presença\n"
                + "0 - Voltar para menu anterior";

        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    Turmas novaTurma = dadosNovaTurma();
                   cadTurma.cadastrarTurmas(novaTurma);
                    break;

                case 2:
                    String codigo = lerCodigo();
                    if (codigo != null && !codigo.isEmpty()) {
                        Turmas t = cadTurma.pesquisarTurma(codigo);
                        if (t != null) {
                            JOptionPane.showMessageDialog(null, t.toString());
                        } else {
                            JOptionPane.showMessageDialog(null, "Turma não encontrada.");
                        }
                    }
                    break;

                case 3:
                    codigo = lerCodigo();
                    if (codigo != null && !codigo.isEmpty()) {
                        Turmas novaCadastro = dadosNovaTurma();
                        boolean atualizado = cadTurma.atualizarTurma(codigo, novaCadastro);
                        if (atualizado) {
                            JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar cadastro.");
                        }
                    }
                    break;

                case 4:
                    codigo = lerCodigo();
                    if (codigo != null && !codigo.isEmpty()) {
                        Turmas remover = cadTurma.pesquisarTurma(codigo);
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
                    }
                    break;
                case 5:
                    cadTurma.imprimirListaPresenca();

                    break;
                default:
                    break;
            }
        } while (opcao != 0);
    }

}
