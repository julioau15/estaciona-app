package br.senai.sp.jandira.estacionamentoApp.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RegistroService {
//    função que vai ler o arquivo csv
    public String[] lerCsv(String arquivo){


        try {
            // Lê todas as linhas em uma lista
            List<String> linhas = Files.readAllLines(Paths.get(arquivo), StandardCharsets.UTF_8);

            // Processa a lista
            for (String linha : linhas) {
                String[] colunas = linha.split(",");
                System.out.println("Primeira coluna: " + colunas[0] + ", Segunda coluna: " + colunas[1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
