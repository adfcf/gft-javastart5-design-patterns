import dp.componentes.Aluno;
import dp.componentes.BDFacade;
import dp.componentes.TiposMensalidade;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        Aluno a1 = new Aluno("Carlos", "AT3253", LocalDate.of(2005, 12, 12));
        Aluno a2 = new Aluno("Maria", "AT3254", LocalDate.of(2004, 2, 18));
        Aluno a3 = new Aluno("Alice", "BT3348", LocalDate.of(2010, 4, 2));

        BDFacade.registrarAluno(a1);
        BDFacade.registrarAluno(a2);
        BDFacade.registrarAluno(a3);

        TiposMensalidade.getInstancia().adicionarTipoMensalidade("padrao", a -> TiposMensalidade.MENSALIDADE_BASE);
        TiposMensalidade.getInstancia().adicionarTipoMensalidade("bolsa_integral", a -> 0);
        TiposMensalidade.getInstancia().adicionarTipoMensalidade("bolsa_parcial", a -> 0.5 * TiposMensalidade.MENSALIDADE_BASE);
        TiposMensalidade.getInstancia().adicionarTipoMensalidade("promocional", a -> {

            final int MAIORIDADE = 18;

            final int ano = a.getNascimento().getYear();
            final int idade = LocalDateTime.now().getYear() - ano;

            final double relacaoMaioridade = ((double) idade / MAIORIDADE);

            return relacaoMaioridade * TiposMensalidade.MENSALIDADE_BASE;

        });

        a1.setRegraMensalidade(TiposMensalidade.getInstancia().obterTipoMensalidade("padrao"));
        a2.setRegraMensalidade(TiposMensalidade.getInstancia().obterTipoMensalidade("bolsa_integral"));
        a3.setRegraMensalidade(TiposMensalidade.getInstancia().obterTipoMensalidade("promocional"));

        a1.pagarMensalidade();
        a2.pagarMensalidade();
        a3.pagarMensalidade();

    }
}