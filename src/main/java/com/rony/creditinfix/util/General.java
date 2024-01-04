package com.rony.creditinfix.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;

public class General {

    public static  <T> T getObjectMapperWithDifferentProperty(String jsonString , TypeReference<T> valueType) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
            return mapper.readValue(jsonString, valueType);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static  <T> T getObjectMapperWithDifferentProperty(String jsonString, Class<T> valueType) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
            return mapper.readValue(jsonString, valueType);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
