package com.kurstestowania.mailchimpapispringboot.http;

import com.kurstestowania.mailchimpapispringboot.configuration.ConfigurationApi;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import okhttp3.*;

import java.io.IOException;

public class Http {

    private ConfigurationApi configurationApi;

    public Http(ConfigurationApi configurationApi) {
        this.configurationApi = configurationApi;
    }

    private static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    public Response post(String endpoint, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        String auth = "geralt00011:"+configurationApi.getApiKey();
        String login = "Basic " + Base64.encode(auth.getBytes());
        Request request = new Request.Builder()
                .url(configurationApi.getUrl() + endpoint)
                .addHeader("Authorization", login)
                .post(body)
                .build();
        return client.newCall(request).execute();
    }
}
