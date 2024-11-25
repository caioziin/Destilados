package vendas;

import model.Bebida;
import pessoas.Cliente;

public class Venda {

    private Cliente cliente;
    private Bebida bebida;
    private int quantidade;

    public Venda(Cliente cliente, Bebida bebida, int quantidade) {
        this.cliente = cliente;
        this.bebida = bebida;
        this.quantidade = quantidade;
    }

    public double calcularTotal() {
        return bebida.calcularTotal();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
