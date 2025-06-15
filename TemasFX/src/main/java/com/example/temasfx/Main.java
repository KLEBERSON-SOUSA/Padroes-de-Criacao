package com.example.temasfx;

import com.example.temasfx.tema.TemaFactory;
import com.example.temasfx.tema.impl.TemaClaro;
import com.example.temasfx.tema.impl.TemaEscuro;
import com.example.temasfx.tema.impl.TemaAltoContraste;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private TemaFactory temaAtual = new TemaClaro();

    @Override
    public void start(Stage stage) {

        Button btnTemaClaro = new Button("Tema Claro");
        Button btnTemaEscuro = new Button("Tema Escuro");
        Button btnTemaAltoContraste = new Button("Alto Contraste");


        HBox botoesTema = new HBox(20, btnTemaClaro, btnTemaEscuro, btnTemaAltoContraste);


        Button btnExemplo = new Button("Exemplo");

        VBox root = new VBox(50, botoesTema, btnExemplo);
        atualizarTema(root);


        btnTemaClaro.setOnAction(e -> {
            temaAtual = new TemaClaro();
            atualizarTema(root);
        });

        btnTemaEscuro.setOnAction(e -> {
            temaAtual = new TemaEscuro();
            atualizarTema(root);
        });

        btnTemaAltoContraste.setOnAction(e -> {
            temaAtual = new TemaAltoContraste();
            atualizarTema(root);
        });

        stage.setScene(new Scene(root, 400, 250));
        stage.setTitle("Seletor de Temas");
        stage.show();
    }

    private void atualizarTema(VBox root) {
        root.setStyle(temaAtual.getCorFundo());
        root.getChildren().forEach(node -> {
            if (node instanceof Button) {
                node.setStyle(temaAtual.getEstiloBotao());
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}