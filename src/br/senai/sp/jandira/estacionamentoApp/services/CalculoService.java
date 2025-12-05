package br.senai.sp.jandira.estacionamentoApp.services;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CalculoService {

    // responsavel por calcular o preço
    public String calcularPreco(String horarioDeEntrada, String horarioDeSaida) {
        double horasTotais = calcularPermanenciaEmHoras(horarioDeEntrada, horarioDeSaida);
        double precoPrimeiraHora = 10.00;
        double precoHorasAdicionais = 5.00;

        // se for menor ou igual a 0 o preço é nulo
        if (horasTotais <= 0) {
            return String.format("%.2f", 0.0);
        }


        // arredonda as horas
        int horasACobrar = (int) Math.ceil(horasTotais);

        double precoTotal = 0.0;

        // se as horas forem menores ou iguais a 1, o preço é igual a 10
        if (horasACobrar <= 1) {
            precoTotal = precoPrimeiraHora;

        // se nao o preço é igual a 10 + (horas seguintes * 5)
        } else {
            precoTotal = precoPrimeiraHora;
            int horasAdicionais = horasACobrar - 1;

            precoTotal += horasAdicionais * precoHorasAdicionais;
        }

        return String.format("%.2f", precoTotal);
    }


    // responsavel por calcular o tempo de permanencia
    public double calcularPermanenciaEmHoras(String horarioDeEntrada, String horarioDeSaida){
        // define o formatter do DateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // transforma as Strings em DateTime
        LocalDateTime entrada = LocalDateTime.parse(horarioDeEntrada, formatter);
        LocalDateTime saida = LocalDateTime.parse(horarioDeSaida, formatter);

        // calcula a diferença de tempo
        Duration duration = Duration.between(entrada, saida);


        // retorna as horas no formato double
        return duration.toSeconds() / 3600.0;
    }
}
