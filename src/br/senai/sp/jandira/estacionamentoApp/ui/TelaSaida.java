package br.senai.sp.jandira.estacionamentoApp.ui;

import br.senai.sp.jandira.estacionamentoApp.repository.ArquivoCsv;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.Optional;

public class TelaSaida extends Application {
    //caminhos para os arquivos csv
    String caminhoEntrada = "src/br/senai/sp/jandira/estacionamentoApp/data/veiculos_estacionados.csv";
    String caminhoSaida = "src/br/senai/sp/jandira/estacionamentoApp/data/historico_saidas.csv";

    ComboBox<String> combo;


    @Override
    public void start(Stage stage) throws Exception {

        //Criar o stage
        stage.setTitle("Projeto Integrador");
        stage.setResizable(false);
        stage.setHeight(700);
        stage.setWidth(700);

        //Criar o root componente principal de layout

        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setStyle("-fx-background-color: #6c00a9");

        //Criamos a cena e colocamos o root nela
        Scene scene = new Scene(root);

        //Criar o header da tela
        VBox header = new VBox();
        header.setPrefHeight(100);
        header.setPadding(new Insets(10));
        header.setStyle("-fx-background-color: rgba(194,158,255,0.84)");

        //Labels de titulo e descricão
        Label titulo = new Label("Registrar Saida");
        Label descricao = new Label("Gerencie a entrada e saída dos veículos");

        combo = new ComboBox<>();

        //criar painel de botoes
        Pane paneButtons = new Pane();
        paneButtons.setPadding(new Insets(10));
        HBox boxButtons = new HBox();
        boxButtons.setPadding(new Insets(5));
        boxButtons.setSpacing(10);

        //criar botoes
        Button buttonCancelar = new Button("Cancelar");
        Button buttonConfirmarSaida = new Button("Confirmar Saida");

        paneButtons.getChildren().addAll(boxButtons);

        //adicionar botoes
        boxButtons.getChildren().addAll(buttonCancelar, buttonConfirmarSaida);


        root.getChildren().addAll(header);
        root.getChildren().addAll(combo);
        root.getChildren().addAll(paneButtons);


        header.getChildren().addAll(titulo, descricao);


        stage.setScene(scene);
        stage.show();

        buttonCancelar.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Deseja realmente sair", ButtonType.YES, ButtonType.NO);

            alert.setHeaderText(null);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.YES){
                stage.close();
            }
        });

        escreverComboBox();

    }

    public void escreverComboBox(){
        String cliente;
        String placa;
        String modelo;


        ArquivoCsv arquivo = new ArquivoCsv();
        List<String> linhas = arquivo.lerCsv(caminhoEntrada);
        for (int i = 1; i < linhas.size(); i++) {
            String linha = linhas.get(i);
            String[] dados = linha.split(";");

            if (dados.length < 4) continue;

            cliente = dados[0];
            placa = dados[2];
            modelo = dados[3];

            String dadosMenu = placa + " - " + modelo + " (" + cliente + ")";

            combo.getItems().add(dadosMenu);
        }
    }
}
