package br.com.erick.principal;

import br.com.erick.modelos.Conversor;
import br.com.erick.modelos.Moedas;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaMoedas {
    public Conversor moedasParaBuscar() throws IOException, InterruptedException{

        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/3b80df9c7301f73acbfdda1f/latest/USD");

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        System.out.println(json);
        Conversor conversor = gson.fromJson(json, Conversor.class);
        System.out.println(conversor);

        Moedas moedas = new Moedas(conversor.conversion_rates());
        System.out.println(moedas);

        System.out.println(moedas.getEuro());
        System.out.println(moedas.getReal());
        System.out.println(moedas.getPesoArgentino());
        System.out.println(moedas.getDolar());
        System.out.println(moedas.getYuan());
        System.out.println(moedas.getRublo());

        return conversor;
    }
}
