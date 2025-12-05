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
    String caminhoSaida = "/Users/SAMSUNG/P.I/java/src/br/senai/sp/jandira/estacionamentoApp/data/historico_saidas.csv";

    public void registrarEntrada(String cliente, String telefone , String placa, String modelo){
        Veiculo veiculo = new Veiculo(cliente, telefone, placa, modelo);
        String dados = veiculo.transformarEmString();
        arquivoCsv.gravarCsv(caminhoEntrada, dados);
    }

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
        for(String veiculoLinha : veiculo){
            dadosEntrada = veiculoLinha.trim().split(";");

            if (dadosEntrada[2].equalsIgnoreCase(placa)){
                cliente = dadosEntrada[0];
                telefone = dadosEntrada[1];
                modelo = dadosEntrada[3];
                horarioDeEntrada = dadosEntrada[4];
                String a = String.valueOf(calculoService.calcularPreco(horarioDeEntrada, horarioDeSaida));
                dados = cliente + ";" + telefone + ";" + modelo + ";" + horarioDeEntrada + ";" + horarioDeSaida + ";" + a + ";";
            } else {
                System.out.println("Veiculo não encontrado");
            }

        }
    }



}
