package com.kurstestowania.mailchimpapispringboot.convert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.InputStream;

public class JsonConverter {
    public static String toJsonString(Object o) {
        ObjectWriter ow = new ObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
                .writer().withDefaultPrettyPrinter();
        try {
            return ow.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static <T> T fromJSON(String content, Class<T> clazz) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, clazz);
    }

    public static <T> T fromJSON(InputStream inputStream, Class<T> clazz) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(inputStream, clazz);
    }
}