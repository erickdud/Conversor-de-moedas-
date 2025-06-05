package br.com.erick.principal;

import br.com.erick.modelos.Moedas;

public class Conversao {
    private Moedas moedas = new Moedas();

    public Conversao(Moedas moedas){
        this.moedas = moedas;
    }


    //     Dólar ==>> Real Brasileiro
//                2) Real brasileiro ==>> Dólar
//                3) Euro ==>> Real Brasileiro
//                4) Yuan ==> Real Brasileiro
//                5) Rublo ==> Real Brasileiro
//                6) Euro ==>> Rublo

    public double dolarParaReal(double dolar){
        return dolar * moedas.getReal();
    }
    public double realParaDolar(double real){
        return real * moedas.getDolar();
    }
    public double euroParaReal(double real){
        return real * (moedas.getEuro()/ moedas.getReal());
    }
    public double yuanParaReal(double real){
        return real * (moedas.getYuan()/ moedas.getReal());
    }
    public double rubloParaReal(double real){
        return real * (moedas.getRublo()/ moedas.getReal());
    }
    public double pesoParaReal(double real){
        return real * (moedas.getPesoArgentino()/ moedas.getReal());
    }

}
