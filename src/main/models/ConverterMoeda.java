package main.models;

public class ConverterMoeda {
    private double num1;
    private double num2;
    private double resultado;

    public ConverterMoeda(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
        this.resultado = num1 * num2;
    }

    public double getResultado() {
        return resultado;
    }
}
