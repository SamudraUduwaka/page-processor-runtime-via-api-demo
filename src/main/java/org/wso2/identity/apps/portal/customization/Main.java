package org.wso2.identity.apps.portal.customization;

import java.net.http.*;
import java.net.URI;
import java.util.*;
import com.google.gson.*;

public class Main {
    public static void main(String[] args) {

        // Define API Endpoint
        String apiUrl = "https://d835f84d-fb72-430b-8a0b-06e529805888.mock.pstmn.io/portal-customization?version=v1.0&type=ORG&name=12345678";

        // Fetch Data from API
        String jsonResponse = fetchFromApi(apiUrl);
        if (jsonResponse == null) {
            System.out.println("Failed to fetch data from API.");
            return;
        }

        // Parse JSON Response
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        String htmlContent = jsonObject.get("html").getAsString();

        // Prepared Context Data
        Map<String, Object> contextData = new HashMap<>();
        contextData.put("errorPage", "style='background-color: red;'");
        contextData.put("heading", "style='color: blue;'"); 

        try {
            // Process HTML with ContextDataParser
            String parsedHtml = ContextDataParser.parse(contextData, htmlContent, "");

            // Print Output
            System.out.println("Parsed HTML:\n" + parsedHtml);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Fetch Data from API
    private static String fetchFromApi(String url) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
