package br.senai.sp.jandira.estacionamentoApp.ui;

import br.senai.sp.jandira.estacionamentoApp.EstacionamentoApp;
import br.senai.sp.jandira.estacionamentoApp.repository.ArquivoCsv;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


public class TelaPrincipal extends Application {
    //classe ArquivoCsv
    ArquivoCsv arquivo = new ArquivoCsv();

    //caminho para o arquivo csv
    String caminhoEntrada = "src/br/senai/sp/jandira/estacionamentoApp/data/veiculos_estacionados.csv";
    String caminhoSaida = "src/br/senai/sp/jandira/estacionamentoApp/data/historico_saidas.csv";

    // declara Tabela 1
    TableView<String[]> tabela = new TableView<>();
    TableColumn<String[], String> cliente;
    TableColumn<String[],String> telefone;
    TableColumn<String[],String> placa;
    TableColumn<String[],String> modelo;
    TableColumn<String[],String> entrada;


    //declara Tabela 2
    TableView<String[]> tabela2;
    TableColumn<String[],String> cliente2;
    TableColumn<String[],String> telefone2;
    TableColumn<String[],String> placa2;
    TableColumn<String[],String> modelo2;
    TableColumn<String[],String> entrada2;
    TableColumn<String[],String> permanencia;
    TableColumn<String[],String> preco;


