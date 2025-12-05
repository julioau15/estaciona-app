package br.senai.sp.jandira.estacionamentoApp.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaEntrada extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        //Criar o stage
        stage.setTitle("Projeto Integrador");
        stage.setResizable(true);
        stage.setHeight(500);
        stage.setWidth(500);

        VBox root = new VBox();

        Scene scene = new Scene(root);

        root.setPadding(new Insets(10));
        root.setStyle("-fx-background-color: #6c00a9");

        VBox header = new VBox();

        Label registrarEntrada = new Label("Registro de entrada");

        Label lblCliente = new Label("Nome do cliente");
        TextField tfCliente = new TextField();

        Label lblTelefoneCliente = new Label("Telefone do Cliente");
        TextField tfTelefoneCliente = new TextField();


        Label lblPlacaCliente = new Label("Placa do Cliente");
        TextField tfPlacaCliente = new TextField();


        Label lblModeloCliente = new Label("Modelo do Cliente");
        TextField tfModeloCliente = new TextField();

        header.getChildren().addAll(registrarEntrada, lblCliente, tfCliente,
                lblTelefoneCliente, tfTelefoneCliente,
                lblPlacaCliente, tfPlacaCliente,
                lblModeloCliente, tfModeloCliente);



        root.getChildren().add(header);
        stage.setScene(scene);
        stage.show();
    }


}
