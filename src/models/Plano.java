package models;

import enums.TipoPlano;

public class Plano {
    private TipoPlano tipo;
    private double valor;
    private int duracaoMeses;
    private String beneficios;

    public Plano(TipoPlano tipo, double valor, int duracaoMeses, String beneficios) {
        this.tipo = tipo;
        this.valor = valor;
        this.duracaoMeses = duracaoMeses;
        this.beneficios = beneficios;
    }

    public TipoPlano getTipo(){
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public int getDuracaoMeses() {
        return duracaoMeses;
    }

    public String getBeneficios() {
        return beneficios;
    }
    
    @Override
    public String toString() {
        return tipo + " | R$ " + valor + " | " + duracaoMeses + " mês(es) | " + beneficios;
    }
}