    @Override
    public void start(Stage stage) throws Exception {

        // Criar o stage
        stage.setTitle("Projeto Integrador");
        stage.setResizable(false);
        stage.setHeight(700);
        stage.setWidth(900);

        // Criar o root componente principal de layout
        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setStyle("-fx-background-color: #023f5d");

        //Criamos a cena e colocamos o root nela
        Scene scene = new Scene(root);

        //Criar o header da tela
        VBox header = new VBox();
        header.setPrefHeight(100);
        header.setPadding(new Insets(10));
        header.setStyle("-fx-background-color: #898989");

        //Labels de titulo e descricão
        Label titulo = new Label("Painel de controle Estacionamento");
        titulo.setStyle(
                "-fx-font-size: 20px; " +
                "-fx-text-fill: #001a31;" +
                "-fx-font-weight: bold;"
        );

        Label descricao = new Label("Gerencie a entrada e saída dos veículos");
        descricao.setStyle(
                "-fx-font-size: 16px; " +
                "-fx-text-fill: #303030;");

        //criar painel de botoes
        HBox boxButtons = new HBox();
        boxButtons.setSpacing(20);
        boxButtons.setPadding(new Insets(10,  10, 10, 10));
        boxButtons.setAlignment(Pos.CENTER);


        //criar botoes
        Button buttonEntrada = new Button("Entrada de veiculo");
        buttonEntrada.setStyle(
                " -fx-background-color: #3b7800;\n" +
                "    -fx-text-fill: #000000;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-min-width: 200;\n" +
                "    -fx-max-width: 200;\n" +
                "    -fx-min-height: 40;\n" +
                "    -fx-max-height: 40;\n" +
                "    -fx-alignment: center;"
        );

        Button buttonSaida = new Button("Saida de veiculo");
        buttonSaida.setStyle(
                " -fx-background-color: #af8c00;\n" +
                        "    -fx-text-fill: #000000;\n" +
                        "    -fx-font-weight: bold;\n" +
                        "    -fx-min-width: 200;\n" +
                        "    -fx-max-width: 200;\n" +
                        "    -fx-min-height: 40;\n" +
                        "    -fx-max-height: 40;\n" +
                        "    -fx-alignment: center;"
        );

        Button buttonLimpar = new Button("Limpar registros");
        buttonLimpar.setStyle(
                " -fx-background-color: #913250;\n" +
                        "    -fx-text-fill: #000000;\n" +
                        "    -fx-font-weight: bold;\n" +
                        "    -fx-min-width: 200;\n" +
                        "    -fx-max-width: 200;\n" +
                        "    -fx-min-height: 40;\n" +
                        "    -fx-max-height: 40;\n" +
                        "    -fx-alignment: center;"
        );

        Button buttonSair = new Button("Sair");
        buttonSair.setStyle(
                " -fx-background-color: #989898;\n" +
                        "    -fx-text-fill: #000000;\n" +
                        "    -fx-font-weight: bold;\n" +
                        "    -fx-min-width: 200;\n" +
                        "    -fx-max-width: 200;\n" +
                        "    -fx-min-height: 40;\n" +
                        "    -fx-max-height: 40;\n" +
                        "    -fx-alignment: center;"
        );

        //adicionar botoes
        boxButtons.getChildren().addAll(buttonEntrada, buttonSaida, buttonLimpar, buttonSair);

        //criar tabela
        tabela = new TableView<>();
        cliente = new TableColumn<>("Cliente");
        telefone = new TableColumn<>("Telefone");
        placa = new TableColumn<>("Placa");
        modelo = new TableColumn<>("Modelo");
        entrada = new TableColumn<>("Entrada");
        tabela.getColumns().addAll(cliente,telefone,placa,modelo,entrada);

        cliente.setCellValueFactory((data -> new SimpleStringProperty(data.getValue()[0])));
        telefone.setCellValueFactory((data -> new SimpleStringProperty(data.getValue()[1])));
        placa.setCellValueFactory((data -> new SimpleStringProperty(data.getValue()[2])));
        modelo.setCellValueFactory((data -> new SimpleStringProperty(data.getValue()[3])));
        entrada.setCellValueFactory((data -> new SimpleStringProperty(data.getValue()[4])));

        tabela.setMaxHeight(300);
        tabela.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


        //criar tabela 2
        tabela2 = new TableView<>();
        cliente2 = new TableColumn<>("Cliente");
        telefone2 = new TableColumn<>("Telefone");
        placa2 = new TableColumn<>("Placa");
        modelo2 = new TableColumn<>("Modelo");
        entrada2 = new TableColumn<>("Entrada");
        permanencia = new TableColumn<>("Permanência");
        preco = new TableColumn<>("Preço");
        tabela2.getColumns().addAll(cliente2,telefone2,placa2,modelo2,entrada2,permanencia, preco);

        cliente2.setCellValueFactory((data -> new SimpleStringProperty(data.getValue()[0])));
        telefone2.setCellValueFactory((data -> new SimpleStringProperty(data.getValue()[1])));
        placa2.setCellValueFactory((data -> new SimpleStringProperty(data.getValue()[2])));
        modelo2.setCellValueFactory((data -> new SimpleStringProperty(data.getValue()[3])));
        entrada2.setCellValueFactory((data -> new SimpleStringProperty(data.getValue()[4])));
        permanencia.setCellValueFactory((data -> new SimpleStringProperty(data.getValue()[6])));
        preco.setCellValueFactory((data -> new SimpleStringProperty(data.getValue()[7])));

        tabela2.setMaxHeight(300);
        tabela2.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        //Conteudo do header
        header.getChildren().addAll(titulo, descricao);

        //conteudo do root
        root.getChildren().addAll(header);
        root.getChildren().addAll(boxButtons);
        root.getChildren().addAll(tabela);
        root.getChildren().addAll(tabela2);

        //Colocamos a cena no palco
        stage.setScene(scene);
        stage.show();

        // definido ação para o botão de entrada
        buttonEntrada.setOnAction(e -> {
            // tenta chamar a tela de entrada
            try {
                Stage entradaStage = new Stage();
                new TelaEntrada().start(entradaStage);

                // quando a tela de entrada fechar as tabelas são atualizadas
                entradaStage.setOnHidden(windowEvent -> {
                    escreverTabela();
                });

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // definido ação para o botão de saida
        buttonSaida.setOnAction(e -> {
             // tenta chamar a tela de saída
            try {
                Stage saidaStage = new Stage();
                new TelaSaida().start(saidaStage);

                 // quando a tela de saída fechar as tabelas são atualizadas
                saidaStage.setOnHiding((event) -> {
                    escreverTabela();
                });

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // definido ação para o botão sair
        buttonSair.setOnAction(e -> {
            // alerta
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Deseja realmente sair", ButtonType.YES, ButtonType.NO);

            alert.setHeaderText(null);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.YES){
                stage.close();
            }
        });

        // definido ação para o botão de limpar
        buttonLimpar.setOnAction(e -> {
            //alerta
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Deseja realmente Limpar as Tabelas?", ButtonType.YES, ButtonType.NO);

            alert.setHeaderText(null);
            Optional<ButtonType> result = alert.showAndWait();
            
            if (result.get() == ButtonType.YES){
                // chamar método par alimpar as tabelas
                chamarLimparArquivo();

                // atualiza as tabelas
                escreverTabela();
            }
        });

        // escreve as tabelas
        escreverTabela();
    }

    // método que escreve as tabelas
    public void escreverTabela(){
        // pega os dados dos arquivos csv
        List<String> dadosEntrada = arquivo.lerCsv(caminhoEntrada);
        List<String> dadosSaida = arquivo.lerCsv(caminhoSaida);

        // limpa as tabelas
        tabela.getItems().clear();
        tabela2.getItems().clear();

        // ignora a primeira linha de cabeçalho
        for(int i = 0; i < dadosEntrada.size(); i++){
            if(i != 0){
                // separa a linha com ";" 
                String[] linha = dadosEntrada.get(i).split(";");
                if (linha.length > 3){
                    // adiciona a linha na tabela
                    tabela.getItems().add(linha);
                }
            }
        }

        // ignora a primeira linha de cabeçalho
        for(int i = 0; i < dadosSaida.size(); i++){
            if(i != 0){
                 // separa a linha com ";" 
                String[] linha = dadosSaida.get(i).split(";");
                 // adiciona a linha na tabela
                if (linha.length > 6){
                    tabela2.getItems().add(linha);
                }
            }

        }
    }

    // método responsável por limpar as tabelas
    public void chamarLimparArquivo(){
        // definindo cabeçalhos
        String cabecalhoEntrada = "cliente;telefone;placa;modelo;horario_de_entrada";
        String cabacalhoSaida = "cliente;telefone;placa;modelo;horario_de_entrada;horario_de_saida;permanencia;preco";

        // chama o método de limpar arquivo csv para os dois arquivos
        arquivo.limparArquivo(caminhoEntrada, cabecalhoEntrada);
        arquivo.limparArquivo(caminhoSaida, cabacalhoSaida);
    }

}
