package main.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GravarConversao {
    private int numeroDaConversao;
    private double valorMoedaUsuario;
    private double valorConvertido;
    private String moedaOrigem;
    private String moedaDestino;

    private String dataHoraDaConversao;

    public GravarConversao(int numeroDaConversao, double valorMoedaUsuario, double valorConvertido, String moedaOrigem, String moedaDestino) {
        this.numeroDaConversao = numeroDaConversao;
        this.valorMoedaUsuario = valorMoedaUsuario;
        this.valorConvertido = valorConvertido;
        this.moedaOrigem = moedaOrigem;
        this.moedaDestino = moedaDestino;

        this.dataHoraDaConversao = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    // Gravar na lista de conversões
    @Override
    public String toString() {
        return "\n---------------- Conversão: " + numeroDaConversao + " ----------------\n" +
                "Moeda original: " + Moedas.getSimbolo(moedaOrigem) + valorMoedaUsuario + " " + moedaOrigem + " " + "\n" +
                "Moeda convertida: " + Moedas.getSimbolo(moedaDestino) + valorConvertido + " " + moedaDestino + " " + "\n\n" +
                "Data e Hora da coversão: " + dataHoraDaConversao + "\n" +
                "----------------------------------------------";
    }
}
