package br.senai.sp.jandira.estacionamentoApp.ui;

import br.senai.sp.jandira.estacionamentoApp.services.RegistroService;
import br.senai.sp.jandira.estacionamentoApp.services.ValidacaoService;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Optional;

public class TelaEntrada extends Application {
    // declarando classe de validação
    ValidacaoService validacao = new ValidacaoService();

    // declarando classe de registro
    RegistroService registroService = new RegistroService();

    // declarando text fields
    TextField tfCliente;
    TextField tfPlacaCliente;
    TextField tfTelefoneCliente;
    TextField tfModeloCliente;

    @Override
    public void start(Stage stage) throws Exception {

        //Criar o stage
        stage.setTitle("Projeto Integrador");
        stage.setResizable(false);
        stage.setWidth(400);

        // definindo box root
        VBox root = new VBox();
        Scene scene = new Scene(root);

        root.setPadding(new Insets(10));
        root.setStyle("-fx-background-color: #023f5d");

        // definindo header
        VBox header = new VBox();
        header.setStyle("-fx-background-color: #898989;");
        header.setPadding(new Insets(10));

        // definindo labels e textfieds
        Label registrarEntrada = new Label("Registro de entrada");
        registrarEntrada.setStyle("-fx-font-size: 20px; -fx-text-fill: #000000; -fx-font-weight: bold;");
        registrarEntrada.setPadding(new Insets(0, 10,10, 0));

        Label lblCliente = new Label("Nome do cliente");
        tfCliente = new TextField();
        tfCliente.setPromptText("joão Silva");
        lblCliente.setStyle("-fx-font-size: 16px;  -fx-text-fill: #000000;");
        lblCliente.setPadding(new Insets(5, 0,5, 0));

        Label lblTelefoneCliente = new Label("Telefone do Cliente");
        tfTelefoneCliente = new TextField();
        tfTelefoneCliente.setPromptText("(11) 99999-9999");
        lblTelefoneCliente.setStyle("-fx-font-size: 16px; -fx-text-fill: #000000;");
        lblTelefoneCliente.setPadding(new Insets(8, 5,5, 0));

        Label lblPlacaCliente = new Label("Placa do Veículo");
        tfPlacaCliente = new TextField();
        tfPlacaCliente.setPromptText("ex: abc-1234");
        lblPlacaCliente.setStyle("-fx-font-size: 16px; -fx-text-fill: #000000;");
        lblPlacaCliente.setPadding(new Insets(8, 5,5, 0));

        Label lblModeloCliente = new Label("Modelo do Veículo");
        tfModeloCliente = new TextField();
        tfModeloCliente.setPromptText("ex: civic");
        lblModeloCliente.setStyle("-fx-font-size: 16px; -fx-text-fill: #000000;");
        lblModeloCliente.setPadding(new Insets(8, 5,5, 0));
        // --------------------------------------

        // adicionando labels e textfields ao header
        header.getChildren().addAll(registrarEntrada,
                lblCliente, tfCliente,
                lblTelefoneCliente, tfTelefoneCliente,
                lblPlacaCliente, tfPlacaCliente,
                lblModeloCliente, tfModeloCliente);


        // conteiner dos botões
        HBox boxButtons = new HBox();
        boxButtons.setSpacing(20);
        boxButtons.setStyle("-fx-background-color: #898989");
        boxButtons.setPadding(new Insets(20, 10,50, 15));
        boxButtons.setAlignment(Pos.CENTER);

        // definindo butões
        Button buttonCancelar = new Button("Cancelar");
        buttonCancelar.setStyle("-fx-background-color: #515151;-fx-font-size: 16px; -fx-text-fill: black; -fx-font-weight: bold;");
        buttonCancelar.setMinWidth(150);

        Button buttonRegistrar = new Button("Registrar");
        buttonRegistrar.setStyle("-fx-background-color: #3b7800; -fx-font-size: 16px; -fx-text-fill: black; -fx-font-weight: bold");
        buttonRegistrar.setMinWidth(150);
        // ---------------------------

        // adicionando botões ao container 
        boxButtons.getChildren().addAll(buttonCancelar, buttonRegistrar);

        // definindo ação ao botão cancelar
        buttonCancelar.setOnAction(e -> {
            // alerta
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Deseja realmente sair", ButtonType.YES, ButtonType.NO);

            alert.setHeaderText(null);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.YES){
                stage.close();
            }
        });

        // definindo ação ao botão registrar
        buttonRegistrar.setOnAction(e -> {
            String placa = tfPlacaCliente.getText();
            String modelo = tfModeloCliente.getText();
            String telefone = tfTelefoneCliente.getText();
            String cliente = tfCliente.getText();

            // se as validações forem verdadeiras então chama receberDados
            if (validacao.validarNome(cliente) && validacao.validarTelefone(telefone) && validacao.validarModelo(modelo) && validacao.validarPlaca(placa)) {
                recebeDados();


                // limpa os campos
                tfCliente.clear();
                tfModeloCliente.clear();
                tfPlacaCliente.clear();
                tfTelefoneCliente.clear();

                // deixa o foco no tfCliente
                tfCliente.requestFocus();
            }


            // se as validações forem falsas então escreve uma mensagem de erro e o foco vai para o campo invalido
            if (!validacao.validarNome(cliente)){
                escreverAviso("Por favor, digite um nome valido!");
                tfCliente.requestFocus();
            }else if (!validacao.validarTelefone(telefone)){
                escreverAviso("Por favor, digite um telefone valido!");
                tfTelefoneCliente.requestFocus();
            }else if (!validacao.validarPlaca(placa)){
                escreverAviso("Por favor, digite uma placa valido!");
                tfPlacaCliente.requestFocus();
            }else if (!validacao.validarModelo(modelo)){
                escreverAviso("Por favor, digite um modelo valido!");
                tfModeloCliente.requestFocus();
            }

        });

        // adiciona o header e os botões
        root.getChildren().add(header);
        root.getChildren().add(boxButtons);
        stage.setScene(scene);

        // mostra a tela
        stage.show();
    }

    // método para receber os dados dos textfields e enviar para o método registrarEntrada 
    public void recebeDados (){
        String placa = tfPlacaCliente.getText();
        String modelo = tfModeloCliente.getText();
        String telefone = tfTelefoneCliente.getText();
        String cliente = tfCliente.getText();

        // usa os dados obtidos para registrar entrada
        registroService.registrarEntrada(cliente, telefone, placa, modelo);
    }

    // método para escrever aviso
    public void escreverAviso(String mensagem){
        Alert alert = new Alert(Alert.AlertType.ERROR, mensagem);
        alert.setHeaderText(null);
        alert.show();
    }



}
