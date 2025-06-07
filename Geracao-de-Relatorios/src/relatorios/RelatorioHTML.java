package relatorios;

import entities.interfaces.Relatorio;
import entities.Cliente;
import entities.Pedido;
import java.time.format.DateTimeFormatter;

public class RelatorioHTML implements Relatorio {
    @Override
    public void gerarRelatorio(Cliente cliente) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        double total = calcularTotal(cliente);

        System.out.println("<!-- RELATÓRIO HTML -->");
        System.out.println("<div class='relatorio'>");
        System.out.println("  <h1>Relatório de Pedidos</h1>");
        System.out.println("  <p><strong>Formato:</strong> " + getTipo() + "</p>");

        System.out.println("  <h2>Dados do Cliente</h2>");
        System.out.println("  <ul>");
        System.out.println("    <li><strong>Nome:</strong> " + cliente.getNome() + "</li>");
        System.out.println("    <li><strong>CPF:</strong> " + cliente.getCpf() + "</li>");
        System.out.println("    <li><strong>Endereço:</strong> " + cliente.getEndereco() + "</li>");
        System.out.println("  </ul>");

        System.out.println("  <h2>Itens do Pedido</h2>");
        System.out.println("  <table border='1'>");
        System.out.println("    <tr>");
        System.out.println("      <th>Produto</th><th>Quantidade</th><th>Valor Unitário</th><th>Total</th>");
        System.out.println("    </tr>");

        for(Pedido p : cliente.getPedidos()) {
            System.out.println("    <tr>");
            System.out.printf("      <td>%s</td><td>%d</td><td>R$%.2f</td><td>R$%.2f</td>%n",
                    p.getNome(),
                    p.getQuantidade(),
                    p.getPrecoUnitario(),
                    p.getPrecoUnitario() * p.getQuantidade());
            System.out.println("    </tr>");
        }

        System.out.println("    <tr>");
        System.out.printf("      <td colspan='3'><strong>TOTAL</strong></td><td><strong>R$%.2f</strong></td>%n", total);
        System.out.println("    </tr>");
        System.out.println("  </table>");

        System.out.println("  <p><em>Data de emissão: " +
                java.time.LocalDateTime.now().format(formatter) + "</em></p>");
        System.out.println("</div>");
        System.out.println("<!-- FIM DO RELATÓRIO -->");
    }

    @Override
    public String getTipo() {
        return "HTML";
    }

    private double calcularTotal(Cliente cliente) {
        return cliente.getPedidos().stream()
                .mapToDouble(p -> p.getPrecoUnitario() * p.getQuantidade())
                .sum();
    }
}