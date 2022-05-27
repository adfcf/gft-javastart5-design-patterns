package dp.componentes;

// SINGLETON: só pode haver uma única instância de dada classe

import java.util.HashMap;
import java.util.Map;

public class TiposMensalidade {

    public static final double MENSALIDADE_BASE = 540;

    private static TiposMensalidade instancia;

    private final Map<String, Mensalidade> tipos = new HashMap<>();

    private TiposMensalidade() {}

    public static TiposMensalidade getInstancia() {
        if (instancia == null)
            instancia = new TiposMensalidade();
        return instancia;
    }

    public void adicionarTipoMensalidade(String nome, Mensalidade mensalidade) {
        tipos.put(nome, mensalidade);
    }

    public Mensalidade obterTipoMensalidade(String nome) {
        return tipos.get(nome);
    }

}
