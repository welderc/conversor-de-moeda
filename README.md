# Conversor de Moeda em Java

## Descrição do projeto

<p align="justify">
Este projeto é um desafio do <b>ONE (Challenges ONE)</b>, uma iniciativa da Oracle e Alura, inspirado no modelo de <b>Aprendizagem Baseada em Desafios (Challenge Based Learning)</b> da Apple. Desenvolvido pela ONE e com o apoio da Apple, o projeto visa criar um conversor de moedas que utiliza a API <b>ExchangeRate-API</b> para obter taxas de câmbio. O usuário pode filtrar e exibir as moedas de seu interesse, tornando a experiência mais personalizada.
</p>

## Objetivo
<p align="justify">
Desenvolver um Conversor de Moedas que ofereça interação textual (via console) com os usuários, proporcionando no mínimo 6 opções distintas de conversões de moedas em um menu. A taxa de conversão não será estática, mas sim dinamicamente obtida por meio de uma API, garantindo dados precisos e em tempo real para uma experiência mais atualizada e eficaz.
</p>

## Funcionalidades

:heavy_check_mark: `Funcionalidade 1:` Configuração do Ambiente Java.

:heavy_check_mark: `Funcionalidade 2:` Criação do Projeto.

:heavy_check_mark: `Funcionalidade 3:` Consumo da API.

:heavy_check_mark: `Funcionalidade 4:` Análise da Resposta JSON.

:heavy_check_mark: `Funcionalidade 5:` Filtro de Moedas.

:heavy_check_mark: `Funcionalidade 6:` Exibição de Resultados aos Usuários.

:heavy_check_mark: `Funcionalidade 7:` Permitir que o usuário guarde as conversões que desejar.

:heavy_check_mark: `Funcionalidade 8:` A aplicação exibe os resultados que o usuário guardou, mostrando a data e o horário de cada salvamento.

## Aplicação

```
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

Digite: 1
Digite o valor em $(USD): 1
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

Digite: 3

--------------- Conversão: 1 ---------------

$1,00[USD] equivale a R$5,67[BRL] 
--------------------------------------------

Deseja gravar essa conversão? (Sim/Não)
sim
Deseja ver alguma conversão que esteja gravada? (Sim/Não)
sim
Digite o número da posição da conversão: 1

---------------- Conversão: 1 ----------------
Moeda original: $1.0 USD 
Moeda convertida: R$5.6685 BRL 

Data e Hora da coversão: (dia)/(mês)/(ano) (Horas):(minutos):(segundos)
----------------------------------------------

Deseja ver alguma outra conversão que esteja gravada? Se sim, digite "sim". Se não, digite qualquer coisa.
Sim
Digite o número da posição da conversão: 2
Conversão não encontrada para o número informado. Verifique o número da conversão e tente novamente.
Digite o número da posição da conversão: 0
Conversão não encontrada para o número informado. Verifique o número da conversão e tente novamente.
Digite o número da posição da conversão: 1

---------------- Conversão: 1 ----------------
Moeda original: $1.0 USD 
Moeda convertida: R$5.6685 BRL 

Data e Hora da coversão: (dia)/(mês)/(ano) (Horas):(minutos):(segundos)
----------------------------------------------

Deseja ver alguma outra conversão que esteja gravada? Se sim, digite "sim". Se não, digite qualquer coisa.
não

Deseja sair do Conversor de Moedas? Se sim, digite "sim". Se não, digite qualquer coisa.
sim
Saindo do Conversor de Moedas...
Process finished with exit code 1
```

## Ferramentas utilizadas
<ul align = "justify">
    <li><b>Java: </b>Linguagem de programação utilizada para desenvolver o projeto. Versão: 21</li><br>
    <li><b>ExchangeRate-API: </b>API utilizada para consultar taxas de câmbio.</li><br>
    <li><b>Gson: </b>Biblioteca utilizada para converter objetos Java em JSON e vice-versa. Versão: 2.11.0</li><br>
</ul>

**Contribuições:**
<p align="justify">
Contribuições são bem-vindas! Se você deseja contribuir para este projeto, abra um problema ou envie uma solicitação de pull.
</p>

## :robot: Tecnologias

![Java](https://img.shields.io/badge/Java-ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
