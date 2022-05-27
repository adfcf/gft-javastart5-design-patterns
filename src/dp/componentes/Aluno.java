package dp.componentes;

import java.time.LocalDate;

public class Aluno {

    private final String nome;
    private final String matricula;
    private final LocalDate nascimento;

    // STRATEGY: comportamento que pode variar...
    private Mensalidade regraMensalidade;

    public Aluno(String nome, String matricula, LocalDate nascimento) {
        this.nome = nome;
        this.matricula = matricula;
        this.nascimento = nascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setRegraMensalidade(Mensalidade regra) {
        this.regraMensalidade = regra;
    }

    public void pagarMensalidade() {
        System.out.println("MENSALIDADE DE '" + nome + "'");
        System.out.println("- Valor: R$ " + regraMensalidade.getMensalidade(this));
        System.out.println("- Status: PAGA");
    }

}
