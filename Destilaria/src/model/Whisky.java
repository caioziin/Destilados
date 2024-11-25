package model;

import enums.TipoWhisky;

public class Whisky extends Bebida {
    private int idade;
    private TipoWhisky tipo;
    private double teorAlcoolico;

    public Whisky(String nome, double preco, int idade, TipoWhisky tipo, double teorAlcoolico, int quantidade) {
        super(nome, preco, quantidade);
        this.idade = idade;
        this.tipo = tipo;
        this.teorAlcoolico = teorAlcoolico;
    }

    @Override
    public double calcularTotal() {
        return getPreco() * getQuantidade();
    }

    public int getIdade() {
        return idade;
    }

    public TipoWhisky getTipo() {
        return tipo;
    }

    public double getTeorAlcoolico() {
        return teorAlcoolico;
    }
}
