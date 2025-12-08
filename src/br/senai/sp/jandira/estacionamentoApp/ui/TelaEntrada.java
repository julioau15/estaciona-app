package br.senai.sp.jandira.estacionamentoApp.ui;

import br.senai.sp.jandira.estacionamentoApp.services.RegistroService;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Optional;

public class TelaEntrada extends Application {

    TextField tfCliente;
    TextField tfPlacaCliente;
    TextField tfTelefoneCliente;
    TextField tfModeloCliente;

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
        root.setStyle("-fx-background-color: #dfacfc");

        VBox header = new VBox();

        Label registrarEntrada = new Label("Registro de entrada");

        Label lblCliente = new Label("Nome do cliente");
        tfCliente = new TextField();

        Label lblTelefoneCliente = new Label("Telefone do Cliente");
        tfTelefoneCliente = new TextField();

        Label lblPlacaCliente = new Label("Placa do Cliente");
        tfPlacaCliente = new TextField();

        Label lblModeloCliente = new Label("Modelo do Cliente");
        tfModeloCliente = new TextField();

        header.getChildren().addAll(registrarEntrada,
                lblCliente, tfCliente,
                lblTelefoneCliente, tfTelefoneCliente,
                lblPlacaCliente, tfPlacaCliente,
                lblModeloCliente, tfModeloCliente);

        Pane paneButtons = new Pane();
        HBox boxButtons = new HBox();
        Button buttonCancelar = new Button("Cancelar");
        Button buttonRegistrar = new Button("Registrar");

        paneButtons.getChildren().addAll(boxButtons);
        boxButtons.getChildren().addAll(buttonCancelar, buttonRegistrar);

        buttonCancelar.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Deseja realmente sair", ButtonType.YES, ButtonType.NO);

            alert.setHeaderText(null);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.YES){
                stage.close();
            }
        });

        buttonRegistrar.setOnAction(e -> {
            recebeDados();
        });

        root.getChildren().add(header);
        root.getChildren().add(paneButtons);
        stage.setScene(scene);
        stage.show();
    }

    public void recebeDados (){
        String placa = tfPlacaCliente.getText();
        String modelo = tfModeloCliente.getText();
        String telefone = tfTelefoneCliente.getText();
        String cliente = tfCliente.getText();

        RegistroService registroService = new RegistroService();
        registroService.registrarEntrada(cliente, telefone, placa, modelo);

    }



}