package br.senai.sp.jandira.estacionamentoApp;
import br.senai.sp.jandira.estacionamentoApp.repository.ArquivoCsv;

public class EstacionamentoApp {
    public static void main(String[] args) {
        ArquivoCsv repository = new ArquivoCsv();
        String caminho = "C:\\Users\\Professor\\Desktop\\estaciona-app\\src\\br\\senai\\sp\\jandira\\estacionamentoApp\\data\\veiculos_estacionados.csv"; 
        String placa = "abc";
        repository.excluirVeiculo(caminho, placa);

    }
}
