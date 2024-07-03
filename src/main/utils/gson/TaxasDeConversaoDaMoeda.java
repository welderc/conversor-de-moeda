package main.utils.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;

// Classe para lidar com taxas de conversão de moedas
public class TaxasDeConversaoDaMoeda {

    private JsonObject jsonObject; // Objeto JSON com as taxas de conversão
    private Map<String, Double> taxas; // Mapa com código do país e taxa de conversão

    // Construtor da classe
    public TaxasDeConversaoDaMoeda(String jsonString) {
        this.jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
        this.taxas = extrairTaxas();
    }

    // Retorna a taxa de conversão
    public Double getTaxaDeConversao(String codigoPais) {
        return taxas.get(codigoPais);
    }

    // Extrai as taxas de conversão do objeto JSON.
    private Map<String, Double> extrairTaxas() {
        Map<String, Double> taxas = new HashMap<>();
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

        // Itera pelas entradas do objeto "conversion_rates"
        for (Map.Entry<String, JsonElement> entrada : conversionRates.entrySet()) {
            String codigoPais = entrada.getKey();
            // Atribui valor a lista "Map" de taxas
            taxas.put(codigoPais, entrada.getValue().getAsDouble());
        }

        return taxas;
    }
}