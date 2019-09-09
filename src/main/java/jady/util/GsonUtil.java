package jady.util;

import com.google.gson.Gson;
import java.lang.reflect.Type;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by liuhan on 2019/9/9.
 */
@Slf4j
public class GsonUtil {
    private static Gson gson = new Gson();

    public static String toJsonString(Object object) {
        return gson.toJson(object);
    }

    public static <T> T readGson(String gsonString, Class<T> cls) {
        return gson.fromJson(gsonString, cls);
    }

    public static <T> T readGson(String gsonString, Type type){
        return gson.fromJson(gsonString, type);
    }
}
