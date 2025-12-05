//package br.senai.sp.jandira.estacionamentoApp.ui;
//
//import br.senai.sp.jandira.estacionamentoApp.EstacionamentoApp;
//import javafx.application.Application;
//import javafx.geometry.Insets;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.Pane;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//public class TelaEntrada extends Application{
//    @Override
//    public void start(Stage stage) throws Exception {
//        stage.setTitle("Projeto Integrador");
//        stage.setResizable(true);
//        stage.setHeight(500);
//        stage.setWidth(500);
//
//        //Criar o root componente principal de layout
//        VBox root = new VBox();
//        root.setPadding(new Insets(10));
//        root.setStyle("-fx-background-color: #6c00a9");
//
//        //Criamos a cena e colocamos o root nela
//        Scene scene = new Scene(root);
//
//        //Criar o header da tela
//        VBox header = new VBox();
//        header.setPrefHeight(100);
//        header.setPadding(new Insets(10));
//        header.setStyle("-fx-background-color: rgba(194,158,255,0.84)");
//
//        Label titulo = new Label("Painel de controle Estacionamento");
//
//        Label descricao = new Label("Gerencie a entrada e saída dos veículos");
//
//        //criar painel de botoes
//        Pane paneButtons = new Pane();
//        paneButtons.setPadding(new Insets(10));
//        HBox boxButtons = new HBox();
//        boxButtons.setPadding(new Insets(5));
//        boxButtons.setSpacing(10);
//
//        //criar botoes
//        Button buttonEntrada = new Button("Entrada de veiculo");
//        Button buttonSaida = new Button("Saida de veiculo");
//        Button buttonLimpar = new Button("Limpar registros");
//        Button buttonSair = new Button("Sair");
//        paneButtons.getChildren().addAll(boxButtons);
//
//        //adicionar botoes
//        boxButtons.getChildren().addAll(buttonEntrada, buttonSaida, buttonLimpar, buttonSair);
//
//        TableView<EstacionamentoApp> tabela =new TableView<>();
//
//        TableColumn<EstacionamentoApp,String> modelo = new TableColumn<>("Nome");
//
//        tabela.getColumns().addAll(modelo);
//
//        //Conteudo do header
//        header.getChildren().addAll(titulo, descricao);
//        //conteudo do root
//        root.getChildren().addAll(header);
//        root.getChildren().addAll(paneButtons);
//        root.getChildren().addAll(tabela);
//
//        //Colocamos a cena no palco
//        stage.setScene(scene);
//        stage.show();
//    }
//}
