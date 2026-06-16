package models;

import java.util.ArrayList;
import java.util.List;

public class Treino {
    private String nome;
    private List<Exercicio> exercicios;

    public Treino(String nome) {
        this.nome = nome;
        this.exercicios = new ArrayList<>();
    }

    public void adicionarExercicio(Exercicio exercicio) {
        exercicios.add(exercicio);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nome).append("\n");

        for (Exercicio exercicio : exercicios) {
            sb.append("- ").append(exercicio).append("\n");
        }

        return sb.toString();
    }
}