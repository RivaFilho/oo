import javax.swing.JOptionPane;
import cadastros.CadastroAluno;
import cadastros.CadastroDisciplina;
import view.MenuAluno;
import view.MenuDisciplina;
import view.MenuPrincipal;

public class Principal {

    static CadastroAluno cadAluno = new CadastroAluno();
    static CadastroDisciplina cadDisciplina = new CadastroDisciplina();

    public static void main(String[] args) {

        int opcao = 0;

        do {
            opcao = MenuPrincipal.menuOpcoes();
            switch (opcao) {
                case 1:
                    MenuAluno.menuAluno(cadAluno);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Cadastro de professores a ser implementado");
                    break;
                case 3:
                    MenuDisciplina.menuDisciplina(cadDisciplina);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Cadastro de turmas a ser implementado");
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
