package com.robot.util;

import com.google.common.collect.ImmutableMap;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.robot.bean.Msg;

import java.util.*;


/**
 * @author gmr
 * @author SD
 */
public class GsonUtil {
    private static Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create();


    public static Gson getGson() {
        return gson;
    }

    /**
     * 返回成功
     *
     * @return
     */
    public static String getSuccessJson() {
        return GsonUtil.getGson().toJson(new Msg("success", null));
    }

    /**
     * 返回成功字符串
     *
     * @param o
     * @return
     */
    public static String getSuccessJson(Object o) {
        return GsonUtil.getGson().toJson(new Msg("success", o));
    }

    /**
     * 用自己指定的gson
     *
     * @param gson
     * @param o
     * @return
     */
    public static String getSuccessJson(Gson gson, Object o) {
        return gson.toJson(new Msg("success", o));
    }

    public static String getErrorJson() {
        return GsonUtil.getGson().toJson(new Msg("error", null));
    }

    public static String getErrorJson(Object o) {
        return GsonUtil.getGson().toJson(new Msg("error", o));
    }

    /**
     * 过滤属性:格式  类、属性、属性、属性...类、属性、属性、属性...类、属性、属性、属性...
     *
     * @param objects
     * @return
     */
    public static Gson getFilterJson(Object... objects) {
        return filter(objects).serializeNulls().setDateFormat("yyyy-MM-dd").create();
    }

    /**
     * 保留传入的属性，其它全部过滤掉
     * 保留属性:格式  类、属性、属性、属性...类、属性、属性、属性...类、属性、属性、属性...
     *
     * @param objects
     * @return
     */
    public static Gson getExistJson(boolean result, Object... objects) {
        return delalProperty(result, objects).serializeNulls().setDateFormat("yyyy-MM-dd").create();
    }

    /**
     * GsonBuilder(以创建的gsonBuilder)
     * 属性:格式  类、属性、属性、属性...类、属性、属性、属性...类、属性、属性、属性...
     *
     * @param gsonBuilder
     * @param objects
     * @return
     */
    private static GsonBuilder delalProperty(GsonBuilder gsonBuilder, boolean result, Object[] objects) {
        Map<Class<?>, Set<String>> map = new HashMap<Class<?>, Set<String>>();
        Class<?> c = null;
        for (Object o : objects) {
            if (o instanceof Class) {
                c = (Class<?>) o;
                map.put(c, new HashSet<String>());
            } else {
                map.get(c).add((String) o);
            }
        }
        return gsonBuilder.setExclusionStrategies(new MapGsonFilter(map, result));
    }

    /**
     * GsonBuilder(以创建的gsonBuilder)
     * 过滤属性:格式  类、属性、属性、属性...类、属性、属性、属性...类、属性、属性、属性...
     *
     * @param gsonBuilder
     * @param objects
     * @return
     */
    public static GsonBuilder filter(GsonBuilder gsonBuilder, Object... objects) {
        return delalProperty(gsonBuilder, true, objects);
    }

    /**
     * 属性:格式  类、属性、属性、属性...类、属性、属性、属性...类、属性、属性、属性...
     *
     * @param objects
     * @return
     */
    private static GsonBuilder delalProperty(boolean result, Object[] objects) {
        Map<Class<?>, Set<String>> map = new HashMap<Class<?>, Set<String>>();
        Class<?> c = null;
        for (Object o : objects) {
            if (o instanceof Class) {
                c = (Class<?>) o;
                map.put(c, new HashSet<String>());
            } else {
                map.get(c).add((String) o);
            }
        }
        if (!result) {
            //存在过滤
            map.put(Msg.class, new HashSet<String>());
            Collections.addAll(map.get(Msg.class), "code", "result", "message");
        }
        return new GsonBuilder().setExclusionStrategies(new MapGsonFilter(map, result));
    }

    /**
     * 过滤属性:格式  类、属性、属性、属性...类、属性、属性、属性...类、属性、属性、属性...
     *
     * @param objects
     * @return
     */
    public static GsonBuilder filter(Object... objects) {
        return delalProperty(true, objects);
    }

