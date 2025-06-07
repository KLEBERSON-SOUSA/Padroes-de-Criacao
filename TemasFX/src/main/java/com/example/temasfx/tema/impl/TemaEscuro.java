package com.example.temasfx.tema.impl;

import com.example.temasfx.tema.TemaFactory;

public class TemaEscuro implements TemaFactory {

    @Override
    public String getCorFundo() {
        return "-fx-background-color: #333;";
    }

    @Override
    public String getCorTexto() {
        return "-fx-text-fill: #eee;";
    }

    @Override
    public String getEstiloBotao() {
        return "-fx-background-color: #666; -fx-text-fill: white;";
    }
}
