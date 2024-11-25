package model;

public abstract class Bebida {
    protected String nome;
    protected double preco;
    protected int quantidade;

    public Bebida(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    //Calcular o total de cada bebida
    public abstract double calcularTotal();
}
