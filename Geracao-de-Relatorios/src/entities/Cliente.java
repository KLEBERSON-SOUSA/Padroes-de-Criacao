package entities;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private String endereco;
    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente(String nome, String cpf, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public Pedido fazerPedido(int opcao, int quantidade) {
        Pedido pedido = switch (opcao) {
            case 1 -> new Pedido("Parmegiana", 26.21, quantidade);
            case 2 -> new Pedido("Filé Mignon ao molho madeira", 119.90, quantidade);
            case 3 -> new Pedido("Risoto a moda do chef", 85.00, quantidade);
            default -> throw new IllegalArgumentException("Opção inválida!");
        };

        pedidos.add(pedido);
        return pedido;
    }
}