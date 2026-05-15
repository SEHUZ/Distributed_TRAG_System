/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.clienteshttp;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dtos.service.ServiceDetailDTO;
import dtos.service.ServiceSummaryDTO;
import dtos.supply.SupplySummaryDTO;
import presentacion.interfaces.backend.IAdministradorServicios;
import presentacion.interfaces.backend.IAdministradorInsumos;
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
public class ClienteHttpInventario implements IAdministradorServicios, IAdministradorInsumos {

    private static final String BASE_URL = "http://localhost:8080/api/catalog";
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    @Override
    public List<ServiceSummaryDTO> obtenerTodosServicios() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/services"))
                .header("Authorization", "Bearer " + Sesion.getToken())
                .GET().build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        Type listType = new TypeToken<List<ServiceSummaryDTO>>() {
        }.getType();
        return gson.fromJson(response.body(), listType);
    }

    @Override
    public List<SupplySummaryDTO> obtenerInsumosNombre(String nombreInsumo) throws Exception {
        String url = BASE_URL + "/supplies?name=" + nombreInsumo.replace(" ", "%20");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "Bearer " + Sesion.getToken())
                .GET().build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        Type listType = new TypeToken<List<SupplySummaryDTO>>() {
        }.getType();
        return gson.fromJson(response.body(), listType);
    }

    @Override
    public ServiceDetailDTO obtenerServicio(Long idServicio) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/services/" + idServicio))
                .header("Authorization", "Bearer " + Sesion.getToken())
                .GET().build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(response.body(), ServiceDetailDTO.class);
    }

    @Override
    public List<ServiceSummaryDTO> obtenerServiciosNombre(String nombreServicio) throws Exception {
        return List.of();
    }
}
