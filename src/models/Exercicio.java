package models;

public class Exercicio {
    private String nome;
    private String seriesRepeticoes;

    public Exercicio(String nome, String seriesRepeticoes) {
        this.nome = nome;
        this.seriesRepeticoes = seriesRepeticoes;
    }

    @Override
    public String toString() {
        return nome + " - " + seriesRepeticoes;
    }
}