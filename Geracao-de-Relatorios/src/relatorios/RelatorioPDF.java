package relatorios;

import entities.interfaces.Relatorio;
import entities.Cliente;
import entities.Pedido;
import java.time.format.DateTimeFormatter;

public class RelatorioPDF implements Relatorio {
    @Override
    public void gerarRelatorio(Cliente cliente) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        double total = calcularTotal(cliente);

        System.out.println("\n=== RELATÓRIO PDF ===");
        System.out.println("Formato: " + getTipo());
        System.out.println("\nDados do Cliente:");
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println("Endereço: " + cliente.getEndereco());

        System.out.println("\nItens do Pedido:");
        System.out.println("--------------------------------------------------");
        System.out.printf("| %-25s | %6s | %10s | %12s |%n",
                "Produto", "Qtd", "Unitário", "Total");
        System.out.println("--------------------------------------------------");

        for(Pedido p : cliente.getPedidos()) {
            System.out.printf("| %-25s | %6d | R$%8.2f | R$%10.2f |%n",
                    p.getNome(),
                    p.getQuantidade(),
                    p.getPrecoUnitario(),
                    p.getPrecoUnitario() * p.getQuantidade());
        }

        System.out.println("--------------------------------------------------");
        System.out.printf("| TOTAL: %46s |%n", String.format("R$%.2f", total));
        System.out.println("--------------------------------------------------");
        System.out.println("\nData de emissão: " +
                java.time.LocalDateTime.now().format(formatter));
        System.out.println("=== FIM DO RELATÓRIO ===");
    }

    @Override
    public String getTipo() {
        return "PDF";
    }

    private double calcularTotal(Cliente cliente) {
        return cliente.getPedidos().stream()
                .mapToDouble(p -> p.getPrecoUnitario() * p.getQuantidade())
                .sum();
    }
}