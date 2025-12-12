package br.senai.sp.jandira.estacionamentoApp.ui;

import br.senai.sp.jandira.estacionamentoApp.repository.ArquivoCsv;
import br.senai.sp.jandira.estacionamentoApp.services.RegistroService;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.Optional;

public class TelaSaida extends Application {
    // declarando tela principal
    TelaPrincipal telaPrincipal = new TelaPrincipal();
    
    // declarando classe arquivo
    ArquivoCsv arquivo = new ArquivoCsv();

    // declarando classe registro
    RegistroService  registro = new RegistroService();

    //caminho para o arquivo csv
    String caminhoEntrada = "src/br/senai/sp/jandira/estacionamentoApp/data/veiculos_estacionados.csv";

    // declarando combo box
    ComboBox<String> combo;


    @Override
    public void start(Stage stage) throws Exception {

        //Criar o stage
        stage.setTitle("Projeto Integrador");
        stage.setResizable(false);
        stage.setWidth(400);

        //Criar o root componente principal de layout
        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setStyle("-fx-background-color: #023f5d");

        //Criamos a cena e colocamos o root nela
        Scene scene = new Scene(root);

        //Criar o header da tela
        VBox header = new VBox();
        header.setPrefHeight(10);
        header.setPadding(new Insets(10));
        header.setStyle("-fx-background-color: #898989");
        header.setAlignment(Pos.CENTER);

        //Labels de titulo e descricão
        Label titulo = new Label("Registrar Saida");
        titulo.setStyle("-fx-font-size: 20px; -fx-text-fill: #000000; -fx-font-weight: bold;");

        Label descricao = new Label("Gerencie a entrada e saída dos veículos");
        descricao.setStyle("-fx-font-size: 16px;  -fx-text-fill: #000000;");

        header.getChildren().addAll(titulo, descricao);
        

        // definindo combo box
        HBox comboBox = new HBox();
        combo = new ComboBox<>();
        String placeHolder = "Selecione um veículo";
        combo.setPromptText(placeHolder);
        combo.setPrefWidth(200);
        combo.setPrefHeight(30);
        comboBox.getChildren().addAll(combo);
        comboBox.setAlignment(Pos.CENTER);
        comboBox.setPadding(new Insets(10));
        comboBox.setStyle("-fx-background-color: #898989");

        //criar painel de botoes
        HBox boxButtons = new HBox();
        boxButtons.setPadding(new Insets(10, 5, 20, 0));
        boxButtons.setSpacing(10);
        boxButtons.setAlignment(Pos.CENTER);
        boxButtons.setStyle("-fx-background-color: #898989");

        //criar botões
        Button buttonCancelar = new Button("Cancelar");
        buttonCancelar.setStyle("-fx-background-color: #515151; -fx-font-weight: bold; -fx-text-fill: #000000;");
        buttonCancelar.setMinWidth(150);
        buttonCancelar.setMaxHeight(70);

        Button buttonConfirmarSaida = new Button("Confirmar Saida");
        buttonConfirmarSaida.setStyle("-fx-background-color: #3b7800;  -fx-font-weight: bold;  -fx-text-fill: #000000;");
        buttonConfirmarSaida.setMinWidth(150);
        buttonConfirmarSaida.setMaxHeight(70);

        //adicionar botoes
        boxButtons.getChildren().addAll(buttonCancelar, buttonConfirmarSaida);

        //adicionando header, combo box e botões
        root.getChildren().addAll(header);
        root.getChildren().addAll(comboBox);
        root.getChildren().addAll(boxButtons);


        stage.setScene(scene);
        stage.show();

        // definindo ação para botão de cancelar
        buttonCancelar.setOnAction(e -> {
            //alerta
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Deseja realmente sair", ButtonType.YES, ButtonType.NO);

            alert.setHeaderText(null);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.YES){
                stage.close();
            }
        });

        // definindo ação para botão de confirmar saída
        buttonConfirmarSaida.setOnAction(e -> {
            // se nada for escolido mostra um alerta
            if (combo.getItems().isEmpty()) {
                Alert alerta = new Alert(Alert.AlertType.ERROR, "Por favor, escolha uma opção!");
                alerta.setHeaderText(null);
                alerta.showAndWait();

                // se foi escolhido registra a saída e atualiza a combo box
            }else{
                chamarRegistrarSaida();
                escreverComboBox();
            }

        });

        // chama o método escreverComboBox
        escreverComboBox();

    }

    // método responsável por escrever o combo box
    public void escreverComboBox(){
        String cliente;
        String placa;
        String modelo;

        // limpa o combo box
        combo.getItems().clear();

        // recebe os dados do arquivo csv
        List<String> linhas = arquivo.lerCsv(caminhoEntrada);
        
        // ignorando a primeira linha de cabeçalho
        // em cada linha é pego os dados de cliente, placa e modelo
        for (int i = 1; i < linhas.size(); i++) {
            String linha = linhas.get(i);
            String[] dados = linha.split(";");

            if (dados.length < 4) continue;

            cliente = dados[0];
            placa = dados[2];
            modelo = dados[3];

            // String que vai ser escrita no combo box
            String dadosMenu = placa + " - " + modelo + " (" + cliente + ")";

            // adiciona a String
            combo.getItems().add(dadosMenu);

        }
    }

    // método para chamar registrarSaida
    public void chamarRegistrarSaida(){
        // pega a String da opção selecionada do combo box
        String linha =  combo.getSelectionModel().getSelectedItem();

        // separa a String em duas partes com " - "
        String[] dados = linha.split(" - ");

        // pega a primeira parte da String (placa)
        String placa  = dados[0];
        
        // registra a saída
        registro.registrarSaida(placa);
    }
}
