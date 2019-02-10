package com.kurstestowania.mailchimpapispringboot.reader;

import com.kurstestowania.mailchimpapispringboot.configuration.ConfigurationApi;
import com.kurstestowania.mailchimpapispringboot.convert.JsonConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

public class ConfigApiReader {
    private static Logger logger = LoggerFactory.getLogger(ConfigApiReader.class);

    public ConfigurationApi getConfigApi() {
        JsonReader jsonReader = new JsonReader();
        InputStream inputStream = jsonReader.getJsonFromResource("api.json");
        try {
            return JsonConverter.fromJSON(inputStream, ConfigurationApi.class);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        throw new RuntimeException("Api.json is not initialized!");
    }
}
