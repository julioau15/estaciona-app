package br.senai.sp.jandira.estacionamentoApp;
import br.senai.sp.jandira.estacionamentoApp.model.Veiculo;
import br.senai.sp.jandira.estacionamentoApp.repository.ArquivoCsv;
import br.senai.sp.jandira.estacionamentoApp.services.RegistroService;
import br.senai.sp.jandira.estacionamentoApp.ui.TelaEntrada;
import br.senai.sp.jandira.estacionamentoApp.ui.TelaPrincipal;
import br.senai.sp.jandira.estacionamentoApp.ui.TelaSaida;
import javafx.application.Application;

public class EstacionamentoApp {
    public static void main(String[] args) {

        //Application.launch(TelaEntrada.class, args);
        Application.launch(TelaPrincipal.class, args);
        //Application.launch(TelaSaida.class, args);


    }
}
