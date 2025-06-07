package relatorios;

import entities.interfaces.Relatorio;
import entities.Cliente;
import entities.Pedido;
import java.time.format.DateTimeFormatter;

public class RelatorioJSON implements Relatorio {
    @Override
    public void gerarRelatorio(Cliente cliente) {
        StringBuilder json = new StringBuilder();
        json.append("{\n");
        json.append("  \"tipoRelatorio\": \"JSON\",\n");
        json.append("  \"dataEmissao\": \""
                + java.time.LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "\",\n");

        json.append("  \"cliente\": {\n");
        json.append("    \"nome\": \"" + escapeJson(cliente.getNome()) + "\",\n");
        json.append("    \"cpf\": \"" + escapeJson(cliente.getCpf()) + "\",\n");
        json.append("    \"endereco\": \"" + escapeJson(cliente.getEndereco()) + "\"\n");
        json.append("  },\n");

        json.append("  \"pedidos\": [\n");
        for (int i = 0; i < cliente.getPedidos().size(); i++) {
            Pedido p = cliente.getPedidos().get(i);
            json.append("    {\n");
            json.append("      \"produto\": \"" + escapeJson(p.getNome()) + "\",\n");
            json.append("      \"quantidade\": " + p.getQuantidade() + ",\n");
            json.append("      \"precoUnitario\": " + p.getPrecoUnitario() + ",\n");
            json.append("      \"totalItem\": " + (p.getPrecoUnitario() * p.getQuantidade()) + "\n");
            json.append("    }" + (i < cliente.getPedidos().size() - 1 ? "," : "") + "\n");
        }
        json.append("  ],\n");

        double total = cliente.getPedidos().stream()
                .mapToDouble(p -> p.getPrecoUnitario() * p.getQuantidade())
                .sum();
        json.append("  \"totalPedido\": " + total + "\n");
        json.append("}");

        System.out.println("=== RELATÓRIO JSON ===");
        System.out.println(json.toString());
        System.out.println("=====================");
    }

    @Override
    public String getTipo() {
        return "JSON";
    }

    private String escapeJson(String input) {
        return input.replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }
}