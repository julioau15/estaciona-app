package br.senai.sp.jandira.estacionamentoApp.repository;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;


public class ArquivoCsv {
    //    função que vai ler o arquivo csv
    public String[] lerCsv(String caminho){
        String[] dados = null;


        try {
            // Lê todas as linhas em uma lista
            List<String> linhas = Files.readAllLines(Paths.get(caminho), StandardCharsets.UTF_8);

            // Processa a lista
            for (String linha : linhas) {
                String[] colunas = linha.split(";");
                dados = colunas;
            }
    
            // pega a exceção
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dados;
    }

    // função que vai gravar os dados no arquivo csv
    public void gravarCsv(String caminho, String dados){
        Path arquivo = Path.of(caminho);
        dados = dados + "\n";
        // tenta gravar
        try{
            Files.writeString(arquivo, dados, StandardOpenOption.APPEND);

        }catch(IOException erro){
            
        }
    }

    // função que exclui a linha do veiculo se for igual a placa informada
    public void excluirVeiculo(String caminho, String placa){
        String[] dados = null;
        String[] dadosAtualizados = null;
        dados = lerCsv(caminho);
       
        for(int i = 0; i < dados.length; i++){
            if (dados[2].equals(placa)) {
                dadosAtualizados[i] = dados[i];
                String linha = dadosAtualizados[i];
                gravarCsv(caminho, linha);
            }else{
                
            }
        }

    }
}
