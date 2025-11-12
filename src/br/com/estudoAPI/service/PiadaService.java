package br.com.estudoAPI.service;

import br.com.estudoAPI.config.ConfigApi;
import br.com.estudoAPI.model.Piadas;

public class PiadaService {
    private final ConfigApi configApi;

    public PiadaService() {
        this.configApi = new ConfigApi();
    }

    public Piadas buscarPiada(String category) {
        try {
            Piadas piadas = configApi.gerarPiadas(category);
            if (piadas == null || piadas.setup() == null || piadas.delivery() == null) {
                System.out.println("⚠️  Nenhuma piada válida foi retornada.");
                return null;
            }

            String setupTraduzido = configApi.traduzirTexto(piadas.setup());
            String deliveryTraduzido = configApi.traduzirTexto(piadas.delivery());

            return new Piadas(piadas.category(), setupTraduzido, deliveryTraduzido);

        } catch (Exception e) {
            System.out.println("❌ Erro ao buscar piada: " + e.getMessage());
            return null;
        }
    }
}
