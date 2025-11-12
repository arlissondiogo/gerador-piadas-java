package br.com.estudoAPI;

import br.com.estudoAPI.model.Piadas;
import br.com.estudoAPI.service.PiadaService;
import br.com.estudoAPI.util.ConsoleUtil;

public class Application {
    public static void main(String[] args) {
        PiadaService service = new PiadaService();

        do {
            String categoria = ConsoleUtil.lerCategoria();
            Piadas piada = service.buscarPiada(categoria);
            ConsoleUtil.exibirPiada(piada);
        } while (ConsoleUtil.desejaContinuar());

        ConsoleUtil.fechar();
        System.out.println("👋 Até a próxima!");
    }
}
