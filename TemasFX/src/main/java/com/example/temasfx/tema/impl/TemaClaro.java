package com.example.temasfx.tema.impl;

import com.example.temasfx.tema.TemaFactory;

public class TemaClaro implements TemaFactory {

    @Override
    public String getCorFundo() {
        return "-fx-background-color: #f5f5f5;";
    }

    @Override
    public String getCorTexto() {
        return "-fx-text-fill: #333;";
    }

    @Override
    public String getEstiloBotao() {
        return "-fx-background-color: #4285f4; -fx-text-fill: white;";
    }
}
