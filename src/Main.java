import pessoas.Gerente;
import pessoas.Cliente;
import model.Whisky;
import vendas.Venda;
import enums.TipoWhisky;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        Gerente gerente = new Gerente("Caio Sousa", "123.456.789-00", 5000, "Bebidas");

        System.out.println("=== Sistema de Gerenciamento de Vendas ===");

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
                    // Registra uma nova venda
                    System.out.println("\n== Registrar Venda ==");

                    System.out.print("Nome do cliente: ");
                    String nomeCliente = scanner.nextLine();

                    Cliente cliente = new Cliente(nomeCliente);

                    System.out.print("Nome do whisky: ");
                    String nomeWhisky = scanner.nextLine();

                    System.out.print("Preço do whisky: ");
                    double precoWhisky = scanner.nextDouble();

                    System.out.print("Idade do whisky (em anos): ");
                    int idadeWhisky = scanner.nextInt();

                    System.out.print("Teor alcoólico do whisky (em %): ");
                    double teorAlcoolico = scanner.nextDouble();

                    System.out.println("Tipo do whisky (1 - Blended, 2 - Single Malt): ");
                    int tipoWhiskyOption = scanner.nextInt();
                    TipoWhisky tipoWhisky = (tipoWhiskyOption == 1) ? TipoWhisky.BLENDED : TipoWhisky.SINGLE_MALT;

                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();

                    Whisky whisky = new Whisky(nomeWhisky, precoWhisky, idadeWhisky, tipoWhisky, teorAlcoolico);
                    Venda venda = new Venda(cliente, whisky, quantidade);

                    gerente.registrarVenda(venda);

                    System.out.println("Venda registrada com sucesso!");
                    break;

                case 2:

                    System.out.printf("\nTotal de vendas gerenciadas por %s: R$%.2f\n",
                            gerente.getNome(), gerente.calcularTotalVendas());
                    break;

                case 3:

                    System.out.println("\n== Detalhes das Vendas ==");
                    if (gerente.getVendasRealizadas().isEmpty()) {
                        System.out.println("Nenhuma venda registrada.");
                    } else {
                        for (Venda v : gerente.getVendasRealizadas()) {
                            System.out.printf("Cliente: %s | Whisky: %s | Quantidade: %d | Total: R$%.2f\n",
                                    v.getCliente().getNome(), v.getWhisky().getNome(),
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