    /**
     * gson过滤器内部类
     *
     * @author gmr
     */
    private static class MapGsonFilter implements ExclusionStrategy {
        boolean result = true;
        private Map<Class<?>, Set<String>> map = new HashMap<Class<?>, Set<String>>();

        /**
         * @param map
         * @param result true表示正常过滤，false表示保留这些字段
         */
        private MapGsonFilter(Map<Class<?>, Set<String>> map, boolean result) {
            this.map = map;
            this.result = result;
        }

        @Override
        public boolean shouldSkipField(FieldAttributes f) {
            Set<String> set = map.get(f.getDeclaringClass());
            if (set != null && set.contains(f.getName())) {
                return result;
            }
            return !result;
        }

        @Override
        public boolean shouldSkipClass(Class<?> clazz) {
            return false;
        }

    }

    // --------------------- added by SD

    public static final String DEFAULT_DATE_FORMAT_PATTERN = "yyyy-MM-dd";
    public static final String DEFAULT_DATE_TIME_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 全局Gson缓存，默认保存两种date format pattern 缓存设置为不可变，初始化后不可更改
     * 可考虑将缓存设置为可变，用户请求新的date format pattern时，创建新的Gson对象返回并加入缓存
     */
    private static final Map<String, Gson> gsonMap;

    static {
        Map<String, Gson> gm = new HashMap<>(4);
        Gson defaultDateFormatGson = new GsonBuilder().serializeNulls()
                .setDateFormat(DEFAULT_DATE_FORMAT_PATTERN).create();

        Gson defaultDateTimeFormatGson = new GsonBuilder().serializeNulls()
                .setDateFormat(DEFAULT_DATE_TIME_FORMAT_PATTERN).create();

        gm.put(DEFAULT_DATE_FORMAT_PATTERN, defaultDateFormatGson);
        gm.put(DEFAULT_DATE_TIME_FORMAT_PATTERN, defaultDateTimeFormatGson);

        // 返回不可变集合
        // 之后扩展可考虑将此集合变为可变，当用户请求新的date format时新建Gson并加入到map中
        // - SD 2016-10-26
        gsonMap = ImmutableMap.copyOf(gm);
    }

    public static Gson getGsonWithDateTimePattern(String pattern) {
        return gsonMap.get(pattern);
    }

    // --------------------- added by SD


    //---add by ZJH
    public static Gson getExistJsonWithSerializeNulls(String dateFormat, Object... objects) {
        return delalProperty(false, objects).serializeNulls().setDateFormat(dateFormat).create();
    }

    public static Gson getFilterJsonWithDateFormat(String dateFormat, Object... objects) {
        return delalProperty(true, objects).serializeNulls().setDateFormat(dateFormat).create();
    }


    public static <T> T getObjectFromJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

//    /**
//     * json 转为 List<T>
//     *
//     * @param json  json字符串
//     * @param clazz list对象类型
//     * @return
//     */
//    public static <T> List<T> getListFromJson(String json, Class<T> clazz) {
//        return gson.fromJson(json, new TypeToken<List<T>>() {
//        }.getType());
//    }
//
//    /**
//     * json 转为 Set<T>
//     *
//     * @param json  json字符串
//     * @param clazz Set对象类型
//     * @param <T>   对象泛型
//     * @return
//     */
//    public static <T> Set<T> getSetFromJson(String json, Class<T> clazz) {
//        return gson.fromJson(json, new TypeToken<Set<T>>() {
//        }.getType());
//    }

//    /**
//     * Json转为Map<K,V>
//     *
//     * @param json   json 字符串
//     * @param kClass map 的 key 类型
//     * @param vClass map 的 value 类型
//     * @param <K>    Key泛型
//     * @param <V>    Value泛型
//     * @return
//     */
//    public static <K, V> Map<K, V> getMapFromJson(String json, Class<K> kClass, Class<V> vClass) {
//        return gson.fromJson(json, new TypeToken<Map<K, V>>() {
//        }.getType());
//    }

}
