package com.meetme.meetme.search;

import java.util.Map;

public class GoogleSearch extends SerpApiSearch {
    public GoogleSearch() {
        super("google_events");
    }

    public GoogleSearch(Map<String, String> parameter) {
        super(parameter, "google_events");
    }

    public GoogleSearch(Map<String, String> parameter, String apiKey) {
        super(parameter, apiKey, "google_events");
    }
}
