package br.com.estudoAPI.config;

import br.com.estudoAPI.model.Piadas;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.URLEncoder;
import java.net.URLDecoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class ConfigApi {
    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    public Piadas gerarPiadas(String category) {
        String endpoint = "https://v2.jokeapi.dev/joke/" + category + "?lang=en&type=twopart";

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endpoint))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), Piadas.class);

        } catch (Exception e) {
            throw new RuntimeException("ERRO AO GERAR PIADA: " + e.getMessage());
        }
    }

    public String traduzirTexto(String texto) {
        try {
            String textoCodificado = URLEncoder.encode(texto, StandardCharsets.UTF_8);
            String langpair = URLEncoder.encode("en|pt", StandardCharsets.UTF_8);

            String url = "https://api.mymemory.translated.net/get?q=" + textoCodificado + "&langpair=" + langpair;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject json = gson.fromJson(response.body(), JsonObject.class);

            String traduzido = json.getAsJsonObject("responseData")
                    .get("translatedText")
                    .getAsString();

            traduzido = URLDecoder.decode(traduzido, StandardCharsets.UTF_8);

            traduzido = traduzido
                    .replace("%0A", "\n")
                    .replace("%22", "\"")
                    .replace("%27", "'")
                    .replace("%2C", ",")
                    .replace("%3F", "?")
                    .replace("%21", "!")
                    .replace("%2E", ".")
                    .replace(" 't", " não")
                    .replace("'t", " não")
                    .replace("'s", " é")
                    .replace("'re", " são")
                    .replace("  ", " ")
                    .trim();

            return traduzido;

        } catch (Exception e) {
            System.out.println("⚠️ Erro ao traduzir texto: " + e.getMessage());
            return texto;
        }
    }

}
