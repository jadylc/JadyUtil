package jady.test;

import lombok.Data;

import java.util.Map;
import java.util.Set;

/**
 * @author liuhan
 * @date 2019/10/22
 */
@Data
public class PromotionActivityCache {
    private Map<String, Set<String>> commodityInfo;
    private Map<String, String> activityInfo;
}
