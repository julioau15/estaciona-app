package br.senai.sp.jandira.estacionamentoApp.services;


import br.senai.sp.jandira.estacionamentoApp.model.Veiculo;
import br.senai.sp.jandira.estacionamentoApp.repository.ArquivoCsv;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RegistroService {
    ArquivoCsv arquivoCsv = new ArquivoCsv();
    CalculoService calculoService = new CalculoService();

    //em fase de teste alterar o usuario "25203700" para seu proprio usuario
    String caminhoEntrada = "/Users/SAMSUNG/P.I/java/src/br/senai/sp/jandira/estacionamentoApp/data/veiculos_estacionados.csv";
    String caminhoSaida = "/Users/SAMSUNG/P.I/java//src/br/senai/sp/jandira/estacionamentoApp/data/historico_saidas.csv";

    // método responsavel por registrar entradas
    public void registrarEntrada(String cliente, String telefone , String placa, String modelo){

        // Organizar os dados em String e gravar utilizando o metodo gravarCsv
        Veiculo veiculo = new Veiculo(cliente, telefone, placa, modelo);
        String dados = veiculo.transformarEmString();
        arquivoCsv.gravarCsv(caminhoEntrada, dados);
    }

    // metodo responsavel por registrar saida
    public void registrarSaida(String placa){
        List<String> veiculo = arquivoCsv.lerCsv(caminhoEntrada);
        String[] dadosEntrada;
        String dados;
        String cliente;
        String telefone;
        String modelo;
        String horarioDeEntrada;
        String horarioDeSaida = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String permanecia;
        String preco;

        // para cada linha no veiculo:
        for(String veiculoLinha : veiculo){
            // separa os dados por ';'
            dadosEntrada = veiculoLinha.trim().split(";");

            // se a placa do veiculo estacionado for igual a placa do veiculo selecionado:
            if (dadosEntrada[2].equalsIgnoreCase(placa)){
                cliente = dadosEntrada[0];
                telefone = dadosEntrada[1];
                modelo = dadosEntrada[3];
                horarioDeEntrada = dadosEntrada[4];
                permanecia = String.format("%.2f", calculoService.calcularPermanenciaEmHoras(horarioDeEntrada, horarioDeSaida)); // calcular o tempo de permanencia
                preco = String.valueOf(calculoService.calcularPreco(horarioDeEntrada, horarioDeSaida));  // calcular o preço
                dados = cliente + ";" + telefone + ";" + placa + ";" + modelo + ";" + horarioDeEntrada + ";" + horarioDeSaida + ";" + permanecia + ";" + preco;

                arquivoCsv.gravarCsv(caminhoSaida, dados); // grava os dados no historico
                arquivoCsv.excluirVeiculo(caminhoEntrada, placa); // exclui a linha dos veiculos estacionados
            }

        }
    }



}
