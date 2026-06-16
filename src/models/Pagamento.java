package models;

import java.time.LocalDate;

public class Pagamento {
    private double valor;
    private LocalDate dataPagamento;

    public Pagamento(double valor) {
        this.valor = valor;
        this.dataPagamento = LocalDate.now();
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    @Override
    public String toString() {
        return "Pagamento de R$ " + valor + " realizado em " + dataPagamento;
    }
}