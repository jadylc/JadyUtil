package jady.test;

import com.google.gson.reflect.TypeToken;
import jady.util.GsonUtil;
import jady.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;
import java.math.BigDecimal;

/**
 * Created by liuhan on 2019/9/9.
 */
@Slf4j
public class test {
    public static void main(String[] args) {
        //JsonUtilTest();
        //GsonUtilTest();
        Double t = 1253.59;

        log.info("result is {}",100*t);





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

    private static Double yuanToFenTools(Double originMoney) {
        String hundred = "100";
        Double result;
        if (originMoney == null || originMoney == 0) {
            result = 0D;
        }else{
            result = new BigDecimal(String.valueOf(originMoney))
                    .multiply(new BigDecimal(hundred))
                    .doubleValue();
        }
        return result;
    }
}
