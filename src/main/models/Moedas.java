package main.models;

import java.util.HashMap;
import java.util.Map;

// Receber símbolo da moeda
public class Moedas {

    private static final Map<String, String> moedas = new HashMap<>();

    static {
        moedas.put("USD", "$");
        moedas.put("EUR", "€");
        moedas.put("BRL", "R$");
        moedas.put("GBP", "£");
        moedas.put("JPY", "¥");
        moedas.put("CHF", "CHF");
    }

    public static String getSimbolo(String codigoMoeda) {
        return moedas.get(codigoMoeda);
    }
}