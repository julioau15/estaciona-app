package br.senai.sp.jandira.estacionamentoApp.model;

import java.text.Format;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Veiculo {
    // declarando variaveis
    private String cliente;
    private String telefone;
    private String placa;
    private String modelo;
    private LocalDateTime horarioDeEntrada;

    // recebe os dados e define as variaveis
    public Veiculo(String cliente, String telefone , String placa, String modelo) {
        this.cliente = cliente;
        this.telefone = telefone;
        this.placa = placa;
        this.modelo = modelo;
        this.horarioDeEntrada = LocalDateTime.now(); // pega a data e o horario atual
    }

    // transforma em uma String separada por ";"
    public String transformarEmString(){
        String retorno = this.cliente + ";" + this.telefone + ";" + this.placa + ";" + this.modelo + ";" + this.horarioDeEntrada.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return retorno; // retorna a String
    }



}
