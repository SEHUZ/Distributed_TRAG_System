/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.clienteshttp;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dtos.customer.CustomerDetailDTO;
import dtos.customer.CustomerSummaryDTO;
import presentacion.interfaces.backend.IAdministradorClientes;
import presentacion.utils.Sesion;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public class ClienteHttpClientes implements IAdministradorClientes {

    private static final String BASE_URL = "http://localhost:8080/api/customers";

    private final HttpClient httpClient;
    private final Gson gson;

    public ClienteHttpClientes() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    @Override
    public List<CustomerSummaryDTO> obtenerTodosClientes() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .header("Authorization", "Bearer " + Sesion.getToken())
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            Type listType = new TypeToken<List<CustomerSummaryDTO>>() {
            }.getType();
            return gson.fromJson(response.body(), listType);
        } else if (response.statusCode() == 401) {
            throw new Exception("No autorizado. El token expiró o es inválido.");
        } else {
            throw new Exception("Error del servidor HTTP " + response.statusCode() + ": " + response.body());
        }
    }

    @Override
    public CustomerDetailDTO obtenerCliente(Long idCliente) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + idCliente))
                .header("Authorization", "Bearer " + Sesion.getToken())
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return gson.fromJson(response.body(), CustomerDetailDTO.class);
        } else {
            throw new Exception("Error al obtener el cliente " + idCliente + ". HTTP " + response.statusCode());
        }
    }
}
