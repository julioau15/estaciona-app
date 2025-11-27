package br.senai.sp.jandira.estacionamentoApp;
import br.senai.sp.jandira.estacionamentoApp.repository.ArquivoCsv;

public class EstacionamentoApp {
    public static void main(String[] args) {
        ArquivoCsv repository = new ArquivoCsv();
        String caminho1 = "C:\\Users\\25203694\\IdeaProjects\\estaciona-app\\src\\br\\senai\\sp\\jandira\\estacionamentoApp\\data\\veiculos_estacionados.csv";
        String caminho2 = "C:\\Users\\25203694\\IdeaProjects\\estaciona-app\\src\\br\\senai\\sp\\jandira\\estacionamentoApp\\data\\historico_saidas.csv";
        String cabecalho1 = "cliente;telefone;placa;modelo;horario_de_entrada";
        String cabecalho2 = "cliente;telefone;placa;modelo;horario_de_entrada;permanencia;preco";
        repository.limparArquivo(caminho1, cabecalho1);
        repository.limparArquivo(caminho2, cabecalho2);

    }
}
