package com.example.temasfx;

import com.example.temasfx.tema.TemaFactory;
import com.example.temasfx.tema.impl.TemaClaro;
import com.example.temasfx.tema.impl.TemaEscuro;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private TemaFactory temaAtual = new TemaClaro(); // Factory concreta

    @Override
    public void start(Stage stage) {

        Button btnTrocarTema = new Button("Mudar Tema");

        VBox root = new VBox(20, btnTrocarTema);
        atualizarTema(root);
        btnTrocarTema.setOnAction(e -> {

            temaAtual = (temaAtual instanceof TemaClaro)
                    ? new TemaEscuro()
                    : new TemaClaro();
            atualizarTema(root);
        });

        stage.setScene(new Scene(root, 300, 200));
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