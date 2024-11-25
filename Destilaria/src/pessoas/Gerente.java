package pessoas;

import vendas.Venda;
import java.util.ArrayList;
import java.util.List;

public class Gerente extends Pessoa {
    private double salario;
    private String departamento;
    private List<Venda> vendasRealizadas;

    public Gerente(String nome, String cpf, double salario, String departamento) {
        super(nome, cpf);
        this.salario = salario;
        this.departamento = departamento;
        this.vendasRealizadas = new ArrayList<>();
    }

    public void registrarVenda(Venda venda) {
        vendasRealizadas.add(venda);
    }

    public List<Venda> getVendasRealizadas() {
        return vendasRealizadas;
    }

    public double calcularTotalVendas() {
        return vendasRealizadas.stream()
                .mapToDouble(Venda::calcularTotal)
                .sum();
    }
}
