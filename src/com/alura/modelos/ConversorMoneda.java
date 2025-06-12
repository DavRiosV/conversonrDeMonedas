package com.alura.modelos;

import com.alura.service.ConsultaApi;
import com.google.gson.Gson;

public class ConversorMoneda {
    private final Gson gson = new Gson();
    private final ConsultaApi consultaApi = new ConsultaApi();

    public MoneyRate obtenerTasa(String base, String target) {
        String json = consultaApi.buscaDivisa(base, target);
        return gson.fromJson(json, MoneyRate.class);
    }
}
