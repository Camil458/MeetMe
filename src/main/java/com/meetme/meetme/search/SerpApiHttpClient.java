package com.meetme.meetme.search;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.meetme.meetme.exception.SerpApiSearchException;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Map;

public class SerpApiHttpClient {
    // http request configuration
    private int httpConnectionTimeout;
    private int httpReadTimeout;

    // backend service
    public static String BACKEND = "https://serpapi.com";

    // initialize gson
    private static final Gson gson = new Gson();

    // current backend HTTP path
    public String path;

    // constructor
    public SerpApiHttpClient(String path) {
        this.path = path;
    }

    // build URL
    protected HttpURLConnection buildConnection(String path, Map<String, String> parameter) throws SerpApiSearchException {
        HttpURLConnection con;
        try {
            allowHTTPS();
            String query = ParameterStringBuilder.getParamsString(parameter);
            URL url = new URL(BACKEND + path + "?" + query);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
        } catch (IOException e) {
            throw new SerpApiSearchException(e);
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
            throw new SerpApiSearchException(e);
        }

        String outputFormat = parameter.get("output");
        if (outputFormat == null) {
            if (path.startsWith("/search?")) {
                throw new SerpApiSearchException("output format must be defined: " + path);
            }
        } else if (outputFormat.startsWith("json")) {
            con.setRequestProperty("Content-Type", "application/json");
        }

        con.setConnectTimeout(getHttpConnectionTimeout());
        con.setReadTimeout(getHttpReadTimeout());

        con.setDoOutput(true);
        return con;
    }

    private void allowHTTPS() throws NoSuchAlgorithmException, KeyManagementException {
        TrustManager[] trustAllCerts;
        trustAllCerts = new TrustManager[] { new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }

            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }

        } };

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        // Create all-trusting host name verifier
        HostnameVerifier allHostsValid = (hostname, session) -> true;
        // Install the all-trusting host verifier
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
    }

    // get result
    public String getResults(Map<String, String> parameter) throws SerpApiSearchException {
        HttpURLConnection con = buildConnection(this.path, parameter);

        // Get HTTP status
        int statusCode;
        // Hold response stream
        InputStream is;
        // Read buffer
        BufferedReader in;
        try {
            statusCode = con.getResponseCode();

            if (statusCode == 200) {
                is = con.getInputStream();
            } else {
                is = con.getErrorStream();
            }

            Reader reader = new InputStreamReader(is);
            in = new BufferedReader(reader);
        } catch (IOException e) {
            throw new SerpApiSearchException(e);
        }

        String inputLine;
        StringBuilder content = new StringBuilder();
        try {
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
            throw new SerpApiSearchException(e);
        }

        // Disconnect
        con.disconnect();

        if (statusCode != 200) {
            triggerSerpApiClientException(content.toString());
        }
        return content.toString();
    }

    // trigger a exception on error
    protected void triggerSerpApiClientException(String content) throws SerpApiSearchException {
        String errorMessage;
        try {
            JsonObject element = gson.fromJson(content, JsonObject.class);
            errorMessage = element.get("error").getAsString();
        } catch (Exception e) {
            throw new AssertionError("invalid response format: " + content);
        }
        throw new SerpApiSearchException(errorMessage);
    }

    // return current HTTP connection timeout
    public int getHttpConnectionTimeout() {
        return httpConnectionTimeout;
    }

    // set HTTP connection timeout
    public void setHttpConnectionTimeout(int httpConnectionTimeout) {
        this.httpConnectionTimeout = httpConnectionTimeout;
    }

    // return current HTTP read timeout
    public int getHttpReadTimeout() {
        return httpReadTimeout;
    }

    // set HTTP read timeout
    public void setHttpReadTimeout(int httpReadTimeout) {
        this.httpReadTimeout = httpReadTimeout;
    }
}
