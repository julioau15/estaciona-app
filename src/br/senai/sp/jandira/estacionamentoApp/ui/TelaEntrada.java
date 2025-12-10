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
        stage.setResizable(false);
        stage.setHeight(700);
        stage.setWidth(700);

        VBox root = new VBox();

        Scene scene = new Scene(root);

        root.setPadding(new Insets(10));
        root.setStyle("-fx-background-color: #001C39");

        VBox header = new VBox();

        Label registrarEntrada = new Label("Registro de entrada");
        registrarEntrada.setStyle("-fx-font-size: 20px; -fx-text-fill: white; -fx-font-weight: bold;");
        registrarEntrada.setPadding(new Insets(0, 10,10, 0));

        Label lblCliente = new Label("Nome do cliente");
        tfCliente = new TextField();
        lblCliente.setStyle("-fx-font-size: 16px;  -fx-text-fill: white;");
        lblCliente.setPadding(new Insets(5, 0,5, 0));

        Label lblTelefoneCliente = new Label("Telefone do Cliente");
        tfTelefoneCliente = new TextField();
        lblTelefoneCliente.setStyle("-fx-font-size: 16px; -fx-text-fill: white;");
        lblTelefoneCliente.setPadding(new Insets(8, 5,5, 0));

        Label lblPlacaCliente = new Label("Placa do Cliente");
        tfPlacaCliente = new TextField();
        lblPlacaCliente.setStyle("-fx-font-size: 16px; -fx-text-fill: white;");
        lblPlacaCliente.setPadding(new Insets(8, 5,5, 0));

        Label lblModeloCliente = new Label("Modelo do Cliente");
        tfModeloCliente = new TextField();
        lblModeloCliente.setStyle("-fx-font-size: 16px; -fx-text-fill: white;");
        lblModeloCliente.setPadding(new Insets(8, 5,5, 0));

        header.getChildren().addAll(registrarEntrada,
                lblCliente, tfCliente,
                lblTelefoneCliente, tfTelefoneCliente,
                lblPlacaCliente, tfPlacaCliente,
                lblModeloCliente, tfModeloCliente);

        Pane paneButtons = new Pane();
        HBox boxButtons = new HBox();
        boxButtons.setSpacing(20);
        Button buttonCancelar = new Button("Cancelar");
        buttonCancelar.setStyle("-fx-background-color: #ffe6ab;");

        Button buttonRegistrar = new Button("Registrar");
        buttonRegistrar.setStyle("-fx-background-color: #FEB704");

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