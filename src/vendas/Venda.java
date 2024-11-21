package vendas;

import model.Whisky; // Corrige o caminho para a classe Whisky
import pessoas.Cliente; // Corrige o caminho para a classe Cliente

public class Venda {

    private Cliente cliente;
    private Whisky whisky;
    private int quantidade;

    // Construtor
    public Venda(Cliente cliente, Whisky whisky, int quantidade) {
        this.cliente = cliente;
        this.whisky = whisky;
        this.quantidade = quantidade;
    }

    // Metodo para cacular a venda
    public double calcularTotal() {
        return whisky.getPreco() * quantidade;
    }

    // Getters e Setters (opcional)
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Whisky getWhisky() {
        return whisky;
    }

    public void setWhisky(Whisky whisky) {
        this.whisky = whisky;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
