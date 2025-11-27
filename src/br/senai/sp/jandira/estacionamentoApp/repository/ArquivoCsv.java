package br.senai.sp.jandira.estacionamentoApp.repository;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ArquivoCsv {
    //    função que vai ler o arquivo csv
    public List<String> lerCsv(String caminho) {
        String[] dados = null;

        //cria uma lista para armazenar as linhas do arquivo
        List<String> linhas = null;
        try {
            // Lê todas as linhas em uma lista
            linhas = Files.readAllLines(Paths.get(caminho), StandardCharsets.UTF_8);

            // pega a exceção
        } catch (IOException e) {
            e.printStackTrace();
        }

        return linhas;
    }

    // função que vai gravar os dados no arquivo csv
    public void gravarCsv(String caminho, String dados){
        Path arquivo = Path.of(caminho);
        dados = dados + "\n";
        // tenta gravar
        try{
            Files.writeString(arquivo, dados, StandardOpenOption.APPEND);

        }catch(IOException erro){
            erro.printStackTrace();
        }
    }

    // função que exclui a linha do veiculo se for igual a placa informada
    public void excluirVeiculo(String caminho, String placa){
        String[] dados = null;
        List<String> linhas;
        List<String> dadosAtualizados = new java.util.ArrayList<>();
        linhas = lerCsv(caminho);


        for(String linha : linhas){ // para cada linha na lista:
            dados = linha.split(";");
            if(!dados[2].equalsIgnoreCase(placa)){ // se não for igual a placa adiciona a linha nos dados atualizados
                dadosAtualizados.add(linha);
            }
        }

        // tenta escrever os dados atualizados no arquivo veiculos_estacionados.csv
        try {
            if (!dadosAtualizados.isEmpty()) {
                Files.write(Paths.get(caminho), dadosAtualizados, StandardCharsets.UTF_8);
            }else{
                System.out.println("Veiculo não encontrado.");
            }

        }catch(IOException erro){
            erro.printStackTrace();
        }
    }

    public void limparArquivo(String caminho, String cabecalho){
        try {
            Files.write(Paths.get(caminho), Collections.singleton(cabecalho), StandardCharsets.UTF_8);
            }catch(IOException erro){
            erro.printStackTrace();
        }
    }


}
