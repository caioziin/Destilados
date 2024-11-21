package model;

public class Ingrediente {

    private String nome;
    private double quantidade;
    private int unidade;

    public Ingrediente(String nome, double quantidade, int unidade){
        this.nome = nome;
        this.quantidade = quantidade;
        this.unidade = unidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public int getUnidade() {
        return unidade;
    }

    public void setUnidade(int unidade) {
        this.unidade = unidade;
    }

    public void usarIngrediente(double quantidade){
        if(quantidade > this.quantidade){
            throw new IllegalArgumentException("Quantidade insuficiente!");
        }
        this.quantidade -= quantidade;
    }

    public void adicionarIgredientes(double quantidade){
        this.quantidade += quantidade;
    }
}
