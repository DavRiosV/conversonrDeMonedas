package com.alura.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {
    public String buscaDivisa(String base, String target) {
        String apiKey = "TU_API_KEY"; // Reemplaza con tu API Key
        String url = "https://v6.exchangerate-api.com/v6/11b56851098e4a96062395f5/latest/USD" + apiKey + "/pair/" + base + "/" + target;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al consultar la API: " + e.getMessage());
        }
    }
}
