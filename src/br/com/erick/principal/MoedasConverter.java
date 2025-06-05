package br.com.erick.principal;

import br.com.erick.modelos.Moedas;

import java.io.IOException;
import java.util.Scanner;

public class MoedasConverter {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        int opc = 0;
        double valor;
        BuscaMoedas novaBusca = new BuscaMoedas();

        Moedas moedas = new Moedas(novaBusca.moedasParaBuscar().conversion_rates());
        System.out.println(moedas);

        Conversao novaConversao = new Conversao(moedas);

        System.out.println(novaBusca.moedasParaBuscar());

        while (opc != 7){
            System.out.println("**************************");
            System.out.println("Sejam Bem-vindos ao Coverte Money\n");

            System.out.println("     1)Dólar ==> Real Brasileiro\n" +
                    "                2) Real brasileiro ==>> Dólar \n" +
                    "                3) Euro ==>> Real Brasileiro \n" +
                    "                4) Yuan ==> Real Brasileiro \n" +
                    "                5) Rublo ==> Real Brasileiro\n" +
                    "                6) Peso ==> Real\n"+
                    "                7) Sair");
            System.out.println("Escolha uma opção: ");
            System.out.println("************************");

            opc = leitura.nextInt();

            if (opc == 7){
                break;
            }

            System.out.println("Digite o valor que deseja converter");
            valor = leitura.nextDouble();

            switch (opc){
                case 1:
                    System.out.println("Valor: " + valor + "[USD] corresponde ao valor final de ==> " + novaConversao.dolarParaReal(valor) + "[BRL]");
                    break;
                case 2:
                    System.out.println("Valor: " + valor + "[BRL] corresponde ao valor final de ==> " + novaConversao.realParaDolar(valor) + "[USD]" );
                    break;
                case 3:
                    System.out.println("Valor: "+ valor + "[EUR] corresponde ao valor final de ==> " + novaConversao.euroParaReal(valor) + "[BRL]");
                    break;
                case 4:
                    System.out.println("Valor: " + valor + "[CNY] corresponde ao valor final de ==> " + novaConversao.yuanParaReal(valor) + "[BRL]");
                    break;
                case 5:
                    System.out.println("Valor: " + valor + "[RUB] corresponde ao valor final de ==> " + novaConversao.rubloParaReal(valor) + "[BRL]");
                    break;
                case 6:
                    System.out.println("Valor"+ valor + "[ARS] corresponde ao valor final de ==> " + novaConversao.pesoParaReal(valor) + "[BRL]");
                    break;
                default:
                    System.out.println("Opção invalida! Digite a opçãod de 1 ao 7");
                    break;
            }
        }
        leitura.close();
    }
}
