package com.meetme.meetme.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.meetme.meetme.search.GoogleSearch;
import com.meetme.meetme.exception.SerpApiSearchException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GoogleSearchService {

    @Value("${api_key}")
    private String SERP_API_KEY;

    public JsonElement search(String q){

        Map<String, String> parameter = new HashMap<>();

        parameter.put("q", q);
        parameter.put("hl", "en");
        parameter.put("gl", "us");
        parameter.put("api_key", SERP_API_KEY);

        GoogleSearch search = new GoogleSearch(parameter);

        try
        {
            JsonObject results = search.getJson();
            return results.get("events_results");
        }
        catch (SerpApiSearchException ex)
        {
            ex.printStackTrace();
        }

        return null;
    }
}

