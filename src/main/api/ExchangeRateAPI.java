package main.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// API utilizada para a conversão
public class ExchangeRateAPI {
    private String moeda;
    private String respostaConsultaAPI;
    private boolean validarConsultaAPI;

    // Receber dados da API em String
    public String getRespostaConsultaAPI() throws Exception {
        if (this.validarConsultaAPI) {
            return respostaConsultaAPI;
        } else {
            throw new Exception("Sem dados da consulta da API");
        }
    }

    public ExchangeRateAPI(String moeda) {
        this.moeda = moeda;
        this.validarConsultaAPI = consultarMoeda(this.moeda);
    }

    public boolean consultarMoeda(String moeda) {

        URI URIApi = URI.create("https://v6.exchangerate-api.com/v6/[Sua chave API]/latest/" + moeda);

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URIApi)
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (!response.body().contains("\"result\":\"error\"")) {
                this.respostaConsultaAPI = response.body();
                return true;
            } else {
                return false;
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro de comunicação: " + e.getMessage());
            return false;
        }

    }
}
