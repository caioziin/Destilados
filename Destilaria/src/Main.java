import java.util.Scanner;
import pessoas.*;
import model.*;
import enums.TipoWhisky;
import vendas.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Pessoa cliente = new Cliente("Pedro Davi", "987.654.321-00", "99999-9999");
        Pessoa funcionario = new Funcionario("Luis Medeiros", "112.233.445-66", 3000.0);
        Pessoa gerente = new Gerente("Caio Sousa", "123.456.789-00", 5000.0, "Bebidas");

        // Mostrando as informações utilizando polimorfismo
        System.out.println("=== Informações dos Funcionários, Cliente e Gerente ===");

        gerente.apresentar();
        cliente.apresentar();
        funcionario.apresentar();
        System.out.println("\n=== Sistema de Gerenciamento de Vendas ===");

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Registrar nova venda");
            System.out.println("2. Exibir total de vendas do gerente");
            System.out.println("3. Listar detalhes das vendas");
            System.out.println("4. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n== Registrar Venda ==");

                    System.out.print("Nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    Cliente clienteVenda = new Cliente(nomeCliente, "123", "99999");

                    System.out.print("Nome da bebida: ");
                    String nomeBebida = scanner.nextLine();

                    System.out.print("Preço da bebida: ");
                    double precoBebida = scanner.nextDouble();

                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();

                    System.out.println("Tipo de bebida (1 - Whisky, 2 - Outra): ");
                    int tipoBebida = scanner.nextInt();

                    Bebida bebida;
                    if (tipoBebida == 1) {
                        System.out.print("Idade do whisky (em anos): ");
                        int idadeWhisky = scanner.nextInt();

                        System.out.print("Teor alcoólico do whisky (em %): ");
                        double teorAlcoolico = scanner.nextDouble();

                        System.out.println("Tipo do whisky (1 - Blended, 2 - Single Malt): ");
                        int tipoWhiskyOption = scanner.nextInt();
                        TipoWhisky tipoWhisky = (tipoWhiskyOption == 1) ? TipoWhisky.BLENDED : TipoWhisky.SINGLE_MALT;

                        bebida = new Whisky(nomeBebida, precoBebida, idadeWhisky, tipoWhisky, teorAlcoolico, quantidade);
                    } else {
                        bebida = new Bebida(nomeBebida, precoBebida, quantidade) {

                            @Override
                            public double calcularTotal() {
                                return getPreco() * getQuantidade();
                            }
                        };
                    }

                    Venda venda = new Venda(clienteVenda, bebida, quantidade);
                    ((Gerente) gerente).registrarVenda(venda);

                    System.out.println("Venda registrada com sucesso!");
                    break;

                case 2:
                    System.out.printf("\nTotal de vendas gerenciadas por %s: R$%.2f\n",
                            ((Gerente) gerente).getNome(), ((Gerente) gerente).calcularTotalVendas());

                    break;

                case 3:
                    System.out.println("\n== Detalhes das Vendas ==");

                    if (((Gerente) gerente).getVendasRealizadas().isEmpty()) {
                        System.out.println("Nenhuma venda registrada.");
                    } else {
                        // Iterar sobre a lista de vendas
                        for (Venda v : ((Gerente) gerente).getVendasRealizadas()) {
                            System.out.printf("Cliente: %s | Bebida: %s | Quantidade: %d | Total: R$%.2f\n",
                                    v.getCliente().getNome(), v.getBebida().getNome(),
                                    v.getQuantidade(), v.calcularTotal());
                        }
                    }
                    break;

                case 4:
                    System.out.println("Encerrando o sistema. Até logo!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
