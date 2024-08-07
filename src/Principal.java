import javax.swing.JOptionPane;

import cadastros.CadastroAluno;
import cadastros.CadastroDisciplina;
import cadastros.CadastroProfessor;
import cadastros.CadastroTurma;
import view.*;

public class Principal {

    static CadastroAluno cadAluno = new CadastroAluno();
    static CadastroDisciplina cadDisciplina = new CadastroDisciplina();
    static CadastroProfessor cadProfessor = new CadastroProfessor();
    static CadastroTurma cadTurmas = new CadastroTurma();

    public static void main(String[] args) {
        int opcao = 0;

        do {
            opcao = MenuPrincipal.menuOpcoes();
            switch (opcao) {
                case 1:
                    MenuAluno.menuAluno(cadAluno);
                    break;
                case 2:
                   MenuProfessor.menuProfessor(cadProfessor);
                    break;
                case 3:
                    MenuDisciplina.menuDisciplina(cadDisciplina);
                    break;
                case 4:
                    MenuTurma.menuTurma(cadTurmas, cadProfessor);
                    break;


                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
                    opcao = -1;
                    break;
            }
        } while (opcao != 0);
    }
}
