package jady.util;

import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by liuhan on 2019/9/9.
 * 基于Jackson
 * 部分非标准解析配置
 */
@Slf4j
public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();
    static {
        //允许接受所有引号引起来的字符
        objectMapper.configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);
        //允许注释
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        //允许非数值型数值
        objectMapper.configure(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS, true);
        //允许整数前有0
        objectMapper.configure(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS, true);
        //允许单引号
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        //允许控制字符
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        //允许属性无引号
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        //找不到属性的时候不报错，只处理有的属性
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static String toJsonString(Object object) {
        String result;
        try {
            result = objectMapper.writeValueAsString(object);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }

    public static <T> T readValue(String content, Class<T> classDeser) {
        T result;
        try {
            result = objectMapper.readValue(content, classDeser);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return result;

    }

    public static <T> T readValue(String content, TypeReference valueTypeRef) {
        T result;
        try {
            result = objectMapper.readValue(content, valueTypeRef);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }

    public static <T> T readValue(String content, JavaType javaType) {
        T result;
        try {
            result = objectMapper.readValue(content, javaType);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }
}
