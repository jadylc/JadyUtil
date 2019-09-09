package jady.util;

import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuhan on 2019/9/9.
 * base on Jackson
 */
@Slf4j
public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static ObjectMapper objectMapperForWcf = new ObjectMapper();

    private static final Map<JsonParser.Feature, Boolean> commonJsonParserFeatureMap = new HashMap<JsonParser.Feature, Boolean>();
    private static final Map<DeserializationFeature, Boolean> commonDeserialParserFeatureMap = new HashMap<DeserializationFeature, Boolean>();

    static {
        commonJsonParserFeatureMap.put(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);
        commonJsonParserFeatureMap.put(JsonParser.Feature.ALLOW_COMMENTS, true);
        commonJsonParserFeatureMap.put(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS, true);
        commonJsonParserFeatureMap.put(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS, true);
        commonJsonParserFeatureMap.put(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        commonJsonParserFeatureMap.put(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        commonJsonParserFeatureMap.put(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        commonDeserialParserFeatureMap.put(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


        // 处理公共配置
        for (Map.Entry<JsonParser.Feature, Boolean> entry : commonJsonParserFeatureMap.entrySet()) {
            objectMapper.configure(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<DeserializationFeature, Boolean> entry : commonDeserialParserFeatureMap.entrySet()) {
            objectMapper.configure(entry.getKey(), entry.getValue());
        }

    }


    public static ObjectMapper getObjectMapperInstance() {
        return objectMapper;
    }

    public static ObjectMapper getObjectMapperForWcf() {
        return objectMapperForWcf;
    }

    public static String writeValueAsString(Object object) {
        String result = "";
        try {
            result = getObjectMapperInstance().writeValueAsString(object);
        } catch (Exception ex) {
            log.error("serialize error:", ex.getMessage());
            throw new RuntimeException(ex);
        }
        return result;
    }

    public static <T> T readValue(String content, Class<T> classDeser) {
        T result = null;
        try {
            result = getObjectMapperInstance().readValue(content, classDeser);
        } catch (Exception ex) {
            log.error("deserialize error:", ex.getMessage());
            throw new RuntimeException(ex);
        }
        return result;

    }

    public static <T> T readValue(String content, TypeReference valueTypeRef) {
        T result = null;
        try {
            result = getObjectMapperInstance().readValue(content, valueTypeRef);
        } catch (Exception ex) {
            log.error("deserialize error:", ex.getMessage());
            throw new RuntimeException(ex);
        }
        return result;
    }

    public static <T> T readValue(String content, JavaType javaType) {
        T result = null;
        try {
            /*            ApiResponse<List<TujiaDataBean>> one  = getObjectMapperInstance().readValue(content, new TypeReference<ApiResponse<List<TujiaDataBean>>>() {});*/
            result = getObjectMapperInstance().readValue(content, javaType);
        } catch (Exception ex) {
            log.error("deserialize error:", ex.getMessage());
            throw new RuntimeException(ex);
        }
        return result;
    }

    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return getObjectMapperInstance().getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }
}
