
package presentacion.controles;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import presentacion.utils.Sesion;
import java.net.URI;

/**
 *
 * @author PC Gamer
 */
public class ControlAuth {

    private static final String API_GATEWAY_URL = "http://localhost:8080/api/auth/login";

    public boolean hacerLogin(String username, String password) {
        try {
            String jsonPayload = String.format("{\"username\":\"%s\", \"password\":\"%s\"}", username, password);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_GATEWAY_URL))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
                    .build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);

                String token = jsonResponse.get("token").getAsString();
                Sesion.setToken(token);

                return true; 
            } else {
                System.out.println("Error de Login: " + response.body());
                return false; 
            }

        } catch (Exception e) {
            System.err.println("Error de conexión con el API Gateway: " + e.getMessage());
            return false;
        }
    }
}
