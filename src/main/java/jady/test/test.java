package jady.test;

import jady.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by liuhan on 2019/9/9.
 */
@Slf4j
public class test {
    public static void main(String[] args) {
        JsonUtilTest();
    }

    private static void JsonUtilTest(){
        UserForTest userForTest = JsonUtil.readValue("{\"name\":\"Jady\",\"id\":123456,\"age\":20}",UserForTest.class);
        String testString = JsonUtil.writeValueAsString(userForTest);
        log.info(testString);
    }
}
