package pessoas;

public class Funcionario extends Pessoa {
    private double salario;

    public Funcionario(String nome, String cpf, double salario) {
        super(nome, cpf);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public void apresentar() {
        System.out.println("Funcionário: " + getNome() + " | CPF: " + getCpf() + " | Salário: R$" + salario);
    }
}
