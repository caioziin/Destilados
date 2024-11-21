package pessoas;

import java.util.ArrayList;
import java.util.List;
import vendas.Venda;

public class Gerente extends Funcionario {
    private String setor;
    private List<Venda> vendasRealizadas; // Lista de vendas gerenciadas

    public Gerente(String nome, String cpf, int salario, String setor) {
        super(nome, cpf, salario);
        this.setor = setor;
        this.vendasRealizadas = new ArrayList<>(); // Inicializa a lista de vendas
    }

    public void registrarVenda(Venda venda) {
        this.vendasRealizadas.add(venda);
    }

    public double calcularTotalVendas() {
        double total = 0.0;
        for (Venda venda : vendasRealizadas) {
            total += venda.calcularTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        return String.format("Gerente: %s | Setor: %s | Total de Vendas: R$%.2f",
                getNome(), setor, calcularTotalVendas());
    }

    // Getters e Setters
    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public List<Venda> getVendasRealizadas() {
        return vendasRealizadas;
    }
}
