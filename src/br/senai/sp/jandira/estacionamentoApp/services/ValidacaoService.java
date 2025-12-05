package br.senai.sp.jandira.estacionamentoApp.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacaoService {
    public boolean validarNome(String nome) {
        // Valida se o nome não está vazio e contém apenas letras e espaços
        if (nome == null) {
            return false;
        }
        String nomeLimpo = nome.trim();
        // Regex para letras (maiúsculas/minúsculas, acentuadas) e espaços
        Pattern pattern = Pattern.compile("^[A-Za-zÀ-ÿ\\s]+$");
        Matcher matcher = pattern.matcher(nomeLimpo);
        return matcher.matches();
    }

    public boolean validarTelefone(String telefone) {
        // Valida telefone no formato:
        // - (11) 99999-9999
        // - 11999999999
        if (telefone == null) {
            return false;
        }

        String telefoneLimpo = telefone.trim();
        String padrao = "^\\(?\\d{2}\\)?\\s?\\d{4,5}-?\\d{4}$";
        Pattern pattern = Pattern.compile(padrao);
        Matcher matcher = pattern.matcher(telefoneLimpo);
        return matcher.matches();
    }

    public boolean validarPlaca(String placa) {
        // Valida placas no padrão brasileiro:
        // - ABC-1234 (Padrão Antigo)
        // - ABC1D23 (Padrão Mercosul)
        if (placa == null) {
            return false;
        }
        String placaLimpa = placa.trim().toUpperCase();

        // Padrão Antigo: 3 letras, hífen, 4 números
        String padraoAntigo = "^[A-Z]{3}-\\d{4}$";
        // Padrão Mercosul: 3 letras, 1 número, 1 letra, 2 números
        String padraoMercosul = "^[A-Z]{3}\\d[A-Z]\\d{2}$";

        Pattern patternAntigo = Pattern.compile(padraoAntigo);
        Pattern patternMercosul = Pattern.compile(padraoMercosul);

        return patternAntigo.matcher(placaLimpa).matches() || patternMercosul.matcher(placaLimpa).matches();
    }

    public boolean validarModelo(String modelo) {
        // Valida se o modelo não está vazio
        if (modelo == null) {
            return false;
        }
        // Verifica se a string, após remover espaços no início e fim, não está vazia
        return !modelo.trim().isEmpty();
    }
}