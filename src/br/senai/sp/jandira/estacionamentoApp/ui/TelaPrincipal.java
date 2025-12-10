package br.senai.sp.jandira.estacionamentoApp.ui;

import br.senai.sp.jandira.estacionamentoApp.EstacionamentoApp;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;


public class TelaPrincipal extends Application {
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
        Label titulo = new Label("Painel de controle Estacionamento");
        Label descricao = new Label("Gerencie a entrada e saída dos veículos");

        //criar painel de botoes
        Pane paneButtons = new Pane();
        paneButtons.setPadding(new Insets(10));
        HBox boxButtons = new HBox();
        boxButtons.setPadding(new Insets(5));
        boxButtons.setSpacing(10);

        //criar botoes
        Button buttonEntrada = new Button("Entrada de veiculo");
        Button buttonSaida = new Button("Saida de veiculo");
        Button buttonLimpar = new Button("Limpar registros");
        Button buttonSair = new Button("Sair");
        paneButtons.getChildren().addAll(boxButtons);

        //adicionar botoes
        boxButtons.getChildren().addAll(buttonEntrada, buttonSaida, buttonLimpar, buttonSair);

        //criar tabela
        TableView<EstacionamentoApp> tabela =new TableView<>();

        TableColumn<EstacionamentoApp,String> cliente = new TableColumn<>("Cliente");
        TableColumn<EstacionamentoApp,String> telefone = new TableColumn<>("Telefone");
        TableColumn<EstacionamentoApp,String> placa = new TableColumn<>("Placa");
        TableColumn<EstacionamentoApp,String> modelo = new TableColumn<>("Modelo");
        TableColumn<EstacionamentoApp,String> entrada = new TableColumn<>("Entrada");
        TableColumn<EstacionamentoApp,String> permanencia = new TableColumn<>("Permanência");
        tabela.getColumns().addAll(cliente,telefone,placa,modelo,entrada,permanencia);

        //criar tabela 2
        TableView<EstacionamentoApp> tabela2 =new TableView<>();
        TableColumn<EstacionamentoApp,String> cliente2 = new TableColumn<>("Cliente");
        TableColumn<EstacionamentoApp,String> telefone2 = new TableColumn<>("Telefone");
        TableColumn<EstacionamentoApp,String> placa2 = new TableColumn<>("Placa");
        TableColumn<EstacionamentoApp,String> modelo2 = new TableColumn<>("Modelo");
        TableColumn<EstacionamentoApp,String> entrada2 = new TableColumn<>("Entrada");
        TableColumn<EstacionamentoApp,String> permanencia2 = new TableColumn<>("Permanência");
        tabela2.getColumns().addAll(cliente2,telefone2,placa2,modelo2,entrada2,permanencia2);

        //Conteudo do header
        header.getChildren().addAll(titulo, descricao);

        //conteudo do root
        root.getChildren().addAll(header);
        root.getChildren().addAll(paneButtons);
        root.getChildren().addAll(tabela);
        root.getChildren().addAll(tabela2);

        //Colocamos a cena no palco
        stage.setScene(scene);
        stage.show();

        buttonEntrada.setOnAction(e -> {
            try {
                new TelaEntrada().start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        buttonSaida.setOnAction(e -> {
            try {
                new TelaSaida().start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        buttonSair.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Deseja realmente sair", ButtonType.YES, ButtonType.NO);

            alert.setHeaderText(null);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.YES){
                stage.close();
            }
        });

    }

}