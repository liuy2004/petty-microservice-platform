package com.github.pettyfer.basic.common.context;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Petty
 */
public class BaseContextHandler {
    public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();

    public static void set(String key, Object value) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>(256);
            threadLocal.set(map);
        }
        map.put(key, value);
    }

    public static Object get(String key) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>(256);
            threadLocal.set(map);
        }
        return map.get(key);
    }

    public static void remove(){
        threadLocal.remove();
    }
}
