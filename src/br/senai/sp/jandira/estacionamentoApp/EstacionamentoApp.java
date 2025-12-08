package br.senai.sp.jandira.estacionamentoApp;
import br.senai.sp.jandira.estacionamentoApp.model.Veiculo;
import br.senai.sp.jandira.estacionamentoApp.repository.ArquivoCsv;
import br.senai.sp.jandira.estacionamentoApp.services.RegistroService;
import br.senai.sp.jandira.estacionamentoApp.ui.TelaEntrada;
import br.senai.sp.jandira.estacionamentoApp.ui.TelaPrincipal;
import javafx.application.Application;

public class EstacionamentoApp {
    public static void main(String[] args) {
       String cliente = "julio";
       String telefone = "123456789";
       String modelo = "Gol";
       String placa = "abc-1234";
        RegistroService registroService = new RegistroService();
        registroService.registrarSaida(placa);

        //Application.launch(TelaEntrada.class, args);
        Application.launch(TelaPrincipal.class, args);


    }
}
