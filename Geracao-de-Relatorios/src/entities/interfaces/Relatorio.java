package entities.interfaces;

import entities.Cliente;

public interface Relatorio {
    void gerarRelatorio(Cliente cliente);
    String getTipo();
}