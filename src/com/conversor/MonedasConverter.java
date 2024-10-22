package com.conversor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import org.json.JSONObject;

public class MonedasConverter {

    private static final String API_KEY = "7ae95ceba0a973459ffa785f";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static double obtenerTasaDeCambio(String monedaOrigen, String monedaDestino) throws IOException, InterruptedException {
        String url = API_URL + monedaOrigen;

        // Crear cliente HTTP
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        // Enviar solicitud y recibir respuesta
        HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

        // Parsear respuesta JSON
        JSONObject jsonRespuesta = new JSONObject(respuesta.body());

        if (!jsonRespuesta.getString("result").equals("success")) {
            throw new IOException("Error al obtener los datos de la tasa de cambio");
        }

        // Devolver la tasa de cambio para la moneda de destino
        return jsonRespuesta.getJSONObject("conversion_rates").getDouble(monedaDestino);
    }
}
