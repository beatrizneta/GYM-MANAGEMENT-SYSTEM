package models;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private String cpf;
    private int idade;
    private Plano plano;
    private List<Pagamento> pagamentos;
    private List<Treino> treinos;

    public Aluno(String nome, String cpf, int idade, Plano plano) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.plano = plano;
        this.pagamentos = new ArrayList<>();
        this.treinos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Plano getPlano() {
        return plano;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public List<Treino> getTreinos() {
        return treinos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public void adicionarPagamento(Pagamento pagamento) {
        pagamentos.add(pagamento);
    }

    public void adicionarTreino(Treino treino) {
        treinos.add(treino);
    }

    public boolean estaInadimplente() {
        return pagamentos.isEmpty();
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                " | CPF: " + cpf +
                " | Idade: " + idade +
                " | Plano: " + plano.getTipo();
    }
}