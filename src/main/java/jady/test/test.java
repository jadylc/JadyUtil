package jady.test;

import com.google.gson.reflect.TypeToken;
import jady.util.GsonUtil;
import jady.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;

/**
 * Created by liuhan on 2019/9/9.
 */
@Slf4j
public class test {
    public static void main(String[] args) {
        JsonUtilTest();
        GsonUtilTest();
    }

    private static void JsonUtilTest(){
        UserForTest userForTest = JsonUtil.readValue("{\"name\":\"Jady\n\",\"id\":0123456,\"age\":20,\"score\":\"INF\"}",UserForTest.class);
        String testString = JsonUtil.toJsonString(userForTest);
        log.info(testString);
    }

    private static void GsonUtilTest(){
        UserForTest userForTest = GsonUtil.readGson("{\"name\":\"Jady\n\",\"id\":0123456,\"age\":20,\"score\":2.2}", new TypeToken<UserForTest>() {}.getType());
        String testString = GsonUtil.toJsonString(userForTest);
        log.info(testString);
    }
}
