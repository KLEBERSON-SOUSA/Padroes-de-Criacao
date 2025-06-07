package entities;

import java.time.LocalDateTime;

public class Pedido {
    private String nome;
    private Double precoUnitario;
    private LocalDateTime dataHora;

    public Pedido(String nome, Double precoUnitario, LocalDateTime dataHora) {
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.dataHora = dataHora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
