package br.senai.sp.jandira.estacionamentoApp.services;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class CalculoService {

    public String calcularPreco(String horarioDeEntrada, String horarioDeSaida) {
        double horasTotais = calcularPermanenciaEmHoras(horarioDeEntrada, horarioDeSaida);
        double precoTotal = 0.0;
        int minutos;

        int horas = (int) horasTotais;

        if (horas <= 1){
            precoTotal = 10;
        }
        minutos = (int) (horasTotais / 60);
        System.out.println(minutos);

        if (minutos >= 5){
            horas ++;
            precoTotal = 10 + (horas - 1)*5;
        }

        String preco = String.format("%.2f", precoTotal);
        return preco;
    }


    public double calcularPermanenciaEmHoras(String horarioDeEntrada, String horarioDeSaida){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime entrada = LocalDateTime.parse(horarioDeEntrada, formatter);
        LocalDateTime saida = LocalDateTime.parse(horarioDeSaida, formatter);

        Duration duration = Duration.between(entrada, saida);


        double horasDecimais = duration.toSeconds() / 3600.0;

        return horasDecimais;
    }
}
