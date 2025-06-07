package entities.interfaces;

import entities.Pedido;

import java.util.ArrayList;
import java.util.List;

public interface Relatorio {
    List <Pedido> pedidos = new ArrayList<>();

    public void gerarRelatorio();
}