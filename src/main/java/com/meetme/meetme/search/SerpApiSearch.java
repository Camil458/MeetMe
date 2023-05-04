package com.meetme.meetme.search;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.meetme.meetme.exception.SerpApiSearchException;

import java.util.HashMap;
import java.util.Map;

public class SerpApiSearch {

    // set of constant
    public static final String API_KEY_NAME = "api_key";

    // default static key
    public static String api_key_default;

    // user secret API key
    protected String api_key;

    // current search engine
    protected String engine;

    // search parameters
    public Map<String, String> parameter;

    // initialize gson
    private static final Gson gson = new Gson();

    // https search implementation
    public SerpApiHttpClient search;


    // constructors
    public SerpApiSearch(Map<String, String> parameter, String api_key, String engine) {
        this.parameter = parameter;
        this.api_key = api_key;
        this.engine = engine;
    }

    public SerpApiSearch(Map<String, String> parameter, String engine) {
        this.parameter = parameter;
        this.engine = engine;
    }

    public SerpApiSearch(String engine) {
        this.parameter = new HashMap<>();
        this.engine = engine;
    }


    // build a serp API query by expanding existing parameter
    public Map<String, String> buildQuery(String path, String output) throws SerpApiSearchException {
        // Initialize search if not done
        if (search == null) {
            this.search = new SerpApiHttpClient(path);
            this.search.setHttpConnectionTimeout(6000);
        } else {
            this.search.path = path;
        }

        // Set current programming language
        this.parameter.put("source", "java");

        // Set api_key
        if (this.parameter.get(API_KEY_NAME) == null) {
            if (this.api_key != null) {
                this.parameter.put(API_KEY_NAME, this.api_key);
            } else if (getApiKey() != null) {
                this.parameter.put(API_KEY_NAME, getApiKey());
            } else {
                throw new SerpApiSearchException(API_KEY_NAME + " is not defined");
            }
        }

        this.parameter.put("engine", this.engine);

        // Set output format
        this.parameter.put("output", output);

        return this.parameter;
    }

    // return current secret api key
    public static String getApiKey() {
        return api_key_default;
    }

    // get HTML output
    public String getHtml() throws SerpApiSearchException {
        Map<String, String> query = buildQuery("/search", "html");
        return search.getResults(query);
    }

    // get JSON output
    public JsonObject getJson() throws SerpApiSearchException {
        Map<String, String> query = buildQuery("/search", "json");
        return asJson(search.getResults(query));
    }

    // convert HTTP content to JsonValue
    public JsonObject asJson(String content) {
        JsonElement element = gson.fromJson(content, JsonElement.class);
        return element.getAsJsonObject();
    }
}
