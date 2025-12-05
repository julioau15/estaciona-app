package br.senai.sp.jandira.estacionamentoApp;
import br.senai.sp.jandira.estacionamentoApp.model.Veiculo;
import br.senai.sp.jandira.estacionamentoApp.repository.ArquivoCsv;
import br.senai.sp.jandira.estacionamentoApp.services.RegistroService;

public class EstacionamentoApp {
    public static void main(String[] args) {
       String cliente = "julio";
       String telefone = "123456789";
       String modelo = "Gol";
       String placa = "abc-1234";
        RegistroService registroService = new RegistroService();
        registroService.registrarSaida(placa);

    }
}
