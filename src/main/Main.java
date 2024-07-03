package main;

import main.api.ExchangeRateAPI;
import main.models.ConverterMoeda;
import main.models.GravarConversao;
import main.models.Moedas;
import main.utils.gson.TaxasDeConversaoDaMoeda;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Map<Integer, GravarConversao> conversoes = new HashMap<>();
        int contConversao = 0;

        Scanner scanner = new Scanner(System.in);

        do {
            // Exibe o menu de seleção da moeda de origem
            exibirMenuMoedaOrigem();

            String moedaOrigem = null;
            boolean validarMoedaOrigem;
            do {
                System.out.print("Digite: ");
                var moedaOrigemId = scanner.nextInt();

                // Consumir a nova linha deixada pelo scanner.nextInt()
                scanner.nextLine();

                switch (moedaOrigemId) {
                    case 1:
                        moedaOrigem = "USD"; // Código da moeda
                        validarMoedaOrigem = true;
                        break;
                    case 2:
                        moedaOrigem = "EUR"; // Código da moeda
                        validarMoedaOrigem = true;
                        break;
                    case 3:
                        moedaOrigem = "BRL"; // Código da moeda
                        validarMoedaOrigem = true;
                        break;
                    case 4:
                        moedaOrigem = "GBP"; // Código da moeda
                        validarMoedaOrigem = true;
                        break;
                    case 5:
                        moedaOrigem = "JPY"; // Código da moeda
                        validarMoedaOrigem = true;
                        break;
                    case 6:
                        moedaOrigem = "CHF"; // Código da moeda
                        validarMoedaOrigem = true;
                        break;
                    case 7:
                        System.out.print("Saindo do Conversor de Moedas...");
                        validarMoedaOrigem = true;
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção inválida. Digite um número de 1 a 7.");
                        validarMoedaOrigem = false;
                        break;
                }
            } while (!validarMoedaOrigem);

            // Solicita o valor a ser convertido
            System.out.print("Digite o valor em " + Moedas.getSimbolo(moedaOrigem) + "(" + moedaOrigem + "): ");
            var valorMoedaUsuario = scanner.nextDouble();

            // Consumir a nova linha deixada pelo scanner.nextDouble()
            scanner.nextLine();

            // Cria um objeto para consultar as taxas de conversão
            ExchangeRateAPI consultarDadosDaMoeda = new ExchangeRateAPI(moedaOrigem);

            // Exibe o menu de seleção da moeda de destino
            exibirMenuMoedaDestino();

            String moedaDestino = null;
            boolean validarMoedaDestino;
            do {

                System.out.print("Digite: ");
                var moedaDestinoId = scanner.nextInt();

                // Consumir a nova linha deixada pelo scanner.nextInt()
                scanner.nextLine();

                switch (moedaDestinoId) {
                    case 1:
                        moedaDestino = "USD"; // Código da moeda
                        validarMoedaDestino = true;
                        break;
                    case 2:
                        moedaDestino = "EUR"; // Código da moeda
                        validarMoedaDestino = true;
                        break;
                    case 3:
                        moedaDestino = "BRL"; // Código da moeda
                        validarMoedaDestino = true;
                        break;
                    case 4:
                        moedaDestino = "GBP"; // Código da moeda
                        validarMoedaDestino = true;
                        break;
                    case 5:
                        moedaDestino = "JPY"; // Código da moeda
                        validarMoedaDestino = true;
                        break;
                    case 6:
                        moedaDestino = "CHF"; // Código da moeda
                        validarMoedaDestino = true;
                        break;
                    case 7:
                        System.out.print("Saindo do Conversor de Moedas...");
                        validarMoedaDestino = true;
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção inválida. Digite um número de 1 a 7.");
                        validarMoedaDestino = false;
                        break;
                }
            } while (!validarMoedaDestino);

            // Consulta a taxa de conversão
            TaxasDeConversaoDaMoeda consultarTaxaDeConversao = new TaxasDeConversaoDaMoeda(consultarDadosDaMoeda.getRespostaConsultaAPI()); // Aqui você precisa obter as taxas de conversão da API.

            // Realiza a conversão
            Double taxa = consultarTaxaDeConversao.getTaxaDeConversao(moedaDestino);
            ConverterMoeda conversaoDoUsuario = new ConverterMoeda(valorMoedaUsuario, taxa);

            double valorConvertido = conversaoDoUsuario.getResultado();

            // Contagem de conversões
            contConversao++;

            // Imprime o resultado
            System.out.printf("\n--------------- Conversão: %d ---------------\n\n", contConversao);
            System.out.printf("%s%.2f[%s] equivale a %s%.2f[%s] \n", Moedas.getSimbolo(moedaOrigem), valorMoedaUsuario, moedaOrigem, Moedas.getSimbolo(moedaDestino), valorConvertido, moedaDestino);
            System.out.println("--------------------------------------------\n");

            // Listar conversões
            String gravarConversao;
            do {
                System.out.println("Deseja gravar essa conversão? (Sim/Não)");
                gravarConversao = scanner.nextLine();

                if (!gravarConversao.equalsIgnoreCase("não") && !gravarConversao.equalsIgnoreCase("sim")) {
                    System.out.println("Digite \"Sim\" ou \"Não\"");
                }
            } while (!gravarConversao.equalsIgnoreCase("não") && !gravarConversao.equalsIgnoreCase("sim"));

            if (gravarConversao.equalsIgnoreCase("Sim")) {
                GravarConversao gravarConversaoNaLista = new GravarConversao(contConversao, valorMoedaUsuario, valorConvertido, moedaOrigem, moedaDestino);
                conversoes.put(contConversao, gravarConversaoNaLista);
            }

            // Visualizar Lista
            if (!conversoes.isEmpty()) { // Verifica se há conversões gravadas antes de perguntar
                String visualizarConversao;
                do {
                    System.out.println("Deseja ver alguma conversão que esteja gravada? (Sim/Não)");
                    visualizarConversao = scanner.nextLine();

                    if (!visualizarConversao.equalsIgnoreCase("não") && !visualizarConversao.equalsIgnoreCase("sim")) {
                        System.out.println("Digite \"Sim\" ou \"Não\"");
                    }

                } while (!visualizarConversao.equalsIgnoreCase("não") && !visualizarConversao.equalsIgnoreCase("sim"));

                int numeroDaConversao;
                do {
                    if (visualizarConversao.equalsIgnoreCase("sim")) {
                        System.out.print("Digite o número da posição da conversão: ");
                        numeroDaConversao = scanner.nextInt();
                        // Consumir a nova linha deixada pelo scanner.nextInt()
                        scanner.nextLine();

                        if (numeroDaConversao <= conversoes.size() && numeroDaConversao > 0) {
                            System.out.println(conversoes.get(numeroDaConversao) + "\n");
                            System.out.println("Deseja ver alguma outra conversão que esteja gravada? Se sim, digite \"sim\". Se não, digite qualquer coisa.");
                            var continuar = scanner.nextLine();
                            if (continuar.equalsIgnoreCase("sim")) {
                                continue;
                            } else {
                                break;
                            }

                        } else {
                            System.out.println("Conversão não encontrada para o número informado. Verifique o número da conversão e tente novamente.");
                        }

                    } else {
                        break;
                    }

                } while (true);
            }

            System.out.println("Deseja sair do Conversor de Moedas? Se sim, digite \"sim\". Se não, digite qualquer coisa.");
            String sairDoPrograma = scanner.nextLine();

            if (sairDoPrograma.equalsIgnoreCase("sim")) {
                System.out.print("Saindo do Conversor de Moedas...");
                System.exit(1);
            }

        } while (true);
    }

    // Método para exibir o menu de seleção da moeda de origem
    private static void exibirMenuMoedaOrigem() {
        System.out.println("""
                ************************************************
                Olá! Bem-vindo ao Conversor de Moeda!
                                
                Escolha a moeda que deseja converter:
                                
                1) Dólar
                2) Euro
                3) Real Brasileiro
                4) Libra Esterlina
                5) Iene Japonês
                6) Franco Suíço
                                
                7) Sair do Conversor de Moeda.
                                
                Digite o número da moeda desejada(1 a 6),
                ou 7 para sair.
                ************************************************
                """);
    }

    // Método para exibir o menu de seleção da moeda de destino
    private static void exibirMenuMoedaDestino() {
        System.out.println("""
                ************************************************
                Agora escolha para qual moeda deseja converter:
                                
                1) Dólar
                2) Euro
                3) Real Brasileiro
                4) Libra Esterlina
                5) Iene Japonês
                6) Franco Suíço
                                
                7) Sair do Conversor de Moeda.
                                
                Digite o número da moeda desejada(1 a 6),
                ou 7 para sair.
                ************************************************
                """);
    }
}