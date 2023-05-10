package com.meetme.meetme.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.meetme.meetme.exception.SerpApiSearchException;
import com.meetme.meetme.search.GoogleSearch;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InvalidClassException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoogleSearchService {

    @Value("${serp_api_key}")
    private String SERP_API_KEY;

    @Value("${geo_api_key}")
    private String GEO_API_KEY;

    public String search(String q, String date, String page){

        Map<String, String> parameter = new HashMap<>();

        parameter.put("q", q);
        parameter.put("hl", "en");
        parameter.put("gl", "us");
        parameter.put("api_key", SERP_API_KEY);

        // advanced filters
        if (date != null){
            parameter.put("date", date);
        }

        if (page != null){
            parameter.put("start", page);
        }

        GoogleSearch search = new GoogleSearch(parameter);

        try
        {
            // result from Serp API
            JsonObject searchResults = search.getJson();
            List<JsonElement> searchResultList = searchResults.getAsJsonArray("events_results").asList();

            // array with missing elements
            JsonArray results = new JsonArray();

            // event id
            int id = 0;

            for (JsonElement result: searchResultList){
                JsonObject event = result.getAsJsonObject();

                JsonArray addressArray = event.getAsJsonArray("address");

                event.addProperty("id", id);
                event.addProperty("coordinates", getCoordinates(addressArray));

                id += 1;

                results.add(event);
            }

            return results.toString();
        }
        catch (SerpApiSearchException ex)
        {
            ex.printStackTrace();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    String getCoordinates(JsonArray addressArray) throws IOException, InterruptedException {

        StringBuilder text = new StringBuilder();

        for (JsonElement address: addressArray){
            String[] splitAddress = address.getAsString().split("[ ,]+");
            for (String a: splitAddress){
                text.append(a);
                text.append("%20");
            }
        }
        // remove last "%20"
        text.delete(text.length()-3, text.length());

        // get coordinates from location using geoapify
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.geoapify.com/v1/geocode/search?text="+text+"&format=json&apiKey="+GEO_API_KEY))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());


        JSONObject responseBody= new JSONObject(response.body());
        JSONArray responseResult = responseBody.getJSONArray("results");
        JSONObject result = (JSONObject) responseResult.get(0);

        // coordinates:[24.2028, 10.4418]
        return "["+result.get("lat")+", "+result.get("lon")+"]";
    }
}

