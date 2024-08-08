package cadastros;

import app.Turma;
import java.util.ArrayList;
import java.util.List;

public class CadastroTurma {
    private List<Turma> turmas;

    public CadastroTurma() {
        turmas = new ArrayList<>();
    }

    public boolean cadastrarTurma(Turma turma) {
        return turmas.add(turma);
    }

    public Turma pesquisarTurma(String codigo) {
        for (Turma turma : turmas) {
            if (turma.getCodigo().equalsIgnoreCase(codigo)) {
                return turma;
            }
        }
        return null;
    }

    public boolean removerTurma(Turma turma) {
        return turmas.remove(turma);
    }

    public boolean atualizarTurma(String codigo, Turma novaTurma) {
        for (int i = 0; i < turmas.size(); i++) {
            Turma turma = turmas.get(i);
            if (turma.getCodigo().equalsIgnoreCase(codigo)) {
                turmas.set(i, novaTurma);
                return true;
            }
        }
        return false;
    }
}