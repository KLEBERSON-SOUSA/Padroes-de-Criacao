package com.example.temasfx.tema.impl;

import com.example.temasfx.tema.TemaFactory;

public class TemaAltoContraste implements TemaFactory {
    @Override
    public String getCorFundo() {
        return "-fx-background-color: #000000;";
    }

    @Override
    public String getCorTexto() {
        return "-fx-text-fill: #FFFFFF;";
    }

    @Override
    public String getEstiloBotao() {
        return "-fx-background-color: #FFFF00; -fx-text-fill: #000000; -fx-border-color: #FFFFFF; -fx-border-width: 2px;";

    }
}
