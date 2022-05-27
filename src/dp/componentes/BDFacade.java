package dp.componentes;

import java.util.ArrayList;
import java.util.List;

public class BDFacade {

    private static List<Aluno> bd = new ArrayList<>();

    public static void registrarAluno(Aluno aluno) {
        bd.add(aluno);
    }

    public static Aluno recuperarAluno(String matricula) {
        var aluno = bd.stream().filter(a -> a.getMatricula().equals(matricula)).findAny();
        if (aluno.isEmpty()) {
            System.out.println("Aluno nao encontrado.");
            return null;
        }
        return aluno.get();
    }

}
