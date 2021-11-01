package com.acn.rj.aem.flagapp.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static org.apache.commons.lang3.StringUtils.defaultIfBlank;

public class CommonHelper {

    public static final String COMMA = ",";
    public static final String HYPHEN = "-";
    public static final String UNDER_SCORE = "_";
    public static final String SLASH = "/";
    public static final String COLON = ":";
    public static final String SEMI_COLON = ";";
    public static final String AT = "@";
    public static final String AMP = "&";


    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonHelper.class);

    private CommonHelper() {
        throw new UnsupportedOperationException();
    }

    public static ObjectMapper getObjectMapper() {
        //OBJECT_MAPPER.registerModule(new JavaTimeModule());
        OBJECT_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
        return OBJECT_MAPPER;
    }

    public static <T> T convertToClass(Object objValue, Class<T> clazz) throws IOException {
        T classValue = null;
        try {
            classValue = getObjectMapper().readValue((objValue instanceof String) ? (String) objValue : writeValueAsString(objValue), clazz);
        } catch (IllegalArgumentException ie) {
            LOGGER.error("Error occurred converting obj to class", ie);
        }
        return classValue;
    }

    public static String writeValueAsString(Object objValue) throws JsonProcessingException {
        return getObjectMapper().writeValueAsString(objValue);
    }

    public static <T> T readValueFromResource(final String resourceFileName, final Class<T> clazz) throws IOException {
        return getObjectMapper().readValue(CommonHelper.class.getResourceAsStream(resourceFileName.startsWith("/") ? resourceFileName : String.format("/%s", resourceFileName.trim())), clazz);
    }

    public static String createNameFromTitle(final String title) {
        return StringUtils.replace(StringUtils.lowerCase(title), StringUtils.SPACE, HYPHEN);
    }

    public static String decodeTitleFromName(final String name) {
        return StringUtils.replace(StringUtils.capitalize(name), HYPHEN, StringUtils.SPACE);
    }

    public static String encode(final String value, final String charset) throws UnsupportedEncodingException {
        return URLEncoder.encode(value, defaultIfBlank(charset, StandardCharsets.UTF_8.name()));
    }

}