package jady.test;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.gson.reflect.TypeToken;
import com.sun.deploy.util.StringUtils;
import jady.util.GsonUtil;
import jady.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by liuhan on 2019/9/9.
 */
@Slf4j
public class test {
    private static ThreadFactory cancelOrderNamedThreadFactory = new ThreadFactoryBuilder().
            setNameFormat("test-%d").build();
    private static ExecutorService executor = new ThreadPoolExecutor(5, 5,
            30, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), cancelOrderNamedThreadFactory,
            new ThreadPoolExecutor.AbortPolicy());
    public static void main(String[] args) {

        //JsonUtilTest();
        //GsonUtilTest();
        List<String> list = Lists.newArrayList("1","2","3","4","5");
        String a = list.stream().map(n -> n+1).collect(Collectors.joining("&","",""));
        //List<List<Integer>> list1 = Lists.partition(list, 6);
        String ids = "1,2,3,4,5,6";
        StreamSupport.stream(Splitter.on(",").split(ids).spliterator(), false)
                .map(Long::parseLong).
                forEach(System.out::println);





    }

    private static LoadingCache<String, PromotionActivityCache> activityInfoCache = CacheBuilder
            .newBuilder()
            .expireAfterWrite(60, TimeUnit.SECONDS)
            .maximumSize(3)
            .build(new CacheLoader<String, PromotionActivityCache>() {
                @Override
                public PromotionActivityCache load(String key) {
                    log.info("营销活动本地缓存加载开始");
                    return loadPromotionActivityInfo(key);
                }
                @Override
                public ListenableFuture<PromotionActivityCache> reload(final String key, PromotionActivityCache oldValue){
                    ListenableFutureTask<PromotionActivityCache> task = ListenableFutureTask.create(() -> {
                        log.info("营销活动本地缓存重新加载开始");
                        return loadPromotionActivityInfo(key);
                    });
                    executor.submit(task);
                    return task;
                }
            });

    private static PromotionActivityCache getPromotion(String key) throws ExecutionException{
        return activityInfoCache.get(key);
    }

    private static PromotionActivityCache loadPromotionActivityInfo(String key){
        PromotionActivityCache promotionActivityCache = new PromotionActivityCache();
        Map<String, Set<String>> commodityInfo = Maps.newHashMap();
        Map<String, String> activityInfo = Maps.newHashMap();
        activityInfo.put("2","5");
        activityInfo.put("3","8");
        promotionActivityCache.setActivityInfo(activityInfo);
        commodityInfo.put("123", Sets.newHashSet("111","222","333"));
        commodityInfo.put("456", Sets.newHashSet("444","555","666"));
        promotionActivityCache.setCommodityInfo(commodityInfo);
        if(key.equals("1")){
            return promotionActivityCache;
        }else if(key.equals("2")){
            return null;
        }else {
            return new PromotionActivityCache();
        }

    }

    private static void JsonUtilTest(){
        UserForTest userForTest = JsonUtil.readValue("{\"name\":\"Jady\n\",\"id\":0123456,\"age\":20,\"score\":\"INF\"}",UserForTest.class);
        String testString = JsonUtil.toJsonString(userForTest);
        log.info(testString);
    }

    private static void GsonUtilTest(){
        UserForTest userForTest = GsonUtil.readGson("{\"name\":\"Jady\n\",\"id\":0123456,\"age\":20,\"score\":2.2}", new TypeToken<UserForTest>() {}.getType());
        String testString = GsonUtil.toJsonString(null);
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
