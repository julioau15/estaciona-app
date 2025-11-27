package br.senai.sp.jandira.estacionamentoApp;
import br.senai.sp.jandira.estacionamentoApp.repository.ArquivoCsv;

public class EstacionamentoApp {
    public static void main(String[] args) {
        ArquivoCsv repository = new ArquivoCsv();
        String caminho = "C:\\Users\\25203694\\IdeaProjects\\estaciona-app\\src\\br\\senai\\sp\\jandira\\estacionamentoApp\\data\\veiculos_estacionados.csv";
        String placa = "abc-1234";
        repository.excluirVeiculo(caminho, placa);

    }
}
