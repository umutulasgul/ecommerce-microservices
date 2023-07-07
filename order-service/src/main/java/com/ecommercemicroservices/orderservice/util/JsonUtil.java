package com.ecommercemicroservices.orderservice.util;

import com.ecommercemicroservices.orderservice.model.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public final class JsonUtil {

    private JsonUtil() {
    }

    private static final Logger LOG = LoggerFactory.getLogger(JsonUtil.class);

    static ObjectWriter ow = new ObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false).writer().withDefaultPrettyPrinter();

    static ObjectMapper mapper = new ObjectMapper();

    public static String objectToJson(Object src) {
        String json = null;
        try {
            json = ow.writeValueAsString(src);
        } catch (JsonProcessingException e) {
            LOG.error(e.getMessage(), e);
        }
        return json;

    }

    public static <T> T jsonToObject(String json, Class<T> clazz) {
        T obj = null;
        try {
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            obj = mapper.readValue(json, clazz);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return obj;

    }

    public static <T> T convertValue(Object object, Class<T> clazz) {
        T obj;
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        obj = mapper.convertValue(object, clazz);
        return obj;
    }

    public static <T> T convertValue(Object object, TypeReference<?> toValueTypeRef) {
        T obj;
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        obj = mapper.convertValue(object, (TypeReference<T>) toValueTypeRef);
        return obj;
    }

    @SuppressWarnings("rawtypes")
    public static Object jsonToParameterizedObject(String json, TypeReference tr) {
        Object obj = null;
        try {
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            obj = mapper.readValue(json, tr);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return obj;

    }

    public static ObjectMapper getMapper() {
        return mapper;
    }

    public static <T> T getContent(ResponseEntity<Response> responseEntity, Class<T> clazz) {
        T obj;
        Map<?, ?> data = (Map<?, ?>) Objects.requireNonNull(responseEntity.getBody()).getData();
        Object content = data.get("content");
        obj = JsonUtil.convertValue(content, clazz);
        return obj;
    }

}


